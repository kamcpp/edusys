using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.SmsWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using System.Threading;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcWizardControlSmsSummary : UserControl, IWizardStepControl
    {
        private UcWizardControlSendRequest _ucSendRequest;
        private UcWizardControlMobileNumberList _ucMobileNumberList;
        private UcWizardControlSmsTemplate _ucSmsTemplate;

        public UcWizardControlSendRequest UcSendRequest
        {
            get { return _ucSendRequest; }
            set { _ucSendRequest = value; }
        }

        public UcWizardControlMobileNumberList UcMobileNumberList
        {
            get { return _ucMobileNumberList; }
            set { _ucMobileNumberList = value; }
        }

        public UcWizardControlSmsTemplate UcSmsTemplate
        {
            get { return _ucSmsTemplate; }
            set { _ucSmsTemplate = value; }
        }

        public UcWizardControlSmsSummary()
        {
            InitializeComponent();
        }

        public void ShowSummary()
        {
            textboxSendRequestName.Text = UcSendRequest.SendRequestName;
            textboxSendRequestDescription.Text = UcSendRequest.SendRequestDescription;
            ucSmsTextEditor.SmsText = UcSmsTemplate.SmsText;
            labelNumberCount.Text = "شماره های ارسالی (" + UcMobileNumberList.MobileNumbers.Count + " عدد)";
            StringBuilder sb = new StringBuilder();
            foreach (MobileNumber mobileNumber in UcMobileNumberList.MobileNumbers)
            {
                sb.Append(mobileNumber.ValidatedNumber + ",");
            }
            textboxNumbers.Text = sb.ToString().Substring(0, sb.ToString().Length - 1);
            Thread thread = new Thread(DoReadCurrentBalance);
            thread.Start();
        }

        public bool ValidateStepControl()
        {
            return true;
        }

        private void DoReadCurrentBalance()
        {
            try
            {
                SmsService service = new SmsService();
                GetCurrentBalanceRequest request = new GetCurrentBalanceRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                GetCurrentBalanceResponse response = service.GetCurrentBalance(request);
                if (labelCurrentBalance.InvokeRequired)
                {
                    labelCurrentBalance.Invoke(new MethodInvoker(delegate { labelCurrentBalance.Text = "میزان شارژ پنل: " + response.Balance + " ریال"; }));
                }
                else
                {
                    labelCurrentBalance.Text = "میزان شارژ پنل: " + response.Balance + " ریال";
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا در دریافت اطلاعات شارژ پنل", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
