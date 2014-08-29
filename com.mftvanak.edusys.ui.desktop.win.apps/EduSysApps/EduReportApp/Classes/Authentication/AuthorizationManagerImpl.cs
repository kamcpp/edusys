using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.EduReportApp.Classes.Authentication
{
    class AuthorizationManagerImpl : IAuthorizationManager
    {
        public void Authorize(Principle principle)
        {
            bool isEmployee = false;
            if (principle.Roles != null)
            {
                foreach (Role role in principle.Roles)
                {
                    if (role.Name == "ROLE_EDU_REPORT")
                    {
                        isEmployee = true;
                    }
                }
            }
            if (!isEmployee)
            {
                throw new UserIsNotAuthorizedException("User is not authorized.");
            }
        }
    }
}
