using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

using Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.AuthenticationServiceWebReference;

namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    public partial class formLogin : formBase
    {
        public formLogin()
        {
            InitializeComponent();
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            /*try
            {
                AuthenticationRequest request = new AuthenticationRequest();
                request.Username = textboxUsername.Text;
                request.Password = textboxPassword.Text;
                AuthenticationService authenticationService = new AuthenticationService();
                AuthenticationResponse response = authenticationService.Authentication(request);
                if (response.Roles == null || (response.Roles != null && response.Roles.Length == 0))
                {
                    MessageBox.Show("رول های کاربر اشتباه می باشند.", "خطا در ورود", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    LoginInformation.Token = response.Token.TokenValue;
                    LoginInformation.Username = response.Token.Username;
                    LoginInformation.Email = response.Token.Email;
                    LoginInformation.UserId = response.Token.UserId;
                    foreach (RoleType roleType in response.Token.Roles)
                    {
                        LoginInformation.Roles.Add(roleType.Name);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("نام کاربری و یا کلمه عبور اشتباه می باشند.", "خطا در ورود", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }*/
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
