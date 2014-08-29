using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.UserWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.AuthenticationWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Cryptoghraphy;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    public partial class UcEditUser : UserControl
    {
        private bool _isNew;
        private long _personId;
        private string _originalUsername;
        private string _originalEmail;
        private string _originalHashedPasswrod;
        private UserType _user;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public long PersonId
        {
            get { return _personId; }
            set { _personId = value; }
        }

        public UserType User
        {
            get { return _user; }
            set
            {
                _user = value;
                if (_user != null)
                {
                    _isNew = false;
                    textboxUsername.Text = _user.Username;
                    textboxAccountEmail.Text = _user.AccountEmail;
                    textboxPassword.Text = _user.HashedPassword;
                    textboxPasswordConfirmation.Text = _user.HashedPassword;
                    checkboxActive.Checked = _user.Active;

                    _originalUsername = _user.Username;
                    _originalEmail = _user.AccountEmail;
                    _originalHashedPasswrod = _user.HashedPassword;

                    ucRolesForUser.UserId = _user.PersonId;
                }
            }
        }

        public UcEditUser()
        {
            InitializeComponent();
            _user = null;
            _isNew = true;
        }

        private void ucEditUser_Load(object sender, EventArgs e)
        {
            if (!_isNew)
            {
                ucRolesForUser.LoadData();
            }
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxUsername.Text))
            {
                errorMessage = "نام کاربری می بایست وارد شود.";
                hasError = true;
            }
            else if (string.IsNullOrEmpty(textboxPassword.Text) || string.IsNullOrEmpty(textboxPasswordConfirmation.Text))
            {
                errorMessage = "کلمه عبور و تکرار آن الزامی است.";
                hasError = true;
            }
            else if (string.IsNullOrEmpty(textboxAccountEmail.Text))
            {
                errorMessage = "ایمیل الزامی است.";
                hasError = true;
            }
            else if (textboxPassword.Text != textboxPasswordConfirmation.Text)
            {
                errorMessage = "کلمه عبور و تکرار آن می بایست برابر باشند.";
                hasError = true;
            }

            if (!hasError && _originalUsername != textboxUsername.Text)
            {
                AuthenticationService authService = new AuthenticationService();
                UserExistsByUsernameRequest request = new UserExistsByUsernameRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Username = StringHelper.MakeCompatibleString(textboxUsername.Text);
                UserExistsByUsernameResponse response = authService.UserExistsByUsername(request);
                if (response.Result)
                {
                    errorMessage = "کاربری با این نام کاربری موجود است.";
                    hasError = true;
                }
            }
            if (!hasError && _originalEmail != textboxAccountEmail.Text)
            {
                AuthenticationService authService = new AuthenticationService();
                UserExistsByEmailRequest request = new UserExistsByEmailRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Email = StringHelper.MakeCompatibleString(textboxAccountEmail.Text);
                UserExistsByEmailResponse response = authService.UserExistsByEmail(request);
                if (response.Result)
                {
                    errorMessage = "کاربری با این ایمیل موجود است.";
                    hasError = true;
                }
            }

            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        public bool Save()
        {
            try
            {
                UserService userService = new UserService();
                _user.PersonId = _personId;
                _user.Username = StringHelper.MakeCompatibleString(textboxUsername.Text);
                _user.AccountEmail = StringHelper.MakeCompatibleString(textboxAccountEmail.Text);
                if (textboxPassword.Text == _originalHashedPasswrod)
                {
                    _user.HashedPassword = _originalHashedPasswrod;
                }
                else
                {
                    _user.HashedPassword = new Sha1HashProvider().GetHash(textboxPassword.Text);
                }
                _user.Active = checkboxActive.Checked;

                if (_isNew)
                {
                    AddUserRequest request = new AddUserRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.User = _user;
                    userService.AddUser(request);
                    _isNew = false;
                }
                else
                {
                    UpdateUserRequest request = new UpdateUserRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.User = _user;
                    userService.UpdateUser(request);
                }
                _originalUsername = _user.Username;
                _originalEmail = _user.AccountEmail;

                ucRolesForUser.UserId = PersonId;
                return ucRolesForUser.Save();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
    }
}
