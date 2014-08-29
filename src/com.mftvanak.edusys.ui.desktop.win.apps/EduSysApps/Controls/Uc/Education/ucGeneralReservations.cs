using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.ReservationWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcGeneralReservations : UserControl
    {
        public UcGeneralReservations()
        {
            InitializeComponent();

            ucEduSysDataGridView1.Columns.AddRange(new DataGridViewColumn[] { this.columnNumber,
            this.columnId,
            this.columnName,
            this.columnDate,
            this.columnClassName,
            this.columnEmail,
            this.columnPhone,
            this.columnText});

            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(26, "دپارتمان وب و برنامه نویسی"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(1, "دپارتمان ICDL و دوره های تکمیلی"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(9, "دپارتمان بین الملل"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(10, "دپارتمان گرافیک و انیمیشن"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(14, "دپارتمان نرم افزارهای فنی و مهندسی"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(15, "دپارتمان زبانهای خارجی"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(21, "دپارتمان سینمای دیجیتال"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(22, "دپارتمان فرهنگ و هنر"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(24, "دپارتمان حسابداری و مالی"));
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(25, "دپارتمان نفت ، گاز و پتروشیمی"));            
            comboboxDepartments.Items.Add(new DepartmentComboBoxItem(27, "دپارتمان شبکه و سخت افزار"));
            comboboxDepartments.SelectedIndex = 0;
        }

        private void buttonSearchGeneralReservations_Click(object sender, EventArgs e)
        {
            LoadGeneralReservations();
        }

        public void LoadGeneralReservations()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoLoadGeneralReservations);
            thread.Start();
        }

        public void DoLoadGeneralReservations()
        {
            try
            {
                if (buttonSearchGeneralReservations.InvokeRequired)
                {
                    buttonSearchGeneralReservations.Invoke(new MethodInvoker(delegate { buttonSearchGeneralReservations.Enabled = false; }));
                }
                else
                {
                    buttonSearchGeneralReservations.Enabled = false;
                }
                ReservationServiceService service = new ReservationServiceService();
                GetCmsGeneralReservationsRequest request = new GetCmsGeneralReservationsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                if (comboboxDepartments.InvokeRequired)
                {
                    comboboxDepartments.Invoke(new MethodInvoker(delegate { request.DepartmentId = (comboboxDepartments.SelectedItem as DepartmentComboBoxItem).Id; }));
                }
                else
                {
                    request.DepartmentId = (comboboxDepartments.SelectedItem as DepartmentComboBoxItem).Id;
                }
                CmsGeneralReservationType[] generalReservations = service.GetCmsGeneralReservations(request);
                if (ucEduSysDataGridView1.InvokeRequired)
                {
                    ucEduSysDataGridView1.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.NumberOfRecords = generalReservations.Length; }));
                }
                else
                {
                    ucEduSysDataGridView1.NumberOfRecords = generalReservations.Length;
                }
                int counter = 1;
                if (ucEduSysDataGridView1.DataGrid.InvokeRequired)
                {
                    ucEduSysDataGridView1.DataGrid.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.DataGrid.Rows.Clear(); }));
                }
                else
                {
                    ucEduSysDataGridView1.DataGrid.Rows.Clear();
                }
                foreach (CmsGeneralReservationType generalReservation in generalReservations)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Id, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Name, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Date, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.CmsClassName, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Email, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Phone, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = generalReservation.Text, ValueType = typeof(string) });
                    /*if (!generalReservation.Seen)
                    {
                        row.DefaultCellStyle.BackColor = Color.FromArgb(153, 217, 234);
                    }*/
                    if (ucEduSysDataGridView1.DataGrid.InvokeRequired)
                    {
                        ucEduSysDataGridView1.DataGrid.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.DataGrid.Rows.Add(row); }));
                    }
                    else
                    {
                        ucEduSysDataGridView1.DataGrid.Rows.Add(row);
                    }
                    counter++;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                LoadingManager.Hide();
                if (buttonSearchGeneralReservations.InvokeRequired)
                {
                    buttonSearchGeneralReservations.Invoke(new MethodInvoker(delegate { buttonSearchGeneralReservations.Enabled = true; }));
                }
                else
                {
                    buttonSearchGeneralReservations.Enabled = true;
                }
            }
        }
    }

    public class DepartmentComboBoxItem
    {
        private long _id;
        private string _name;

        public long Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public DepartmentComboBoxItem(long id, string name)
        {
            Id = id;
            Name = name;
        }

        public override string ToString()
        {
            return _name;
        }
    }
}
