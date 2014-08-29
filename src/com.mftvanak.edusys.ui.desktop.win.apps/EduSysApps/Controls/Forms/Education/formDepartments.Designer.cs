namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    partial class FormDepartments
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
            this.ucDepartments = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcDepartments();
            this.SuspendLayout();
            // 
            // ucDepartments
            // 
            this.ucDepartments.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucDepartments.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucDepartments.Institute = null;
            this.ucDepartments.Location = new System.Drawing.Point(0, 0);
            this.ucDepartments.Name = "ucDepartments";
            this.ucDepartments.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucDepartments.Size = new System.Drawing.Size(921, 388);
            this.ucDepartments.TabIndex = 0;
            // 
            // formDepartments
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(921, 388);
            this.Controls.Add(this.ucDepartments);
            this.Name = "formDepartments";
            this.Text = "لیست دپارتمان ها";
            this.Load += new System.EventHandler(this.formDepartments_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Education.UcDepartments ucDepartments;
    }
}