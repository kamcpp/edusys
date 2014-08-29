using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using Microsoft.Win32;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes
{
    public static class ApplicationSettings
    {
        private static NotifyIcon _notifyControl;

        public static NotifyIcon NotifyControl
        {
            get { return _notifyControl; }
            set { _notifyControl = value; }
        }

        public static string InitialUsername
        {
            get
            {
                RegistryKey key = Registry.CurrentUser.OpenSubKey("Software\\EduSys");
                if (key == null)
                {
                    Registry.CurrentUser.CreateSubKey("Software\\EduSys");
                    key = Registry.CurrentUser.OpenSubKey("Software\\EduSys");
                }
                object result = key.GetValue("InitialUsername");
                if (result == null)
                {
                    return "";
                }
                key.Close();
                return result.ToString();
            }
            set
            {
                RegistryKey key = Registry.CurrentUser.OpenSubKey("Software\\EduSys", true);
                if (key == null)
                {
                    Registry.CurrentUser.CreateSubKey("Software\\EduSys");
                    key = Registry.CurrentUser.OpenSubKey("Software\\EduSys", true);
                }
                key.SetValue("InitialUsername", value, RegistryValueKind.String);
                key.Close();
            }
        }
    }
}
