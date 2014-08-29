using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    public partial class formMain : formBase
    {
        public formMain()
        {
            InitializeComponent();
            this.Text = String.Format(this.Text, VersionInfo.Version);
        }

        private void toolstripbuttonNew_Click(object sender, EventArgs e)
        {
            formPhoneEditor form = new formPhoneEditor();
            form.ShowDialog();
        }

        private void toolstripbuttonReports_Click(object sender, EventArgs e)
        {
            formReport form = new formReport();
            form.ShowDialog();
        }

        private void formMain_Load(object sender, EventArgs e)
        {
            formLogin form = new formLogin();
            form.ShowDialog();
        }
    }
}
