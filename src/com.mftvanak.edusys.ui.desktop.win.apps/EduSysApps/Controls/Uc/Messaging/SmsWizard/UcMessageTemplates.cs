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
    public enum MessageTemplateTypeEnum
    {
        Both = 0,
        Sms = 1,
        Email = 2
    }

    public partial class UcMessageTemplates : UserControl
    {
        public delegate void NeedsRefreshEventHandler(object sender);

        public event NeedsRefreshEventHandler NeedsRefresh;

        protected virtual void OnNeedsRefresh()
        {
            if (NeedsRefresh != null)
            {
                NeedsRefresh(this);
            }
        }

        public bool Editable { get; set; }

        private List<MessageTemplateType> _messageTemplates;

        public List<MessageTemplateType> MessageTemplates
        {
            get { return _messageTemplates; }
            set
            {
                _messageTemplates = value;
                if (_messageTemplates != null)
                {
                    LoadMessageTemplates();
                }
            }
        }

        public MessageTemplateTypeEnum MessageTemplateType { get; set; }

        public MessageTemplateType SelectedMessageTemplate
        {
            get
            {
                if (datagridviewMessageTemplates.SelectedCells.Count == 0)
                {
                    return null;
                }
                return datagridviewMessageTemplates.SelectedCells[0].OwningRow.Tag as MessageTemplateType;
            }
        }

        public UcMessageTemplates()
        {
            InitializeComponent();
            Editable = false;
        }

        public void LoadMessageTemplates()
        {
            if (datagridviewMessageTemplates.InvokeRequired)
            {
                datagridviewMessageTemplates.Invoke(new MethodInvoker(delegate { datagridviewMessageTemplates.Rows.Clear(); }));
            }
            else
            {
                datagridviewMessageTemplates.Rows.Clear();
            }
            int counter = 1;
            foreach (MessageTemplateType messageTemplate in _messageTemplates)
            {
                DataGridViewRow row = new DataGridViewRow();
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = messageTemplate.Id, ValueType = typeof(int) });
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = messageTemplate.Name, ValueType = typeof(string) });
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = messageTemplate.OwnerFullName, ValueType = typeof(string) });
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = messageTemplate.Text, ValueType = typeof(string) });
                row.Cells.Add(new DataGridViewTextBoxCell() { Value = messageTemplate.Description, ValueType = typeof(string) });
                row.Tag = messageTemplate;
                if (datagridviewMessageTemplates.InvokeRequired)
                {
                    datagridviewMessageTemplates.Invoke(new MethodInvoker(delegate { datagridviewMessageTemplates.Rows.Add(row); }));
                }
                else
                {
                    datagridviewMessageTemplates.Rows.Add(row);
                }
                counter++;
            }
        }

        private void datagridviewMessageTemplates_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (!Editable)
            {
                return;
            }
            if (datagridviewMessageTemplates.SelectedCells.Count == 0)
            {
                return;
            }
            MessageTemplateType selectedMessageTemplate = datagridviewMessageTemplates.SelectedCells[0].OwningRow.Tag as MessageTemplateType;

            try
            {
                MessageTemplateService service = new MessageTemplateService();
                GetMessageTemplateByIdRequest request = new GetMessageTemplateByIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.MessageTemplateId = selectedMessageTemplate.Id;
                GetMessageTemplateByIdResponse response = service.GetMessageTemplateById(request);

                if(response.MessageTemplate.Type == 1)
                {
                    FormEditSmsMessageTemplate form = new FormEditSmsMessageTemplate();
                    form.MessageTemplate = response.MessageTemplate;
                    form.IsNew = false;
                    if (form.ShowDialog() == DialogResult.OK)
                    {
                        OnNeedsRefresh();
                    }
                }                
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
