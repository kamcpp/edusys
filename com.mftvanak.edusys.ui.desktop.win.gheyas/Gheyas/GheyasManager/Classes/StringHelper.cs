using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes
{
    class StringHelper
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
    }
}
