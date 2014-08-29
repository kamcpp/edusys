namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication
{
    partial class FormChangePassword
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
            this.ucChangePassword = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcChangePassword();
            this.buttonChangePassword = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // ucChangePassword
            // 
            this.ucChangePassword.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucChangePassword.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucChangePassword.Location = new System.Drawing.Point(6, 6);
            this.ucChangePassword.Name = "ucChangePassword";
            this.ucChangePassword.Size = new System.Drawing.Size(379, 82);
            this.ucChangePassword.TabIndex = 0;
            this.ucChangePassword.SuccessfulPasswordChange += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcChangePassword.SuccessfulPasswordChangeEventHandler(this.ucChangePassword_SuccessfulPasswordChange);
            this.ucChangePassword.ExceptionOccurred += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcChangePassword.ExceptionOccurredEventHandler(this.ucChangePassword_ExceptionOccurred);
            // 
            // buttonChangePassword
            // 
            this.buttonChangePassword.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonChangePassword.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonChangePassword.Location = new System.Drawing.Point(265, 94);
            this.buttonChangePassword.Name = "buttonChangePassword";
            this.buttonChangePassword.Size = new System.Drawing.Size(105, 23);
            this.buttonChangePassword.TabIndex = 1;
            this.buttonChangePassword.Text = "تغییر کلمه عبور";
            this.buttonChangePassword.UseVisualStyleBackColor = true;
            this.buttonChangePassword.Click += new System.EventHandler(this.buttonChangePassword_Click);
            // 
            // FormChangePassword
            // 
            this.AcceptButton = this.buttonChangePassword;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(382, 125);
            this.Controls.Add(this.buttonChangePassword);
            this.Controls.Add(this.ucChangePassword);
            this.Name = "FormChangePassword";
            this.Text = "تغییر کلمه عبور";
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Authentication.UcChangePassword ucChangePassword;
        private System.Windows.Forms.Button buttonChangePassword;
    }
}