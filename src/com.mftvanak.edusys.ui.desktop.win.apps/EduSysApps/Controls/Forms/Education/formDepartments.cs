using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    public partial class FormDepartments : FormBase
    {
        public InstituteType Institue
        {
            get { return ucDepartments.Institute; }
            set { ucDepartments.Institute = value; }
        }

        public FormDepartments()
        {
            InitializeComponent();
        }

        private void formDepartments_Load(object sender, EventArgs e)
        {
            ucDepartments.LoadDepartments();
        }
    }
}
