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
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Official;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Forms
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
            }
            else
            {
                this.Close();
            }
        }

        private void toolstripmenuitemInstitutes_Click(object sender, EventArgs e)
        {
            new FormInstitutes().ShowDialog();
        }

        private void toolstripmenuitemRoles_Click(object sender, EventArgs e)
        {
            new FormRoles().ShowDialog();
        }

        private void toolstirpmenuitemEmployees_Click(object sender, EventArgs e)
        {
            new FormEmployees().ShowDialog();
        }

        private void toolstripmenuitemClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void toolstripmenuitemDepartments_Click(object sender, EventArgs e)
        {
            FormInstituteSelector form = new FormInstituteSelector();
            if (form.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                new FormDepartments() { Institue = form.Institute }.Show();
            }
        }

        private void formMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }
    }
}
