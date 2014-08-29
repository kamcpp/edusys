using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Web.Services.Protocols;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication
{
    public partial class FormLogin : FormBase
    {
        public string Username
        {
            get { return ucLogin.Username; }
            set { ucLogin.Username = value; }
        }

        public FormLogin()
        {
            InitializeComponent();
        }

        private void ucLogin_Authenticated(object sender)
        {
            DialogResult = System.Windows.Forms.DialogResult.OK;
        }

        private void ucLogin_ExceptionOccurred(object sender, Exception ex)
        {
            MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void ucLogin_Canceled(object sender)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        private void formLogin_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                ucLogin.Login();
            }
        }
    }
}
