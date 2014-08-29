using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.EmployeeWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;


namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    public partial class UcEditEmployee : UserControl
    {
        private bool _isNew;
        private long _personId;
        private string _originalEmployeeNumber;
        private EmployeeType _employee;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public long PersonId
        {
            get { return _personId; }
            set { _personId = value; }
        }

        public EmployeeType Employee
        {
            get { return _employee; }
            set
            {
                _employee = value;
                if (_employee != null)
                {
                    _isNew = false;
                    textboxEmployeeNumber.Text = _employee.EmployeeNumber;
                    _originalEmployeeNumber = _employee.EmployeeNumber;
                }
            }
        }

        public UcEditEmployee()
        {
            InitializeComponent();
            _employee = null;
            _isNew = true;
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (string.IsNullOrEmpty(textboxEmployeeNumber.Text))
            {
                errorMessage = "شماره پرسنلی می بایست وارد شود.";
                hasError = true;
            }
            if (!hasError && _originalEmployeeNumber != textboxEmployeeNumber.Text)
            {
                EmployeeService employeeService = new EmployeeService();
                EmployeeExistsByEmployeeNumberRequest request = new EmployeeExistsByEmployeeNumberRequest();
                ClientInformation.FillWithClientInformation(request);
                request.EmployeeNumber =  StringHelper.MakeCompatibleString(textboxEmployeeNumber.Text);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                EmployeeExistsByEmployeeNumberResponse response = employeeService.EmployeeExistsByEmployeeNumber(request);
                if (response.Result)
                {
                    errorMessage = "کارمندی با این شماره پرسنلی وجود دارد.";
                    hasError = true;
                }
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        public bool Save()
        {
            try
            {
                EmployeeService employeeService = new EmployeeService();
                _employee.PersonId = _personId;
                _employee.EmployeeNumber =  StringHelper.MakeCompatibleString(textboxEmployeeNumber.Text);

                if (_isNew)
                {
                    AddEmployeeRequest request = new AddEmployeeRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Employee = _employee;
                    employeeService.AddEmployee(request);
                    _isNew = false;
                }
                else
                {
                    UpdateEmployeeRequest request = new UpdateEmployeeRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.Employee = _employee;
                    employeeService.UpdateEmployee(request);
                }
                _originalEmployeeNumber = _employee.EmployeeNumber;
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
