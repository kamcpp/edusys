using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication
{
    public partial class FormChangePassword : FormBase
    {
        public FormChangePassword()
        {
            InitializeComponent();
        }

        private void buttonChangePassword_Click(object sender, EventArgs e)
        {
            ucChangePassword.ChangePassword();
        }

        private void ucChangePassword_ExceptionOccurred(object sender, Exception ex)
        {
            MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        private void ucChangePassword_SuccessfulPasswordChange(object sender)
        {
            MessageBox.Show("کلمه عبور با موفقیت تغییر یافت. لطفا از برنامه خارج شده و دوباره وارد شوید.", "تغییر کلمه عبور", MessageBoxButtons.OK, MessageBoxIcon.Information);
            DialogResult = System.Windows.Forms.DialogResult.OK;
        }
    }
}
