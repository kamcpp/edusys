using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.UserWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    public partial class UcRolesForUser : UserControl
    {
        private long _userId;
        private List<long> _addedRoleIds;
        private List<long> _removedRoleIds;

        public long UserId
        {
            get { return _userId; }
            set { _userId = value; }
        }

        public UcRolesForUser()
        {
            InitializeComponent();

            _addedRoleIds = new List<long>();
            _removedRoleIds = new List<long>();
        }

        private void ucRolesForUser_Load(object sender, EventArgs e)
        {
            if (!DesignMode)
            {
                try
                {
                    RoleService roleService = new RoleService();
                    GetRolesRequest request = new GetRolesRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference.RoleType[] roleTypes = roleService.GetRoles(request);
                    comboboxRoles.DataSource = roleTypes;
                    comboboxRoles.DisplayMember = "Name";
                    comboboxRoles.ValueMember = "Id";
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void buttonRefresh_Click(object sender, EventArgs e)
        {
            LoadData();
        }

        private void buttonAddRole_Click(object sender, EventArgs e)
        {
            if (comboboxRoles.SelectedIndex < 0)
            {
                return;
            }
            bool found = false;
            foreach (ListViewItem item in listviewRoles.Items)
            {
                if (item.Tag.ToString() == comboboxRoles.SelectedValue.ToString())
                {
                    found = true;
                }
            }
            if (found)
            {
                return;
            }

            ListViewItem addingItem = new ListViewItem();
            addingItem.Text = comboboxRoles.Text;
            addingItem.Tag = comboboxRoles.SelectedValue.ToString();
            listviewRoles.Items.Add(addingItem);

            _addedRoleIds.Add(long.Parse(comboboxRoles.SelectedValue.ToString()));
            _removedRoleIds.Remove(long.Parse(comboboxRoles.SelectedValue.ToString()));
        }

        private void buttonRemoveRole_Click(object sender, EventArgs e)
        {
            if (listviewRoles.SelectedItems.Count == 0)
            {
                return;
            }

            _removedRoleIds.Add(long.Parse(listviewRoles.SelectedItems[0].Tag.ToString()));
            _addedRoleIds.Remove(long.Parse(listviewRoles.SelectedItems[0].Tag.ToString()));

            listviewRoles.Items.Remove(listviewRoles.SelectedItems[0]);
        }

        public void LoadData()
        {
            try
            {
                UserService userService = new UserService();
                GetRolesForUserRequest request = new GetRolesForUserRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.UserId = _userId;
                Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.UserWebReference.RoleType[] roleTypes = userService.GetRolesForUser(request);
                listviewRoles.Items.Clear();
                foreach (Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.UserWebReference.RoleType roleType in roleTypes)
                {
                    ListViewItem item = new ListViewItem();
                    item.Text = roleType.Name;
                    item.Tag = roleType.Id;
                    listviewRoles.Items.Add(item);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public bool Save()
        {
            try
            {
                UserService userService = new UserService();
                foreach (long roleId in _addedRoleIds)
                {
                    GrantRoleToUserRequest request = new GrantRoleToUserRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.RoleId = roleId;
                    request.UserId = _userId;
                    userService.GrantRoleToUser(request);
                }

                foreach (long roleId in _removedRoleIds)
                {
                    RevokeRoleFromUserRequest request = new RevokeRoleFromUserRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.RoleId = roleId;
                    request.UserId = _userId;
                    userService.RevokeRoleFromUser(request);
                }
                return true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
    }
}
