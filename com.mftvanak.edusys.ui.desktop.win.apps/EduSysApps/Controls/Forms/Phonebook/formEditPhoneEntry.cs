using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PhonebookWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Phonebook
{
    public partial class FormEditPhoneEntry : FormBase
    {
        public bool IsNew
        {
            get { return ucEditPhoneEntry.IsNew; }
            set { ucEditPhoneEntry.IsNew = value; }
        }

        public PhoneEntryType PhoneEntry
        {
            get { return ucEditPhoneEntry.PhoneEntry; }
            set { ucEditPhoneEntry.PhoneEntry = value; }
        }

        public FormEditPhoneEntry()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            try
            {
                buttonSave.Enabled = false;
                if (ucEditPhoneEntry.ValidateInformation() && ucEditPhoneEntry.Save())
                {
                    DialogResult = System.Windows.Forms.DialogResult.OK;
                }
            }
            catch
            {
            }
            finally
            {
                buttonSave.Enabled = true;
            }                
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        private void formEditPhoneEntry_Load(object sender, EventArgs e)
        {
            LoadingManager.Hide();
        }
    }
}
