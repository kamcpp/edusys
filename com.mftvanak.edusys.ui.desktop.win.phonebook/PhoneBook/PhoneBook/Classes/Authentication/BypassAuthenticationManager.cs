using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.PhoneBook.Classes.Authentication
{
    class BypassAuthenticationManager : IAuthenticationManager
    {
        public IToken Authenticate(ICredential credential)
        {
            EduSysToken token = new EduSysToken();
            token.Email = "temp@edusys.com";
            token.Roles.Add(new Role() { Id = 1, Name = "ROLE_ADMIN" });
            token.Value = "123";
            return token;
        }
    }
}
