using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard;
using System.IO;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcWizardControlMobileNumberList : UserControl, IWizardStepControl
    {
        private List<MobileNumber> _mobileNumbers;

        public List<MobileNumber> MobileNumbers
        {
            get
            {
                List<MobileNumber> toReturn = new List<MobileNumber>();
                foreach (MobileNumber mobileNumber in _mobileNumbers)
                {
                    if (mobileNumber.IsMobile)
                    {
                        toReturn.Add(mobileNumber);
                    }
                }
                return toReturn;
            }
        }

        public UcWizardControlMobileNumberList()
        {
            InitializeComponent();
            _mobileNumbers = new List<MobileNumber>();
        }

        public void AddMobileNumber(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                return;
            }
            number = number.Trim().Replace("-", "").Replace(" ", "").Replace("_", "");
            MobileNumber mobileNumber = new MobileNumber(number);
            if (!_mobileNumbers.Contains(mobileNumber))
            {
                _mobileNumbers.Add(mobileNumber);
                int index = checkedlistboxNumbers.Items.Add(new MobileNumberCheckedListBoxItem(mobileNumber));
                checkedlistboxNumbers.SetItemChecked(index, mobileNumber.IsMobile);
                labelTitle.Text = "کل شماره ها " + _mobileNumbers.Count + " عدد و انتخاب شده " + checkedlistboxNumbers.CheckedItems.Count + " عدد";
            }
        }

        private void checkedlistboxNumbers_ItemCheck(object sender, ItemCheckEventArgs e)
        {
            labelTitle.Text = "کل شماره ها " + _mobileNumbers.Count + " عدد و انتخاب شده " + (checkedlistboxNumbers.CheckedItems.Count + (e.NewValue == CheckState.Checked ? 1 : -1)) + " عدد";
        }

        private void buttonAddMyPhones_Click(object sender, EventArgs e)
        {
            AddMobileNumber(AuthenticationContext.DefaultContext.CurrentPrinciple.Phone1);
            AddMobileNumber(AuthenticationContext.DefaultContext.CurrentPrinciple.Phone2);
            AddMobileNumber(AuthenticationContext.DefaultContext.CurrentPrinciple.Phone3);
        }

        private void buttonAddPhone_Click(object sender, EventArgs e)
        {
            FormMobileNumberEdit form = new FormMobileNumberEdit();
            if (form.ShowDialog() == DialogResult.OK)
            {
                AddMobileNumber(form.MobileNumber);
            }
        }

        private void checkedlistboxNumbers_DoubleClick(object sender, EventArgs e)
        {
            if (checkedlistboxNumbers.SelectedItems.Count == 0)
            {
                return;
            }
            MobileNumberCheckedListBoxItem item = checkedlistboxNumbers.SelectedItems[0] as MobileNumberCheckedListBoxItem;
            FormMobileNumberEdit form = new FormMobileNumberEdit();
            form.MobileNumber = item.Number.ValidatedNumber;
            if (form.ShowDialog() == DialogResult.OK)
            {
                item.Number.OriginalNumber = form.MobileNumber;
                checkedlistboxNumbers.SetItemChecked(checkedlistboxNumbers.SelectedIndices[0], item.Number.IsMobile);
            }
        }

        public bool ValidateStepControl()
        {
            if (MobileNumbers.Count == 0)
            {
                MessageBox.Show("شما می بایست شماره ای برای فرستادن انتخاب نمایید", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        private void buttonExportCSV_Click(object sender, EventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.Filter = "CSV Files|*.csv";
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                StringBuilder sb = new StringBuilder();
                foreach (MobileNumber mobileNumber in MobileNumbers)
                {
                    sb.Append(mobileNumber.ValidatedNumber + ",");
                }
                using (StreamWriter sw = new StreamWriter(dialog.FileName))
                {
                    sw.Write(sb.ToString().Substring(0, sb.ToString().Length - 1));
                }
            }
        }

        private void buttonExportText_Click(object sender, EventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.Filter = "Text Files|*.txt";
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                StringBuilder sb = new StringBuilder();
                foreach (MobileNumber mobileNumber in MobileNumbers)
                {
                    sb.AppendLine(mobileNumber.ValidatedNumber);
                }
                using (StreamWriter sw = new StreamWriter(dialog.FileName))
                {
                    sw.Write(sb.ToString());
                }
            }
        }
    }

    public class MobileNumberCheckedListBoxItem
    {
        private MobileNumber _number;

        public MobileNumber Number
        {
            get { return _number; }
            set { _number = value; }
        }

        public MobileNumberCheckedListBoxItem(MobileNumber number)
        {
            Number = number;
        }

        public override string ToString()
        {
            return _number.ValidatedNumber;
        }
    }
}
