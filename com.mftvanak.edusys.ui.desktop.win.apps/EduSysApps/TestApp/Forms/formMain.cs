using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.TestApp.Forms
{
    public partial class formMain : FormBase
    {
        public formMain()
        {
            InitializeComponent();
        }

        private void buttonEduSysDataGridViewTest_Click(object sender, EventArgs e)
        {
            new formEduSysDataGridViewTest().ShowDialog();
        }
    }
}
