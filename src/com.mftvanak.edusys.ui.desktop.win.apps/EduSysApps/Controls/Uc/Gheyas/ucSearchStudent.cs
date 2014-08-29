using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas
{
    public partial class UcSearchStudent : UserControl
    {
        public UcSearchStudent()
        {
            InitializeComponent();
        }

        private void buttonSearch_Click(object sender, EventArgs e)
        {
            Search();
        }

        private void ucStudents_LoadDone(object sender)
        {
            buttonSearch.Enabled = true;
        }

        public void Search()
        {
            LoadingManager.LoadingShower.ShowLoading();
            Thread thread = new Thread(DoSearch);
            thread.Start();
        }

        public void DoSearch()
        {
            try
            {
                if (string.IsNullOrEmpty(textboxName.Text) && string.IsNullOrEmpty(textboxFamily.Text))
                {
                    MessageBox.Show("یکی از موارد نام یا نام خانوادگی الزامی است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                if (buttonSearch.InvokeRequired)
                {
                    buttonSearch.Invoke(new MethodInvoker(delegate { buttonSearch.Enabled = false; }));
                }
                else
                {
                    buttonSearch.Enabled = false;
                }
                if (this.InvokeRequired)
                {
                    this.Invoke(new MethodInvoker(delegate { this.Refresh(); }));
                }
                else
                {
                    this.Refresh();
                }
                SearchStudentsRequest request = new SearchStudentsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                request.Name = StringHelper.MakeCompatibleString(textboxName.Text);
                request.Family = StringHelper.MakeCompatibleString(textboxFamily.Text);
                GheyasService gheyasService = new GheyasService();
                GheyasStudentType[] students = gheyasService.SearchStudents(request);
                List<GheyasStudentType> studentsList = new List<GheyasStudentType>(students);
                ucStudents.Students = studentsList;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                if (buttonSearch.InvokeRequired)
                {
                    buttonSearch.Invoke(new MethodInvoker(delegate { buttonSearch.Enabled = true; }));
                }
                else
                {
                    buttonSearch.Enabled = true;
                }
                LoadingManager.LoadingShower.HideLoading();
            }
        }

        private void ucStudents_NeedData(object sender)
        {
            Search();
        }
    }
}
