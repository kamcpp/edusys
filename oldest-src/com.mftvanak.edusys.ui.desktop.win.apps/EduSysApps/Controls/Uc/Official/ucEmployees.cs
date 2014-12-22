using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.EmployeeWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Official;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    public partial class UcEmployees : UserControl
    {
        private DataGridViewTextBoxColumn _columnNumber;
        private DataGridViewTextBoxColumn _columnPersonnelNumber;
        private DataGridViewTextBoxColumn _columnFullName;
        private DataGridViewTextBoxColumn _columnId;

        public UcEmployees()
        {
            InitializeComponent();

            // 
            // columnNumber
            // 
            _columnNumber = new DataGridViewTextBoxColumn();
            _columnNumber.FillWeight = 10F;
            _columnNumber.HeaderText = "ردیف";
            _columnNumber.Name = "columnNumber";
            _columnNumber.ReadOnly = true;
            _columnNumber.Width = 60;

            // 
            // columnPersonnelNumber
            // 
            _columnPersonnelNumber = new DataGridViewTextBoxColumn();
            _columnPersonnelNumber.FillWeight = 10F;
            _columnPersonnelNumber.HeaderText = "شماره پرسنلی";
            _columnPersonnelNumber.Name = "columnPersonnelNumber";
            _columnPersonnelNumber.ReadOnly = true;
            _columnPersonnelNumber.Width = 100;

            // 
            // columnFullName
            // 
            _columnFullName = new DataGridViewTextBoxColumn();
            _columnFullName.FillWeight = 10F;
            _columnFullName.HeaderText = "نام و نام خانوادگی";
            _columnFullName.Name = "columnFullName";
            _columnFullName.ReadOnly = true;
            _columnFullName.Width = 250;

            // 
            // columnId
            // 
            _columnId = new DataGridViewTextBoxColumn();
            _columnId.FillWeight = 10F;
            _columnId.HeaderText = "مشخصه";
            _columnId.Name = "columnId";
            _columnId.ReadOnly = true;
            _columnId.Width = 100;

            ucEduSysDataGridView.DataGrid.Columns.AddRange(new DataGridViewTextBoxColumn[] { 
                _columnNumber, 
                _columnPersonnelNumber, 
                _columnFullName, 
                _columnId });
        }

        private void ucCrudToolbar_AfterAddClicked(object sender)
        {
            Add();
        }

        private void ucCrudToolbar_AfterRefreshClicked(object sender)
        {
            LoadData();
        }

        private void ucEduSysDataGridView_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            UpdateData();
        }

        private void Add()
        {
            FormEditEmployee form = new FormEditEmployee();
            form.IsNew = true;
            if (form.ShowDialog() == DialogResult.OK)
            {
                LoadData();
            }
        }

        private void UpdateData()
        {
            if (ucEduSysDataGridView.DataGrid.SelectedCells.Count == 0)
            {
                return;
            }

            long personId = long.Parse(ucEduSysDataGridView.DataGrid.SelectedCells[0].OwningRow.Tag.ToString());
            FormEditEmployee form = new FormEditEmployee();
            form.IsNew = false;
            form.PersonId = personId;
            if (form.ShowDialog() == DialogResult.OK)
            {
                LoadData();
            }
        }

        private void Delete()
        {
        }

        public void LoadData()
        {
            try
            {
                EmployeeService employeeService = new EmployeeService();
                GetEmployeeSummariesRequest request = new GetEmployeeSummariesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                EmployeeSummaryType[] employeeSummaries = employeeService.GetEmployeeSummaries(request);
                ucEduSysDataGridView.DataGrid.Rows.Clear();
                ucEduSysDataGridView.NumberOfRecords = employeeSummaries.Length;
                int counter = 1;
                foreach (EmployeeSummaryType employeeSummary in employeeSummaries)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = employeeSummary.EmployeeNumber, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = employeeSummary.PersianFullName, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = employeeSummary.PersonId, ValueType = typeof(int) });
                    row.Tag = employeeSummary.PersonId;
                    ucEduSysDataGridView.DataGrid.Rows.Add(row);
                    counter++;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
