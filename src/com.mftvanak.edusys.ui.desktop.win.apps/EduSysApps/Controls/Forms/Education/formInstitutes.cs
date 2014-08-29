using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    public partial class FormInstitutes : FormBase
    {
        public FormInstitutes()
        {
            InitializeComponent();
        }

        private void formInstitutes_Load(object sender, EventArgs e)
        {
            ucInstitutes.LoadData();
        }
    }
}
