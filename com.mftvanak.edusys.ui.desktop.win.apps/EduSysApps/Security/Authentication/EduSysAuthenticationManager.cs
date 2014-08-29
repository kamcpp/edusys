using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.AuthenticationWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Cryptoghraphy;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public class EduSysAuthenticationManager : IAuthenticationManager
    {
        public Principle Authenticate(string username, string password)
        {
            AuthenticationService service = new AuthenticationService();
            AuthenticationRequest request = new AuthenticationRequest();
            ClientInformation.FillWithClientInformation(request);
            request.Username = username;
            request.Password = new Sha1HashProvider().GetHash(password);
            AuthenticationResponse response = service.Authentication(request);
            AuthenticationContext.DefaultContext.CurrentPrinciple = new Principle();
            AuthenticationContext.DefaultContext.CurrentPrinciple.UserId = response.UserId;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Username = username;
            AuthenticationContext.DefaultContext.CurrentPrinciple.FullName = response.PersianFullName;
            AuthenticationContext.DefaultContext.CurrentPrinciple.AccountEmail = response.AccountEmail;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Email1 = response.Email1;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Email2 = response.Email2;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Phone1 = response.Phone1;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Phone2 = response.Phone2;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Phone3 = response.Phone3;
            AuthenticationContext.DefaultContext.CurrentPrinciple.Token = response.Token;
            if (response.Roles != null)
            {
                foreach (RoleType roleType in response.Roles)
                {
                    AuthenticationContext.DefaultContext.CurrentPrinciple.Roles.Add(new Role() { Id = roleType.Id, Name = roleType.Name });
                }
            }
            return AuthenticationContext.DefaultContext.CurrentPrinciple;
        }

        public void ChangePassword(string currentPassword, string newPassword)
        {
            AuthenticationService service = new AuthenticationService();
            ChangePasswordRequest request = new ChangePasswordRequest();
            ClientInformation.FillWithClientInformation(request);
            request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
            request.Username = AuthenticationContext.DefaultContext.CurrentPrinciple.Username;
            request.CurrentHashedPassword = new Sha1HashProvider().GetHash(currentPassword);
            request.NewHashedPassword = new Sha1HashProvider().GetHash(newPassword);
            service.ChangePassword(request);
        }
    }
}
