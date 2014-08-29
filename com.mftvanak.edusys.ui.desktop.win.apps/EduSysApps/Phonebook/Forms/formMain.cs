using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Phonebook.Forms
{
    public partial class formMain : FormBase
    {
        public formMain()
        {
            InitializeComponent();
        }

        private void formMain_Load(object sender, EventArgs e)
        {
            if (new FormLogin().ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                ucUserInformationStatusBar.UpdateLabels();
                ucPhonebookPanel.LoadData();
            }
            else
            {
                Process.GetCurrentProcess().Kill();
            }
        }

        private void formMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }
    }
}
