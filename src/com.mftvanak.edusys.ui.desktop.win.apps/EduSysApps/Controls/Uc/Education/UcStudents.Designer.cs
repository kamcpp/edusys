namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcStudents
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
            this.components = new System.ComponentModel.Container();
            this.contextmenustripStudent = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.toolstripmenuitemEditDaneshgahField = new System.Windows.Forms.ToolStripMenuItem();
            this.ucedusysdatagridviewStudnets = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcEduSysDataGridView();
            this.contextmenustripStudent.SuspendLayout();
            this.SuspendLayout();
            // 
            // contextmenustripStudent
            // 
            this.contextmenustripStudent.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.contextmenustripStudent.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemEditDaneshgahField});
            this.contextmenustripStudent.Name = "contextmenustripStudent";
            this.contextmenustripStudent.Size = new System.Drawing.Size(179, 48);
            this.contextmenustripStudent.Opening += new System.ComponentModel.CancelEventHandler(this.contextmenustripStudent_Opening);
            // 
            // toolstripmenuitemEditDaneshgahField
            // 
            this.toolstripmenuitemEditDaneshgahField.Name = "toolstripmenuitemEditDaneshgahField";
            this.toolstripmenuitemEditDaneshgahField.Size = new System.Drawing.Size(178, 22);
            this.toolstripmenuitemEditDaneshgahField.Text = "ویرایش فیلد دانشگاه";
            this.toolstripmenuitemEditDaneshgahField.Click += new System.EventHandler(this.toolstripmenuitemEditDaneshgahField_Click);
            // 
            // ucedusysdatagridviewStudnets
            // 
            this.ucedusysdatagridviewStudnets.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucedusysdatagridviewStudnets.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucedusysdatagridviewStudnets.Location = new System.Drawing.Point(0, 0);
            this.ucedusysdatagridviewStudnets.Name = "ucedusysdatagridviewStudnets";
            this.ucedusysdatagridviewStudnets.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucedusysdatagridviewStudnets.Size = new System.Drawing.Size(643, 299);
            this.ucedusysdatagridviewStudnets.TabIndex = 0;
            // 
            // UcStudents
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.ucedusysdatagridviewStudnets);
            this.Name = "UcStudents";
            this.Size = new System.Drawing.Size(643, 299);
            this.contextmenustripStudent.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private Common.UcEduSysDataGridView ucedusysdatagridviewStudnets;
        private System.Windows.Forms.ContextMenuStrip contextmenustripStudent;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemEditDaneshgahField;
    }
}
