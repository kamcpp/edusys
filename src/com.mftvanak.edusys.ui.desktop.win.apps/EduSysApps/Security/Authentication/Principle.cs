using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public class Principle
    {
        private long _userId;
        private string _username;
        private string _fullName;
        private string _accountEmail;
        private string _email1;
        private string _email2;
        private string _phone1;
        private string _phone2;
        private string _phone3;
        private string _token;
        private List<Role> _roles;

        public long UserId
        {
            get { return _userId; }
            set { _userId = value; }
        }

        public string Username
        {
            get { return _username; }
            set { _username = value; }
        }

        public string FullName
        {
            get { return _fullName; }
            set { _fullName = value; }
        }

        public string AccountEmail
        {
            get { return _accountEmail; }
            set { _accountEmail = value; }
        }

        public string Email1
        {
            get { return _email1; }
            set { _email1 = value; }
        }

        public string Email2
        {
            get { return _email2; }
            set { _email2 = value; }
        }

        public string Phone1
        {
            get { return _phone1; }
            set { _phone1 = value; }
        }

        public string Phone2
        {
            get { return _phone2; }
            set { _phone2 = value; }
        }

        public string Phone3
        {
            get { return _phone3; }
            set { _phone3 = value; }
        }

        public string Token
        {
            get { return _token; }
            set { _token = value; }
        }

        public List<Role> Roles
        {
            get { return _roles; }
            set { _roles = value; }
        }


        public Principle()
        {
            _roles = new List<Role>();
        }

        public bool HashRole(string roleName)
        {
            if (_roles == null)
            {
                return false;
            }
            foreach (Role role in _roles)
            {
                if (role.Name == roleName)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
