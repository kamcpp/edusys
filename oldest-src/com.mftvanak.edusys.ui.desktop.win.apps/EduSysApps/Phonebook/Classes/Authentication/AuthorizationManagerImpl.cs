using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Phonebook.Classes.Authentication
{
    class AuthorizationManagerImpl : IAuthorizationManager
    {
        public void Authorize(Principle principle)
        {
            bool isAuthorized = false;
            if (principle.Roles != null)
            {
                foreach (Role role in principle.Roles)
                {
                    if (role.Name == "ROLE_PHONEBOOK")
                    {
                        isAuthorized = true;
                    }
                }
            }
            if (!isAuthorized)
            {
                throw new UserIsNotAuthorizedException("User is not authenticated.");
            }
        }
    }
}
