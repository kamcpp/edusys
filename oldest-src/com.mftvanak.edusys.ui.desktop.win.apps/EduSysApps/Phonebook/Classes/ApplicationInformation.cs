using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Phonebook.Classes
{
    class ApplicationInformationImpl : ApplicationInformation
    {
        public string GetApplicationName()
        {
            return "Phonebook";
        }

        public string GetApplicationVersion()
        {
            throw new NotImplementedException();
        }
    }
}
