using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.MessageTemplateWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    public partial class FormEditSmsMessageTemplate : FormBase
    {
        public bool IsNew
        {
            get { return ucEditSmsMessageTemplate.IsNew; }
            set { ucEditSmsMessageTemplate.IsNew = value; }
        }

        public MessageTemplateType MessageTemplate
        {
            get { return ucEditSmsMessageTemplate.MessageTemplate; }
            set { ucEditSmsMessageTemplate.MessageTemplate = value; }
        }

        public UcEditSmsMessageTemplate UcSmsMessageTemplate
        {
            get { return ucEditSmsMessageTemplate; }
        }

        public FormEditSmsMessageTemplate()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (ucEditSmsMessageTemplate.ValidateInformation() && ucEditSmsMessageTemplate.Save())
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }
    }
}
