using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.AuthenticationWebReference;
using System.Web.Services.Protocols;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using System.Threading;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication
{
    public partial class UcLogin : UserControl
    {
        private bool _errorOccurred;
        private bool _textboxUsernameSelected;

        public delegate void AuthenticatedEventHandler(object sender);
        public delegate void CanceledEventHandler(object sender);
        public delegate void ExceptionOccurredEventHandler(object sender, Exception ex);

        public event AuthenticatedEventHandler Authenticated;
        public event CanceledEventHandler Canceled;
        public event ExceptionOccurredEventHandler ExceptionOccurred;

        public string Username
        {
            get { return textboxUsername.Text; }
            set { textboxUsername.Text = value; }
        }

        protected void OnAuthenticated()
        {
            if (Authenticated != null)
            {
                Authenticated(this);
            }
        }
        protected void OnCanceled()
        {
            if (Canceled != null)
            {
                Canceled(this);
            }
        }
        protected void OnExceptionOccurred(Exception ex)
        {
            if (ExceptionOccurred != null)
            {
                ExceptionOccurred(this, ex);
            }
        }

        public UcLogin()
        {
            InitializeComponent();
            _textboxUsernameSelected = false;
            _errorOccurred = false;
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            Login();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            OnCanceled();
        }

        private void textboxPassword_Enter(object sender, EventArgs e)
        {
            textboxPassword.SelectAll();
        }

        private void textboxUsername_Enter(object sender, EventArgs e)
        {
            textboxUsername.SelectAll();
            if (!_textboxUsernameSelected)
            {
                if (!string.IsNullOrEmpty(textboxUsername.Text))
                {
                    textboxPassword.Focus();
                }
                _textboxUsernameSelected = true;
            }
        }

        public void Login()
        {
            if (String.IsNullOrEmpty(textboxUsername.Text) || String.IsNullOrEmpty(textboxPassword.Text))
            {
                MessageBox.Show("وارد کردن نام کاربری و کلمه عبور الزامی است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            Thread loginThread = new Thread(DoLogin);
            loginThread.Start();
        }

        private void DoLogin()
        {
            if (_errorOccurred)
            {
                _errorOccurred = false;
                return;
            }
            try
            {                
                _errorOccurred = true;
                buttonLogin.Invoke(new MethodInvoker(delegate { buttonLogin.Enabled = false; }));
                buttonCancel.Invoke(new MethodInvoker(delegate { buttonCancel.Enabled = false; }));
                pictureboxLoading.Invoke(new MethodInvoker(delegate { pictureboxLoading.Visible = true; }));
                LogToStatusBar("Connecting ...");
                this.Invoke(new MethodInvoker(delegate { Refresh(); }));
                Principle principle = AuthenticationContext.DefaultContext.AuthenticationManager.Authenticate(textboxUsername.Text, textboxPassword.Text);
                LogToStatusBar("Authenticated.");
                LogToStatusBar("Authorizing ...");
                AuthenticationContext.DefaultContext.AuthorizationManager.Authorize(principle);
                LogToStatusBar("Authorized.");
                OnAuthenticated();
            }
            catch (UserIsNotAuthorizedException ex)
            {
                LogToStatusBar("ERROR: " + ex.Message);
                OnExceptionOccurred(ex);
                _errorOccurred = true;
            }
            catch (SoapHeaderException ex)
            {
                LogToStatusBar("ERROR: " + ex.Message);
                OnExceptionOccurred(ex);
                _errorOccurred = true;
            }
            catch (Exception ex)
            {
                LogToStatusBar("ERROR: " + ex.Message);
                OnExceptionOccurred(ex);
                _errorOccurred = true;
            }
            finally
            {
                try
                {
                    buttonLogin.Invoke(new MethodInvoker(delegate { buttonLogin.Enabled = true; }));
                    buttonCancel.Invoke(new MethodInvoker(delegate { buttonCancel.Enabled = true; }));
                    pictureboxLoading.Invoke(new MethodInvoker(delegate { pictureboxLoading.Visible = false; }));
                }
                catch
                {
                }
            }
        }

        private void LogToStatusBar(string message)
        {
            if (statusbar.InvokeRequired)
            {
                statusbar.Invoke(new MethodInvoker(delegate { toolstripstatuslabelStatus.Text = message; }));
            }
            else
            {
                toolstripstatuslabelStatus.Text = message;
            }
        }

        private void ucLogin_Load(object sender, EventArgs e)
        {            
        }

        private void buttonLogin_MouseMove(object sender, MouseEventArgs e)
        {
            _errorOccurred = false;
        }
    }
}
