using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public class UserIsNotAuthorizedException : Exception
    {
        public UserIsNotAuthorizedException(string message)
            : base(message)
        {
        }
    }
}
