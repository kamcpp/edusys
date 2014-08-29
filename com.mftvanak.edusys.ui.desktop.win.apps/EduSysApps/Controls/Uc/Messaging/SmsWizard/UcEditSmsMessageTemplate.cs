using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.MessageTemplateWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcEditSmsMessageTemplate : UserControl
    {
        private bool _isNew;
        private MessageTemplateType _messageTemplate;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public MessageTemplateType MessageTemplate
        {
            get { return _messageTemplate; }
            set
            {
                _messageTemplate = value;

                if (_messageTemplate != null)
                {
                    _isNew = false;
                    textboxName.Text = _messageTemplate.Name != null ? _messageTemplate.Name.Replace("\n", "\r\n") : null;
                    textboxDescription.Text = _messageTemplate.Description != null ? _messageTemplate.Description.Replace("\n", "\r\n") : null; ;
                    ucSmsTextEditor.SmsText = _messageTemplate.Text != null ? _messageTemplate.Text.Replace("\n", "\r\n") : null; 
                }
            }
        }

        public string TemplateName
        {
            get { return textboxName.Text; }
            set { textboxName.Text = value; }
        }

        public string SmsText
        {
            get { return ucSmsTextEditor.SmsText; }
            set { ucSmsTextEditor.SmsText = value; }
        }

        public string Description
        {
            get { return textboxDescription.Text; }
            set { textboxDescription.Text = value; }
        }

        public UcEditSmsMessageTemplate()
        {
            InitializeComponent();
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxName.Text))
            {
                errorMessage = "نام قالب الزامی است.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(ucSmsTextEditor.SmsText))
            {
                errorMessage = "متن پیامک الزامی است.";
                hasError = true;
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return !hasError;
        }

        public bool Save()
        {
            try
            {
                MessageTemplateService service = new MessageTemplateService();
                _messageTemplate.Name = textboxName.Text;
                _messageTemplate.Description = textboxDescription.Text;
                _messageTemplate.Text = ucSmsTextEditor.SmsText;
                _messageTemplate.Type = 1;
                _messageTemplate.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                if (_isNew)
                {
                    AddMessageTemplateRequest request = new AddMessageTemplateRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.MessageTemplate = _messageTemplate;
                    AddMessageTemplateResponse response = service.AddMessageTemplate(request);
                    _messageTemplate.Id = response.MessageTemplateId;
                    _isNew = false;
                }
                else
                {
                    UpdateMessageTemplateRequest request = new UpdateMessageTemplateRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.MessageTemplate = _messageTemplate;
                    service.UpdateMessageTemplate(request);
                }
                return true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
    }
}
