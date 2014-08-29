using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership
{
    public partial class FormRoles : FormBase
    {
        public FormRoles()
        {
            InitializeComponent();
        }

        private void formRoles_Load(object sender, EventArgs e)
        {
            ucRoles.LoadRoles();
        }
    }
}
