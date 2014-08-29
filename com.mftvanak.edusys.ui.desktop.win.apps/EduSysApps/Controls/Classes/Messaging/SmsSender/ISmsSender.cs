using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsSender
{
    public interface ISmsSender
    {
        void submitSms(string to, string body);

        void submitSms(string[] to, string[] body);

        void submitSms(string[] to, string body);
    }
}
