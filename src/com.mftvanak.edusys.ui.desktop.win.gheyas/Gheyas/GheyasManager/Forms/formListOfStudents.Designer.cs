namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
{
    partial class formListOfStudents
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
            this.buttonRefreshStudents = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listviewStudents
            // 
            this.listviewStudents.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
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
            this.listviewStudents.Location = new System.Drawing.Point(12, 36);
            this.listviewStudents.Name = "listviewStudents";
            this.listviewStudents.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewStudents.RightToLeftLayout = true;
            this.listviewStudents.Size = new System.Drawing.Size(904, 333);
            this.listviewStudents.TabIndex = 0;
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
            // buttonRefreshStudents
            // 
            this.buttonRefreshStudents.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefreshStudents.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Properties.Resources.view_refresh;
            this.buttonRefreshStudents.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonRefreshStudents.Location = new System.Drawing.Point(796, 5);
            this.buttonRefreshStudents.Name = "buttonRefreshStudents";
            this.buttonRefreshStudents.Size = new System.Drawing.Size(120, 25);
            this.buttonRefreshStudents.TabIndex = 8;
            this.buttonRefreshStudents.Text = "بازآوری دوباره";
            this.buttonRefreshStudents.UseVisualStyleBackColor = true;
            this.buttonRefreshStudents.Click += new System.EventHandler(this.buttonRefreshStudents_Click);
            // 
            // formListOfStudents
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(928, 381);
            this.Controls.Add(this.buttonRefreshStudents);
            this.Controls.Add(this.listviewStudents);
            this.Name = "formListOfStudents";
            this.Text = "لیست دانشجویان";
            this.Load += new System.EventHandler(this.formListOfStudents_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView listviewStudents;
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
        private System.Windows.Forms.ColumnHeader columnheaderRow;
        private System.Windows.Forms.Button buttonRefreshStudents;
    }
}