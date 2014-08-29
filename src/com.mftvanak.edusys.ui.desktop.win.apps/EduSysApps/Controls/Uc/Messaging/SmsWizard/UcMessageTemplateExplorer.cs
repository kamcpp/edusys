using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.MessageTemplateWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcMessageTemplateExplorer : UserControl
    {
        public MessageTemplateTypeEnum MessageTemplateType
        {
            get { return ucmessagetemplatesMine.MessageTemplateType; }
            set { ucmessagetemplatesMine.MessageTemplateType = ucmessagetemplatesAll.MessageTemplateType = value; }
        }

        public MessageTemplateType SelectedMessageTemplate
        {
            get
            {
                if (tabControl.SelectedTab == tabpageMine)
                {
                    return ucmessagetemplatesMine.SelectedMessageTemplate;
                }
                else if(tabControl.SelectedTab == tabpageAll)
                {
                    return ucmessagetemplatesAll.SelectedMessageTemplate;
                }
                return null;
            }
        }

        public UcMessageTemplateExplorer()
        {
            InitializeComponent();
        }

        public void LoadMyMessageTemplates()
        {
            try
            {
                MessageTemplateService service = new MessageTemplateService();
                GetMessageTemplatesByOwnerIdRequest request = new GetMessageTemplatesByOwnerIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                request.Count = 0;
                MessageTemplateType[] messageTemplates = service.GetMessageTemplatesByOwnerId(request);
                ucmessagetemplatesMine.MessageTemplates = new List<MessageTemplateType>(messageTemplates);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void LoadAllMessageTemplates()
        {
            try
            {
                MessageTemplateService service = new MessageTemplateService();
                GetMessageTemplatesRequest request = new GetMessageTemplatesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                MessageTemplateType[] messageTemplates = service.GetMessageTemplates(request);
                ucmessagetemplatesAll.MessageTemplates = new List<MessageTemplateType>(messageTemplates);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void buttonNewMessageTemplate_Click(object sender, EventArgs e)
        {
            FormEditSmsMessageTemplate form = new FormEditSmsMessageTemplate();
            form.MessageTemplate = new MessageTemplateType();
            form.IsNew = true;
            form.UcSmsMessageTemplate.Description = "اضافه شده توسط " + AuthenticationContext.DefaultContext.CurrentPrinciple.FullName + " در تاریخ " + FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(DateTime.UtcNow).ToString() + " به زمان UTC";
            if (form.ShowDialog() == DialogResult.OK)
            {
                LoadMyMessageTemplates();
                LoadAllMessageTemplates();
            }
        }

        private void buttonRefreshMyMessageTemplates_Click(object sender, EventArgs e)
        {
            LoadMyMessageTemplates();
        }

        private void buttonRefreshAllMessageTemplates_Click(object sender, EventArgs e)
        {
            LoadAllMessageTemplates();
        }

        private void ucmessagetemplatesMine_NeedsRefresh(object sender)
        {
            LoadMyMessageTemplates();
            LoadAllMessageTemplates();
        }

        private void buttonRemoveMessageTemplate_Click(object sender, EventArgs e)
        {
            if(SelectedMessageTemplate == null )
            {
                return;
            }
            if (SelectedMessageTemplate.OwnerId != AuthenticationContext.DefaultContext.CurrentPrinciple.UserId)
            {
                return;
            }
            if (MessageBox.Show("آیا اطمینان به حذف قالب دارید؟", "اخطار", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.No)
            {
                return;
            }
            try
            {
                MessageTemplateService service = new MessageTemplateService();
                DeleteMessageTemplateRequest request = new DeleteMessageTemplateRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.MessageTemplateId = SelectedMessageTemplate.Id;
                service.DeleteMessageTemplate(request);
                LoadMyMessageTemplates();
                LoadAllMessageTemplates();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
