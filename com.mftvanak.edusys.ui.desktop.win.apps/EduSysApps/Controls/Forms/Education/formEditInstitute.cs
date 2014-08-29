using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    public partial class FormEditInstitute : FormBase
    {
        public bool IsNew
        {
            get { return ucEditInstitute.IsNew; }
            set { ucEditInstitute.IsNew = value; }
        }

        public InstituteType InstituteType
        {
            get { return ucEditInstitute.InstituteType; }
            set { ucEditInstitute.InstituteType = value; }
        }

        public FormEditInstitute()
        {
            InitializeComponent();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (ucEditInstitute.ValidateInformation() && ucEditInstitute.Save())
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }
    }
}
