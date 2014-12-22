using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.GheyasWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
{
    public partial class formListOfStudents : formBase
    {
        private string _classCode;

        public formListOfStudents(string classCode)
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
                request.Token = Context.DefaultContext.CurrentPrinciple.TokenValue;
                request.ClassCode = _classCode;
                GheyasStudentType[] students = gheyasService.GetStudents(request);
                listviewStudents.Items.Clear();
                int counter = 1;
                foreach (GheyasStudentType student in students)
                {
                    ListViewItem item = new ListViewItem();
                    item.Text = counter.ToString();
                    item.SubItems.Add(student.Code);
                    item.SubItems.Add(student.Name);
                    item.SubItems.Add(student.Family);
                    item.SubItems.Add(student.Phone);
                    item.SubItems.Add(student.EmergencyPhone);
                    item.SubItems.Add(student.Email);
                    item.SubItems.Add(student.BirthDate);
                    item.SubItems.Add(student.Paid);
                    item.SubItems.Add(student.Payment);
                    item.SubItems.Add(student.PaymentDate);
                    item.SubItems.Add(student.PaymentDiscount);
                    item.SubItems.Add(student.Address);
                    item.SubItems.Add(student.Description);
                    listviewStudents.Items.Add(item);
                    counter++;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
