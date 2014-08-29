using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    public partial class FormListOfStudents : FormBase
    {
        private string _classCode;

        public FormListOfStudents(string classCode)
        {
            InitializeComponent();
            _classCode = classCode;
        }

        private void formListOfStudents_Load(object sender, EventArgs e)
        {
            LoadStudents();
        }

        private void buttonRefreshStudents_Click(object sender, EventArgs e)
        {
            buttonRefreshStudents.Enabled = false;
            this.Refresh();
            LoadStudents();
            buttonRefreshStudents.Enabled = true;
        }

        private void LoadStudents()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetStudentsRequest request = new GetStudentsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                request.ClassCode = _classCode;
                GheyasStudentType[] students = gheyasService.GetStudents(request);
                List<GheyasStudentType> listStudents = new List<GheyasStudentType>(students);
                ucStudents.Students = listStudents;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void ucStudents_NeedData(object sender)
        {
            LoadStudents();
        }
    }
}
