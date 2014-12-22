namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Phonebook.Forms
{
    partial class formMain
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
            this.ucUserInformationStatusBar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.UcUserInformationStatusBar();
            this.ucPhonebookPanel = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcPhonebookPanel();
            this.SuspendLayout();
            // 
            // ucUserInformationStatusBar
            // 
            this.ucUserInformationStatusBar.BackColor = System.Drawing.Color.Transparent;
            this.ucUserInformationStatusBar.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.ucUserInformationStatusBar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucUserInformationStatusBar.Location = new System.Drawing.Point(0, 510);
            this.ucUserInformationStatusBar.Name = "ucUserInformationStatusBar";
            this.ucUserInformationStatusBar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucUserInformationStatusBar.Size = new System.Drawing.Size(1047, 22);
            this.ucUserInformationStatusBar.TabIndex = 0;
            // 
            // ucPhonebookPanel
            // 
            this.ucPhonebookPanel.BackColor = System.Drawing.Color.Transparent;
            this.ucPhonebookPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucPhonebookPanel.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucPhonebookPanel.Location = new System.Drawing.Point(0, 0);
            this.ucPhonebookPanel.Name = "ucPhonebookPanel";
            this.ucPhonebookPanel.Size = new System.Drawing.Size(1047, 510);
            this.ucPhonebookPanel.TabIndex = 1;
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1047, 532);
            this.Controls.Add(this.ucPhonebookPanel);
            this.Controls.Add(this.ucUserInformationStatusBar);
            this.KeyPreview = true;
            this.Name = "formMain";
            this.Text = "Phonebook";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.formMain_FormClosing);
            this.Load += new System.EventHandler(this.formMain_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Controls.Uc.UcUserInformationStatusBar ucUserInformationStatusBar;
        private Controls.Uc.Phonebook.UcPhonebookPanel ucPhonebookPanel;
    }
}