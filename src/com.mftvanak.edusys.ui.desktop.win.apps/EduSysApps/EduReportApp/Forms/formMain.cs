using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.EduReportApp.Forms
{
    public partial class formMain : FormBase
    {
        public formMain()
        {
            InitializeComponent();

            if (new FormLogin().ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                ucUserInformationStatusBar.UpdateLabels();
            }
            else
            {
                Process.GetCurrentProcess().Kill();
            }
        }

        private void formMain_Load(object sender, EventArgs e)
        {
            
        }

        private void toolstripmenuitemClose_Click(object sender, EventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }

        private void toolstripmenuitemSearchStudent_Click(object sender, EventArgs e)
        {
            new FormSearchStudent().Show();
        }

        private void toolstripmenuitemSearchClass_Click(object sender, EventArgs e)
        {
            LoadingManager.Show();
            new FormSearchClass().Show();
        }

        private void formMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }
    }
}
