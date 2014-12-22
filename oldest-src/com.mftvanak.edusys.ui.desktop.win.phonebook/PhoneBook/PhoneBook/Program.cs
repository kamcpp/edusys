using System;
using System.Collections.Generic;
using System.Windows.Forms;

using Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms;

namespace PhoneBook
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new formMain());
        }
    }
}
