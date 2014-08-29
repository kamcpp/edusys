using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard
{
    public interface IWizardStep
    {
        bool IsInitialStep { get; }

        bool IsFinalStep { get; }

        Control StepControl { get; }

        bool ValidateStep();
    }
}
