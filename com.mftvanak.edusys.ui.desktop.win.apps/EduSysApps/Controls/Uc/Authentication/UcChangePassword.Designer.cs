namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication
{
    partial class UcChangePassword
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
            this.labelCurrentPassword = new System.Windows.Forms.Label();
            this.labelNewPassword = new System.Windows.Forms.Label();
            this.labelNewPasswordConfirmation = new System.Windows.Forms.Label();
            this.textboxCurrentPassword = new System.Windows.Forms.TextBox();
            this.textboxNewPassword = new System.Windows.Forms.TextBox();
            this.textboxNewPasswordConfirmation = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // labelCurrentPassword
            // 
            this.labelCurrentPassword.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelCurrentPassword.AutoSize = true;
            this.labelCurrentPassword.Location = new System.Drawing.Point(272, 6);
            this.labelCurrentPassword.Name = "labelCurrentPassword";
            this.labelCurrentPassword.Size = new System.Drawing.Size(81, 13);
            this.labelCurrentPassword.TabIndex = 0;
            this.labelCurrentPassword.Text = "کلمه عبور فعلی";
            // 
            // labelNewPassword
            // 
            this.labelNewPassword.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelNewPassword.AutoSize = true;
            this.labelNewPassword.Location = new System.Drawing.Point(272, 33);
            this.labelNewPassword.Name = "labelNewPassword";
            this.labelNewPassword.Size = new System.Drawing.Size(77, 13);
            this.labelNewPassword.TabIndex = 1;
            this.labelNewPassword.Text = "کلمه عبور جدید";
            // 
            // labelNewPasswordConfirmation
            // 
            this.labelNewPasswordConfirmation.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelNewPasswordConfirmation.AutoSize = true;
            this.labelNewPasswordConfirmation.Location = new System.Drawing.Point(272, 60);
            this.labelNewPasswordConfirmation.Name = "labelNewPasswordConfirmation";
            this.labelNewPasswordConfirmation.Size = new System.Drawing.Size(101, 13);
            this.labelNewPasswordConfirmation.TabIndex = 2;
            this.labelNewPasswordConfirmation.Text = "تکرار کلمه عبور جدید";
            // 
            // textboxCurrentPassword
            // 
            this.textboxCurrentPassword.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxCurrentPassword.Location = new System.Drawing.Point(3, 3);
            this.textboxCurrentPassword.Name = "textboxCurrentPassword";
            this.textboxCurrentPassword.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxCurrentPassword.Size = new System.Drawing.Size(263, 21);
            this.textboxCurrentPassword.TabIndex = 3;
            this.textboxCurrentPassword.UseSystemPasswordChar = true;
            // 
            // textboxNewPassword
            // 
            this.textboxNewPassword.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxNewPassword.Location = new System.Drawing.Point(3, 30);
            this.textboxNewPassword.Name = "textboxNewPassword";
            this.textboxNewPassword.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxNewPassword.Size = new System.Drawing.Size(263, 21);
            this.textboxNewPassword.TabIndex = 4;
            this.textboxNewPassword.UseSystemPasswordChar = true;
            // 
            // textboxNewPasswordConfirmation
            // 
            this.textboxNewPasswordConfirmation.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxNewPasswordConfirmation.Location = new System.Drawing.Point(3, 57);
            this.textboxNewPasswordConfirmation.Name = "textboxNewPasswordConfirmation";
            this.textboxNewPasswordConfirmation.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxNewPasswordConfirmation.Size = new System.Drawing.Size(263, 21);
            this.textboxNewPasswordConfirmation.TabIndex = 5;
            this.textboxNewPasswordConfirmation.UseSystemPasswordChar = true;
            // 
            // UcChangePassword
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.textboxNewPasswordConfirmation);
            this.Controls.Add(this.textboxNewPassword);
            this.Controls.Add(this.textboxCurrentPassword);
            this.Controls.Add(this.labelNewPasswordConfirmation);
            this.Controls.Add(this.labelNewPassword);
            this.Controls.Add(this.labelCurrentPassword);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcChangePassword";
            this.Size = new System.Drawing.Size(379, 82);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelCurrentPassword;
        private System.Windows.Forms.Label labelNewPassword;
        private System.Windows.Forms.Label labelNewPasswordConfirmation;
        private System.Windows.Forms.TextBox textboxCurrentPassword;
        private System.Windows.Forms.TextBox textboxNewPassword;
        private System.Windows.Forms.TextBox textboxNewPasswordConfirmation;
    }
}
