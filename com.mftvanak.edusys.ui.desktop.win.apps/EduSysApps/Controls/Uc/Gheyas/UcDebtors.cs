using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas
{
    public partial class UcDebtors : UserControl
    {
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnCode;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnFullName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDebt;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnShouldPay;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPaid;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDiscount;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPhone1;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPhone2;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnEmail;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnAddress;

        public UcDebtors()
        {
            InitializeComponent();

            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnCode = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnFullName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDebt = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnShouldPay = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPaid = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDiscount = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPhone1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPhone2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnEmail = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnAddress = new System.Windows.Forms.DataGridViewTextBoxColumn();

            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 60;
            // 
            // columnCode
            // 
            this.columnCode.HeaderText = "کد دانشجو";
            this.columnCode.Name = "columnCode";
            this.columnCode.ReadOnly = true;
            this.columnCode.Width = 100;
            // 
            // columnFullName
            // 
            this.columnFullName.HeaderText = "نام و نام خانوادگی";
            this.columnFullName.Name = "columnCode";
            this.columnFullName.ReadOnly = true;
            this.columnFullName.Width = 200;
            // 
            // columnDebt
            // 
            this.columnDebt.HeaderText = "بدهی";
            this.columnDebt.Name = "columnDebt";
            this.columnDebt.ReadOnly = true;
            this.columnDebt.Width = 150;
            // 
            // columnShouldPay
            // 
            this.columnShouldPay.HeaderText = "مبلغ قابل پرداخت";
            this.columnShouldPay.Name = "columnShouldPay";
            this.columnShouldPay.ReadOnly = true;
            this.columnShouldPay.Width = 150;
            // 
            // columnPaid
            // 
            this.columnPaid.HeaderText = "مبلغ پرداختی";
            this.columnPaid.Name = "columnPaid";
            this.columnPaid.ReadOnly = true;
            this.columnPaid.Width = 150;
            // 
            // columnDiscount
            // 
            this.columnDiscount.HeaderText = "تخفیف";
            this.columnDiscount.Name = "columnDiscount";
            this.columnDiscount.ReadOnly = true;
            this.columnDiscount.Width = 150;
            // 
            // columnPhone1
            // 
            this.columnPhone1.HeaderText = "تلفن 1";
            this.columnPhone1.Name = "columnPhone1";
            this.columnPhone1.ReadOnly = true;
            this.columnPhone1.Width = 150;
            // 
            // columnPhone2
            // 
            this.columnPhone2.HeaderText = "تلفن 2";
            this.columnPhone2.Name = "columnPhone2";
            this.columnPhone2.ReadOnly = true;
            this.columnPhone2.Width = 150;
            // 
            // columnEmail
            // 
            this.columnEmail.HeaderText = "ایمیل";
            this.columnEmail.Name = "columnEmail";
            this.columnEmail.ReadOnly = true;
            this.columnEmail.Width = 150;
            // 
            // columnAddress
            // 
            this.columnAddress.HeaderText = "آدرس";
            this.columnAddress.Name = "columnAddress";
            this.columnAddress.ReadOnly = true;
            this.columnAddress.Width = 250;

            ucEduSysDataGridView1.DataGrid.Columns.AddRange(new DataGridViewColumn[] {columnNumber, 
                columnCode,
                columnFullName,
                columnDebt,
                columnShouldPay,
                columnPaid,
                columnDiscount,
                columnPhone1,
                columnPhone2,
                columnEmail,
                columnAddress});
        }

        public void LoadDebtors()
        {
            LoadingManager.LoadingShower.ShowLoading();
            Thread thread = new Thread(DoLoadDebtors);
            thread.Start();
        }

        public void DoLoadDebtors()
        {
            try
            {
                if (buttonRefresh.InvokeRequired)
                {
                    buttonRefresh.Invoke(new MethodInvoker(delegate { buttonRefresh.Enabled = false; }));
                }
                else
                {
                    buttonRefresh.Enabled = false;
                }
                GheyasService service = new GheyasService();
                GetDebtorsRequest request = new GetDebtorsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                GheyasDebtorType[] debtors = service.GetDebtors(request);
                if (ucEduSysDataGridView1.InvokeRequired)
                {
                    ucEduSysDataGridView1.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.NumberOfRecords = debtors.Length; }));
                }
                else
                {
                    ucEduSysDataGridView1.NumberOfRecords = debtors.Length;
                }
                if (ucEduSysDataGridView1.InvokeRequired)
                {
                    ucEduSysDataGridView1.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.DataGrid.Rows.Clear(); }));
                }
                else
                {
                    ucEduSysDataGridView1.DataGrid.Rows.Clear();
                }
                int counter = 1;
                foreach (GheyasDebtorType debtor in debtors)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Code, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Name + " " + debtor.Family, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = StringHelper.Get3CharsCommaSeperated(debtor.Debt), ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = StringHelper.Get3CharsCommaSeperated(debtor.ShouldPay), ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = StringHelper.Get3CharsCommaSeperated(debtor.Paid), ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = StringHelper.Get3CharsCommaSeperated(debtor.Discount), ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Phone1, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Phone2, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Email, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = debtor.Address, ValueType = typeof(string) });
                    if (ucEduSysDataGridView1.InvokeRequired)
                    {
                        ucEduSysDataGridView1.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView1.DataGrid.Rows.Add(row); }));
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
                LoadingManager.LoadingShower.HideLoading();
                if (buttonRefresh.InvokeRequired)
                {
                    buttonRefresh.Invoke(new MethodInvoker(delegate { buttonRefresh.Enabled = true; }));
                }
                else
                {
                    buttonRefresh.Enabled = true;
                }
            }
        }

        private void buttonRefresh_Click(object sender, EventArgs e)
        {
            LoadDebtors();
        }
    }
}
