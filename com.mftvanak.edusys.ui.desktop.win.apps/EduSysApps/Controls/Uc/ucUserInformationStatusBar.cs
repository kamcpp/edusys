using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc
{
    public partial class UcUserInformationStatusBar : UserControl
    {
        public UcUserInformationStatusBar()
        {
            InitializeComponent();
        }

        public void UpdateLabels()
        {
            if (AuthenticationContext.DefaultContext.CurrentPrinciple != null)
            {
                toolstripstatuslabelUsername.Text = AuthenticationContext.DefaultContext.CurrentPrinciple.Username;
                toolstripstatuslabelFullName.Text = AuthenticationContext.DefaultContext.CurrentPrinciple.FullName;
                toolstripstatuslabelEmail.Text = AuthenticationContext.DefaultContext.CurrentPrinciple.AccountEmail;
            }
        }
    }
}
