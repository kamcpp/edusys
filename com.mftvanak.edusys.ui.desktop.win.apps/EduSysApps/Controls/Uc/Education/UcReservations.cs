using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.ReservationWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcReservations : UserControl
    {
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnEmail;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPhone;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnText;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTime;

        public UcReservations()
        {
            InitializeComponent();

            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnEmail = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPhone = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnText = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTime = new System.Windows.Forms.DataGridViewTextBoxColumn();

            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 60;
            // 
            // columnId
            // 
            this.columnId.HeaderText = "مشخصه";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            this.columnId.Width = 60;
            // 
            // columnName
            // 
            this.columnName.HeaderText = "نام";
            this.columnName.Name = "columnName";
            this.columnName.ReadOnly = true;
            this.columnName.Width = 200;
            // 
            // columnDate
            // 
            this.columnDate.HeaderText = "تاریخ";
            this.columnDate.Name = "columnDate";
            this.columnDate.ReadOnly = true;
            this.columnDate.Width = 150;
            // 
            // columnTime
            // 
            this.columnTime.HeaderText = "زمان";
            this.columnTime.Name = "columnTime";
            this.columnTime.ReadOnly = true;
            this.columnTime.Width = 250;
            // 
            // columnEmail
            // 
            this.columnEmail.HeaderText = "ایمیل";
            this.columnEmail.Name = "columnEmail";
            this.columnEmail.ReadOnly = true;
            this.columnEmail.Width = 200;
            // 
            // columnPhone
            // 
            this.columnPhone.HeaderText = "تلفن";
            this.columnPhone.Name = "columnPhone";
            this.columnPhone.ReadOnly = true;
            this.columnPhone.Width = 150;
            // 
            // columnText
            // 
            this.columnText.HeaderText = "توضیحات";
            this.columnText.Name = "columnText";
            this.columnText.ReadOnly = true;
            this.columnText.Width = 300;
            
            ucEduSysDataGridView.Columns.AddRange(new DataGridViewColumn[] { this.columnNumber,
            this.columnId,
            this.columnName,
            this.columnDate,
            this.columnTime,
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

            comboboxReservationPlans.Items.Add(new ReservationPlanComboBoxItem(1, "پیش ثبت نام مهر ماه"));
            comboboxReservationPlans.SelectedIndex = 0;
        }

        private void buttonSearchReservations_Click(object sender, EventArgs e)
        {
            LoadReservations();
        }

        public void LoadReservations()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoLoadReservations);
            thread.Start();
        }

        public void DoLoadReservations()
        {
            try
            {
                if (buttonSearchReservations.InvokeRequired)
                {
                    buttonSearchReservations.Invoke(new MethodInvoker(delegate { buttonSearchReservations.Enabled = false; }));
                }
                else
                {
                    buttonSearchReservations.Enabled = false;
                }
                ReservationServiceService service = new ReservationServiceService();
                GetCmsReservationsRequest request = new GetCmsReservationsRequest();
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
                if (comboboxReservationPlans.InvokeRequired)
                {
                    comboboxReservationPlans.Invoke(new MethodInvoker(delegate { request.ReservationPlanId = (comboboxReservationPlans.SelectedItem as ReservationPlanComboBoxItem).Id; }));
                }
                else
                {
                    request.ReservationPlanId = (comboboxReservationPlans.SelectedItem as ReservationPlanComboBoxItem).Id;
                }
                CmsReservationType[] reservations = service.GetCmsReservations(request);
                if (ucEduSysDataGridView.InvokeRequired)
                {
                    ucEduSysDataGridView.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView.NumberOfRecords = reservations.Length; }));
                }
                else
                {
                    ucEduSysDataGridView.NumberOfRecords = reservations.Length;
                }
                int counter = 1;
                if (ucEduSysDataGridView.DataGrid.InvokeRequired)
                {
                    ucEduSysDataGridView.DataGrid.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView.DataGrid.Rows.Clear(); }));
                }
                else
                {
                    ucEduSysDataGridView.DataGrid.Rows.Clear();
                }
                foreach (CmsReservationType reservation in reservations)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Id, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Name, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Date, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Time, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Email, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Phone, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = reservation.Text, ValueType = typeof(string) });
                    /*if (!generalReservation.Seen)
                    {
                        row.DefaultCellStyle.BackColor = Color.FromArgb(153, 217, 234);
                    }*/
                    if (ucEduSysDataGridView.DataGrid.InvokeRequired)
                    {
                        ucEduSysDataGridView.DataGrid.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView.DataGrid.Rows.Add(row); }));
                    }
                    else
                    {
                        ucEduSysDataGridView.DataGrid.Rows.Add(row);
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
                if (buttonSearchReservations.InvokeRequired)
                {
                    buttonSearchReservations.Invoke(new MethodInvoker(delegate { buttonSearchReservations.Enabled = true; }));
                }
                else
                {
                    buttonSearchReservations.Enabled = true;
                }
            }
        }
    }

    public class ReservationPlanComboBoxItem
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

        public ReservationPlanComboBoxItem(long id, string name)
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
