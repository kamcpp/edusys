using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes
{
    class ApplicationInformationImpl : ApplicationInformation
    {
        public string GetApplicationName()
        {
            return "StaffApp";
        }

        public string GetApplicationVersion()
        {
            return "1.3.13.990";
        }
    }
}
