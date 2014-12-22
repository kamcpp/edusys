using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership
{
    public partial class FormEditRole : FormBase
    {
        private Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference.RoleType _roleType;

        public Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference.RoleType RoleType
        {
            get { return _roleType; }
            set
            {
                _roleType = value;
                if (_roleType != null)
                {
                    textboxName.Text = _roleType.Name;
                }
            }
        }

        public FormEditRole()
        {
            InitializeComponent();
        }

        private void formEditRole_Load(object sender, EventArgs e)
        {
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            try
            {
                RoleService roleService = new RoleService();
                if (_roleType == null)
                {
                    Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference.RoleType roleType = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.RoleWebReference.RoleType();
                    roleType.Name = textboxName.Text;
                    AddRoleRequest request = new AddRoleRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Role = roleType;
                    roleService.AddRole(request);
                    _roleType = roleType;
                }
                else
                {
                    _roleType.Name = textboxName.Text;
                    UpdateRoleRequest request = new UpdateRoleRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Role = _roleType;
                    roleService.UpdateRole(request);
                }
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
