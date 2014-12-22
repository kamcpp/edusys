using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers
{
    public class StringHelper
    {
        public static string MakeCompatibleString(string str)
        {
            string res = "";
            for (int i = 0; i < str.Length; i++)
            {
                if ((int)str[i] == 1740)
                {
                    res += (char)(1610);
                }
                else if ((int)str[i] == 1705)
                {
                    res += (char)1603;
                }
                else
                {
                    res += str[i];
                }
            }
            return res;
        }

        public static bool IsAsciiString(string str)
        {
            string strOut = Encoding.ASCII.GetString(Encoding.ASCII.GetBytes(str));
            return strOut == str;
        }

        public static string Get3CharsCommaSeperated(string str)
        {
            string reversed = "";
            int counter = 0;
            for (int i = str.Length - 1; i >= 0; i--)
            {
                reversed += str[i];
                counter++;
                if (counter % 3 == 0 && counter < str.Length)
                {
                    reversed += ",";
                }
            }
            string result = "";
            for (int i = reversed.Length - 1; i >= 0; i--)
            {
                result += reversed[i];
            }
            return result;
        }
    }
}
