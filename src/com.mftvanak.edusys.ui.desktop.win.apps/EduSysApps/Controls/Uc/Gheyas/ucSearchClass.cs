using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas
{
    public partial class UcSearchClass : UserControl
    {
        public UcSearchClass()
        {
            InitializeComponent();
        }

        private void buttonSearchClass_Click(object sender, EventArgs e)
        {
            LoadClasses();
        }

        private void buttonRefreshTerms_Click(object sender, EventArgs e)
        {
            buttonRefreshTerms.Enabled = false;
            this.Refresh();
            LoadTerms();
            buttonRefreshTerms.Enabled = true;
        }

        private void buttonRefreshGroups_Click(object sender, EventArgs e)
        {
            buttonRefreshGroups.Enabled = false;
            this.Refresh();
            LoadGroups();
            buttonRefreshGroups.Enabled = true;
        }

        private void buttonSelectAllTerms_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < checkedlistboxTerms.Items.Count; i++)
            {
                checkedlistboxTerms.SetItemChecked(i, true);
            }
        }

        private void buttonSelectAllGroups_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < checkedlistboxGroups.Items.Count; i++)
            {
                checkedlistboxGroups.SetItemChecked(i, true);
            }
        }

        private void buttonDeselectAllTerms_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < checkedlistboxTerms.Items.Count; i++)
            {
                checkedlistboxTerms.SetItemChecked(i, false);
            }
        }

        private void buttonDeselectAllGroups_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < checkedlistboxGroups.Items.Count; i++)
            {
                checkedlistboxGroups.SetItemChecked(i, false);
            }
        }

        private void radiobuttonFinished_Click(object sender, EventArgs e)
        {
            LoadClasses();
        }

        private void radiobuttonRunning_Click(object sender, EventArgs e)
        {
            LoadClasses();
        }

        private void radiobuttonReserved_Click(object sender, EventArgs e)
        {
            LoadClasses();
        }

        private void radiobuttonAll_Click(object sender, EventArgs e)
        {
            LoadClasses();
        }

        private void textboxClassCode_TextChanged(object sender, EventArgs e)
        {
            disableEnableForm(!string.IsNullOrEmpty(textboxClassCode.Text), false);
        }

        private void datagridviewClasses_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0)
            {
                return;
            }
            string classCode = datagridviewClasses.Rows[datagridviewClasses.SelectedCells[0].RowIndex].Tag.ToString();
            new FormListOfStudents(classCode).Show();
        }

        public void LoadTerms()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetTermsRequest request = new GetTermsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                GheyasTermType[] terms = gheyasService.GetTerms(request);
                foreach (GheyasTermType term in terms)
                {
                    checkedlistboxTerms.Items.Add(new CheckedListBoxItem() { Id = term.Code, Text = term.Name }, false);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void LoadGroups()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetGroupsRequest request = new GetGroupsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                GheyasClassGroupType[] groups = gheyasService.GetGroups(request);
                checkedlistboxGroups.Items.Clear();
                foreach (GheyasClassGroupType group in groups)
                {
                    checkedlistboxGroups.Items.Add(new CheckedListBoxItem() { Id = group.Code, Text = group.Name }, false);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void LoadClasses()
        {
            buttonSearchClass.Enabled = false;
            disableEnableForm(false, true);
            this.Refresh();
            try
            {
                if (!string.IsNullOrEmpty(textboxClassCode.Text))
                {
                    long.Parse(textboxClassCode.Text);
                }
            }
            catch (Exception)
            {
                MessageBox.Show("لطفا برای کد کلاس عدد وارد نمایید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            try
            {
                string termCodes = "";
                for (int i = 0; i < checkedlistboxTerms.CheckedItems.Count; i++)
                {
                    CheckedListBoxItem item = checkedlistboxTerms.CheckedItems[i] as CheckedListBoxItem;
                    termCodes += item.Id;
                    if (i < checkedlistboxTerms.CheckedItems.Count - 1)
                    {
                        termCodes += ",";
                    }
                }
                string groupCodes = "";
                for (int i = 0; i < checkedlistboxGroups.CheckedItems.Count; i++)
                {
                    CheckedListBoxItem item = checkedlistboxGroups.CheckedItems[i] as CheckedListBoxItem;
                    groupCodes += item.Id;
                    if (i < checkedlistboxGroups.CheckedItems.Count - 1)
                    {
                        groupCodes += ",";
                    }
                }
                GheyasService gheyasService = new GheyasService();
                GetClassesRequest request = new GetClassesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                request.TermCodes = termCodes;
                request.GroupCodes = groupCodes;
                if (!string.IsNullOrEmpty(textboxClassName.Text))
                {
                    request.ClassName = textboxClassName.Text;
                }
                if (!string.IsNullOrEmpty(textboxClassCode.Text))
                {
                    request.ClassCode = long.Parse(textboxClassCode.Text);
                }
                if (radiobuttonFinished.Checked)
                {
                    request.ClassNamePattern = "N'*%'";
                }
                else if (radiobuttonRunning.Checked)
                {
                    request.ClassNamePattern = "N'#%'";
                }
                else if (radiobuttonAll.Checked)
                {
                    request.ShowAll = true;
                }
                Report("جست و جوی کلاس ...");
                GheyasClassType[] classes = gheyasService.GetClasses(request);
                Report("آماده");
                datagridviewClasses.Rows.Clear();
                int counter = 1;
                foreach (GheyasClassType gheyasClass in classes)
                {
                    if (!gheyasClass.Name.Contains("خصوص") && !gheyasClass.Name.Contains("آزمون"))
                    {
                        DataGridViewRow row = new DataGridViewRow();
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.Code });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.Name });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.ActiveDays });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.NumberOfStudents, ValueType = typeof(long) });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.StartDate });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.EndDate });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.TeacherTarafHesabCode });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.TeacherName + " " + gheyasClass.TeacherFamily });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.TeacherPhone1 });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.TeacherPhone2 });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = gheyasClass.TeacherEmail });
                        row.Tag = gheyasClass.Code;
                        if (radiobuttonReserved.Checked)
                        {
                            if (gheyasClass.NumberOfStudents == 3)
                            {
                                row.DefaultCellStyle.BackColor = Color.FromArgb(255, 254, 62);
                            }
                            else if (gheyasClass.NumberOfStudents >= 4 && gheyasClass.NumberOfStudents <= 7)
                            {
                                row.DefaultCellStyle.BackColor = Color.LightGreen;
                            }
                            else if (gheyasClass.NumberOfStudents > 7)
                            {
                                row.DefaultCellStyle.BackColor = Color.Red;
                            }
                        }
                        datagridviewClasses.Rows.Add(row);
                        counter++;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                buttonSearchClass.Enabled = true;
                disableEnableForm(true, true);
            }
        }

        private void Report(string message)
        {
            toolStripStatusLabel.Text = message;
            Refresh();
        }

        private void disableEnableForm(bool enable, bool changeClassCodeTextbox)
        {
            checkedlistboxTerms.Enabled = enable;
            checkedlistboxGroups.Enabled = enable;
            buttonDeselectAllGroups.Enabled = enable;
            buttonDeselectAllTerms.Enabled = enable;
            buttonRefreshGroups.Enabled = enable;
            buttonRefreshTerms.Enabled = enable;
            buttonSelectAllGroups.Enabled = enable;
            buttonSelectAllTerms.Enabled = enable;
            radiobuttonAll.Enabled = enable;
            radiobuttonFinished.Enabled = enable;
            radiobuttonReserved.Enabled = enable;
            radiobuttonRunning.Enabled = enable;
            if (changeClassCodeTextbox)
            {
                textboxClassCode.Enabled = enable;
            }
        }
    }

    public class CheckedListBoxItem
    {
        public string Id;
        public string Text;

        public override string ToString()
        {
            return Text;
        }
    }
}
