using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.UserWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.EmployeeWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PersonWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    public partial class UcEmployeeEditor : UserControl
    {
        private bool _isNew;
        private long _personId;

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

        public UcEmployeeEditor()
        {
            InitializeComponent();
            _isNew = true;
            _personId = -1;
        }

        public bool Save()
        {
            if (ucEditPerson.ValidateInformation() && ucEditUser.ValidateInformation() && ucEditEmployee.ValidateInformation())
            {
                long personId = -1;
                bool result = ucEditPerson.Save(ref personId);
                if (!result)
                {
                    return false;
                }
                ucEditEmployee.PersonId = personId;
                ucEditUser.PersonId = personId;
                return ucEditUser.Save() && ucEditEmployee.Save();
            }
            else
            {
                return false;
            }
        }

        public void LoadData()
        {
            try
            {
                if (_isNew)
                {
                    PersonType person = new PersonType();
                    ucEditPerson.Person = person;
                    ucEditPerson.IsNew = true;

                    UserType user = new UserType();
                    ucEditUser.User = user;
                    ucEditUser.IsNew = true;

                    EmployeeType employee = new EmployeeType();
                    ucEditEmployee.Employee = employee;
                    ucEditEmployee.IsNew = true;
                }
                else
                {
                    PersonService personService = new PersonService();
                    GetPersonByIdRequest getPersonByIdRequest = new GetPersonByIdRequest();
                    ClientInformation.FillWithClientInformation(getPersonByIdRequest);
                    getPersonByIdRequest.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    getPersonByIdRequest.PersonId = _personId;
                    GetPersonByIdResponse getPersonByIdResponse = personService.GetPersonById(getPersonByIdRequest);
                    ucEditPerson.Person = getPersonByIdResponse.Person;
                    ucEditPerson.IsNew = false;

                    UserService userService = new UserService();
                    GetUserByIdRequest getUserByIdRequest = new GetUserByIdRequest();
                    ClientInformation.FillWithClientInformation(getUserByIdRequest);
                    getUserByIdRequest.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    getUserByIdRequest.UserId = _personId;
                    GetUserByIdResponse getUserByIdResponse = userService.GetUserById(getUserByIdRequest);
                    ucEditUser.User = getUserByIdResponse.User;
                    ucEditUser.IsNew = false;

                    EmployeeService employeeService = new EmployeeService();
                    GetEmployeeByIdRequest getEmployeeByIdRequest = new GetEmployeeByIdRequest();
                    ClientInformation.FillWithClientInformation(getEmployeeByIdRequest);
                    getEmployeeByIdRequest.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    getEmployeeByIdRequest.EmployeeId = _personId;
                    GetEmployeeByIdResponse getEmployeeByIdResponse = employeeService.GetEmployeeById(getEmployeeByIdRequest);
                    ucEditEmployee.Employee = getEmployeeByIdResponse.Employee;
                    ucEditEmployee.IsNew = false;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
