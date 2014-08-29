using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public interface IAuthorizationManager
    {
        void Authorize(Principle principle);
    }
}
