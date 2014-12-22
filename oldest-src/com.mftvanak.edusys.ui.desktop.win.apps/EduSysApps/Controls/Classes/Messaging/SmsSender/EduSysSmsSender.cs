using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.SendListWebReference;
using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsSender
{
    public class EduSysSmsSender : ISmsSender
    {
        private long _sendRequestId;

        public long SendRequestId
        {
            get { return _sendRequestId; }
            set { _sendRequestId = value; }
        }

        public void submitSms(string to, string body)
        {
            if (!AuthenticationContext.DefaultContext.CurrentPrinciple.HashRole("ROLE_SMS"))
            {
                return;
            }
            SendListService sendListService = new SendListService();
            AddSendListItemRequest request = new AddSendListItemRequest();
            ClientInformation.FillWithClientInformation(request);
            request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;           
            DateTime now = DateTime.UtcNow;
            request.SendListItem = new SendListItemType();
            request.SendListItem.ClientSubmitDateTimeYear = now.Year;
            request.SendListItem.ClientSubmitDateTimeMonth = now.Month;
            request.SendListItem.ClientSubmitDateTimeDay = now.Day;
            request.SendListItem.ClientSubmitDateTimeHour = now.Hour;
            request.SendListItem.ClientSubmitDateTimeMinute = now.Minute;
            request.SendListItem.ClientSubmitDateTimeSecond = now.Second;
            request.SendListItem.ClientSubmitDateTimeMilliSecond = now.Millisecond;
            // request.SendListItem.sendreq
            // request.SendListItem.To = to;
            request.SendListItem.Body = body;
            request.SendListItem.Status = 1;
            request.SendListItem.Type = 1;
            request.SendListItem.ContentType = 1;
            request.SendListItem.Delivery = 1;
            request.SendListItem.NumberOfTries = 0;
            request.SendListItem.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
            AddSendListItemResponse response =  sendListService.AddSendListItem(request);
        }

        public void submitSms(string[] to, string[] body)
        {
            for (int i = 0; i < to.Length; i++)
            {
                submitSms(to[i], body[i]);
            }
        }

        public void submitSms(string[] to, string body)
        {
            for (int i = 0; i < to.Length; i++)
            {
                submitSms(to[i], body);
            }
        }
    }
}
