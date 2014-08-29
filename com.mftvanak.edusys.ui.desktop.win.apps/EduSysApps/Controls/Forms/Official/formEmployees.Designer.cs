using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Official
{
    partial class FormEmployees
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
            this.ucEmployees = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official.UcEmployees();
            this.SuspendLayout();
            // 
            // ucEmployees
            // 
            this.ucEmployees.BackColor = System.Drawing.Color.Transparent;
            this.ucEmployees.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEmployees.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEmployees.Location = new System.Drawing.Point(0, 0);
            this.ucEmployees.Name = "ucEmployees";
            this.ucEmployees.Size = new System.Drawing.Size(691, 377);
            this.ucEmployees.TabIndex = 0;
            // 
            // formEmployees
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(691, 377);
            this.Controls.Add(this.ucEmployees);
            this.Name = "formEmployees";
            this.Text = "لیست کارمندان";
            this.Load += new System.EventHandler(this.formEmployees_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private UcEmployees ucEmployees;

    }
}