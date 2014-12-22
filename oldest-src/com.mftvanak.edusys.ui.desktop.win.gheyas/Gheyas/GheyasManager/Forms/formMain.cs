using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.GheyasWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
{
    public partial class formMain : formBase
    {
        public formMain()
        {
            InitializeComponent();

            if (new formLogin().ShowDialog() != System.Windows.Forms.DialogResult.OK)
            {
                Process.GetCurrentProcess().Kill();
            }
        }

        private void formMain_Load(object sender, EventArgs e)
        {
        }

        private void toolstripmenuitemClose_Click(object sender, EventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }

        private void toolstripmenuitemListOfClasses_Click(object sender, EventArgs e)
        {
            new formListOfClasses().Show();
        }

        private void buttonSearch_Click(object sender, EventArgs e)
        {
            try
            {
                if (string.IsNullOrEmpty(textboxName.Text) && string.IsNullOrEmpty(textboxFamily.Text))
                {
                    MessageBox.Show("یکی از موارد نام یا نام خانوادگی الزامی است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }

                buttonSearch.Enabled = false;
                this.Refresh();
                SearchStudentsRequest request = new SearchStudentsRequest();
                request.Token = Context.DefaultContext.CurrentPrinciple.TokenValue;
                request.Name = StringHelper.MakeCompatibleString(textboxName.Text);
                request.Family = StringHelper.MakeCompatibleString(textboxFamily.Text);
                GheyasService gheyasService = new GheyasService();
                GheyasStudentType[] students = gheyasService.SearchStudents(request);
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
            finally
            {
                buttonSearch.Enabled = true;
            }
        }
    }
}
