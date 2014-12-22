using System;
using System.Collections.Generic;
using System.Text;

namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook
{
    public static class LoginInformation
    {
        private static List<string> roles_;

        public static long UserId { get; set; }
        public static string Username { get; set; }
        public static string Email { get; set; }
        public static string Token { get; set; }
        public static List<string> Roles
        {
            get
            {
                if (roles_ == null)
                {
                    roles_ = new List<string>();
                }
                return roles_;
            }
        }
    }
}
