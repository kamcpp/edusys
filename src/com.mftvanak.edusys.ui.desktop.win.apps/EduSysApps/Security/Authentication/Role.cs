using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public class Role
    {
        private long _id;
        private string _name;

        public long Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
    }
}
