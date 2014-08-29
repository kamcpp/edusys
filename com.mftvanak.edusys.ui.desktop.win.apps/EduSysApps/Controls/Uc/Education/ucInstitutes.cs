using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcInstitutes : UserControl
    {
        public UcInstitutes()
        {
            InitializeComponent();
        }

        private void ucCrudToolbar_AfterAddClicked(object sender)
        {
            Add();
        }

        private void ucCrudToolbar_AfterEditClicked(object sender)
        {
            Edit();
        }

        private void ucCrudToolbar_AfterRefreshClicked(object sender)
        {
            LoadData();
        }

        private void datagridviewInstitutes_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0)
            {
                return;
            }
            Edit();
        }

        public void LoadData()
        {
            try
            {
                InstituteServiceService instituteService = new InstituteServiceService();
                GetInstitutesRequest request = new GetInstitutesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                InstituteType[] institutes = instituteService.GetInstitutes(request);
                datagridviewInstitutes.Rows.Clear();
                int counter = 1;
                foreach (InstituteType instituteType in institutes)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter.ToString() });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = instituteType.Id.ToString() });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = instituteType.PersianName });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = instituteType.WebUrl1 });
                    row.Tag = instituteType.Id;
                    datagridviewInstitutes.Rows.Add(row);
                    counter++;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void Add()
        {
            try
            {
                FormEditInstitute form = new FormEditInstitute();
                form.InstituteType = new InstituteType();
                form.IsNew = true;
                if (form.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                {
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
        }

        public void Edit()
        {
            try
            {
                if (datagridviewInstitutes.SelectedCells.Count == 0)
                {
                    return;
                }
                long instituteId = long.Parse(datagridviewInstitutes.Rows[datagridviewInstitutes.SelectedCells[0].RowIndex].Tag.ToString());
                InstituteServiceService instituteService = new InstituteServiceService();
                GetInstituteByIdRequest request = new GetInstituteByIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = instituteId;
                GetInstituteByIdResponse response = instituteService.GetInstituteById(request);
                FormEditInstitute form = new FormEditInstitute();
                form.InstituteType = response.Institute;
                form.IsNew = false;
                if (form.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                {
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
        }
    }
}
