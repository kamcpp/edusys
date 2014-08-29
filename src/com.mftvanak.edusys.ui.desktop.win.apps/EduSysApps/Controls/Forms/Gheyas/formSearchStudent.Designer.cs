namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    partial class FormSearchStudent
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
            this.ucSearchStudent = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas.UcSearchStudent();
            this.SuspendLayout();
            // 
            // ucSearchStudent
            // 
            this.ucSearchStudent.BackColor = System.Drawing.Color.Transparent;
            this.ucSearchStudent.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucSearchStudent.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucSearchStudent.Location = new System.Drawing.Point(0, 0);
            this.ucSearchStudent.Name = "ucSearchStudent";
            this.ucSearchStudent.Size = new System.Drawing.Size(786, 352);
            this.ucSearchStudent.TabIndex = 0;
            // 
            // formSearchStudent
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(786, 352);
            this.Controls.Add(this.ucSearchStudent);
            this.KeyPreview = true;
            this.Name = "formSearchStudent";
            this.Text = "جست و جوی دانشجو";
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.formSearchStudent_KeyUp);
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Gheyas.UcSearchStudent ucSearchStudent;
    }
}