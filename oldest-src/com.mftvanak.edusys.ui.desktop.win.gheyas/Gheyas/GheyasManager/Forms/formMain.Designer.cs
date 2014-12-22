namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
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
            this.toolstripmenuitemGheyas = new System.Windows.Forms.ToolStripMenuItem();
            this.toolstripmenuitemListOfClasses = new System.Windows.Forms.ToolStripMenuItem();
            this.groupboxSearch = new System.Windows.Forms.GroupBox();
            this.buttonSearch = new System.Windows.Forms.Button();
            this.textboxFamily = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textboxName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.listviewStudents = new System.Windows.Forms.ListView();
            this.columnheaderRow = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderCode = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderFamily = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderPhone = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderEmergencyPhone = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderEmail = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderBirthDate = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderPaid = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderPayment = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderPaymentDate = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderPaymentDiscount = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderAddress = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderDescription = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.menustripMain.SuspendLayout();
            this.groupboxSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // menustripMain
            // 
            this.menustripMain.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menustripMain.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemFile,
            this.toolstripmenuitemGheyas});
            this.menustripMain.Location = new System.Drawing.Point(0, 0);
            this.menustripMain.Name = "menustripMain";
            this.menustripMain.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.menustripMain.Size = new System.Drawing.Size(821, 24);
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
            // toolstripmenuitemGheyas
            // 
            this.toolstripmenuitemGheyas.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripmenuitemListOfClasses});
            this.toolstripmenuitemGheyas.Name = "toolstripmenuitemGheyas";
            this.toolstripmenuitemGheyas.Size = new System.Drawing.Size(63, 20);
            this.toolstripmenuitemGheyas.Text = "گزارشات";
            // 
            // toolstripmenuitemListOfClasses
            // 
            this.toolstripmenuitemListOfClasses.Name = "toolstripmenuitemListOfClasses";
            this.toolstripmenuitemListOfClasses.Size = new System.Drawing.Size(155, 22);
            this.toolstripmenuitemListOfClasses.Text = "لیست کلاس ها";
            this.toolstripmenuitemListOfClasses.Click += new System.EventHandler(this.toolstripmenuitemListOfClasses_Click);
            // 
            // groupboxSearch
            // 
            this.groupboxSearch.Controls.Add(this.buttonSearch);
            this.groupboxSearch.Controls.Add(this.textboxFamily);
            this.groupboxSearch.Controls.Add(this.label2);
            this.groupboxSearch.Controls.Add(this.textboxName);
            this.groupboxSearch.Controls.Add(this.label1);
            this.groupboxSearch.Location = new System.Drawing.Point(12, 27);
            this.groupboxSearch.Name = "groupboxSearch";
            this.groupboxSearch.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.groupboxSearch.Size = new System.Drawing.Size(797, 59);
            this.groupboxSearch.TabIndex = 1;
            this.groupboxSearch.TabStop = false;
            this.groupboxSearch.Text = "جست و جوی دانشجو";
            // 
            // buttonSearch
            // 
            this.buttonSearch.Location = new System.Drawing.Point(263, 24);
            this.buttonSearch.Name = "buttonSearch";
            this.buttonSearch.Size = new System.Drawing.Size(111, 23);
            this.buttonSearch.TabIndex = 4;
            this.buttonSearch.Text = "جست و جو";
            this.buttonSearch.UseVisualStyleBackColor = true;
            this.buttonSearch.Click += new System.EventHandler(this.buttonSearch_Click);
            // 
            // textboxFamily
            // 
            this.textboxFamily.Location = new System.Drawing.Point(380, 26);
            this.textboxFamily.Name = "textboxFamily";
            this.textboxFamily.Size = new System.Drawing.Size(150, 21);
            this.textboxFamily.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(536, 29);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "نام خانوادگی";
            // 
            // textboxName
            // 
            this.textboxName.Location = new System.Drawing.Point(607, 26);
            this.textboxName.Name = "textboxName";
            this.textboxName.Size = new System.Drawing.Size(150, 21);
            this.textboxName.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(763, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(23, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "نام ";
            // 
            // listviewStudents
            // 
            this.listviewStudents.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnheaderRow,
            this.columnheaderCode,
            this.columnheaderName,
            this.columnheaderFamily,
            this.columnheaderPhone,
            this.columnheaderEmergencyPhone,
            this.columnheaderEmail,
            this.columnheaderBirthDate,
            this.columnheaderPaid,
            this.columnheaderPayment,
            this.columnheaderPaymentDate,
            this.columnheaderPaymentDiscount,
            this.columnheaderAddress,
            this.columnheaderDescription});
            this.listviewStudents.FullRowSelect = true;
            this.listviewStudents.GridLines = true;
            this.listviewStudents.Location = new System.Drawing.Point(12, 92);
            this.listviewStudents.Name = "listviewStudents";
            this.listviewStudents.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewStudents.RightToLeftLayout = true;
            this.listviewStudents.Size = new System.Drawing.Size(797, 304);
            this.listviewStudents.TabIndex = 2;
            this.listviewStudents.UseCompatibleStateImageBehavior = false;
            this.listviewStudents.View = System.Windows.Forms.View.Details;
            // 
            // columnheaderRow
            // 
            this.columnheaderRow.Text = "ردیف";
            // 
            // columnheaderCode
            // 
            this.columnheaderCode.Text = "کد";
            // 
            // columnheaderName
            // 
            this.columnheaderName.Text = "نام";
            this.columnheaderName.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderName.Width = 120;
            // 
            // columnheaderFamily
            // 
            this.columnheaderFamily.Text = "نام خانوادگی";
            this.columnheaderFamily.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderFamily.Width = 120;
            // 
            // columnheaderPhone
            // 
            this.columnheaderPhone.Text = "شماره تلفن";
            this.columnheaderPhone.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderPhone.Width = 120;
            // 
            // columnheaderEmergencyPhone
            // 
            this.columnheaderEmergencyPhone.Text = "شماره تلفن 2";
            this.columnheaderEmergencyPhone.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderEmergencyPhone.Width = 120;
            // 
            // columnheaderEmail
            // 
            this.columnheaderEmail.Text = "ایمیل";
            this.columnheaderEmail.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderEmail.Width = 150;
            // 
            // columnheaderBirthDate
            // 
            this.columnheaderBirthDate.Text = "تاریخ تولد";
            this.columnheaderBirthDate.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderBirthDate.Width = 100;
            // 
            // columnheaderPaid
            // 
            this.columnheaderPaid.Text = "پرداخت شده";
            this.columnheaderPaid.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderPaid.Width = 120;
            // 
            // columnheaderPayment
            // 
            this.columnheaderPayment.Text = "شهریه";
            this.columnheaderPayment.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderPayment.Width = 120;
            // 
            // columnheaderPaymentDate
            // 
            this.columnheaderPaymentDate.Text = "تاریخ پرداخت";
            this.columnheaderPaymentDate.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderPaymentDate.Width = 120;
            // 
            // columnheaderPaymentDiscount
            // 
            this.columnheaderPaymentDiscount.Text = "تخفیف";
            this.columnheaderPaymentDiscount.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderPaymentDiscount.Width = 120;
            // 
            // columnheaderAddress
            // 
            this.columnheaderAddress.Text = "آدرس";
            this.columnheaderAddress.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderAddress.Width = 200;
            // 
            // columnheaderDescription
            // 
            this.columnheaderDescription.Text = "توضیحات";
            this.columnheaderDescription.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.columnheaderDescription.Width = 200;
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(821, 408);
            this.Controls.Add(this.listviewStudents);
            this.Controls.Add(this.groupboxSearch);
            this.Controls.Add(this.menustripMain);
            this.MainMenuStrip = this.menustripMain;
            this.Name = "formMain";
            this.Text = "برنامه گزارش آموزشی";
            this.Load += new System.EventHandler(this.formMain_Load);
            this.menustripMain.ResumeLayout(false);
            this.menustripMain.PerformLayout();
            this.groupboxSearch.ResumeLayout(false);
            this.groupboxSearch.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menustripMain;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemFile;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemClose;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemGheyas;
        private System.Windows.Forms.ToolStripMenuItem toolstripmenuitemListOfClasses;
        private System.Windows.Forms.GroupBox groupboxSearch;
        private System.Windows.Forms.Button buttonSearch;
        private System.Windows.Forms.TextBox textboxFamily;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textboxName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListView listviewStudents;
        private System.Windows.Forms.ColumnHeader columnheaderRow;
        private System.Windows.Forms.ColumnHeader columnheaderCode;
        private System.Windows.Forms.ColumnHeader columnheaderName;
        private System.Windows.Forms.ColumnHeader columnheaderFamily;
        private System.Windows.Forms.ColumnHeader columnheaderPhone;
        private System.Windows.Forms.ColumnHeader columnheaderEmergencyPhone;
        private System.Windows.Forms.ColumnHeader columnheaderEmail;
        private System.Windows.Forms.ColumnHeader columnheaderBirthDate;
        private System.Windows.Forms.ColumnHeader columnheaderPaid;
        private System.Windows.Forms.ColumnHeader columnheaderPayment;
        private System.Windows.Forms.ColumnHeader columnheaderPaymentDate;
        private System.Windows.Forms.ColumnHeader columnheaderPaymentDiscount;
        private System.Windows.Forms.ColumnHeader columnheaderAddress;
        private System.Windows.Forms.ColumnHeader columnheaderDescription;
    }
}