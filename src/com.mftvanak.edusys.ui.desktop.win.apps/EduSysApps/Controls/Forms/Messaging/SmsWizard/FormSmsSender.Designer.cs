namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard
{
    partial class FormSmsSender
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormSmsSender));
            this.ucSmsSender = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcSmsSender();
            this.SuspendLayout();
            // 
            // ucSmsSender
            // 
            this.ucSmsSender.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucSmsSender.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucSmsSender.Location = new System.Drawing.Point(0, 0);
            this.ucSmsSender.Message = null;
            this.ucSmsSender.Name = "ucSmsSender";
            this.ucSmsSender.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucSmsSender.Size = new System.Drawing.Size(489, 301);
            this.ucSmsSender.TabIndex = 0;
            this.ucSmsSender.Tos = ((System.Collections.Generic.List<string>)(resources.GetObject("ucSmsSender.Tos")));
            this.ucSmsSender.SendSuccessful += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcSmsSender.SendSuccessfulEventHandler(this.ucSmsSender_SendSuccessful);
            // 
            // FormSmsSender
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(489, 301);
            this.Controls.Add(this.ucSmsSender);
            this.Name = "FormSmsSender";
            this.Text = "ارسال پیامک";
            this.ResumeLayout(false);

        }

        #endregion

        public Uc.Messaging.SmsWizard.UcSmsSender ucSmsSender;

    }
}