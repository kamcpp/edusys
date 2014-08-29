using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using FarsiLibrary.Utils;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcStudents : UserControl
    {
        public delegate void NeedDataEventHandler(object sender);
        public delegate void LoadDoneEventHandler(object sender);

        public event NeedDataEventHandler NeedData;
        public event LoadDoneEventHandler LoadDone;

        protected virtual void OnNeedData()
        {
            if (NeedData != null)
            {
                NeedData(this);
            }
        }

        protected virtual void OnLoadDone()
        {
            if (LoadDone != null)
            {
                LoadDone(this);
            }
        }

        private List<GheyasStudentType> _students;

        private DataGridViewTextBoxColumn _columnRow;
        private DataGridViewTextBoxColumn _columnStatus;
        private DataGridViewTextBoxColumn _columnKaramuzCode;
        private DataGridViewTextBoxColumn _columnTarafHesabCode;
        private DataGridViewTextBoxColumn _columnName;
        private DataGridViewTextBoxColumn _columnFamily;
        private DataGridViewTextBoxColumn _columnClassCode;
        private DataGridViewTextBoxColumn _columnClassName;
        private DataGridViewTextBoxColumn _columnReshteh;
        private DataGridViewTextBoxColumn _columnDaneshgah;
        private DataGridViewTextBoxColumn _columnPhone;
        private DataGridViewTextBoxColumn _columnEmergencyPhone;
        private DataGridViewTextBoxColumn _columnEmail;
        private DataGridViewTextBoxColumn _columnBirthDate;
        private DataGridViewTextBoxColumn _columnPaid;
        private DataGridViewTextBoxColumn _columnPayment;
        private DataGridViewTextBoxColumn _columnPaymentDate;
        private DataGridViewTextBoxColumn _columnPaymentDiscount;
        private DataGridViewTextBoxColumn _columnAddress;
        private DataGridViewTextBoxColumn _columnDescription;

        public List<GheyasStudentType> Students
        {
            get { return _students; }
            set
            {
                _students = value;
                if (_students != null)
                {
                    LoadStudents();
                }
            }
        }

        public UcStudents()
        {
            InitializeComponent();

            // 
            // columnRow
            // 
            _columnRow = new DataGridViewTextBoxColumn();
            _columnRow.FillWeight = 10F;
            _columnRow.HeaderText = "ردیف";
            _columnRow.Name = "columnRow";
            _columnRow.ReadOnly = true;
            _columnRow.Width = 60;
            // 
            // columnStatus
            // 
            _columnStatus = new DataGridViewTextBoxColumn();
            _columnStatus.FillWeight = 10F;
            _columnStatus.HeaderText = "وضعیت";
            _columnStatus.Name = "columnStatus";
            _columnStatus.ReadOnly = true;
            _columnStatus.Width = 60;
            // 
            // columnKaramuzCode
            // 
            _columnKaramuzCode = new DataGridViewTextBoxColumn();
            _columnKaramuzCode.FillWeight = 10F;
            _columnKaramuzCode.HeaderText = "کد کارآموز";
            _columnKaramuzCode.Name = "columnKaramuzCode";
            _columnKaramuzCode.ReadOnly = true;
            _columnKaramuzCode.Width = 100;
            // 
            // columnTarafHesabCode
            // 
            _columnTarafHesabCode = new DataGridViewTextBoxColumn();
            _columnTarafHesabCode.FillWeight = 10F;
            _columnTarafHesabCode.HeaderText = "کد طرف حساب";
            _columnTarafHesabCode.Name = "columnTarafHesabCode";
            _columnTarafHesabCode.ReadOnly = true;
            _columnTarafHesabCode.Width = 100;
            // 
            // columnName
            // 
            _columnName = new DataGridViewTextBoxColumn();
            _columnName.FillWeight = 10F;
            _columnName.HeaderText = "نام";
            _columnName.Name = "columnName";
            _columnName.ReadOnly = true;
            _columnName.Width = 120;
            // 
            // columnFamily
            // 
            _columnFamily = new DataGridViewTextBoxColumn();
            _columnFamily.FillWeight = 10F;
            _columnFamily.HeaderText = "نام خانوادگی";
            _columnFamily.Name = "columnFamily";
            _columnFamily.ReadOnly = true;
            _columnFamily.Width = 120;
            // 
            // columnClassCode
            // 
            _columnClassCode = new DataGridViewTextBoxColumn();
            _columnClassCode.FillWeight = 10F;
            _columnClassCode.HeaderText = "کد کلاس";
            _columnClassCode.Name = "columnClassCode";
            _columnClassCode.ReadOnly = true;
            _columnClassCode.Width = 100;
            // 
            // columnClassName
            // 
            _columnClassName = new DataGridViewTextBoxColumn();
            _columnClassName.FillWeight = 10F;
            _columnClassName.HeaderText = "نام کلاس";
            _columnClassName.Name = "columnClassName";
            _columnClassName.ReadOnly = true;
            _columnClassName.Width = 200;
            // 
            // columnReshteh
            // 
            _columnReshteh = new DataGridViewTextBoxColumn();
            _columnReshteh.FillWeight = 10F;
            _columnReshteh.HeaderText = "رشته";
            _columnReshteh.Name = "columnReshteh";
            _columnReshteh.ReadOnly = true;
            _columnReshteh.Width = 100;
            // 
            // columnDaneshgah
            // 
            _columnDaneshgah = new DataGridViewTextBoxColumn();
            _columnDaneshgah.FillWeight = 10F;
            _columnDaneshgah.HeaderText = "دانشگاه";
            _columnDaneshgah.Name = "columnDaneshgah";
            _columnDaneshgah.ReadOnly = true;
            _columnDaneshgah.Width = 250;
            // 
            // columnPhone
            // 
            _columnPhone = new DataGridViewTextBoxColumn();
            _columnPhone.FillWeight = 10F;
            _columnPhone.HeaderText = "تلفن 1";
            _columnPhone.Name = "columnPhone";
            _columnPhone.ReadOnly = true;
            _columnPhone.Width = 120;
            // 
            // columnEmergencyPhone
            // 
            _columnEmergencyPhone = new DataGridViewTextBoxColumn();
            _columnEmergencyPhone.FillWeight = 10F;
            _columnEmergencyPhone.HeaderText = "تلفن 2";
            _columnEmergencyPhone.Name = "columnEmergencyPhone";
            _columnEmergencyPhone.ReadOnly = true;
            _columnEmergencyPhone.Width = 120;
            // 
            // columnEmail
            // 
            _columnEmail = new DataGridViewTextBoxColumn();
            _columnEmail.FillWeight = 10F;
            _columnEmail.HeaderText = "ایمیل";
            _columnEmail.Name = "columnEmail";
            _columnEmail.ReadOnly = true;
            _columnEmail.Width = 120;
            // 
            // columnBirthDate
            // 
            _columnBirthDate = new DataGridViewTextBoxColumn();
            _columnBirthDate.FillWeight = 10F;
            _columnBirthDate.HeaderText = "تاریخ تولد";
            _columnBirthDate.Name = "columnBirthDate";
            _columnBirthDate.ReadOnly = true;
            _columnBirthDate.Width = 100;
            // 
            // columnPaid
            // 
            _columnPaid = new DataGridViewTextBoxColumn();
            _columnPaid.FillWeight = 10F;
            _columnPaid.HeaderText = "پرداخت شده";
            _columnPaid.Name = "columnPaid";
            _columnPaid.ReadOnly = true;
            _columnPaid.Width = 120;
            // 
            // columnPayment
            // 
            _columnPayment = new DataGridViewTextBoxColumn();
            _columnPayment.FillWeight = 10F;
            _columnPayment.HeaderText = "شهریه";
            _columnPayment.Name = "columnPayment";
            _columnPayment.ReadOnly = true;
            _columnPayment.Width = 120;
            // 
            // columnPaymentDate
            // 
            _columnPaymentDate = new DataGridViewTextBoxColumn();
            _columnPaymentDate.FillWeight = 10F;
            _columnPaymentDate.HeaderText = "تاریخ پرداخت";
            _columnPaymentDate.Name = "columnPaymentDate";
            _columnPaymentDate.ReadOnly = true;
            _columnPaymentDate.Width = 120;
            // 
            // columnPaymentDiscount
            // 
            _columnPaymentDiscount = new DataGridViewTextBoxColumn();
            _columnPaymentDiscount.FillWeight = 10F;
            _columnPaymentDiscount.HeaderText = "تخفیف";
            _columnPaymentDiscount.Name = "columnPaymentDiscount";
            _columnPaymentDiscount.ReadOnly = true;
            _columnPaymentDiscount.Width = 120;
            // 
            // columnAddress
            // 
            _columnAddress = new DataGridViewTextBoxColumn();
            _columnAddress.FillWeight = 10F;
            _columnAddress.HeaderText = "آدرس";
            _columnAddress.Name = "columnAddress";
            _columnAddress.ReadOnly = true;
            _columnAddress.Width = 200;
            // 
            // columnDescription
            // 
            _columnDescription = new DataGridViewTextBoxColumn();
            _columnDescription.FillWeight = 10F;
            _columnDescription.HeaderText = "توضیحات";
            _columnDescription.Name = "columnDescription";
            _columnDescription.ReadOnly = true;
            _columnDescription.Width = 200;

            ucedusysdatagridviewStudnets.DataGrid.Columns.AddRange(new DataGridViewColumn[] {
                _columnRow,
                _columnStatus,
                _columnKaramuzCode,
                _columnTarafHesabCode, 
                _columnName, 
                _columnFamily,
                _columnClassCode,
                _columnClassName,
                _columnReshteh,
                _columnDaneshgah,
                _columnPhone, 
                _columnEmergencyPhone, 
                _columnBirthDate,
                _columnEmail, 
                _columnPaid, 
                _columnPayment, 
                _columnPaymentDate, 
                _columnPaymentDiscount, 
                _columnAddress, 
                _columnDescription });
            ucedusysdatagridviewStudnets.DataGrid.ContextMenuStrip = contextmenustripStudent;
        }

        public void LoadStudents()
        {
            Thread thread = new Thread(InternalLoadStudents);
            LoadingManager.Show();
            thread.Start();
        }

        private void InternalLoadStudents()
        {
            try
            {
                int counter = 1;
                if (ucedusysdatagridviewStudnets.DataGrid.InvokeRequired)
                {
                    ucedusysdatagridviewStudnets.DataGrid.Invoke(new MethodInvoker(delegate { ucedusysdatagridviewStudnets.DataGrid.Rows.Clear(); }));
                }
                else
                {
                    ucedusysdatagridviewStudnets.DataGrid.Rows.Clear();
                }
                if (ucedusysdatagridviewStudnets.InvokeRequired)
                {
                    ucedusysdatagridviewStudnets.Invoke(new MethodInvoker(delegate { ucedusysdatagridviewStudnets.NumberOfRecords = _students.Count; }));
                }
                else
                {
                    ucedusysdatagridviewStudnets.NumberOfRecords = _students.Count;
                }
                foreach (GheyasStudentType student in _students)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    if (student.State != "0")
                    {
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = "انصراف", ValueType = typeof(string) });
                    }
                    else
                    {
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = "ثبت نام", ValueType = typeof(string) });
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.KaramuzCode, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.TarafHesabCode, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Name, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Family, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.ClassCode, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.ClassName, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Reshteh, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Daneshgah, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Phone, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.EmergencyPhone, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.BirthDate, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Email, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Paid, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Payment, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.PaymentDate, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.PaymentDiscount, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Address, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = student.Description, ValueType = typeof(string) });
                    row.Tag = student;
                    try
                    {
                        if (student.PaymentDate == "0")
                        {
                            row.DefaultCellStyle.BackColor = Color.DarkGreen;
                            row.DefaultCellStyle.ForeColor = Color.White;
                        }
                        else
                        {
                            string paymentShamsiDate = "13" + student.PaymentDate;
                            PersianDate paymentPersianDateTimeObject = PersianDate.Parse(paymentShamsiDate);
                            DateTime gregorianDateTime = PersianDateConverter.ToGregorianDateTime(paymentPersianDateTimeObject);
                            TimeSpan diff = DateTime.Now - gregorianDateTime;
                            if (diff.Days >= 25)
                            {
                                row.DefaultCellStyle.BackColor = Color.DarkRed;
                                row.DefaultCellStyle.ForeColor = Color.White;
                            }
                            else if (diff.Days >= 15)
                            {
                                row.DefaultCellStyle.BackColor = Color.OrangeRed;
                                row.DefaultCellStyle.ForeColor = Color.White;
                            }
                            else if (diff.Days >= 10)
                            {
                                row.DefaultCellStyle.BackColor = Color.Orange;
                            }
                            else if (diff.Days >= 5)
                            {
                                row.DefaultCellStyle.BackColor = Color.LightYellow;
                            }
                        }
                        if (student.State != "0")
                        {
                            row.DefaultCellStyle.BackColor = Color.Pink;
                            row.DefaultCellStyle.ForeColor = Color.Black;
                        }
                    }
                    catch (Exception e)
                    {
                        MessageBox.Show("تاریخ با فرمت اشتباه ثبت شده است. لطفا آن را در نرم افزار قیاس اطلاح نمایید.", "خطا در خواندن اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    if (ucedusysdatagridviewStudnets.DataGrid.InvokeRequired)
                    {
                        ucedusysdatagridviewStudnets.DataGrid.Invoke(new MethodInvoker(delegate { ucedusysdatagridviewStudnets.DataGrid.Rows.Add(row); }));
                    }
                    else
                    {
                        ucedusysdatagridviewStudnets.DataGrid.Rows.Add(row);
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
                OnLoadDone();
            }
        }

        private void toolstripmenuitemEditDaneshgahField_Click(object sender, EventArgs e)
        {
            if (!AuthenticationContext.DefaultContext.CurrentPrinciple.HashRole("ROLE_DANESHGAH_FIELD_EDITOR"))
            {
                return;
            }
            if (ucedusysdatagridviewStudnets.DataGrid.SelectedCells.Count == 0)
            {
                return;
            }
            GheyasStudentType student = ucedusysdatagridviewStudnets.DataGrid.SelectedCells[0].OwningRow.Tag as GheyasStudentType;
            FormEditDaneshgahField form = new FormEditDaneshgahField();
            form.FullName = student.Name + " " + student.Family;
            form.DaneshgahField = student.Daneshgah;
            form.CodeKaramuz = student.KaramuzCode;
            if (form.ShowDialog() == DialogResult.OK)
            {
                OnNeedData();
            }
        }

        private void contextmenustripStudent_Opening(object sender, CancelEventArgs e)
        {
            toolstripmenuitemEditDaneshgahField.Visible = AuthenticationContext.DefaultContext.CurrentPrinciple.HashRole("ROLE_DANESHGAH_FIELD_EDITOR");
        }
    }
}
