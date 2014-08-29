using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.PhoneBook.Classes.Authentication
{
    interface IUsernamePasswordCredential : ICredential
    {
        string Username { get; }
        string Password { get; }
    }
}
