using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Forms
{
    public partial class formSplash : Form
    {
        public formSplash()
        {
            InitializeComponent();
            ApplicationSettings.NotifyControl = notifyIcon;
            timer.Start();
        }

        private void timer_Tick(object sender, EventArgs e)
        {
            timer.Stop();
            formMain form = new formMain();
            LoadingManager.LoadingShower = form;
            this.Hide();
            form.ShowDialog();
        }

        private void formSplash_FormClosing(object sender, FormClosingEventArgs e)
        {
            notifyIcon.Icon = null;
        }
    }
}
