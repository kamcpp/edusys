using System;
using System.Collections.Generic;
using System.Configuration;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes
{
    public static class GeneralSettings
    {
        private static List<long> _instituteIds;

        public static List<long> InstituteIds
        {
            get
            {
                if (_instituteIds == null)
                {
                    string instituteIds = ConfigurationManager.AppSettings["InstituteIds"].ToString();
                    string[] tokens = instituteIds.Split(',');
                    _instituteIds = new List<long>();
                    foreach (string token in tokens)
                    {
                        _instituteIds.Add(long.Parse(token));
                    }
                }
                return _instituteIds;
            }
        }

        public static long? LastSelectedUserId
        {
            get
            {
                return null;
            }
            set
            {
            }
        }
    }
}
