using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Membership
{
    partial class FormRoles
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
            this.ucRoles = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership.UcRoles();
            this.SuspendLayout();
            // 
            // ucRoles
            // 
            this.ucRoles.BackColor = System.Drawing.Color.Transparent;
            this.ucRoles.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucRoles.Location = new System.Drawing.Point(0, -1);
            this.ucRoles.Name = "ucRoles";
            this.ucRoles.Size = new System.Drawing.Size(552, 318);
            this.ucRoles.TabIndex = 0;
            // 
            // formRoles
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(552, 317);
            this.Controls.Add(this.ucRoles);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "formRoles";
            this.Text = "لیست نقش ها";
            this.Load += new System.EventHandler(this.formRoles_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private UcRoles ucRoles;
    }
}