using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Cryptoghraphy
{
    public interface HashProvider
    {
        string GetHash(string input);
    }
}
