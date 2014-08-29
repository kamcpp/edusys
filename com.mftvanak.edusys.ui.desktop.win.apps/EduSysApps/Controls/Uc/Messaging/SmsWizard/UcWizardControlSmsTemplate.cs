using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.MessageTemplateWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcWizardControlSmsTemplate : UserControl, IWizardStepControl
    {
        public string SmsText
        {
            get { return ucSmsTextEditor.SmsText; }
            set { ucSmsTextEditor.SmsText = value; }
        }

        public UcWizardControlSmsTemplate()
        {
            InitializeComponent();
        }

        public bool ValidateStepControl()
        {
            if (string.IsNullOrEmpty(ucSmsTextEditor.SmsText))
            {
                MessageBox.Show("متن قالب خالی است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            if (ucSmsTextEditor.SmsCount > 0)
            {
                if (MessageBox.Show("اندازه قالب بیش از یک پیامک است. پیشنهاد می شود که متن مورد نظر را در یک پیامک بگنجانید. آیا مطمئن به ادامه هستید؟", "هشدار در مورد طول پیامک", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.Yes)
                {
                    return true;
                }
                return false;
            }
            return true;
        }

        private void buttonSaveSmsMessageTemplate_Click(object sender, EventArgs e)
        {
            FormEditSmsMessageTemplate form = new FormEditSmsMessageTemplate();
            form.MessageTemplate = new MessageTemplateType();
            form.MessageTemplate.Text = form.UcSmsMessageTemplate.SmsText = ucSmsTextEditor.SmsText;
            form.UcSmsMessageTemplate.Description = "اضافه شده توسط " + AuthenticationContext.DefaultContext.CurrentPrinciple.FullName + " در تاریخ " + FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(DateTime.UtcNow).ToString() + " به زمان UTC";
            form.IsNew = true;
            form.ShowDialog();
        }

        private void buttonSelectSmsMessageTemplate_Click(object sender, EventArgs e)
        {
            FormMessageTemplateExplorer form = new FormMessageTemplateExplorer();
            form.MessageTemplateExplorer.LoadMyMessageTemplates();
            form.MessageTemplateExplorer.LoadAllMessageTemplates();
            form.MessageTemplateExplorer.MessageTemplateType = MessageTemplateTypeEnum.Sms;
            if (form.ShowDialog() == DialogResult.OK)
            {
                if (form.MessageTemplateExplorer.SelectedMessageTemplate != null)
                {
                    ucSmsTextEditor.SmsText = form.MessageTemplateExplorer.SelectedMessageTemplate.Text.Replace("\n", "\r\n");
                }
            }
        }
    }
}
