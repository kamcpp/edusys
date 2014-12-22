using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    partial class FormInstitutes
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
            this.ucInstitutes = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcInstitutes();
            this.SuspendLayout();
            // 
            // ucInstitutes
            // 
            this.ucInstitutes.BackColor = System.Drawing.Color.Transparent;
            this.ucInstitutes.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucInstitutes.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucInstitutes.Location = new System.Drawing.Point(0, 0);
            this.ucInstitutes.Name = "ucInstitutes";
            this.ucInstitutes.Size = new System.Drawing.Size(581, 262);
            this.ucInstitutes.TabIndex = 0;
            // 
            // formInstitutes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(581, 262);
            this.Controls.Add(this.ucInstitutes);
            this.Name = "formInstitutes";
            this.Text = "مدیریت موسسات";
            this.Load += new System.EventHandler(this.formInstitutes_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Education.UcInstitutes ucInstitutes;

    }
}