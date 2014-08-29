using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes.Authentication
{
    interface IAuthenticationManager
    {
        IToken Authenticate(ICredential credential);
    }
}
