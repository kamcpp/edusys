using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    public partial class FormSearchClass : FormBase
    {
        public FormSearchClass()
        {
            InitializeComponent();
        }

        private void formSearchClass_Load(object sender, EventArgs e)
        {
            ucSearchClass.LoadGroups();
            ucSearchClass.LoadTerms();
            LoadingManager.Hide();
        }

        private void formSearchClass_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                ucSearchClass.LoadClasses();
            }
        }
    }
}
