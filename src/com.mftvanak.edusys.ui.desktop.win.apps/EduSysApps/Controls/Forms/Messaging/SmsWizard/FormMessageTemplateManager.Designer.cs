namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    partial class FormMessageTemplateManager
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.ucMessageTemplateExplorer = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcMessageTemplateExplorer();
            this.SuspendLayout();
            // 
            // ucMessageTemplateExplorer
            // 
            this.ucMessageTemplateExplorer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucMessageTemplateExplorer.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucMessageTemplateExplorer.Location = new System.Drawing.Point(0, 0);
            this.ucMessageTemplateExplorer.MessageTemplateType = Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.MessageTemplateTypeEnum.Sms;
            this.ucMessageTemplateExplorer.Name = "ucMessageTemplateExplorer";
            this.ucMessageTemplateExplorer.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucMessageTemplateExplorer.Size = new System.Drawing.Size(715, 419);
            this.ucMessageTemplateExplorer.TabIndex = 1;
            // 
            // FormMessageTemplateManager
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(715, 419);
            this.Controls.Add(this.ucMessageTemplateExplorer);
            this.Name = "FormMessageTemplateManager";
            this.Text = "مدیریت قالب ها";
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Messaging.SmsWizard.UcMessageTemplateExplorer ucMessageTemplateExplorer;
    }
}