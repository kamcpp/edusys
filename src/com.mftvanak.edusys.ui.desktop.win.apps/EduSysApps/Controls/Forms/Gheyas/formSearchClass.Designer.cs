namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    partial class FormSearchClass
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
            this.ucSearchClass = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas.UcSearchClass();
            this.SuspendLayout();
            // 
            // ucSearchClass
            // 
            this.ucSearchClass.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucSearchClass.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucSearchClass.Location = new System.Drawing.Point(0, 0);
            this.ucSearchClass.Name = "ucSearchClass";
            this.ucSearchClass.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucSearchClass.Size = new System.Drawing.Size(852, 562);
            this.ucSearchClass.TabIndex = 0;
            // 
            // formSearchClass
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(852, 562);
            this.Controls.Add(this.ucSearchClass);
            this.KeyPreview = true;
            this.Name = "formSearchClass";
            this.Text = "جست و جوی کلاس";
            this.Load += new System.EventHandler(this.formSearchClass_Load);
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.formSearchClass_KeyUp);
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Gheyas.UcSearchClass ucSearchClass;
    }
}