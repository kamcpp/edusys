namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    partial class FormMessageTemplateExplorer
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
            this.buttonSelect = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // ucMessageTemplateExplorer
            // 
            this.ucMessageTemplateExplorer.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucMessageTemplateExplorer.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucMessageTemplateExplorer.Location = new System.Drawing.Point(0, 0);
            this.ucMessageTemplateExplorer.MessageTemplateType = Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.MessageTemplateTypeEnum.Sms;
            this.ucMessageTemplateExplorer.Name = "ucMessageTemplateExplorer";
            this.ucMessageTemplateExplorer.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucMessageTemplateExplorer.Size = new System.Drawing.Size(714, 399);
            this.ucMessageTemplateExplorer.TabIndex = 0;
            // 
            // buttonSelect
            // 
            this.buttonSelect.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonSelect.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonSelect.Location = new System.Drawing.Point(609, 405);
            this.buttonSelect.Name = "buttonSelect";
            this.buttonSelect.Size = new System.Drawing.Size(100, 23);
            this.buttonSelect.TabIndex = 1;
            this.buttonSelect.Text = "انتخاب قالب";
            this.buttonSelect.UseVisualStyleBackColor = true;
            this.buttonSelect.Click += new System.EventHandler(this.buttonSelect_Click);
            // 
            // FormMessageTemplateExplorer
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(714, 433);
            this.Controls.Add(this.buttonSelect);
            this.Controls.Add(this.ucMessageTemplateExplorer);
            this.Name = "FormMessageTemplateExplorer";
            this.Text = "انتخاب قالب";
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Messaging.SmsWizard.UcMessageTemplateExplorer ucMessageTemplateExplorer;
        private System.Windows.Forms.Button buttonSelect;
    }
}