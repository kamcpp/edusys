namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    partial class FormEditSmsMessageTemplate
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
            this.ucEditSmsMessageTemplate = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcEditSmsMessageTemplate();
            this.buttonSave = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // ucEditSmsMessageTemplate
            // 
            this.ucEditSmsMessageTemplate.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucEditSmsMessageTemplate.Description = "";
            this.ucEditSmsMessageTemplate.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEditSmsMessageTemplate.IsNew = false;
            this.ucEditSmsMessageTemplate.Location = new System.Drawing.Point(3, 2);
            this.ucEditSmsMessageTemplate.MessageTemplate = null;
            this.ucEditSmsMessageTemplate.Name = "ucEditSmsMessageTemplate";
            this.ucEditSmsMessageTemplate.Size = new System.Drawing.Size(500, 347);
            this.ucEditSmsMessageTemplate.SmsText = "";
            this.ucEditSmsMessageTemplate.TabIndex = 0;
            this.ucEditSmsMessageTemplate.TemplateName = "";
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(428, 355);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(75, 23);
            this.buttonSave.TabIndex = 1;
            this.buttonSave.Text = "ذخیره";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(3, 355);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 2;
            this.button2.Text = "لغو";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // FormEditSmsMessageTemplate
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(506, 383);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.ucEditSmsMessageTemplate);
            this.Name = "FormEditSmsMessageTemplate";
            this.Text = "ویرایش قالب پیام";
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Messaging.SmsWizard.UcEditSmsMessageTemplate ucEditSmsMessageTemplate;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Button button2;

    }
}