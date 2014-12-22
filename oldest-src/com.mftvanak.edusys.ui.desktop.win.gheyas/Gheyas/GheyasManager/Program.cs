using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms;
using System;
using System.Collections.Generic;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes.Authentication;

namespace GheyasManager
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Context.DefaultContext.AuthenticationManager = new BypassAuthenticationManager();

            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new formMain());
        }
    }
}
