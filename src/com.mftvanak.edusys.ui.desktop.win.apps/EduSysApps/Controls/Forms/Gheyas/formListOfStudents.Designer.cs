namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    partial class FormListOfStudents
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
            this.buttonRefreshStudents = new System.Windows.Forms.Button();
            this.ucStudents = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcStudents();
            this.SuspendLayout();
            // 
            // buttonRefreshStudents
            // 
            this.buttonRefreshStudents.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefreshStudents.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonRefreshStudents.Location = new System.Drawing.Point(970, 5);
            this.buttonRefreshStudents.Name = "buttonRefreshStudents";
            this.buttonRefreshStudents.Size = new System.Drawing.Size(120, 25);
            this.buttonRefreshStudents.TabIndex = 8;
            this.buttonRefreshStudents.Text = "بازآوری دوباره";
            this.buttonRefreshStudents.UseVisualStyleBackColor = true;
            this.buttonRefreshStudents.Click += new System.EventHandler(this.buttonRefreshStudents_Click);
            // 
            // ucStudents
            // 
            this.ucStudents.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucStudents.Location = new System.Drawing.Point(12, 36);
            this.ucStudents.Name = "ucStudents";
            this.ucStudents.Size = new System.Drawing.Size(1078, 440);
            this.ucStudents.Students = null;
            this.ucStudents.TabIndex = 9;
            this.ucStudents.NeedData += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcStudents.NeedDataEventHandler(this.ucStudents_NeedData);
            // 
            // FormListOfStudents
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1102, 488);
            this.Controls.Add(this.ucStudents);
            this.Controls.Add(this.buttonRefreshStudents);
            this.Name = "FormListOfStudents";
            this.Text = "لیست دانشجویان";
            this.Load += new System.EventHandler(this.formListOfStudents_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button buttonRefreshStudents;
        private Uc.Education.UcStudents ucStudents;
    }
}