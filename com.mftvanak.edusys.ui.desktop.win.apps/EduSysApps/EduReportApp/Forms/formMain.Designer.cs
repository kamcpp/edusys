namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.EduReportApp.Forms
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
            this.toolstripmenuitemSearch = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemSearchClass = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemSearchStudent = new System.Windows.Forms.ToolStripMenuItem();
            this.ucUserInformationStatusBar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.UcUserInformationStatusBar();
            this.menustripMain.SuspendLayout();
            this.SuspendLayout();
            // 
            // menustripMain
            // 
            this.menustripMain.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menustripMain.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemFile,
            this.toolstripmenuitemSearch});
            this.menustripMain.Location = new System.Drawing.Point(0, 0);
            this.menustripMain.Name = "menustripMain";
            this.menustripMain.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.menustripMain.Size = new System.Drawing.Size(644, 24);
            this.menustripMain.TabIndex = 0;
            this.menustripMain.Text = "menuStrip1";
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
            this.toolstripmenuitemClose.Size = new System.Drawing.Size(99, 22);
            this.toolstripmenuitemClose.Text = "خروج";
            this.toolstripmenuitemClose.Click += new System.EventHandler(this.toolstripmenuitemClose_Click);
            // 
            // toolstripmenuitemSearch
            // 
            this.toolstripmenuitemSearch.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemSearchClass,
            this.toolstripmenuitemSearchStudent});
            this.toolstripmenuitemSearch.Name = "toolstripmenuitemSearch";
            this.toolstripmenuitemSearch.Size = new System.Drawing.Size(77, 20);
            this.toolstripmenuitemSearch.Text = "جست و جو";
            // 
            // toolstripmenuitemSearchClass
            // 
            this.toolstripmenuitemSearchClass.Name = "toolstripmenuitemSearchClass";
            this.toolstripmenuitemSearchClass.ShortcutKeys = System.Windows.Forms.Keys.F2;
            this.toolstripmenuitemSearchClass.Size = new System.Drawing.Size(204, 22);
            this.toolstripmenuitemSearchClass.Text = "جست و جوی کلاس";
            this.toolstripmenuitemSearchClass.Click += new System.EventHandler(this.toolstripmenuitemSearchClass_Click);
            // 
            // toolstripmenuitemSearchStudent
            // 
            this.toolstripmenuitemSearchStudent.Name = "toolstripmenuitemSearchStudent";
            this.toolstripmenuitemSearchStudent.ShortcutKeys = System.Windows.Forms.Keys.F3;
            this.toolstripmenuitemSearchStudent.Size = new System.Drawing.Size(204, 22);
            this.toolstripmenuitemSearchStudent.Text = "جست و جوی دانشجو";
            this.toolstripmenuitemSearchStudent.Click += new System.EventHandler(this.toolstripmenuitemSearchStudent_Click);
            // 
            // ucUserInformationStatusBar
            // 
            this.ucUserInformationStatusBar.BackColor = System.Drawing.Color.Transparent;
            this.ucUserInformationStatusBar.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.ucUserInformationStatusBar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucUserInformationStatusBar.Location = new System.Drawing.Point(0, 293);
            this.ucUserInformationStatusBar.Name = "ucUserInformationStatusBar";
            this.ucUserInformationStatusBar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucUserInformationStatusBar.Size = new System.Drawing.Size(644, 22);
            this.ucUserInformationStatusBar.TabIndex = 1;
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(644, 315);
            this.Controls.Add(this.ucUserInformationStatusBar);
            this.Controls.Add(this.menustripMain);
            this.MainMenuStrip = this.menustripMain;
            this.Name = "formMain";
            this.Text = "برنامه گزارش آموزشی";
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
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemClose;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemSearch;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemSearchStudent;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemSearchClass;
        private Controls.Uc.UcUserInformationStatusBar ucUserInformationStatusBar;
    }
}