using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.GheyasWebReference;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    public partial class FormEditDaneshgahField : FormBase
    {
        public string CodeKaramuz
        {
            get { return labelCodeKaramuzValue.Text; }
            set { labelCodeKaramuzValue.Text = value; }
        }

        public string FullName
        {
            get { return labelFullNameValue.Text; }
            set { labelFullNameValue.Text = value; }
        }

        public string DaneshgahField
        {
            get { return textboxDaneshgahField.Text; }
            set { textboxDaneshgahField.Text = value; }
        }

        public FormEditDaneshgahField()
        {
            InitializeComponent();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            try
            {
                GheyasService service = new GheyasService();
                UpdateStudentDaneshgahFieldRequest request = new UpdateStudentDaneshgahFieldRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = (int)GeneralSettings.InstituteIds[0];
                request.KaramuzCode = CodeKaramuz;
                request.DaneshaghFieldNewValue = textboxDaneshgahField.Text;
                service.UpdateStudentDaneshgahField(request);
                DialogResult = System.Windows.Forms.DialogResult.OK;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
