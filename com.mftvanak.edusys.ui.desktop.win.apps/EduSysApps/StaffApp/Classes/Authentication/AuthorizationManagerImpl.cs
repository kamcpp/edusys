using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes.Authentication
{
    class AuthorizationManagerImpl : IAuthorizationManager
    {
        public void Authorize(Principle principle)
        {
            bool isAuthorized = false;
            isAuthorized = true;
            if (!isAuthorized)
            {
                throw new UserIsNotAuthorizedException("User is not authenticated.");
            }
        }
    }
}
