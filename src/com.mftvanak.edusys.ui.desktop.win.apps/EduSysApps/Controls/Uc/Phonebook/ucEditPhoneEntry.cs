using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PhonebookWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    public partial class UcEditPhoneEntry : UserControl
    {
        private bool _isNew;
        private bool _originalSeen;
        private PhoneEntryType _phoneEntry;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public PhoneEntryType PhoneEntry
        {
            get { return _phoneEntry; }
            set
            {
                _phoneEntry = value;
                if (_phoneEntry != null)
                {
                    _isNew = false;
                    if (!ucDepartmentSelector.Loaded)
                    {
                        ucDepartmentSelector.LoadInstitutes();
                    }
                    ucDepartmentSelector.InstituteId = _phoneEntry.InstituteId;
                    ucDepartmentSelector.DepartmentId = _phoneEntry.DepartmentId;
                    labelRegistrarValue.Text = _phoneEntry.OwnerName;
                    string stringPersianSubmitDate = "ERROR";
                    try
                    {
                        stringPersianSubmitDate = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(DateHelper.ConvertJavaMsToDotNetDateTime(_phoneEntry.SubmitDate)).ToString();
                    }
                    catch
                    {
                    }
                    labelRegisterDateValue.Text = stringPersianSubmitDate;
                    textboxName.Text = _phoneEntry.Name;
                    textboxNumber.Text = _phoneEntry.Number;
                    textboxDescription.Text = _phoneEntry.Description;
                    checkboxSeen.Checked = _phoneEntry.Seen.HasValue ? _phoneEntry.Seen.Value : false;
                    checkboxPrivate.Checked = _phoneEntry.Private.HasValue ? _phoneEntry.Private.Value : false;
                    checkboxRegistered.Checked = _phoneEntry.Registered.HasValue ? _phoneEntry.Registered.Value : false;
                    checkboxShouldBeFollowed.Checked = _phoneEntry.ShouldBeFollowed.HasValue ? _phoneEntry.ShouldBeFollowed.Value : false;
                    _originalSeen = _phoneEntry.Seen.HasValue ? _phoneEntry.Seen.Value : false;
                    if (_phoneEntry.Color != null)
                    {
                        if (_phoneEntry.Color.Value == ColorType.Blue)
                        {
                            colorcomboboxColor.SelectedColor = Color.Blue;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Green)
                        {
                            colorcomboboxColor.SelectedColor = Color.Green;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Orange)
                        {
                            colorcomboboxColor.SelectedColor = Color.Orange;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Pink)
                        {
                            colorcomboboxColor.SelectedColor = Color.Pink;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Purple)
                        {
                            colorcomboboxColor.SelectedColor = Color.Purple;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Red)
                        {
                            colorcomboboxColor.SelectedColor = Color.Red;
                        }
                        else if (_phoneEntry.Color.Value == ColorType.Yellow)
                        {
                            colorcomboboxColor.SelectedColor = Color.Yellow;
                        }
                    }
                    foreach (MethodDeConnaissanceComboBoxItem item in comboboxMethodDeConnaissance.Items)
                    {
                        if (item.Code == _phoneEntry.MethodDeConnaissance)
                        {
                            comboboxMethodDeConnaissance.SelectedItem = item;
                        }
                    }
                }
            }
        }

        public UcEditPhoneEntry()
        {
            InitializeComponent();

            colorcomboboxColor.Items.Clear();
            colorcomboboxColor.AddNullItem();
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "آبی", Value = "Blue", ForeColor = Color.Blue });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "قرمز", Value = "Red", ForeColor = Color.Red });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "زرد", Value = "Yellow", ForeColor = Color.Yellow });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "سبز", Value = "Green", ForeColor = Color.Green });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "نارنجی", Value = "Orange", ForeColor = Color.Orange });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "بنفش", Value = "Purple", ForeColor = Color.Purple });
            colorcomboboxColor.Items.Add(new ColorComboBoxItem() { Text = "صورتی", Value = "Pink", ForeColor = Color.Pink });
            colorcomboboxColor.SelectedIndex = 0;

            comboboxMethodDeConnaissance.Items.Clear();
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("---------", 0));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("پرسیده نشده", 1));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("ایمیل", 2));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("تبلیغات روزنامه", 3));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("بنرهای تبلیغاتی", 4));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("جست و جوی گوگل", 5));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("تراکت", 6));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("دوستان و آشنایان", 7));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("اساتید", 8));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("آموزشگاه های دیگر", 9));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("پیام کوتاه", 10));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("فیس بوک", 11));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("توییتر", 12));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("اینترنت", 13));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("دانشجوی قدیمی", 15));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("معرفی شده توسط دانشجویان", 16));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("تابلو", 17));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("تبلیغات مترو", 18));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("معرفی شده توسط سعادت آباد", 19));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("فکس", 20));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("پیک برتر", 21));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("بیلبورد", 22));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("سایت موسسه", 23));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("معرفی شده توسط دوستان", 24));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("سایت تخفیفان", 25));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("دانشگاه آزاد", 26));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("دانشگاه", 27));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("وب سایت نوآوران دانش", 28));
            comboboxMethodDeConnaissance.Items.Add(new MethodDeConnaissanceComboBoxItem("غیره", 14));
            comboboxMethodDeConnaissance.SelectedIndex = 0;
        }

        private void ucEditPhoneEntry_Load(object sender, EventArgs e)
        {
            if (!DesignMode)
            {
                if (_isNew)
                {
                    labelRegistrarValue.Text = AuthenticationContext.DefaultContext.CurrentPrinciple.FullName;
                    labelRegisterDateValue.Text = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(DateTime.Now).ToString();
                }
                if (!ucDepartmentSelector.Loaded)
                {
                    ucDepartmentSelector.LoadInstitutes();
                }
            }
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (ucDepartmentSelector.Department == null)
            {
                errorMessage = "دپارتمان می بایست انتخاب شود.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxName.Text))
            {
                errorMessage = "نام الزامی است.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxNumber.Text))
            {
                errorMessage = "شماره الزامی است.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxDescription.Text))
            {
                errorMessage = "توضیحات الزامی است.";
                hasError = true;
            }
            if (!hasError && (comboboxMethodDeConnaissance.SelectedItem as MethodDeConnaissanceComboBoxItem).Code == 0)
            {
                errorMessage = "نحوه آشنایی می بایست انتخاب شود.";
                hasError = true;
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return !hasError;
        }

        public bool Save()
        {
            try
            {
                PhoneBookService service = new PhoneBookService();
                if (colorcomboboxColor.SelectedColor.HasValue)
                {
                    if (colorcomboboxColor.SelectedColor == Color.Blue)
                    {
                        _phoneEntry.Color = ColorType.Blue;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Blue)
                    {
                        _phoneEntry.Color = ColorType.Blue;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Green)
                    {
                        _phoneEntry.Color = ColorType.Green;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Orange)
                    {
                        _phoneEntry.Color = ColorType.Orange;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Pink)
                    {
                        _phoneEntry.Color = ColorType.Pink;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Purple)
                    {
                        _phoneEntry.Color = ColorType.Purple;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Red)
                    {
                        _phoneEntry.Color = ColorType.Red;
                    }
                    else if (colorcomboboxColor.SelectedColor == Color.Yellow)
                    {
                        _phoneEntry.Color = ColorType.Yellow;
                    }
                }
                else
                {
                    _phoneEntry.Color = null;
                }
                _phoneEntry.Name = textboxName.Text;
                _phoneEntry.Number = textboxNumber.Text;
                _phoneEntry.Description = textboxDescription.Text;
                _phoneEntry.InstituteId = ucDepartmentSelector.InstituteId.Value;
                _phoneEntry.DepartmentId = ucDepartmentSelector.DepartmentId.Value;
                _phoneEntry.Seen = checkboxSeen.Checked;
                _phoneEntry.ShouldBeFollowed = checkboxShouldBeFollowed.Checked;
                _phoneEntry.Registered = checkboxRegistered.Checked;
                _phoneEntry.Private = checkboxPrivate.Checked;
                _phoneEntry.MethodDeConnaissance = (comboboxMethodDeConnaissance.SelectedItem as MethodDeConnaissanceComboBoxItem).Code;
                if (_isNew)
                {
                    _phoneEntry.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                    _phoneEntry.OwnerName = AuthenticationContext.DefaultContext.CurrentPrinciple.FullName;

                    AddPhoneEntryRequest request = new AddPhoneEntryRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.PhoneEntry = _phoneEntry;
                    service.AddPhoneEntry(request);
                    _isNew = false;
                }
                else
                {
                    UpdatePhoneEntryRequest request = new UpdatePhoneEntryRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.PhoneEntry = _phoneEntry;
                    service.UpdatePhoneEntry(request);
                }
                return true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
    }

    public class MethodDeConnaissanceComboBoxItem
    {
        private string _name;
        private int _code;

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public int Code
        {
            get { return _code; }
            set { _code = value; }
        }

        public MethodDeConnaissanceComboBoxItem(string name, int code)
        {
            _name = name;
            _code = code;
        }

        public override string ToString()
        {
            return _name;
        }
    }
}
