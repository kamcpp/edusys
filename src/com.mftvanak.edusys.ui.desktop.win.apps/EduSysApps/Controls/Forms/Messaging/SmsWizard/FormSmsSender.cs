using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    public partial class FormSmsSender : FormBase
    {
        public FormSmsSender()
        {
            InitializeComponent();
        }

        public void Start()
        {
            ucSmsSender.Start();
        }

        private void ucSmsSender_SendSuccessful(object sender)
        {
            MessageBox.Show("ارسال پیام ها با موفقیت به اتمام رسید.", "موفقیت", MessageBoxButtons.OK, MessageBoxIcon.Information);
            DialogResult = System.Windows.Forms.DialogResult.OK;
        }
    }
}
