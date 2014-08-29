using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.TodoWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.StaffApp.Forms
{
    public partial class formMain : FormBase, LoadingShower
    {
        private UcSearchClass _ucSearchClass;
        private UcSearchStudent _ucSearchStudent;
        private UcMyPhoneEntries _ucMyPhoneEntries;
        private UcSearchPhoneEntries _ucSearchPhoneEntries;
        private UcMyTodoItems _ucMyTodoItems;
        private UcAssignedTodoItems _ucAssignedTodoITems;
        private UcGeneralReservations _ucGeneralReservations;
        private UcReservations _ucReservations;
        private UcDebtors _ucDebtors;
        private Control _showingControl;

        public formMain()
        {
            InitializeComponent();

            if (GeneralSettings.InstituteIds.Count == 1 && GeneralSettings.InstituteIds[0] == 2)
            {
                linklabelGeneralReserves.Visible = false;
                linklabelPreRegistration.Visible = false;
                linklabelTeachers.Visible = false;
                linklabelStudents.Visible = false;
                linklabelDebtors.Visible = false;
            }
            this.Text = this.Text + " - " + AuthenticationContext.DefaultContext.ApplicationInformation.GetApplicationVersion();
        }

        public void ShowLoading()
        {
            if (pictureboxLoading.InvokeRequired)
            {
                pictureboxLoading.Invoke(new MethodInvoker(delegate { pictureboxLoading.Visible = true; }));
            }
            else
            {
                pictureboxLoading.Visible = true;
            }
        }

        public void HideLoading()
        {
            if (pictureboxLoading.InvokeRequired)
            {
                pictureboxLoading.Invoke(new MethodInvoker(delegate { pictureboxLoading.Visible = false; }));
            }
            else
            {
                pictureboxLoading.Visible = false;
            }
        }

        private void formMain_Load(object sender, EventArgs e)
        {
            FormLogin form = new FormLogin();
            form.Username = ApplicationSettings.InitialUsername;
            if (form.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                ApplicationSettings.InitialUsername = form.Username;
                ucUserInformationStatusBar.UpdateLabels();
                linklabelSmsWizard.Visible = AuthenticationContext.DefaultContext.CurrentPrinciple.HashRole("ROLE_SMS");
            }
            else
            {
                ApplicationSettings.InitialUsername = form.Username;
                ApplicationSettings.NotifyControl.Visible = false;
                Process.GetCurrentProcess().Kill();
            }
        }

        private void formMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (MessageBox.Show("آیا اطمینان به خروج دارید؟", "خروج", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == System.Windows.Forms.DialogResult.Yes)
            {
                ApplicationSettings.NotifyControl.Visible = false;
                Process.GetCurrentProcess().Kill();
            }
            else
            {
                e.Cancel = true;
            }
        }

        private void toolstripmenuitemExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void linklabelSearchClass_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucSearchClass == null || _showingControl != _ucSearchClass)
            {
                if (_ucSearchClass == null)
                {
                    _ucSearchClass = new UcSearchClass();
                    _ucSearchClass.LoadGroups();
                    _ucSearchClass.LoadTerms();
                    _ucSearchClass.Dock = DockStyle.Fill;
                }
                _showingControl = _ucSearchClass;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelStudentSearch_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucSearchStudent == null || _showingControl != _ucSearchStudent)
            {
                if (_ucSearchStudent == null)
                {
                    _ucSearchStudent = new UcSearchStudent();
                    _ucSearchStudent.Dock = DockStyle.Fill;
                }
                _showingControl = _ucSearchStudent;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelMyPhoneEntries_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucMyPhoneEntries == null || _showingControl != _ucMyPhoneEntries)
            {
                if (_ucMyPhoneEntries == null)
                {
                    _ucMyPhoneEntries = new UcMyPhoneEntries();
                    _ucMyPhoneEntries.LoadPhoneEntries();
                    _ucMyPhoneEntries.Dock = DockStyle.Fill;
                }
                _showingControl = _ucMyPhoneEntries;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelPhoneEntryReport_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucSearchPhoneEntries == null || _showingControl != _ucSearchPhoneEntries)
            {
                if (_ucSearchPhoneEntries == null)
                {
                    _ucSearchPhoneEntries = new UcSearchPhoneEntries();
                    _ucSearchPhoneEntries.LoadControl();
                    _ucSearchPhoneEntries.Dock = DockStyle.Fill;
                }
                _showingControl = _ucSearchPhoneEntries;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelAddTodoItem_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FormEditTodoItem form = new FormEditTodoItem();
            form.TodoItem = new TodoItemType();
            form.IsNew = true;
            form.ShowDialog();
        }

        private void linklabelMyTasks_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucMyTodoItems == null || _showingControl != _ucMyTodoItems)
            {
                if (_ucMyTodoItems == null)
                {
                    _ucMyTodoItems = new UcMyTodoItems();
                    _ucMyTodoItems.LoadTooItems();
                    _ucMyTodoItems.Dock = DockStyle.Fill;
                }
                _showingControl = _ucMyTodoItems;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelAssignedTasks_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucAssignedTodoITems == null || _showingControl != _ucAssignedTodoITems)
            {
                if (_ucAssignedTodoITems == null)
                {
                    _ucAssignedTodoITems = new UcAssignedTodoItems();
                    _ucAssignedTodoITems.LoadTooItems();
                    _ucAssignedTodoITems.Dock = DockStyle.Fill;
                }
                _showingControl = _ucAssignedTodoITems;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelDashboard_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            panelUc.Controls.Clear();
        }

        private void linklabelQuit_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (MessageBox.Show("آیا اطمینان به خروج دارید؟", "خروج", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == System.Windows.Forms.DialogResult.Yes)
            {
                ApplicationSettings.NotifyControl.Visible = false;
                Process.GetCurrentProcess().Kill();
            }
        }

        private void linklabelProfile_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FormProfile form = new FormProfile();
            form.PersonId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
            form.IsNew = false;
            form.ShowDialog();
        }

        private void linklabelGeneralReserves_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucGeneralReservations == null || _showingControl != _ucGeneralReservations)
            {
                if (_ucGeneralReservations == null)
                {
                    _ucGeneralReservations = new UcGeneralReservations();
                    _ucGeneralReservations.Dock = DockStyle.Fill;
                }
                _showingControl = _ucGeneralReservations;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelSmsWizard_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FormSmsWizard form = new FormSmsWizard();
            form.ShowDialog();
        }

        private void linklabelMessageTemplateManagement_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FormMessageTemplateManager form = new FormMessageTemplateManager();
            form.MessageTemplateExplorer.LoadMyMessageTemplates();
            form.MessageTemplateExplorer.LoadAllMessageTemplates();
            form.ShowDialog();
        }

        private void linklabelChangePassword_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FormChangePassword form = new FormChangePassword();
            form.ShowDialog();
        }

        private void linklabelPreRegistration_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucReservations == null || _showingControl != _ucReservations)
            {
                if (_ucReservations == null)
                {
                    _ucReservations = new UcReservations();
                    _ucReservations.Dock = DockStyle.Fill;
                }
                _showingControl = _ucReservations;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }

        private void linklabelDebtors_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (_ucDebtors == null || _showingControl != _ucDebtors)
            {
                if (_ucDebtors == null)
                {
                    _ucDebtors = new UcDebtors();
                    _ucDebtors.LoadDebtors();
                    _ucDebtors.Dock = DockStyle.Fill;
                }
                _showingControl = _ucDebtors;
                panelUc.Controls.Clear();
                panelUc.Controls.Add(_showingControl);
            }
        }
    }
}
