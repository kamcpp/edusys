namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.AdminApp.Forms
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
            this.menustripMain = new System.Windows.Forms.MenuStrip();
            this.toolstripmenuitemFile = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemClose = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemOffical = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstirpmenuitemEmployees = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemEducation = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemInstitutes = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemDepartments = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemMembership = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemUsers = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemRoles = new System.Windows.Forms.ToolStripMenuItem();
            this.ucUserInformationStatusBar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.UcUserInformationStatusBar();
            this.menustripMain.SuspendLayout();
            this.SuspendLayout();
            // 
            // menustripMain
            // 
            this.menustripMain.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menustripMain.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemFile,
            this.toolstripmenuitemEducation,
            this.toolstripmenuitemMembership,
            this.toolstripmenuitemOffical});
            this.menustripMain.Location = new System.Drawing.Point(0, 0);
            this.menustripMain.Name = "menustripMain";
            this.menustripMain.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.menustripMain.Size = new System.Drawing.Size(406, 24);
            this.menustripMain.TabIndex = 0;
            // 
            // toolstripmenuitemFile
            // 
            this.toolstripmenuitemFile.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemClose});
            this.toolstripmenuitemFile.Name = "toolstripmenuitemFile";
            this.toolstripmenuitemFile.Size = new System.Drawing.Size(40, 20);
            this.toolstripmenuitemFile.Text = "فایل";
            // 
            // toolstripmenuitemClose
            // 
            this.toolstripmenuitemClose.Name = "toolstripmenuitemClose";
            this.toolstripmenuitemClose.Size = new System.Drawing.Size(152, 22);
            this.toolstripmenuitemClose.Text = "خروج";
            this.toolstripmenuitemClose.Click += new System.EventHandler(this.toolstripmenuitemClose_Click);
            // 
            // toolstripmenuitemOffical
            // 
            this.toolstripmenuitemOffical.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstirpmenuitemEmployees});
            this.toolstripmenuitemOffical.Name = "toolstripmenuitemOffical";
            this.toolstripmenuitemOffical.Size = new System.Drawing.Size(45, 20);
            this.toolstripmenuitemOffical.Text = "اداری";
            // 
            // toolstirpmenuitemEmployees
            // 
            this.toolstirpmenuitemEmployees.Name = "toolstirpmenuitemEmployees";
            this.toolstirpmenuitemEmployees.Size = new System.Drawing.Size(152, 22);
            this.toolstirpmenuitemEmployees.Text = "لیست کارمندان";
            this.toolstirpmenuitemEmployees.Click += new System.EventHandler(this.toolstirpmenuitemEmployees_Click);
            // 
            // toolstripmenuitemEducation
            // 
            this.toolstripmenuitemEducation.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemInstitutes,
            this.toolstripmenuitemDepartments});
            this.toolstripmenuitemEducation.Name = "toolstripmenuitemEducation";
            this.toolstripmenuitemEducation.Size = new System.Drawing.Size(52, 20);
            this.toolstripmenuitemEducation.Text = "آموزش";
            // 
            // toolstripmenuitemInstitutes
            // 
            this.toolstripmenuitemInstitutes.Name = "toolstripmenuitemInstitutes";
            this.toolstripmenuitemInstitutes.Size = new System.Drawing.Size(164, 22);
            this.toolstripmenuitemInstitutes.Text = "لیست موسسات";
            this.toolstripmenuitemInstitutes.Click += new System.EventHandler(this.toolstripmenuitemInstitutes_Click);
            // 
            // toolstripmenuitemDepartments
            // 
            this.toolstripmenuitemDepartments.Name = "toolstripmenuitemDepartments";
            this.toolstripmenuitemDepartments.Size = new System.Drawing.Size(164, 22);
            this.toolstripmenuitemDepartments.Text = "لیست دپارتمان ها";
            this.toolstripmenuitemDepartments.Click += new System.EventHandler(this.toolstripmenuitemDepartments_Click);
            // 
            // toolstripmenuitemMembership
            // 
            this.toolstripmenuitemMembership.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemUsers,
            this.toolstripmenuitemRoles});
            this.toolstripmenuitemMembership.Name = "toolstripmenuitemMembership";
            this.toolstripmenuitemMembership.Size = new System.Drawing.Size(52, 20);
            this.toolstripmenuitemMembership.Text = "کاربران";
            // 
            // toolstripmenuitemUsers
            // 
            this.toolstripmenuitemUsers.Name = "toolstripmenuitemUsers";
            this.toolstripmenuitemUsers.Size = new System.Drawing.Size(152, 22);
            this.toolstripmenuitemUsers.Text = "لیست کاربران";
            // 
            // toolstripmenuitemRoles
            // 
            this.toolstripmenuitemRoles.Name = "toolstripmenuitemRoles";
            this.toolstripmenuitemRoles.Size = new System.Drawing.Size(152, 22);
            this.toolstripmenuitemRoles.Text = "لیست نقش ها";
            this.toolstripmenuitemRoles.Click += new System.EventHandler(this.toolstripmenuitemRoles_Click);
            // 
            // ucUserInformationStatusBar
            // 
            this.ucUserInformationStatusBar.BackColor = System.Drawing.Color.Transparent;
            this.ucUserInformationStatusBar.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.ucUserInformationStatusBar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucUserInformationStatusBar.Location = new System.Drawing.Point(0, 213);
            this.ucUserInformationStatusBar.Name = "ucUserInformationStatusBar";
            this.ucUserInformationStatusBar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucUserInformationStatusBar.Size = new System.Drawing.Size(406, 22);
            this.ucUserInformationStatusBar.TabIndex = 1;
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(406, 235);
            this.Controls.Add(this.ucUserInformationStatusBar);
            this.Controls.Add(this.menustripMain);
            this.MainMenuStrip = this.menustripMain;
            this.Name = "formMain";
            this.Text = "EduSys Admin";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.formMain_FormClosing);
            this.Load += new System.EventHandler(this.formMain_Load);
            this.menustripMain.ResumeLayout(false);
            this.menustripMain.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menustripMain;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemFile;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemEducation;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemClose;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemInstitutes;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemMembership;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemUsers;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemRoles;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemOffical;
        private System.Windows.Forms.ToolStripMenuItem toolstirpmenuitemEmployees;
        private Controls.Uc.UcUserInformationStatusBar ucUserInformationStatusBar;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemDepartments;
    }
}