using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.PhoneBook.Classes
{
    class StringHelper
    {
        public static string MakeCompatibleString(string str)
        {
            string res = "";
            for (int i = 0; i < str.Length; i++)
            {
                if ((int)str[i] == 1610)
                {
                    res += (char)(1740);
                }
                else if ((int)str[i] == 1603)
                {
                    res += (char)1705;
                }
                else
                {
                    res += str[i];
                }
            }
            return res;
        }
    }
}
