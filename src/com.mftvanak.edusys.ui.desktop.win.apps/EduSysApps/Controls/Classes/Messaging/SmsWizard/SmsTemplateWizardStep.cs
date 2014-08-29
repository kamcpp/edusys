using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsWizard
{
    public class SmsTemplateWizardStep : IWizardStep
    {
        private UcWizardControlSmsTemplate _control;

        public bool IsInitialStep
        {
            get { return false; }
        }

        public bool IsFinalStep
        {
            get { return false; }
        }

        public System.Windows.Forms.Control StepControl
        {
            get
            {
                if (_control == null)
                {
                    _control = new UcWizardControlSmsTemplate();
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
