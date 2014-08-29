using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public interface IAuthenticationManager
    {
        Principle Authenticate(string username, string password);
        void ChangePassword(string currentPassword, string newPassword);
    }
}
