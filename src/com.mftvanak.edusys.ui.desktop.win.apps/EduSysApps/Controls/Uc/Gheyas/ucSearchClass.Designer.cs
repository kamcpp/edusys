namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas
{
    partial class UcSearchClass
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.buttonDeselectAllGroups = new System.Windows.Forms.Button();
            this.buttonDeselectAllTerms = new System.Windows.Forms.Button();
            this.buttonSelectAllGroups = new System.Windows.Forms.Button();
            this.buttonSelectAllTerms = new System.Windows.Forms.Button();
            this.checkedlistboxGroups = new System.Windows.Forms.CheckedListBox();
            this.checkedlistboxTerms = new System.Windows.Forms.CheckedListBox();
            this.textboxClassName = new System.Windows.Forms.TextBox();
            this.labelClassName = new System.Windows.Forms.Label();
            this.textboxClassCode = new System.Windows.Forms.TextBox();
            this.labelClassCode = new System.Windows.Forms.Label();
            this.radiobuttonAll = new System.Windows.Forms.RadioButton();
            this.radiobuttonReserved = new System.Windows.Forms.RadioButton();
            this.radiobuttonRunning = new System.Windows.Forms.RadioButton();
            this.radiobuttonFinished = new System.Windows.Forms.RadioButton();
            this.buttonRefreshGroups = new System.Windows.Forms.Button();
            this.buttonRefreshTerms = new System.Windows.Forms.Button();
            this.buttonSearchClass = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.labelTerm = new System.Windows.Forms.Label();
            this.statusStrip = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel = new System.Windows.Forms.ToolStripStatusLabel();
            this.datagridviewClasses = new System.Windows.Forms.DataGridView();
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnClassCode = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnClassName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnClassTimes = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnNumberOfStudents = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnStartDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnEndDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTeacherTarafHesabCode = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTeacherFullName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTeacherPhone1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTeacherPhone2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnTeacherEmail = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox1.SuspendLayout();
            this.statusStrip.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewClasses)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.buttonDeselectAllGroups);
            this.groupBox1.Controls.Add(this.buttonDeselectAllTerms);
            this.groupBox1.Controls.Add(this.buttonSelectAllGroups);
            this.groupBox1.Controls.Add(this.buttonSelectAllTerms);
            this.groupBox1.Controls.Add(this.checkedlistboxGroups);
            this.groupBox1.Controls.Add(this.checkedlistboxTerms);
            this.groupBox1.Controls.Add(this.textboxClassName);
            this.groupBox1.Controls.Add(this.labelClassName);
            this.groupBox1.Controls.Add(this.textboxClassCode);
            this.groupBox1.Controls.Add(this.labelClassCode);
            this.groupBox1.Controls.Add(this.radiobuttonAll);
            this.groupBox1.Controls.Add(this.radiobuttonReserved);
            this.groupBox1.Controls.Add(this.radiobuttonRunning);
            this.groupBox1.Controls.Add(this.radiobuttonFinished);
            this.groupBox1.Controls.Add(this.buttonRefreshGroups);
            this.groupBox1.Controls.Add(this.buttonRefreshTerms);
            this.groupBox1.Controls.Add(this.buttonSearchClass);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.labelTerm);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(807, 271);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "جست و جوی کلاس";
            // 
            // buttonDeselectAllGroups
            // 
            this.buttonDeselectAllGroups.Location = new System.Drawing.Point(15, 113);
            this.buttonDeselectAllGroups.Name = "buttonDeselectAllGroups";
            this.buttonDeselectAllGroups.Size = new System.Drawing.Size(75, 23);
            this.buttonDeselectAllGroups.TabIndex = 9;
            this.buttonDeselectAllGroups.Text = "لغو همه";
            this.buttonDeselectAllGroups.UseVisualStyleBackColor = true;
            this.buttonDeselectAllGroups.Click += new System.EventHandler(this.buttonDeselectAllGroups_Click);
            // 
            // buttonDeselectAllTerms
            // 
            this.buttonDeselectAllTerms.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonDeselectAllTerms.Location = new System.Drawing.Point(461, 113);
            this.buttonDeselectAllTerms.Name = "buttonDeselectAllTerms";
            this.buttonDeselectAllTerms.Size = new System.Drawing.Size(75, 23);
            this.buttonDeselectAllTerms.TabIndex = 5;
            this.buttonDeselectAllTerms.Text = "لغو همه";
            this.buttonDeselectAllTerms.UseVisualStyleBackColor = true;
            this.buttonDeselectAllTerms.Click += new System.EventHandler(this.buttonDeselectAllTerms_Click);
            // 
            // buttonSelectAllGroups
            // 
            this.buttonSelectAllGroups.Location = new System.Drawing.Point(15, 84);
            this.buttonSelectAllGroups.Name = "buttonSelectAllGroups";
            this.buttonSelectAllGroups.Size = new System.Drawing.Size(75, 23);
            this.buttonSelectAllGroups.TabIndex = 8;
            this.buttonSelectAllGroups.Text = "انتخاب همه";
            this.buttonSelectAllGroups.UseVisualStyleBackColor = true;
            this.buttonSelectAllGroups.Click += new System.EventHandler(this.buttonSelectAllGroups_Click);
            // 
            // buttonSelectAllTerms
            // 
            this.buttonSelectAllTerms.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonSelectAllTerms.Location = new System.Drawing.Point(461, 84);
            this.buttonSelectAllTerms.Name = "buttonSelectAllTerms";
            this.buttonSelectAllTerms.Size = new System.Drawing.Size(75, 23);
            this.buttonSelectAllTerms.TabIndex = 4;
            this.buttonSelectAllTerms.Text = "انتخاب همه";
            this.buttonSelectAllTerms.UseVisualStyleBackColor = true;
            this.buttonSelectAllTerms.Click += new System.EventHandler(this.buttonSelectAllTerms_Click);
            // 
            // checkedlistboxGroups
            // 
            this.checkedlistboxGroups.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.checkedlistboxGroups.CheckOnClick = true;
            this.checkedlistboxGroups.FormattingEnabled = true;
            this.checkedlistboxGroups.Location = new System.Drawing.Point(96, 53);
            this.checkedlistboxGroups.MultiColumn = true;
            this.checkedlistboxGroups.Name = "checkedlistboxGroups";
            this.checkedlistboxGroups.Size = new System.Drawing.Size(326, 180);
            this.checkedlistboxGroups.TabIndex = 6;
            // 
            // checkedlistboxTerms
            // 
            this.checkedlistboxTerms.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkedlistboxTerms.CheckOnClick = true;
            this.checkedlistboxTerms.FormattingEnabled = true;
            this.checkedlistboxTerms.Location = new System.Drawing.Point(542, 53);
            this.checkedlistboxTerms.Name = "checkedlistboxTerms";
            this.checkedlistboxTerms.Size = new System.Drawing.Size(226, 180);
            this.checkedlistboxTerms.TabIndex = 2;
            // 
            // textboxClassName
            // 
            this.textboxClassName.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxClassName.Enabled = false;
            this.textboxClassName.Location = new System.Drawing.Point(357, 26);
            this.textboxClassName.Name = "textboxClassName";
            this.textboxClassName.Size = new System.Drawing.Size(169, 21);
            this.textboxClassName.TabIndex = 1;
            // 
            // labelClassName
            // 
            this.labelClassName.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelClassName.AutoSize = true;
            this.labelClassName.Location = new System.Drawing.Point(532, 29);
            this.labelClassName.Name = "labelClassName";
            this.labelClassName.Size = new System.Drawing.Size(49, 13);
            this.labelClassName.TabIndex = 25;
            this.labelClassName.Text = "نام کلاس";
            // 
            // textboxClassCode
            // 
            this.textboxClassCode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxClassCode.Location = new System.Drawing.Point(587, 26);
            this.textboxClassCode.Name = "textboxClassCode";
            this.textboxClassCode.Size = new System.Drawing.Size(161, 21);
            this.textboxClassCode.TabIndex = 0;
            this.textboxClassCode.TextChanged += new System.EventHandler(this.textboxClassCode_TextChanged);
            // 
            // labelClassCode
            // 
            this.labelClassCode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelClassCode.AutoSize = true;
            this.labelClassCode.Location = new System.Drawing.Point(754, 29);
            this.labelClassCode.Name = "labelClassCode";
            this.labelClassCode.Size = new System.Drawing.Size(47, 13);
            this.labelClassCode.TabIndex = 23;
            this.labelClassCode.Text = "کد کلاس";
            // 
            // radiobuttonAll
            // 
            this.radiobuttonAll.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.radiobuttonAll.AutoSize = true;
            this.radiobuttonAll.Location = new System.Drawing.Point(461, 245);
            this.radiobuttonAll.Name = "radiobuttonAll";
            this.radiobuttonAll.Size = new System.Drawing.Size(122, 17);
            this.radiobuttonAll.TabIndex = 13;
            this.radiobuttonAll.TabStop = true;
            this.radiobuttonAll.Text = "نمایش همه کلاس ها";
            this.radiobuttonAll.UseVisualStyleBackColor = true;
            this.radiobuttonAll.Click += new System.EventHandler(this.radiobuttonAll_Click);
            // 
            // radiobuttonReserved
            // 
            this.radiobuttonReserved.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.radiobuttonReserved.AutoSize = true;
            this.radiobuttonReserved.Checked = true;
            this.radiobuttonReserved.Location = new System.Drawing.Point(589, 245);
            this.radiobuttonReserved.Name = "radiobuttonReserved";
            this.radiobuttonReserved.Size = new System.Drawing.Size(42, 17);
            this.radiobuttonReserved.TabIndex = 12;
            this.radiobuttonReserved.TabStop = true;
            this.radiobuttonReserved.Text = "رزرو";
            this.radiobuttonReserved.UseVisualStyleBackColor = true;
            this.radiobuttonReserved.Click += new System.EventHandler(this.radiobuttonReserved_Click);
            // 
            // radiobuttonRunning
            // 
            this.radiobuttonRunning.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.radiobuttonRunning.AutoSize = true;
            this.radiobuttonRunning.Location = new System.Drawing.Point(637, 245);
            this.radiobuttonRunning.Name = "radiobuttonRunning";
            this.radiobuttonRunning.Size = new System.Drawing.Size(82, 17);
            this.radiobuttonRunning.TabIndex = 11;
            this.radiobuttonRunning.TabStop = true;
            this.radiobuttonRunning.Text = "در حال جریان";
            this.radiobuttonRunning.UseVisualStyleBackColor = true;
            this.radiobuttonRunning.Click += new System.EventHandler(this.radiobuttonRunning_Click);
            // 
            // radiobuttonFinished
            // 
            this.radiobuttonFinished.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.radiobuttonFinished.AutoSize = true;
            this.radiobuttonFinished.Location = new System.Drawing.Point(725, 245);
            this.radiobuttonFinished.Name = "radiobuttonFinished";
            this.radiobuttonFinished.Size = new System.Drawing.Size(70, 17);
            this.radiobuttonFinished.TabIndex = 10;
            this.radiobuttonFinished.TabStop = true;
            this.radiobuttonFinished.Text = "تمام شده";
            this.radiobuttonFinished.UseVisualStyleBackColor = true;
            this.radiobuttonFinished.Click += new System.EventHandler(this.radiobuttonFinished_Click);
            // 
            // buttonRefreshGroups
            // 
            this.buttonRefreshGroups.Location = new System.Drawing.Point(15, 53);
            this.buttonRefreshGroups.Name = "buttonRefreshGroups";
            this.buttonRefreshGroups.Size = new System.Drawing.Size(75, 25);
            this.buttonRefreshGroups.TabIndex = 7;
            this.buttonRefreshGroups.Text = "بازآوری";
            this.buttonRefreshGroups.UseVisualStyleBackColor = true;
            this.buttonRefreshGroups.Click += new System.EventHandler(this.buttonRefreshGroups_Click);
            // 
            // buttonRefreshTerms
            // 
            this.buttonRefreshTerms.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefreshTerms.Location = new System.Drawing.Point(461, 53);
            this.buttonRefreshTerms.Name = "buttonRefreshTerms";
            this.buttonRefreshTerms.Size = new System.Drawing.Size(75, 25);
            this.buttonRefreshTerms.TabIndex = 3;
            this.buttonRefreshTerms.Text = "بازآوری";
            this.buttonRefreshTerms.UseVisualStyleBackColor = true;
            this.buttonRefreshTerms.Click += new System.EventHandler(this.buttonRefreshTerms_Click);
            // 
            // buttonSearchClass
            // 
            this.buttonSearchClass.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.buttonSearchClass.Location = new System.Drawing.Point(15, 238);
            this.buttonSearchClass.Name = "buttonSearchClass";
            this.buttonSearchClass.Size = new System.Drawing.Size(134, 23);
            this.buttonSearchClass.TabIndex = 14;
            this.buttonSearchClass.Text = "جست و جوی کلاس";
            this.buttonSearchClass.UseVisualStyleBackColor = true;
            this.buttonSearchClass.Click += new System.EventHandler(this.buttonSearchClass_Click);
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(428, 56);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(27, 13);
            this.label1.TabIndex = 14;
            this.label1.Text = "گروه";
            // 
            // labelTerm
            // 
            this.labelTerm.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelTerm.AutoSize = true;
            this.labelTerm.Location = new System.Drawing.Point(774, 56);
            this.labelTerm.Name = "labelTerm";
            this.labelTerm.Size = new System.Drawing.Size(22, 13);
            this.labelTerm.TabIndex = 12;
            this.labelTerm.Text = "ترم";
            // 
            // statusStrip
            // 
            this.statusStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel});
            this.statusStrip.Location = new System.Drawing.Point(0, 468);
            this.statusStrip.Name = "statusStrip";
            this.statusStrip.Size = new System.Drawing.Size(807, 22);
            this.statusStrip.TabIndex = 7;
            this.statusStrip.Text = "statusStrip1";
            // 
            // toolStripStatusLabel
            // 
            this.toolStripStatusLabel.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolStripStatusLabel.Name = "toolStripStatusLabel";
            this.toolStripStatusLabel.Size = new System.Drawing.Size(32, 17);
            this.toolStripStatusLabel.Text = "آماده";
            // 
            // datagridviewClasses
            // 
            this.datagridviewClasses.AllowUserToAddRows = false;
            this.datagridviewClasses.AllowUserToDeleteRows = false;
            this.datagridviewClasses.AllowUserToResizeRows = false;
            this.datagridviewClasses.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridviewClasses.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewClasses.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnClassCode,
            this.columnClassName,
            this.columnClassTimes,
            this.columnNumberOfStudents,
            this.columnStartDate,
            this.columnEndDate,
            this.columnTeacherTarafHesabCode,
            this.columnTeacherFullName,
            this.columnTeacherPhone1,
            this.columnTeacherPhone2,
            this.columnTeacherEmail});
            this.datagridviewClasses.Location = new System.Drawing.Point(3, 277);
            this.datagridviewClasses.Name = "datagridviewClasses";
            this.datagridviewClasses.ReadOnly = true;
            this.datagridviewClasses.RowHeadersVisible = false;
            this.datagridviewClasses.Size = new System.Drawing.Size(801, 188);
            this.datagridviewClasses.TabIndex = 8;
            this.datagridviewClasses.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridviewClasses_CellDoubleClick);
            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 50;
            // 
            // columnClassCode
            // 
            this.columnClassCode.HeaderText = "کد کلاس";
            this.columnClassCode.Name = "columnClassCode";
            this.columnClassCode.ReadOnly = true;
            // 
            // columnClassName
            // 
            this.columnClassName.HeaderText = "نام کلاس";
            this.columnClassName.Name = "columnClassName";
            this.columnClassName.ReadOnly = true;
            this.columnClassName.Width = 250;
            // 
            // columnClassTimes
            // 
            this.columnClassTimes.HeaderText = "روز و ساعت";
            this.columnClassTimes.Name = "columnClassTimes";
            this.columnClassTimes.ReadOnly = true;
            this.columnClassTimes.Width = 150;
            // 
            // columnNumberOfStudents
            // 
            this.columnNumberOfStudents.HeaderText = "تعداد دانشجوی ثبت نامی";
            this.columnNumberOfStudents.Name = "columnNumberOfStudents";
            this.columnNumberOfStudents.ReadOnly = true;
            this.columnNumberOfStudents.Width = 200;
            // 
            // columnStartDate
            // 
            this.columnStartDate.HeaderText = "تاریخ شروع";
            this.columnStartDate.Name = "columnStartDate";
            this.columnStartDate.ReadOnly = true;
            this.columnStartDate.Width = 150;
            // 
            // columnEndDate
            // 
            this.columnEndDate.HeaderText = "تاریخ پایان";
            this.columnEndDate.Name = "columnEndDate";
            this.columnEndDate.ReadOnly = true;
            this.columnEndDate.Width = 150;
            // 
            // columnTeacherTarafHesabCode
            // 
            this.columnTeacherTarafHesabCode.HeaderText = "کد استاد";
            this.columnTeacherTarafHesabCode.Name = "columnTeacherTarafHesabCode";
            this.columnTeacherTarafHesabCode.ReadOnly = true;
            // 
            // columnTeacherFullName
            // 
            this.columnTeacherFullName.HeaderText = "استاد";
            this.columnTeacherFullName.Name = "columnTeacherFullName";
            this.columnTeacherFullName.ReadOnly = true;
            this.columnTeacherFullName.Width = 250;
            // 
            // columnTeacherPhone1
            // 
            this.columnTeacherPhone1.HeaderText = "تلفن اول استاد";
            this.columnTeacherPhone1.Name = "columnTeacherPhone1";
            this.columnTeacherPhone1.ReadOnly = true;
            this.columnTeacherPhone1.Width = 150;
            // 
            // columnTeacherPhone2
            // 
            this.columnTeacherPhone2.HeaderText = "تلفن دوم استاد";
            this.columnTeacherPhone2.Name = "columnTeacherPhone2";
            this.columnTeacherPhone2.ReadOnly = true;
            this.columnTeacherPhone2.Width = 150;
            // 
            // columnTeacherEmail
            // 
            this.columnTeacherEmail.HeaderText = "ایمیل استاد";
            this.columnTeacherEmail.Name = "columnTeacherEmail";
            this.columnTeacherEmail.ReadOnly = true;
            this.columnTeacherEmail.Width = 250;
            // 
            // UcSearchClass
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.datagridviewClasses);
            this.Controls.Add(this.statusStrip);
            this.Controls.Add(this.groupBox1);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcSearchClass";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(807, 490);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.statusStrip.ResumeLayout(false);
            this.statusStrip.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewClasses)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radiobuttonAll;
        private System.Windows.Forms.RadioButton radiobuttonReserved;
        private System.Windows.Forms.RadioButton radiobuttonRunning;
        private System.Windows.Forms.RadioButton radiobuttonFinished;
        private System.Windows.Forms.Button buttonRefreshGroups;
        private System.Windows.Forms.Button buttonRefreshTerms;
        private System.Windows.Forms.Button buttonSearchClass;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelTerm;
        private System.Windows.Forms.TextBox textboxClassCode;
        private System.Windows.Forms.Label labelClassCode;
        private System.Windows.Forms.TextBox textboxClassName;
        private System.Windows.Forms.Label labelClassName;
        private System.Windows.Forms.CheckedListBox checkedlistboxGroups;
        private System.Windows.Forms.CheckedListBox checkedlistboxTerms;
        private System.Windows.Forms.Button buttonSelectAllGroups;
        private System.Windows.Forms.Button buttonSelectAllTerms;
        private System.Windows.Forms.Button buttonDeselectAllGroups;
        private System.Windows.Forms.Button buttonDeselectAllTerms;
        private System.Windows.Forms.StatusStrip statusStrip;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel;
        private System.Windows.Forms.DataGridView datagridviewClasses;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnClassCode;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnClassName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnClassTimes;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumberOfStudents;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnStartDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnEndDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTeacherTarafHesabCode;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTeacherFullName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTeacherPhone1;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTeacherPhone2;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTeacherEmail;
    }
}
