using System;
using System.Collections.Generic;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Classes.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            AuthenticationContext.DefaultContext.ApplicationInformation = new ApplicationInformationImpl();
            AuthenticationContext.DefaultContext.AuthenticationManager = new EduSysAuthenticationManager();
            AuthenticationContext.DefaultContext.AuthorizationManager = new AuthorizationManagerImpl();

            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new formMain());
        }
    }
}
