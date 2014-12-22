using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcEditInstitute : UserControl
    {
        private bool _isNew;
        private InstituteType _instituteType;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public InstituteType InstituteType
        {
            get { return _instituteType; }
            set
            {
                _instituteType = value;
                if (_instituteType != null)
                {
                    textboxPersianName.Text = _instituteType.PersianName;
                    textboxEnglishName.Text = _instituteType.EnglishName;
                    textboxPhone1.Text = _instituteType.Phone1;
                    textboxPhone2.Text = _instituteType.Phone2;
                    textboxFaxNumber.Text = _instituteType.FaxNumber;
                    textboxEmail1.Text = _instituteType.Email1;
                    textboxEmail2.Text = _instituteType.Email2;
                    textboxWebUrl1.Text = _instituteType.WebUrl1;
                    textboxWebUrl2.Text = _instituteType.WebUrl2;
                }
            }
        }

        public UcEditInstitute()
        {
            InitializeComponent();
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxPersianName.Text))
            {
                errorMessage = "نام موسسه الزامی است.";
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
                InstituteServiceService instituteService = new InstituteServiceService();
                _instituteType.PersianName = StringHelper.MakeCompatibleString(textboxPersianName.Text);
                _instituteType.EnglishName = StringHelper.MakeCompatibleString(textboxEnglishName.Text);
                _instituteType.Phone1 = StringHelper.MakeCompatibleString(textboxPhone1.Text);
                _instituteType.Phone2 = StringHelper.MakeCompatibleString(textboxPhone2.Text);
                _instituteType.FaxNumber = StringHelper.MakeCompatibleString(textboxFaxNumber.Text);
                _instituteType.Email1 = StringHelper.MakeCompatibleString(textboxEmail1.Text);
                _instituteType.Email2 = StringHelper.MakeCompatibleString(textboxEmail2.Text);
                _instituteType.WebUrl1 = StringHelper.MakeCompatibleString(textboxWebUrl1.Text);
                _instituteType.WebUrl2 = StringHelper.MakeCompatibleString(textboxWebUrl2.Text);

                if (_isNew)
                {
                    AddInstituteRequest request = new AddInstituteRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Institute = _instituteType;
                    instituteService.AddInstitute(request);
                }
                else
                {
                    UpdateInstituteRequest request = new UpdateInstituteRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Institute = _instituteType;
                    instituteService.UpdateInstitute(request);
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
