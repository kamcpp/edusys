using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    class BypassAuthenticationManager : IAuthenticationManager
    {
        public Principle Authenticate(string username, string password)
        {
            Principle principle = new Principle();
            principle.Username = username;
            principle.AccountEmail = "";
            principle.Token = "";
            principle.Roles.Add(new Role() { Id = 1, Name = "ROLE_ADMIN" });
            AuthenticationContext.DefaultContext.CurrentPrinciple = principle;
            return principle;
        }


        public void ChangePassword(string currentPassword, string newPassword)
        {
            throw new NotImplementedException();
        }
    }
}
