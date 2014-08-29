using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
{
    public partial class formLogin : formBase
    {
        public formLogin()
        {
            InitializeComponent();
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            try
            {
                buttonLogin.Enabled = false;
                this.Refresh();
                EduSysToken token = (EduSysToken)Context.DefaultContext.AuthenticationManager.Authenticate(new UsernamePasswordCredentialImpl(textboxUsername.Text, textboxPassword.Text));
                Context.DefaultContext.CurrentPrinciple = new Principle();
                Context.DefaultContext.CurrentPrinciple.Email = token.Email;
                Context.DefaultContext.CurrentPrinciple.TokenValue = token.Value;
                Context.DefaultContext.CurrentPrinciple.Username = textboxUsername.Text;
                Context.DefaultContext.CurrentPrinciple.Roles.AddRange(token.Roles);
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
            catch (Exception)
            {
                textboxUsername.Focus();
                MessageBox.Show("نام کاربری و یا کلمه عبور اشتباه است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                buttonLogin.Enabled = true;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }
    }
}
