using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    public partial class FormMessageTemplateManager : FormBase
    {
        public UcMessageTemplateExplorer MessageTemplateExplorer
        {
            get { return ucMessageTemplateExplorer; }
        }

        public FormMessageTemplateManager()
        {
            InitializeComponent();
        }
    }
}
