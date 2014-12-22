using System;
using System.Collections.Generic;
using System.Threading;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Forms;

namespace StaffApp
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Thread.CurrentThread.CurrentUICulture = new System.Globalization.CultureInfo("fa-IR");

            AuthenticationContext.DefaultContext.ApplicationInformation = new ApplicationInformationImpl();
            AuthenticationContext.DefaultContext.AuthenticationManager = new EduSysAuthenticationManager();
            AuthenticationContext.DefaultContext.AuthorizationManager = new AuthorizationManagerImpl();

            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new formSplash());
        }
    }
}
