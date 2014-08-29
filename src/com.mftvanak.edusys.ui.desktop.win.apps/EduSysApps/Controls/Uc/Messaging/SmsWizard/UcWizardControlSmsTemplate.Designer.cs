namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcWizardControlSmsTemplate
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelText = new System.Windows.Forms.Label();
            this.buttonSaveSmsMessageTemplate = new System.Windows.Forms.Button();
            this.buttonSelectSmsMessageTemplate = new System.Windows.Forms.Button();
            this.ucSmsTextEditor = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcSmsTextEditor();
            this.SuspendLayout();
            // 
            // labelText
            // 
            this.labelText.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelText.AutoSize = true;
            this.labelText.Location = new System.Drawing.Point(443, 19);
            this.labelText.Name = "labelText";
            this.labelText.Size = new System.Drawing.Size(55, 13);
            this.labelText.TabIndex = 0;
            this.labelText.Text = "متن پیامک";
            // 
            // buttonSaveSmsMessageTemplate
            // 
            this.buttonSaveSmsMessageTemplate.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonSaveSmsMessageTemplate.Location = new System.Drawing.Point(96, 9);
            this.buttonSaveSmsMessageTemplate.Name = "buttonSaveSmsMessageTemplate";
            this.buttonSaveSmsMessageTemplate.Size = new System.Drawing.Size(150, 23);
            this.buttonSaveSmsMessageTemplate.TabIndex = 4;
            this.buttonSaveSmsMessageTemplate.Text = "ذخیره متن به عنوان قالب";
            this.buttonSaveSmsMessageTemplate.UseVisualStyleBackColor = true;
            this.buttonSaveSmsMessageTemplate.Click += new System.EventHandler(this.buttonSaveSmsMessageTemplate_Click);
            // 
            // buttonSelectSmsMessageTemplate
            // 
            this.buttonSelectSmsMessageTemplate.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonSelectSmsMessageTemplate.Location = new System.Drawing.Point(3, 9);
            this.buttonSelectSmsMessageTemplate.Name = "buttonSelectSmsMessageTemplate";
            this.buttonSelectSmsMessageTemplate.Size = new System.Drawing.Size(87, 23);
            this.buttonSelectSmsMessageTemplate.TabIndex = 5;
            this.buttonSelectSmsMessageTemplate.Text = "انتخاب قالب";
            this.buttonSelectSmsMessageTemplate.UseVisualStyleBackColor = true;
            this.buttonSelectSmsMessageTemplate.Click += new System.EventHandler(this.buttonSelectSmsMessageTemplate_Click);
            // 
            // ucSmsTextEditor
            // 
            this.ucSmsTextEditor.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucSmsTextEditor.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucSmsTextEditor.Location = new System.Drawing.Point(0, 35);
            this.ucSmsTextEditor.Name = "ucSmsTextEditor";
            this.ucSmsTextEditor.Size = new System.Drawing.Size(504, 182);
            this.ucSmsTextEditor.SmsText = "";
            this.ucSmsTextEditor.TabIndex = 6;
            // 
            // UcSmsTemplate
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.ucSmsTextEditor);
            this.Controls.Add(this.buttonSelectSmsMessageTemplate);
            this.Controls.Add(this.buttonSaveSmsMessageTemplate);
            this.Controls.Add(this.labelText);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcSmsTemplate";
            this.Size = new System.Drawing.Size(504, 217);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelText;
        private System.Windows.Forms.Button buttonSaveSmsMessageTemplate;
        private System.Windows.Forms.Button buttonSelectSmsMessageTemplate;
        private UcSmsTextEditor ucSmsTextEditor;
    }
}
