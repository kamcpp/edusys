using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Phonebook;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PhonebookWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    public partial class UcMyPhoneEntries : UserControl
    {
        public UcMyPhoneEntries()
        {
            InitializeComponent();
        }

        private void toolstripbuttonRefreshLatestPhoneEntires_Click(object sender, EventArgs e)
        {
            LoadPhoneEntries();
        }

        private void toolstripbuttonNewPhoneEntry_Click(object sender, EventArgs e)
        {
            Add();
        }

        private void toolstripbuttonEditPhoneEntry_Click(object sender, EventArgs e)
        {
            ucPhoneEntries.Edit();
        }

        private void ucPhoneEntries_DataRefteshNeeded(object sender)
        {
            LoadPhoneEntries();
        }

        public void LoadPhoneEntries()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoLoadPhoneEntries);
            thread.Start();
        }

        public void DoLoadPhoneEntries()
        {
            try
            {
                PhoneBookService service = new PhoneBookService();
                GetPhoneEntriesByOwnerIdRequest request = new GetPhoneEntriesByOwnerIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                request.Count = 200;
                PhoneEntryType[] phoneEntries = service.GetPhoneEntriesByOwnerId(request);
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
            }
        }

        public void Add()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoAdd);
            thread.Start();
        }

        private void DoAdd()
        {
            FormEditPhoneEntry form = new FormEditPhoneEntry();
            PhoneEntryType phoneEntryType = new PhoneEntryType();
            phoneEntryType.ShouldBeFollowed = true;
            form.PhoneEntry = phoneEntryType;
            form.IsNew = true;
            if (form.ShowDialog() == DialogResult.OK)
            {
                LoadPhoneEntries();
            }
        }
    }
}
