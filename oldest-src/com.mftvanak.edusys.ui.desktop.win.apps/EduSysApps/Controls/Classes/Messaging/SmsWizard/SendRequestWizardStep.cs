using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard;
using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsWizard
{
    public class SendRequestWizardStep : IWizardStep
    {
        private UcWizardControlSendRequest _control;

        public bool IsInitialStep
        {
            get { return true; }
        }

        public bool IsFinalStep
        {
            get { return false; }
        }

        public Control StepControl
        {
            get
            {
                if (_control == null)
                {
                    _control = new UcWizardControlSendRequest();
                }
                return _control;
            }
        }

        public bool ValidateStep()
        {
            return _control.ValidateStepControl();
        }
    }
}
