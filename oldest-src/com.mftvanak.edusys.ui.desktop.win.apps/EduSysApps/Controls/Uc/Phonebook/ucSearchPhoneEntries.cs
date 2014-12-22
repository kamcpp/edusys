using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PhonebookWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    public partial class UcSearchPhoneEntries : UserControl
    {
        public UcSearchPhoneEntries()
        {
            InitializeComponent();
        }

        private void buttonSearch_Click(object sender, EventArgs e)
        {
            Search();
        }

        private void ucPhoneEntries_DataRefteshNeeded(object sender)
        {
            Search();
        }

        private void checkboxSelectAllDepartments_CheckedChanged(object sender, EventArgs e)
        {
            ucDepartmentSelector.Enabled = !checkboxSelectAllDepartments.Checked;
        }

        public void LoadControl()
        {
            ucDepartmentSelector.LoadInstitutes();
            checkboxSelectAllDepartments.Checked = true;
        }

        public void Search()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoSearch);
            thread.Start();
        }

        private void DoSearch()
        {
            try
            {
                if (buttonSearch.InvokeRequired)
                {
                    buttonSearch.Invoke(new MethodInvoker(delegate { buttonSearch.Enabled = false; }));
                }
                else
                {
                    buttonSearch.Enabled = false;
                }
                PhoneBookService service = new PhoneBookService();
                GetPhoneEntriesByPredicateRequest request = new GetPhoneEntriesByPredicateRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.Predicate = new PhoneEntrySearchPredicateType();
                if (!checkboxSelectAllDepartments.Checked)
                {
                    if (ucDepartmentSelector.InvokeRequired)
                    {
                        ucDepartmentSelector.Invoke(new MethodInvoker(delegate { request.Predicate.DepartmentId = ucDepartmentSelector.DepartmentId; }));
                    }
                    else
                    {
                        request.Predicate.DepartmentId = ucDepartmentSelector.DepartmentId;
                    }
                }
                if (!fadatepickerSubmitDateStart.IsNull)
                {
                    request.Predicate.SubmitDateStartYear = fadatepickerSubmitDateStart.SelectedDateTime.Year;
                    request.Predicate.SubmitDateStartMonth = fadatepickerSubmitDateStart.SelectedDateTime.Month - 1;
                    request.Predicate.SubmitDateStartDay = fadatepickerSubmitDateStart.SelectedDateTime.Day;
                }
                if (!fadatepickerSubmitDateEnd.IsNull)
                {
                    request.Predicate.SubmitDateEndYear = fadatepickerSubmitDateEnd.SelectedDateTime.Year;
                    request.Predicate.SubmitDateEndMonth = fadatepickerSubmitDateEnd.SelectedDateTime.Month - 1;
                    request.Predicate.SubmitDateEndDay = fadatepickerSubmitDateEnd.SelectedDateTime.Day;
                }
                PhoneEntryType[] phoneEntries = service.GetPhoneEntriesByPredicate(request);
                List<PhoneEntryType> list = new List<PhoneEntryType>();
                list.AddRange(phoneEntries);
                ucPhoneEntries.PhoneEntries = list;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                LoadingManager.Hide();
                if (buttonSearch.InvokeRequired)
                {
                    buttonSearch.Invoke(new MethodInvoker(delegate { buttonSearch.Enabled = true; }));
                }
                else
                {
                    buttonSearch.Enabled = true;
                }
            }
        }
    }
}
