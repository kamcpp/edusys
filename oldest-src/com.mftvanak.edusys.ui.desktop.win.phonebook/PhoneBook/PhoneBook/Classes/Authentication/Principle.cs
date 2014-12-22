using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.PhoneBook.Classes.Authentication
{
    class Principle
    {
        private List<Role> _roles;

        public string Username { get; set; }
        public string Email { get; set; }
        public string TokenValue { get; set; }

        internal List<Role> Roles
        {
            get
            {
                if (_roles == null)
                {
                    _roles = new List<Role>();
                }
                return _roles;
            }
            set { _roles = value; }
        }

    }
}
