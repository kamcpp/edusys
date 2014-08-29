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
    public partial class formListOfClasses : formBase
    {
        public formListOfClasses()
        {
            InitializeComponent();
        }

        private void formListOfClasses_Load(object sender, EventArgs e)
        {
            LoadTerms();
            LoadGroups();
        }

        private void buttonShowListOfClasses_Click(object sender, EventArgs e)
        {
            buttonShowListOfClasses.Enabled = false;
            this.Refresh();
            LoadClasses();
            buttonShowListOfClasses.Enabled = true;
        }

        private void listviewClasses_DoubleClick(object sender, EventArgs e)
        {
            if (listviewClasses.SelectedItems.Count == 0)
            {
                return;
            }
            string classCode = listviewClasses.SelectedItems[0].SubItems[1].Text;
            new formListOfStudents(classCode).Show();
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

        private void LoadTerms()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetTermsRequest gheyasTermRequest = new GetTermsRequest();
                gheyasTermRequest.Token = Context.DefaultContext.CurrentPrinciple.TokenValue;
                GheyasTermType[] terms = gheyasService.GetTerms(gheyasTermRequest);
                comboboxTerm.DataSource = terms;
                comboboxTerm.DisplayMember = "Name";
                comboboxTerm.ValueMember = "Code";
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void LoadGroups()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetGroupsRequest gheyasGroupRequest = new GetGroupsRequest();
                gheyasGroupRequest.Token = Context.DefaultContext.CurrentPrinciple.TokenValue;
                GheyasClassGroupType[] groups = gheyasService.GetGroups(gheyasGroupRequest);
                comboboxGroup.DataSource = groups;
                comboboxGroup.DisplayMember = "Name";
                comboboxGroup.ValueMember = "Code";
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void LoadClasses()
        {
            try
            {
                GheyasService gheyasService = new GheyasService();
                GetClassesRequest request = new GetClassesRequest();
                request.Token = Context.DefaultContext.CurrentPrinciple.TokenValue;
                request.TermCode = comboboxTerm.SelectedValue.ToString();
                request.GroupCode = comboboxGroup.SelectedValue.ToString();
                GheyasClassType[] classes = gheyasService.GetClasses(request);
                listviewClasses.Items.Clear();
                int counter = 1;
                foreach (GheyasClassType gheyasClass in classes)
                {
                    ListViewItem item = new ListViewItem();
                    item.Text = counter.ToString();
                    item.SubItems.Add(gheyasClass.Code);
                    item.SubItems.Add(gheyasClass.Name);
                    item.SubItems.Add(gheyasClass.ActiveDays);
                    item.SubItems.Add(gheyasClass.NumberOfStudents.ToString());
                    item.SubItems.Add(gheyasClass.Description);
                    listviewClasses.Items.Add(item);
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
