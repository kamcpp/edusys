using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Classes
{
    class ApplicationInformationImpl : ApplicationInformation
    {
        public string GetApplicationName()
        {
            return "AdminApp";
        }

        public string GetApplicationVersion()
        {
            return "1.1.2.830";
        }
    }
}
