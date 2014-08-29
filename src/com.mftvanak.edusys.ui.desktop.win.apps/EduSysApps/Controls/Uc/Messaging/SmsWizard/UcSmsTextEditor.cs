using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcSmsTextEditor : UserControl
    {
        public bool ReadOnly
        {
            get { return textboxText.ReadOnly; }
            set { textboxText.ReadOnly = value; }
        }

        public int SmsCount
        {
            get
            {
                int charsPerSms = 160;
                if (!StringHelper.IsAsciiString(textboxText.Text))
                {
                    charsPerSms = 80;
                }
                return textboxText.Text.Length / charsPerSms;
            }
        }

        public int RemainedCharsCount
        {
            get
            {
                int charsPerSms = 160;
                if (!StringHelper.IsAsciiString(textboxText.Text))
                {
                    charsPerSms = 80;
                }
                return charsPerSms - (textboxText.Text.Length - SmsCount * charsPerSms);
            }
        }

        public string SmsText
        {
            get { return textboxText.Text; }
            set { textboxText.Text = value; }
        }

        public UcSmsTextEditor()
        {
            InitializeComponent();
            UpdateSmsCountLabel();
        }

        private void UpdateSmsCountLabel()
        {
            labelSmsCountValue.Text = RemainedCharsCount + "/" + SmsCount;
        }

        private void textboxText_TextChanged(object sender, EventArgs e)
        {
            UpdateSmsCountLabel();
        }
    }
}
