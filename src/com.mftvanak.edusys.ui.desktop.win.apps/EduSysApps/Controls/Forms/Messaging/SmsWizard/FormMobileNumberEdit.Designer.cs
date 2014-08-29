namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    partial class FormMobileNumberEdit
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
            this.textboxMobileNumber = new System.Windows.Forms.TextBox();
            this.labelMobileNumber = new System.Windows.Forms.Label();
            this.buttonSave = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textboxMobileNumber
            // 
            this.textboxMobileNumber.Location = new System.Drawing.Point(12, 9);
            this.textboxMobileNumber.Name = "textboxMobileNumber";
            this.textboxMobileNumber.Size = new System.Drawing.Size(157, 21);
            this.textboxMobileNumber.TabIndex = 0;
            // 
            // labelMobileNumber
            // 
            this.labelMobileNumber.AutoSize = true;
            this.labelMobileNumber.Location = new System.Drawing.Point(175, 12);
            this.labelMobileNumber.Name = "labelMobileNumber";
            this.labelMobileNumber.Size = new System.Drawing.Size(68, 13);
            this.labelMobileNumber.TabIndex = 1;
            this.labelMobileNumber.Text = "شماره موبایل";
            // 
            // buttonSave
            // 
            this.buttonSave.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonSave.Location = new System.Drawing.Point(249, 7);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(75, 23);
            this.buttonSave.TabIndex = 2;
            this.buttonSave.Text = "تایید";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // FormMobileNumberEdit
            // 
            this.AcceptButton = this.buttonSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(335, 42);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.labelMobileNumber);
            this.Controls.Add(this.textboxMobileNumber);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FormMobileNumberEdit";
            this.Text = "ویرایش شماره موبایل";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textboxMobileNumber;
        private System.Windows.Forms.Label labelMobileNumber;
        private System.Windows.Forms.Button buttonSave;
    }
}