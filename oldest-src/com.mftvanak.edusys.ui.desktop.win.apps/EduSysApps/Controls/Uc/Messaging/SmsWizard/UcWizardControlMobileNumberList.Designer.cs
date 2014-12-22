namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcWizardControlMobileNumberList
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
            this.checkedlistboxNumbers = new System.Windows.Forms.CheckedListBox();
            this.labelTitle = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.buttonAddPhone = new System.Windows.Forms.Button();
            this.buttonAddMyPhones = new System.Windows.Forms.Button();
            this.buttonExportExcel = new System.Windows.Forms.Button();
            this.buttonExportCSV = new System.Windows.Forms.Button();
            this.buttonExportText = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // checkedlistboxNumbers
            // 
            this.checkedlistboxNumbers.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.checkedlistboxNumbers.CheckOnClick = true;
            this.checkedlistboxNumbers.FormattingEnabled = true;
            this.checkedlistboxNumbers.Location = new System.Drawing.Point(9, 38);
            this.checkedlistboxNumbers.MultiColumn = true;
            this.checkedlistboxNumbers.Name = "checkedlistboxNumbers";
            this.checkedlistboxNumbers.ScrollAlwaysVisible = true;
            this.checkedlistboxNumbers.Size = new System.Drawing.Size(434, 244);
            this.checkedlistboxNumbers.TabIndex = 0;
            this.checkedlistboxNumbers.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.checkedlistboxNumbers_ItemCheck);
            this.checkedlistboxNumbers.DoubleClick += new System.EventHandler(this.checkedlistboxNumbers_DoubleClick);
            // 
            // labelTitle
            // 
            this.labelTitle.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelTitle.Location = new System.Drawing.Point(405, 11);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.labelTitle.Size = new System.Drawing.Size(209, 13);
            this.labelTitle.TabIndex = 1;
            this.labelTitle.Text = "شماره های انتخابی";
            this.labelTitle.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.Enabled = false;
            this.button1.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.excel;
            this.button1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.button1.Location = new System.Drawing.Point(449, 102);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(170, 26);
            this.button1.TabIndex = 3;
            this.button1.Text = "وارد کردن فایل اکسل";
            this.button1.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.button1.UseVisualStyleBackColor = true;
            // 
            // buttonAddPhone
            // 
            this.buttonAddPhone.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonAddPhone.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.bullet_toggle_plus;
            this.buttonAddPhone.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonAddPhone.Location = new System.Drawing.Point(449, 38);
            this.buttonAddPhone.Name = "buttonAddPhone";
            this.buttonAddPhone.Size = new System.Drawing.Size(170, 26);
            this.buttonAddPhone.TabIndex = 2;
            this.buttonAddPhone.Text = "اضافه کردن شماره جدید";
            this.buttonAddPhone.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.buttonAddPhone.UseVisualStyleBackColor = true;
            this.buttonAddPhone.Click += new System.EventHandler(this.buttonAddPhone_Click);
            // 
            // buttonAddMyPhones
            // 
            this.buttonAddMyPhones.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonAddMyPhones.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.sms;
            this.buttonAddMyPhones.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonAddMyPhones.Location = new System.Drawing.Point(449, 70);
            this.buttonAddMyPhones.Name = "buttonAddMyPhones";
            this.buttonAddMyPhones.Size = new System.Drawing.Size(170, 26);
            this.buttonAddMyPhones.TabIndex = 4;
            this.buttonAddMyPhones.Text = "اضافه کردن شماره های من";
            this.buttonAddMyPhones.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.buttonAddMyPhones.UseVisualStyleBackColor = true;
            this.buttonAddMyPhones.Click += new System.EventHandler(this.buttonAddMyPhones_Click);
            // 
            // buttonExportExcel
            // 
            this.buttonExportExcel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonExportExcel.Enabled = false;
            this.buttonExportExcel.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonExportExcel.Location = new System.Drawing.Point(449, 198);
            this.buttonExportExcel.Name = "buttonExportExcel";
            this.buttonExportExcel.Size = new System.Drawing.Size(170, 26);
            this.buttonExportExcel.TabIndex = 5;
            this.buttonExportExcel.Text = "خروجی اکسل";
            this.buttonExportExcel.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.buttonExportExcel.UseVisualStyleBackColor = true;
            // 
            // buttonExportCSV
            // 
            this.buttonExportCSV.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonExportCSV.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonExportCSV.Location = new System.Drawing.Point(449, 134);
            this.buttonExportCSV.Name = "buttonExportCSV";
            this.buttonExportCSV.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.buttonExportCSV.Size = new System.Drawing.Size(170, 26);
            this.buttonExportCSV.TabIndex = 6;
            this.buttonExportCSV.Text = "خروجی CSV";
            this.buttonExportCSV.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonExportCSV.UseVisualStyleBackColor = true;
            this.buttonExportCSV.Click += new System.EventHandler(this.buttonExportCSV_Click);
            // 
            // buttonExportText
            // 
            this.buttonExportText.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonExportText.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.buttonExportText.Location = new System.Drawing.Point(449, 166);
            this.buttonExportText.Name = "buttonExportText";
            this.buttonExportText.Size = new System.Drawing.Size(170, 26);
            this.buttonExportText.TabIndex = 7;
            this.buttonExportText.Text = "خروجی متنی";
            this.buttonExportText.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.buttonExportText.UseVisualStyleBackColor = true;
            this.buttonExportText.Click += new System.EventHandler(this.buttonExportText_Click);
            // 
            // UcWizardControlMobileNumberList
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.buttonExportText);
            this.Controls.Add(this.buttonExportCSV);
            this.Controls.Add(this.buttonExportExcel);
            this.Controls.Add(this.buttonAddMyPhones);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.buttonAddPhone);
            this.Controls.Add(this.labelTitle);
            this.Controls.Add(this.checkedlistboxNumbers);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcWizardControlMobileNumberList";
            this.Size = new System.Drawing.Size(624, 286);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.CheckedListBox checkedlistboxNumbers;
        private System.Windows.Forms.Label labelTitle;
        private System.Windows.Forms.Button buttonAddPhone;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button buttonAddMyPhones;
        private System.Windows.Forms.Button buttonExportExcel;
        private System.Windows.Forms.Button buttonExportCSV;
        private System.Windows.Forms.Button buttonExportText;
    }
}
