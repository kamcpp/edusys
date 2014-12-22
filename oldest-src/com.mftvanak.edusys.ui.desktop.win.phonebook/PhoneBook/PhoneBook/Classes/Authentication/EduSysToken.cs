using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.PhoneBook.Classes.Authentication
{
    class EduSysToken : IToken
    {
        private List<Role> _roles;

        public string Email { get; set; }
        public string Value { get; set; }

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
