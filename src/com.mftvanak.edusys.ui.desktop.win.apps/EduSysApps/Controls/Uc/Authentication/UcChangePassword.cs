using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.AuthenticationWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication
{
    public partial class UcChangePassword : UserControl
    {
        public delegate void SuccessfulPasswordChangeEventHandler(object sender);
        public delegate void ExceptionOccurredEventHandler(object sender, Exception ex);

        public event SuccessfulPasswordChangeEventHandler SuccessfulPasswordChange;
        public event ExceptionOccurredEventHandler ExceptionOccurred;

        protected virtual void OnSuccessfulPasswordChange()
        {
            if (SuccessfulPasswordChange != null)
            {
                SuccessfulPasswordChange(this);
            }
        }

        protected virtual void OnExceptionOccurred(Exception ex)
        {
            if (ExceptionOccurred != null)
            {
                ExceptionOccurred(this, ex);
            }
        }

        public UcChangePassword()
        {
            InitializeComponent();
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxCurrentPassword.Text))
            {
                errorMessage = "کلمه عبور فعلی الزامی است.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxNewPassword.Text))
            {
                errorMessage = "کلمه عبور جدید الزامی است.";
                hasError = true;
            }
            if (!hasError && textboxNewPassword.Text != textboxNewPasswordConfirmation.Text)
            {
                errorMessage = "کلمه عبور جدید و تکرار آن با هم برابر نیستند.";
                hasError = true;
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return !hasError;
        }

        public void ChangePassword()
        {
            if (!ValidateInformation())
            {
                return;
            }
            try
            {
                AuthenticationContext.DefaultContext.AuthenticationManager.ChangePassword(textboxCurrentPassword.Text, textboxNewPassword.Text);
                OnSuccessfulPasswordChange();                
            }
            catch (Exception ex)
            {
                OnExceptionOccurred(ex);  
            }
        }
    }
}
