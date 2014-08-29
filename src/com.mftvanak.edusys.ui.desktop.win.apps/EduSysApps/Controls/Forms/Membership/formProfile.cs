using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PersonWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership
{
    public partial class FormProfile : FormBase
    {
        public bool IsNew
        {
            get { return ucEditPerson.IsNew; }
            set { ucEditPerson.IsNew = value; }
        }

        public long PersonId
        {
            get { return ucEditPerson.Person.Id; }
            set 
            {
                PersonService personService = new PersonService();
                GetPersonByIdRequest getPersonByIdRequest = new GetPersonByIdRequest();
                ClientInformation.FillWithClientInformation(getPersonByIdRequest);
                getPersonByIdRequest.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                getPersonByIdRequest.PersonId = value;
                GetPersonByIdResponse getPersonByIdResponse = personService.GetPersonById(getPersonByIdRequest);
                ucEditPerson.Person = getPersonByIdResponse.Person;
                ucEditPerson.IsNew = false;
                ucEditPerson.Person = getPersonByIdResponse.Person;
                IsNew = false;
            }
        }

        public FormProfile()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (Save())
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        public bool Save()
        {
            if (ucEditPerson.ValidateInformation())
            {
                long personId = -1;
                bool result = ucEditPerson.Save(ref personId);
                if (!result)
                {
                    return false;
                }
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
