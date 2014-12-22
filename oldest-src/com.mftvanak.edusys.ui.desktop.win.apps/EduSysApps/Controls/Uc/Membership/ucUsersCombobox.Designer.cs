namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    partial class UcUsersCombobox
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
            this.comboboxUsers = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // comboboxUsers
            // 
            this.comboboxUsers.Dock = System.Windows.Forms.DockStyle.Fill;
            this.comboboxUsers.FormattingEnabled = true;
            this.comboboxUsers.Location = new System.Drawing.Point(0, 0);
            this.comboboxUsers.Name = "comboboxUsers";
            this.comboboxUsers.Size = new System.Drawing.Size(310, 21);
            this.comboboxUsers.TabIndex = 0;
            // 
            // ucUsersCombobox
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.comboboxUsers);
            this.Name = "ucUsersCombobox";
            this.Size = new System.Drawing.Size(310, 22);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ComboBox comboboxUsers;
    }
}
