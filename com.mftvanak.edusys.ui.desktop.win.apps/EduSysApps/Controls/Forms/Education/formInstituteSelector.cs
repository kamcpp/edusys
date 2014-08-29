using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    public partial class FormInstituteSelector : FormBase
    {
        public InstituteType Institute
        {
            get
            {
                return (comboboxInstitutes.SelectedItem as ComboBoxItem).Institute;
            }
        }

        public FormInstituteSelector()
        {
            InitializeComponent();
        }

        private void formInstituteSelector_Load(object sender, EventArgs e)
        {
            LoadInstitutes();
        }

        private void buttonSelect_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.OK;
        }

        public void LoadInstitutes()
        {
            try
            {
                InstituteServiceService instituteService = new InstituteServiceService();
                GetInstitutesRequest request = new GetInstitutesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                InstituteType[] institutes = instituteService.GetInstitutes(request);
                comboboxInstitutes.Items.Clear();
                foreach (InstituteType institute in institutes)
                {
                    comboboxInstitutes.Items.Add(new ComboBoxItem() { Institute = institute });
                }
                comboboxInstitutes.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                DialogResult = System.Windows.Forms.DialogResult.Cancel;
            }
        }
    }

    public class ComboBoxItem
    {
        public InstituteType Institute;

        public override string ToString()
        {
            return Institute.PersianName;
        }
    }
}
