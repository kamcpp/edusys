namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication
{
    partial class UcLogin
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
            this.textboxUsername = new System.Windows.Forms.TextBox();
            this.textboxPassword = new System.Windows.Forms.TextBox();
            this.labelUsername = new System.Windows.Forms.Label();
            this.labelPassword = new System.Windows.Forms.Label();
            this.buttonLogin = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.statusbar = new System.Windows.Forms.StatusStrip();
            this.toolstripstatuslabelStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.pictureboxLoading = new System.Windows.Forms.PictureBox();
            this.statusbar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureboxLoading)).BeginInit();
            this.SuspendLayout();
            // 
            // textboxUsername
            // 
            this.textboxUsername.Location = new System.Drawing.Point(3, 3);
            this.textboxUsername.Name = "textboxUsername";
            this.textboxUsername.Size = new System.Drawing.Size(248, 21);
            this.textboxUsername.TabIndex = 0;
            this.textboxUsername.Enter += new System.EventHandler(this.textboxUsername_Enter);
            // 
            // textboxPassword
            // 
            this.textboxPassword.Location = new System.Drawing.Point(3, 29);
            this.textboxPassword.Name = "textboxPassword";
            this.textboxPassword.Size = new System.Drawing.Size(248, 21);
            this.textboxPassword.TabIndex = 1;
            this.textboxPassword.UseSystemPasswordChar = true;
            this.textboxPassword.Enter += new System.EventHandler(this.textboxPassword_Enter);
            // 
            // labelUsername
            // 
            this.labelUsername.AutoSize = true;
            this.labelUsername.Location = new System.Drawing.Point(257, 6);
            this.labelUsername.Name = "labelUsername";
            this.labelUsername.Size = new System.Drawing.Size(53, 13);
            this.labelUsername.TabIndex = 2;
            this.labelUsername.Text = "نام کاربری";
            // 
            // labelPassword
            // 
            this.labelPassword.AutoSize = true;
            this.labelPassword.Location = new System.Drawing.Point(257, 32);
            this.labelPassword.Name = "labelPassword";
            this.labelPassword.Size = new System.Drawing.Size(52, 13);
            this.labelPassword.TabIndex = 3;
            this.labelPassword.Text = "کلمه عبور";
            // 
            // buttonLogin
            // 
            this.buttonLogin.Location = new System.Drawing.Point(234, 56);
            this.buttonLogin.Name = "buttonLogin";
            this.buttonLogin.Size = new System.Drawing.Size(75, 23);
            this.buttonLogin.TabIndex = 4;
            this.buttonLogin.Text = "ورود";
            this.buttonLogin.UseVisualStyleBackColor = true;
            this.buttonLogin.Click += new System.EventHandler(this.buttonLogin_Click);
            this.buttonLogin.MouseMove += new System.Windows.Forms.MouseEventHandler(this.buttonLogin_MouseMove);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(3, 56);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 5;
            this.buttonCancel.Text = "لغو";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // statusbar
            // 
            this.statusbar.AutoSize = false;
            this.statusbar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripstatuslabelStatus});
            this.statusbar.Location = new System.Drawing.Point(0, 86);
            this.statusbar.Name = "statusbar";
            this.statusbar.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.statusbar.Size = new System.Drawing.Size(312, 22);
            this.statusbar.TabIndex = 6;
            this.statusbar.Text = "statusStrip1";
            // 
            // toolstripstatuslabelStatus
            // 
            this.toolstripstatuslabelStatus.Name = "toolstripstatuslabelStatus";
            this.toolstripstatuslabelStatus.Size = new System.Drawing.Size(0, 17);
            // 
            // pictureboxLoading
            // 
            this.pictureboxLoading.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.loading1;
            this.pictureboxLoading.Location = new System.Drawing.Point(203, 56);
            this.pictureboxLoading.Name = "pictureboxLoading";
            this.pictureboxLoading.Size = new System.Drawing.Size(23, 23);
            this.pictureboxLoading.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureboxLoading.TabIndex = 7;
            this.pictureboxLoading.TabStop = false;
            this.pictureboxLoading.Visible = false;
            // 
            // UcLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.pictureboxLoading);
            this.Controls.Add(this.statusbar);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonLogin);
            this.Controls.Add(this.labelPassword);
            this.Controls.Add(this.labelUsername);
            this.Controls.Add(this.textboxPassword);
            this.Controls.Add(this.textboxUsername);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcLogin";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(312, 108);
            this.Load += new System.EventHandler(this.ucLogin_Load);
            this.statusbar.ResumeLayout(false);
            this.statusbar.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureboxLoading)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textboxUsername;
        private System.Windows.Forms.TextBox textboxPassword;
        private System.Windows.Forms.Label labelUsername;
        private System.Windows.Forms.Label labelPassword;
        private System.Windows.Forms.Button buttonLogin;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.StatusStrip statusbar;
        private System.Windows.Forms.ToolStripStatusLabel toolstripstatuslabelStatus;
        private System.Windows.Forms.PictureBox pictureboxLoading;
    }
}
