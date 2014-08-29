using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    public partial class FormEditDepartment : FormBase
    {
        public bool IsNew
        {
            get { return ucEditDepartment.IsNew; }
            set { ucEditDepartment.IsNew = value; }
        }

        public InstituteType Institute
        {
            get { return ucEditDepartment.Institute; }
            set { ucEditDepartment.Institute = value; }
        }

        public DepartmentType Department
        {
            get { return ucEditDepartment.Department; }
            set { ucEditDepartment.Department = value; }
        }

        public FormEditDepartment()
        {
            InitializeComponent();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (ucEditDepartment.ValidateInformation() && ucEditDepartment.Save())
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }
    }
}
