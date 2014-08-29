using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsWizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsSender;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    public partial class FormSmsWizard : FormBase
    {
        private int _index;
        private SendRequestWizardStep _sendRequestWizardStep;
        private MobileNumberListWizardStep _mobileNumberListWizardStep;
        private SmsTemplateWizardStep _smsTemplateWizardStep;
        private SmsSummaryWizardStep _smsSummaryWizardStep;
        private List<IWizardStep> _wizardControls;

        public FormSmsWizard()
        {
            InitializeComponent();

            buttonNext.Enabled = false;
            buttonSend.Enabled = false;
            buttonPrevious.Enabled = false;

            _index = -1;

            _sendRequestWizardStep = new SendRequestWizardStep();
            _mobileNumberListWizardStep = new MobileNumberListWizardStep();
            _smsTemplateWizardStep = new SmsTemplateWizardStep();
            _smsSummaryWizardStep = new SmsSummaryWizardStep();
            (_smsSummaryWizardStep.StepControl as UcWizardControlSmsSummary).UcSendRequest = _sendRequestWizardStep.StepControl as UcWizardControlSendRequest;
            (_smsSummaryWizardStep.StepControl as UcWizardControlSmsSummary).UcMobileNumberList = _mobileNumberListWizardStep.StepControl as UcWizardControlMobileNumberList;
            (_smsSummaryWizardStep.StepControl as UcWizardControlSmsSummary).UcSmsTemplate = _smsTemplateWizardStep.StepControl as UcWizardControlSmsTemplate;

            _wizardControls = new List<IWizardStep>();
            _wizardControls.Add(_sendRequestWizardStep);
            _wizardControls.Add(_mobileNumberListWizardStep);
            _wizardControls.Add(_smsTemplateWizardStep);
            _wizardControls.Add(_smsSummaryWizardStep);
        }

        private void FormSmsWizard_Load(object sender, EventArgs e)
        {
            Next();
        }

        public void AddMobileNumber(string number)
        {
            (_mobileNumberListWizardStep.StepControl as UcWizardControlMobileNumberList).AddMobileNumber(number);
        }

        private void buttonNext_Click(object sender, EventArgs e)
        {
            if (_wizardControls[_index].ValidateStep())
            {
                Next();
                buttonSend.Enabled = _wizardControls[_index].IsFinalStep;
            }
        }

        private void buttonPrevious_Click(object sender, EventArgs e)
        {
            Prev();
            buttonSend.Enabled = _wizardControls[_index].IsFinalStep;
        }

        private void FormSmsWizard_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (MessageBox.Show("آیا اطمینان به خروج دارید؟", "هشدار", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == System.Windows.Forms.DialogResult.No)
            {
                e.Cancel = true;
            }
        }

        private void buttonSend_Click(object sender, EventArgs e)
        {
            UcWizardControlMobileNumberList ucMobileNumberList = _mobileNumberListWizardStep.StepControl as UcWizardControlMobileNumberList;
            string[] tos = new string[ucMobileNumberList.MobileNumbers.Count];
            for (int i = 0; i < tos.Length; i++)
            {
                tos[i] = ucMobileNumberList.MobileNumbers[i].ValidatedNumber;
            }
            UcWizardControlSmsTemplate ucSmsTemplate = _smsTemplateWizardStep.StepControl as UcWizardControlSmsTemplate;
            string body = ucSmsTemplate.SmsText;
            FormSmsSender form = new FormSmsSender();
            form.ucSmsSender.Message = body;
            form.ucSmsSender.Tos = new List<string>(tos);
            form.Start();
            if (form.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }

        private void Next()
        {
            if (_index < _wizardControls.Count)
            {
                if (_index < _wizardControls.Count - 1)
                {
                    _index++;
                }
                panelWizardStep.Controls.Clear();
                _wizardControls[_index].StepControl.Dock = DockStyle.Fill;
                panelWizardStep.Controls.Add(_wizardControls[_index].StepControl);
                if (_wizardControls[_index].StepControl is UcWizardControlSmsSummary)
                {
                    (_wizardControls[_index].StepControl as UcWizardControlSmsSummary).ShowSummary();
                }
                buttonPrevious.Enabled = _index > 0;
                buttonNext.Enabled = true;
                if (_index == _wizardControls.Count - 1)
                {
                    buttonNext.Enabled = false;
                }
            }
        }

        private void Prev()
        {
            if (_index > 0)
            {
                _index--;
                panelWizardStep.Controls.Clear();
                _wizardControls[_index].StepControl.Dock = DockStyle.Fill;
                panelWizardStep.Controls.Add(_wizardControls[_index].StepControl);
                buttonNext.Enabled = _index < _wizardControls.Count - 1;
                buttonPrevious.Enabled = true;
                if (_index == 0)
                {
                    buttonPrevious.Enabled = false;
                }
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}

