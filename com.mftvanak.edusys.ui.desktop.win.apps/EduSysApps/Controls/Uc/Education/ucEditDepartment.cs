using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcEditDepartment : UserControl
    {
        private bool _isNew;
        private InstituteType _instituteType;
        private DepartmentType _department;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public InstituteType Institute
        {
            get { return _instituteType; }
            set { _instituteType = value; }
        }

        public DepartmentType Department
        {
            get { return _department; }
            set
            {
                _department = value;
                if (_department != null)
                {
                    _isNew = false;
                    textboxPersianName.Text = _department.PersianName;
                    textboxEnglishName.Text = _department.EnglishName;
                    textboxSeoKeywords.Text = _department.SeoKeywords;
                    textboxSeoDescription.Text = _department.SeoDescription;
                    textboxColor.Text = _department.Color;
                    textboxShowOrder.Text = _department.ShowOrder.ToString();
                    try
                    {
                        pictureboxColor.BackColor = ColorTranslator.FromHtml(_department.Color);
                    }
                    catch (Exception)
                    {
                    }
                }
            }
        }

        public UcEditDepartment()
        {
            InitializeComponent();
        }

        private void buttonSelectColor_Click(object sender, EventArgs e)
        {
            ColorDialog colorDialog = new ColorDialog();
            if (colorDialog.ShowDialog() == DialogResult.OK)
            {
                textboxColor.Text = "#" + colorDialog.Color.R.ToString("X2") + colorDialog.Color.G.ToString("X2") + colorDialog.Color.B.ToString("X2");
                pictureboxColor.BackColor = colorDialog.Color;
            }
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxPersianName.Text))
            {
                errorMessage = "نام الزامی است.";
                hasError = true;
            }
            if (string.IsNullOrEmpty(textboxEnglishName.Text))
            {
                errorMessage = "نام انگلیسی الزامی است.";
                hasError = true;
            }
            if (string.IsNullOrEmpty(textboxColor.Text))
            {
                errorMessage = "رنگ الزامی است.";
                hasError = true;
            }
            if (string.IsNullOrEmpty(textboxShowOrder.Text))
            {
                errorMessage = "ترتیب الزامی است.";
                hasError = true;
            }
            try
            {
                ColorTranslator.FromHtml(textboxColor.Text);
            }
            catch (Exception)
            {
                errorMessage = "رنگ مقداری نامعتبر دارد.";
                hasError = true;
            }
            if (!hasError)
            {
                try
                {
                    int.Parse(textboxShowOrder.Text);
                }
                catch (Exception)
                {
                    errorMessage = "ترتیب یک عدد می باشد.";
                    hasError = true;
                }
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
                DepartmentServiceService service = new DepartmentServiceService();
                _department.PersianName = StringHelper.MakeCompatibleString(textboxPersianName.Text);
                _department.EnglishName = StringHelper.MakeCompatibleString(textboxEnglishName.Text);
                _department.Color = textboxColor.Text;
                _department.SeoKeywords = StringHelper.MakeCompatibleString(textboxSeoKeywords.Text);
                _department.SeoDescription = StringHelper.MakeCompatibleString(textboxSeoDescription.Text);
                _department.ShowOrder = int.Parse(textboxShowOrder.Text);
                if (_isNew)
                {
                    _department.InstituteId = Institute.Id;
                    Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference.AddDepartmentRequest request = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference.AddDepartmentRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Department = _department;
                    service.AddDepartment(request);
                }
                else
                {
                    UpdateDepartmentRequest request = new UpdateDepartmentRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Department = _department;
                    service.UpdateDepartment(request);
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
