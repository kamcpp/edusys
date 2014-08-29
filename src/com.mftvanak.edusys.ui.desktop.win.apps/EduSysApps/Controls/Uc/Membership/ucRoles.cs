using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    public partial class UcRoles : UserControl
    {
        public UcRoles()
        {
            InitializeComponent();
        }

        private void ucCrudToolbar_AfterAddClicked(object sender)
        {
            NewRole();
        }

        private void ucCrudToolbar_AfterDeleteClicked(object sender)
        {
            DeleteRole();
        }

        private void ucCrudToolbar_AfterEditClicked(object sender)
        {
            EditRole();
        }

        private void ucCrudToolbar_AfterRefreshClicked(object sender)
        {
            LoadRoles();
        }

        private void listviewRoles_DoubleClick(object sender, EventArgs e)
        {
            EditRole();
        }

        public void LoadRoles()
        {
            try
            {
                GetRolesRequest request = new GetRolesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                RoleService roleService = new RoleService();
                RoleType[] roles = roleService.GetRoles(request);
                int counter = 1;
                listviewRoles.Items.Clear();
                foreach (RoleType roleType in roles)
                {
                    ListViewItem item = new ListViewItem();
                    item.Text = counter.ToString();
                    item.SubItems.Add(roleType.Id.ToString());
                    item.SubItems.Add(roleType.Name);
                    listviewRoles.Items.Add(item);
                    counter++;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void NewRole()
        {
            try
            {
                FormEditRole form = new FormEditRole();
                if (form.ShowDialog() == DialogResult.OK)
                {
                    LoadRoles();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void EditRole()
        {
            try
            {
                if (listviewRoles.SelectedItems.Count == 0)
                {
                    return;
                }
                RoleType roleType = new RoleType();
                roleType.Id = long.Parse(listviewRoles.SelectedItems[0].SubItems[1].Text);
                roleType.Name = listviewRoles.SelectedItems[0].SubItems[3].Text;
                FormEditRole form = new FormEditRole();
                form.RoleType = roleType;
                if (form.ShowDialog() == DialogResult.OK)
                {
                    LoadRoles();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void DeleteRole()
        {
            try
            {
                if (listviewRoles.SelectedItems.Count == 0)
                {
                    return;
                }
                long nodeId = long.Parse(listviewRoles.SelectedItems[0].SubItems[1].Text);
                if (MessageBox.Show("آیا مطمئن به حذف هستید؟", "اخطار", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.Yes)
                {
                    DeleteRoleRequest request = new DeleteRoleRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.RoleId = nodeId;
                    RoleService roleService = new RoleService();
                    roleService.DeleteRole(request);
                    LoadRoles();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
