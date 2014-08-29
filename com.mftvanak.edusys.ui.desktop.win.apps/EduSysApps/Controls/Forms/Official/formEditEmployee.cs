using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Official
{
    public partial class FormEditEmployee : FormBase
    {
        public bool IsNew
        {
            get { return ucEmployeeEditor.IsNew; }
            set { ucEmployeeEditor.IsNew = value; }
        }

        public long PersonId
        {
            get { return ucEmployeeEditor.PersonId; }
            set { ucEmployeeEditor.PersonId = value; }
        }

        public FormEditEmployee()
        {
            InitializeComponent();
        }

        private void buttonSaveAndClose_Click(object sender, EventArgs e)
        {
            buttonSaveAndClose.Enabled = false;
            buttonSaveAndClose.Text = "در حال ذخیره ...";
            this.Refresh();
            if (ucEmployeeEditor.Save())
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
            else
            {
                buttonSaveAndClose.Enabled = true;
                buttonSaveAndClose.Text = "ذخیره و خروج";
            }
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            buttonSave.Enabled = false;
            buttonSave.Text = "در حال ذخیره ...";
            this.Refresh();
            ucEmployeeEditor.Save();
            buttonSave.Enabled = true;
            buttonSave.Text = "ذخیره";
        }

        private void formEditEmployee_Load(object sender, EventArgs e)
        {
            ucEmployeeEditor.LoadData();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

       
    }
}
