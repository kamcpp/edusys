using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PhonebookWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Phonebook;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    public partial class UcPhoneEntries : UserControl
    {
        public delegate void DataRefreshNeededEventHandler(object sender);

        public event DataRefreshNeededEventHandler DataRefteshNeeded;

        public bool AutoRefresh
        {
            get { return checkboxAutoRefresh.Checked; }
            set { checkboxAutoRefresh.Checked = value; }
        }

        protected void OnDataRefreshNeeded()
        {
            if (DataRefteshNeeded != null)
            {
                DataRefteshNeeded(this);
            }
        }

        private List<PhoneEntryType> _phoneEntries;

        public List<PhoneEntryType> PhoneEntries
        {
            get { return _phoneEntries; }
            set
            {
                _phoneEntries = value;
                LoadData();
            }
        }

        public UcPhoneEntries()
        {
            InitializeComponent();
            this.ucEduSysDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnCategory,
            this.columnInstituteName,
            this.columnDepartment,
            this.columnSubmitDate,
            this.columnName,
            this.columnDescription,
            this.columnPhone,
            this.columnSeen,
            this.columnPrivate,
            this.columnRegistered,
            this.columnOwnerName,
            this.columnId});
            timer.Start();
        }

        private void ucEduSysDataGridView_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            Edit();
        }

        private void timer_Tick(object sender, EventArgs e)
        {
            if (checkboxAutoRefresh.Checked)
            {
                OnDataRefreshNeeded();
            }
        }

        public void Edit()
        {
            LoadingManager.Show();
            Thread thread = new Thread(new ThreadStart(DoEdit));
            thread.Start();
        }

        public void LoadData()
        {
            if (ucEduSysDataGridView.DataGrid.InvokeRequired)
            {
                ucEduSysDataGridView.DataGrid.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView.DataGrid.Rows.Clear(); }));
            }
            else
            {
                ucEduSysDataGridView.DataGrid.Rows.Clear();
            }

            int counter = 1;
            if (_phoneEntries != null)
            {
                if (ucEduSysDataGridView.InvokeRequired)
                {
                    ucEduSysDataGridView.Invoke(new MethodInvoker(delegate { ucEduSysDataGridView.NumberOfRecords = _phoneEntries.Count; }));
                }
                else
                {
                    ucEduSysDataGridView.NumberOfRecords = _phoneEntries.Count;
                }
                foreach (PhoneEntryType phoneEntryType in _phoneEntries)
                {
                    if (!GeneralSettings.InstituteIds.Contains(phoneEntryType.InstituteId))
                    {
                        continue;
                    }
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    DataGridViewTextBoxCell categoryow = new DataGridViewTextBoxCell() { Value = "", ValueType = typeof(int) };
                    if (phoneEntryType.Color == ColorType.Blue)
                    {
                        categoryow.Style.BackColor = Color.LightBlue;
                    }
                    else if (phoneEntryType.Color == ColorType.Green)
                    {
                        categoryow.Style.BackColor = Color.LightGreen;
                    }
                    else if (phoneEntryType.Color == ColorType.Orange)
                    {
                        categoryow.Style.BackColor = Color.Orange;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (phoneEntryType.Color == ColorType.Pink)
                    {
                        categoryow.Style.BackColor = Color.Pink;
                    }
                    else if (phoneEntryType.Color == ColorType.Purple)
                    {
                        categoryow.Style.BackColor = Color.Purple;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (phoneEntryType.Color == ColorType.Red)
                    {
                        categoryow.Style.BackColor = Color.DarkRed;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (phoneEntryType.Color == ColorType.Yellow)
                    {
                        categoryow.Style.BackColor = Color.Yellow;
                    }
                    row.Cells.Add(categoryow);
                    if (phoneEntryType.InstituteId == 1)
                    {
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = "ونک", ValueType = typeof(string) });
                    }
                    else if (phoneEntryType.InstituteId == 2)
                    {
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = "نارمک", ValueType = typeof(string) });
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.DepartmentName, ValueType = typeof(string) });
                    string stringPersianSubmitDate = "ERROR";
                    try
                    {
                        stringPersianSubmitDate = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(DateHelper.ConvertJavaMsToDotNetDateTime(phoneEntryType.SubmitDate)).ToString();
                    }
                    catch
                    {
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = stringPersianSubmitDate, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.Name, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.Description, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.Number, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[(phoneEntryType.Seen.HasValue && phoneEntryType.Seen.Value) ? 0 : 1] });
                    row.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[(phoneEntryType.Private.HasValue && phoneEntryType.Private.Value) ? 0 : 1] });
                    row.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[(phoneEntryType.Registered.HasValue && phoneEntryType.Registered.Value) ? 0 : 1] });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.OwnerName, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = phoneEntryType.Id, ValueType = typeof(long) });
                    row.Tag = phoneEntryType.Id;
                    if (phoneEntryType.ShouldBeFollowed.HasValue && phoneEntryType.ShouldBeFollowed.Value)
                    {
                        row.DefaultCellStyle.BackColor = Color.Pink;
                    }
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
        }

        private void DoEdit()
        {
            try
            {
                if (ucEduSysDataGridView.DataGrid.SelectedCells.Count == 0)
                {
                    return;
                }
                long phoneEntryId = long.Parse(ucEduSysDataGridView.DataGrid.Rows[ucEduSysDataGridView.DataGrid.SelectedCells[0].RowIndex].Tag.ToString());
                PhoneBookService service = new PhoneBookService();
                GetPhoneEntryByIdRequest request = new GetPhoneEntryByIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.PhoneEntryId = phoneEntryId;
                GetPhoneEntryByIdResponse response = service.GetPhoneEntryById(request);
                FormEditPhoneEntry form = new FormEditPhoneEntry();
                form.PhoneEntry = response.PhoneEntry;
                form.IsNew = false;
                if (form.ShowDialog() == DialogResult.OK)
                {
                    OnDataRefreshNeeded();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
