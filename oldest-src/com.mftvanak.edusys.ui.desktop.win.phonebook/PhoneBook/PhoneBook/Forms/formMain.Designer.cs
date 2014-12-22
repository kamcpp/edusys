namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
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
            this.menustrip = new System.Windows.Forms.MenuStrip();
            this.toolstripmenuitemUser = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemLogout = new System.Windows.Forms.ToolStripMenuItem();
            this.listviewPhonesForToday = new System.Windows.Forms.ListView();
            this.columnName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnPhone = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnDepartment = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.toolstrip = new System.Windows.Forms.ToolStrip();
            this.toolstripbuttonNew = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonReports = new System.Windows.Forms.ToolStripButton();
            this.labelPhonesForToday = new System.Windows.Forms.Label();
            this.menustrip.SuspendLayout();
            this.toolstrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // menustrip
            // 
            this.menustrip.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menustrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemUser});
            this.menustrip.Location = new System.Drawing.Point(0, 0);
            this.menustrip.Name = "menustrip";
            this.menustrip.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.menustrip.Size = new System.Drawing.Size(511, 24);
            this.menustrip.TabIndex = 0;
            // 
            // toolstripmenuitemUser
            // 
            this.toolstripmenuitemUser.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemLogout});
            this.toolstripmenuitemUser.Name = "toolstripmenuitemUser";
            this.toolstripmenuitemUser.Size = new System.Drawing.Size(41, 20);
            this.toolstripmenuitemUser.Text = "کاربر";
            // 
            // toolstripmenuitemLogout
            // 
            this.toolstripmenuitemLogout.Name = "toolstripmenuitemLogout";
            this.toolstripmenuitemLogout.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.X)));
            this.toolstripmenuitemLogout.Size = new System.Drawing.Size(182, 22);
            this.toolstripmenuitemLogout.Text = "خروج از برنامه";
            // 
            // listviewPhonesForToday
            // 
            this.listviewPhonesForToday.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnName,
            this.columnPhone,
            this.columnDepartment});
            this.listviewPhonesForToday.FullRowSelect = true;
            this.listviewPhonesForToday.GridLines = true;
            this.listviewPhonesForToday.Location = new System.Drawing.Point(12, 96);
            this.listviewPhonesForToday.MultiSelect = false;
            this.listviewPhonesForToday.Name = "listviewPhonesForToday";
            this.listviewPhonesForToday.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewPhonesForToday.RightToLeftLayout = true;
            this.listviewPhonesForToday.Size = new System.Drawing.Size(487, 249);
            this.listviewPhonesForToday.TabIndex = 1;
            this.listviewPhonesForToday.UseCompatibleStateImageBehavior = false;
            this.listviewPhonesForToday.View = System.Windows.Forms.View.Details;
            // 
            // columnName
            // 
            this.columnName.Text = "نام";
            this.columnName.Width = 100;
            // 
            // columnPhone
            // 
            this.columnPhone.Text = "تلفن";
            this.columnPhone.Width = 100;
            // 
            // columnDepartment
            // 
            this.columnDepartment.Text = "دپارتمان";
            this.columnDepartment.Width = 250;
            // 
            // toolstrip
            // 
            this.toolstrip.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolstrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripbuttonNew,
            this.toolstripbuttonReports});
            this.toolstrip.Location = new System.Drawing.Point(0, 24);
            this.toolstrip.Name = "toolstrip";
            this.toolstrip.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.toolstrip.Size = new System.Drawing.Size(511, 39);
            this.toolstrip.TabIndex = 2;
            this.toolstrip.Text = "toolstrip";
            // 
            // toolstripbuttonNew
            // 
            this.toolstripbuttonNew.Image = global::Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Properties.Resources.cell;
            this.toolstripbuttonNew.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolstripbuttonNew.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonNew.Name = "toolstripbuttonNew";
            this.toolstripbuttonNew.Size = new System.Drawing.Size(68, 36);
            this.toolstripbuttonNew.Text = "جدید";
            this.toolstripbuttonNew.Click += new System.EventHandler(this.toolstripbuttonNew_Click);
            // 
            // toolstripbuttonReports
            // 
            this.toolstripbuttonReports.Image = global::Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Properties.Resources.list;
            this.toolstripbuttonReports.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolstripbuttonReports.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonReports.Name = "toolstripbuttonReports";
            this.toolstripbuttonReports.Size = new System.Drawing.Size(76, 36);
            this.toolstripbuttonReports.Text = "گزارش";
            this.toolstripbuttonReports.Click += new System.EventHandler(this.toolstripbuttonReports_Click);
            // 
            // labelPhonesForToday
            // 
            this.labelPhonesForToday.AutoSize = true;
            this.labelPhonesForToday.Location = new System.Drawing.Point(421, 77);
            this.labelPhonesForToday.Name = "labelPhonesForToday";
            this.labelPhonesForToday.Size = new System.Drawing.Size(78, 13);
            this.labelPhonesForToday.TabIndex = 3;
            this.labelPhonesForToday.Text = "تلفن های امروز";
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(511, 352);
            this.Controls.Add(this.labelPhonesForToday);
            this.Controls.Add(this.toolstrip);
            this.Controls.Add(this.listviewPhonesForToday);
            this.Controls.Add(this.menustrip);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MainMenuStrip = this.menustrip;
            this.MaximizeBox = false;
            this.Name = "formMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "دفترچه تلفن - نسخه {0}";
            this.Load += new System.EventHandler(this.formMain_Load);
            this.menustrip.ResumeLayout(false);
            this.menustrip.PerformLayout();
            this.toolstrip.ResumeLayout(false);
            this.toolstrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menustrip;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemUser;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemLogout;
        private System.Windows.Forms.ListView listviewPhonesForToday;
        private System.Windows.Forms.ToolStrip toolstrip;
        private System.Windows.Forms.ToolStripButton toolstripbuttonNew;
        private System.Windows.Forms.Label labelPhonesForToday;
        private System.Windows.Forms.ColumnHeader columnName;
        private System.Windows.Forms.ColumnHeader columnPhone;
        private System.Windows.Forms.ColumnHeader columnDepartment;
        private System.Windows.Forms.ToolStripButton toolstripbuttonReports;
    }
}