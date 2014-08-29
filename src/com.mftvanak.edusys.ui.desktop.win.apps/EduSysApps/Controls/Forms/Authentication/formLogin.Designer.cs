using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Authentication
{
    partial class FormLogin
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
            this.ucLogin = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcLogin();
            this.SuspendLayout();
            // 
            // ucLogin
            // 
            this.ucLogin.BackColor = System.Drawing.Color.Transparent;
            this.ucLogin.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucLogin.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucLogin.Location = new System.Drawing.Point(0, 0);
            this.ucLogin.Name = "ucLogin";
            this.ucLogin.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucLogin.Size = new System.Drawing.Size(317, 105);
            this.ucLogin.TabIndex = 0;
            this.ucLogin.Username = "";
            this.ucLogin.Authenticated += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcLogin.AuthenticatedEventHandler(this.ucLogin_Authenticated);
            this.ucLogin.Canceled += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcLogin.CanceledEventHandler(this.ucLogin_Canceled);
            this.ucLogin.ExceptionOccurred += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Authentication.UcLogin.ExceptionOccurredEventHandler(this.ucLogin_ExceptionOccurred);
            // 
            // FormLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(317, 105);
            this.ControlBox = false;
            this.Controls.Add(this.ucLogin);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.KeyPreview = true;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FormLogin";
            this.Text = "ورود";
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.formLogin_KeyUp);
            this.ResumeLayout(false);

        }

        #endregion

        private UcLogin ucLogin;

    }
}