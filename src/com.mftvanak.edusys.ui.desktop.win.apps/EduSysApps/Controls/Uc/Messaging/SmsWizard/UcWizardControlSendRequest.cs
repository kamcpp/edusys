using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcWizardControlSendRequest : UserControl, IWizardStepControl
    {
        public string SendRequestName
        {
            get { return textboxName.Text; }
        }

        public string SendRequestDescription
        {
            get { return textboxDescription.Text; }
        }

        public UcWizardControlSendRequest()
        {
            InitializeComponent();
        }

        public bool ValidateStepControl()
        {
            if (string.IsNullOrEmpty(textboxName.Text))
            {
                MessageBox.Show("ارائه یک عنوان برای ارسال الزامی است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }
    }
}
