using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcDepartments : UserControl
    {
        private InstituteType _instituteType;

        public InstituteType Institute
        {
            get { return _instituteType; }
            set { _instituteType = value; }
        }

        public UcDepartments()
        {
            InitializeComponent();
        }

        private void ucCrudToolbar_AfterRefreshClicked(object sender)
        {
            LoadDepartments();
        }

        private void ucCrudToolbar_AfterAddClicked(object sender)
        {
            Add();
        }

        private void ucCrudToolbar_AfterEditClicked(object sender)
        {
            Edit();
        }

        private void datagridviewDepartments_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0)
            {
                return;
            }
            Edit();
        }

        public void LoadDepartments()
        {
            try
            {
                DepartmentServiceService service = new DepartmentServiceService();
                GetDepartmentsRequest request = new GetDepartmentsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = _instituteType.Id;
                DepartmentType[] departments = service.GetDepartments(request);
                datagridviewDepartments.Rows.Clear();
                int counter = 1;
                foreach (DepartmentType departmentType in departments)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = departmentType.Id, ValueType = typeof(string) });                    
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = departmentType.PersianName, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = departmentType.EnglishName, ValueType = typeof(string) });
                    DataGridViewTextBoxCell colorCell = new DataGridViewTextBoxCell() { Value = departmentType.Color, ValueType = typeof(string) };
                    try
                    {
                        colorCell.Style.BackColor = ColorTranslator.FromHtml(departmentType.Color);
                    }
                    catch
                    {
                    }
                    row.Cells.Add(colorCell);
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = departmentType.ShowOrder, ValueType = typeof(int) });
                    row.Tag = departmentType.Id;
                    datagridviewDepartments.Rows.Add(row);
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
            FormEditDepartment form = new FormEditDepartment();
            form.Department = new DepartmentType();
            form.Institute = Institute;
            form.IsNew = true;
            if (form.ShowDialog() == DialogResult.OK)
            {
                LoadDepartments();
            }
        }

        public void Edit()
        {
            try
            {
                if (datagridviewDepartments.SelectedCells.Count == 0)
                {
                    return;
                }
                long departmentId = long.Parse(datagridviewDepartments.Rows[datagridviewDepartments.SelectedCells[0].RowIndex].Tag.ToString());
                DepartmentServiceService service = new DepartmentServiceService();
                GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.DepartmentId = departmentId;
                GetDepartmentByIdResponse response = service.GetDepartmentById(request);
                FormEditDepartment form = new FormEditDepartment();
                form.Department = response.Department;
                form.Institute = Institute;
                form.IsNew = false;
                if (form.ShowDialog() == DialogResult.OK)
                {
                    LoadDepartments();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
