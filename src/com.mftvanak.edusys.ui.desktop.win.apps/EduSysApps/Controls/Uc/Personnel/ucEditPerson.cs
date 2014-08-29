using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PersonWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Personnel
{
    public partial class UcEditPerson : UserControl
    {
        private bool _isNew;
        private PersonType _person;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public PersonType Person
        {
            get { return _person; }
            set
            {
                _person = value;
                if (_person != null)
                {
                    textboxPersianName.Text = _person.PersianName;
                    textboxPersianFamily.Text = _person.PersianFamily;
                    textboxEnglishName.Text = _person.EnglishName;
                    textboxEnglishFamily.Text = _person.EnglishFamily;
                    textboxFatherName.Text = _person.FatherName;
                    textboxNationalCode.Text = _person.NationalCode;
                    textboxShSh.Text = _person.ShSh;
                    textboxShLocation.Text = _person.ShLocation;
                    textboxPhone1.Text = _person.Phone1;
                    textboxPhone2.Text = _person.Phone2;
                    textboxPhone3.Text = _person.Phone3;
                    textboxEmail1.Text = _person.Email1;
                    textboxEmail2.Text = _person.Email2;
                    textboxWebUrl1.Text = _person.WebUrl1;
                    textboxWebUrl2.Text = _person.WebUrl2;
                    textboxAddress1.Text = _person.Address1;
                    textboxAddress2.Text = _person.Address2;
                    textboxDescription.Text = _person.Description;
                    comboboxGender.SelectedIndex = _person.Gender;
                    if (_person.DateOfBirth != 0)
                    {
                        fadatepickerDateOfBirth.SelectedDateTime = new DateTime(_person.DateOfBirth);
                    }
                    else
                    {
                        fadatepickerDateOfBirth.IsNull = true;
                    }
                }
            }
        }

        public UcEditPerson()
        {
            InitializeComponent();

            comboboxGender.Items.Clear();
            comboboxGender.Items.Add("-----");
            comboboxGender.Items.Add("مرد");
            comboboxGender.Items.Add("زن");
            comboboxGender.Items.Add("غیره");
            comboboxGender.SelectedIndex = 0;

            _isNew = true;
            _person = null;
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxPersianName.Text) || string.IsNullOrEmpty(textboxPersianFamily.Text))
            {
                errorMessage = "نام و نام خانوادگی می بایست وارد شود.";
                hasError = true;
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        public bool Save(ref long personId)
        {
            try
            {
                PersonService personService = new PersonService();
                _person.PersianName =  StringHelper.MakeCompatibleString(textboxPersianName.Text);
                _person.PersianFamily =  StringHelper.MakeCompatibleString(textboxPersianFamily.Text);
                _person.EnglishName =  StringHelper.MakeCompatibleString(textboxEnglishName.Text);
                _person.EnglishFamily =  StringHelper.MakeCompatibleString(textboxEnglishFamily.Text);
                _person.FatherName =  StringHelper.MakeCompatibleString(textboxFatherName.Text);
                _person.NationalCode =  StringHelper.MakeCompatibleString(textboxNationalCode.Text);
                _person.ShLocation =  StringHelper.MakeCompatibleString(textboxShLocation.Text);
                _person.Description =  StringHelper.MakeCompatibleString(textboxDescription.Text);
                _person.ShSh =  StringHelper.MakeCompatibleString(textboxShSh.Text);
                _person.Phone1 = StringHelper.MakeCompatibleString(textboxPhone1.Text);
                _person.Phone2 = StringHelper.MakeCompatibleString(textboxPhone2.Text);
                _person.Phone3 = StringHelper.MakeCompatibleString(textboxPhone3.Text);
                _person.Email1 = StringHelper.MakeCompatibleString(textboxEmail1.Text);
                _person.Email2 = StringHelper.MakeCompatibleString(textboxEmail2.Text);
                _person.WebUrl1 = StringHelper.MakeCompatibleString(textboxWebUrl1.Text);
                _person.WebUrl2 = StringHelper.MakeCompatibleString(textboxWebUrl2.Text);
                _person.Address1 = StringHelper.MakeCompatibleString(textboxAddress1.Text);
                _person.Address2 = StringHelper.MakeCompatibleString(textboxAddress2.Text);
                _person.DateOfBirth = !fadatepickerDateOfBirth.IsNull ? fadatepickerDateOfBirth.SelectedDateTime.Ticks : 0;
                _person.Gender = comboboxGender.SelectedIndex;

                if (_isNew)
                {
                    AddPersonRequest request = new AddPersonRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Person = _person;
                    AddPersonResponse response = personService.AddPerson(request);
                    personId = response.PersonId;
                    _isNew = false;
                }
                else
                {
                    UpdatePersonRequest request = new UpdatePersonRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Person = _person;
                    personService.UpdatePerson(request);
                    personId = _person.Id;
                    _isNew = false;
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
}
