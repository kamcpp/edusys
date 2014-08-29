namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    partial class UcEditEmployee
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
            this.groupboxEmployeeInformation = new System.Windows.Forms.GroupBox();
            this.textboxEmployeeNumber = new System.Windows.Forms.TextBox();
            this.labelEmployeeNumber = new System.Windows.Forms.Label();
            this.groupboxEmployeeInformation.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupboxEmployeeInformation
            // 
            this.groupboxEmployeeInformation.Controls.Add(this.textboxEmployeeNumber);
            this.groupboxEmployeeInformation.Controls.Add(this.labelEmployeeNumber);
            this.groupboxEmployeeInformation.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupboxEmployeeInformation.Location = new System.Drawing.Point(0, 0);
            this.groupboxEmployeeInformation.Name = "groupboxEmployeeInformation";
            this.groupboxEmployeeInformation.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.groupboxEmployeeInformation.Size = new System.Drawing.Size(399, 198);
            this.groupboxEmployeeInformation.TabIndex = 0;
            this.groupboxEmployeeInformation.TabStop = false;
            this.groupboxEmployeeInformation.Text = "اطلاعات کارمندی";
            // 
            // textboxEmployeeNumber
            // 
            this.textboxEmployeeNumber.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxEmployeeNumber.Location = new System.Drawing.Point(76, 24);
            this.textboxEmployeeNumber.Name = "textboxEmployeeNumber";
            this.textboxEmployeeNumber.Size = new System.Drawing.Size(233, 21);
            this.textboxEmployeeNumber.TabIndex = 0;
            // 
            // labelEmployeeNumber
            // 
            this.labelEmployeeNumber.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelEmployeeNumber.AutoSize = true;
            this.labelEmployeeNumber.Location = new System.Drawing.Point(315, 27);
            this.labelEmployeeNumber.Name = "labelEmployeeNumber";
            this.labelEmployeeNumber.Size = new System.Drawing.Size(78, 13);
            this.labelEmployeeNumber.TabIndex = 0;
            this.labelEmployeeNumber.Text = "شماره کارمندی";
            // 
            // ucEditEmployee
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.groupboxEmployeeInformation);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucEditEmployee";
            this.Size = new System.Drawing.Size(399, 198);
            this.groupboxEmployeeInformation.ResumeLayout(false);
            this.groupboxEmployeeInformation.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupboxEmployeeInformation;
        private System.Windows.Forms.TextBox textboxEmployeeNumber;
        private System.Windows.Forms.Label labelEmployeeNumber;
    }
}
