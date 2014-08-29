using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Cryptoghraphy
{
    public class Sha1HashProvider : HashProvider
    {
        public string GetHash(string s)
        {
            byte[] bytes = Encoding.UTF8.GetBytes(s);
            var sha1 = SHA1.Create();
            byte[] hashBytes = sha1.ComputeHash(bytes);
            return HexStringFromBytes(hashBytes);
        }

        public string HexStringFromBytes(byte[] bytes)
        {
            var sb = new StringBuilder();
            foreach (byte b in bytes)
            {
                var hex = b.ToString("x2");
                sb.Append(hex);
            }
            return sb.ToString();
        }
    }
}
