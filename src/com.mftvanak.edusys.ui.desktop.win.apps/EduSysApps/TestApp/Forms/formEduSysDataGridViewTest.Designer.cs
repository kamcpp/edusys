namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.TestApp.Forms
{
    partial class formEduSysDataGridViewTest
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
            this.ucEduSysDataGridView1 = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcEduSysDataGridView();
            this.SuspendLayout();
            // 
            // ucEduSysDataGridView1
            // 
            this.ucEduSysDataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEduSysDataGridView1.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEduSysDataGridView1.Location = new System.Drawing.Point(0, 0);
            this.ucEduSysDataGridView1.Name = "ucEduSysDataGridView1";
            this.ucEduSysDataGridView1.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEduSysDataGridView1.Size = new System.Drawing.Size(653, 408);
            this.ucEduSysDataGridView1.TabIndex = 0;
            // 
            // formEduSysDataGridViewTest
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(653, 408);
            this.Controls.Add(this.ucEduSysDataGridView1);
            this.Name = "formEduSysDataGridViewTest";
            this.Text = "formEduSysDataGridViewTest";
            this.Load += new System.EventHandler(this.formEduSysDataGridViewTest_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Controls.Uc.Common.UcEduSysDataGridView ucEduSysDataGridView1;

    }
}