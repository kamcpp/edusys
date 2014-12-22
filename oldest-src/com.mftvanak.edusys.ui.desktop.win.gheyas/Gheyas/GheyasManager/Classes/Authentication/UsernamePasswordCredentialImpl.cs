using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes.Authentication
{
    class UsernamePasswordCredentialImpl : IUsernamePasswordCredential
    {
        public string Username { get; set; }
        public string Password { get; set; }

        public UsernamePasswordCredentialImpl(string username, string password)
        {
            Username = username;
            Password = password;
        }
    }
}
