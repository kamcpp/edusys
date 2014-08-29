namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Forms
{
    partial class formListOfClasses
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
            this.listviewClasses = new System.Windows.Forms.ListView();
            this.columnheaderRow = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderCode = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderActiveDays = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderNumberOfStudents = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderDescription = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.buttonShowListOfClasses = new System.Windows.Forms.Button();
            this.comboboxGroup = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.comboboxTerm = new System.Windows.Forms.ComboBox();
            this.labelTerm = new System.Windows.Forms.Label();
            this.buttonRefreshTerms = new System.Windows.Forms.Button();
            this.buttonRefreshGroups = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listviewClasses
            // 
            this.listviewClasses.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.listviewClasses.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnheaderRow,
            this.columnheaderCode,
            this.columnheaderName,
            this.columnheaderActiveDays,
            this.columnheaderNumberOfStudents,
            this.columnheaderDescription});
            this.listviewClasses.FullRowSelect = true;
            this.listviewClasses.GridLines = true;
            this.listviewClasses.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.Nonclickable;
            this.listviewClasses.Location = new System.Drawing.Point(12, 89);
            this.listviewClasses.Name = "listviewClasses";
            this.listviewClasses.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewClasses.RightToLeftLayout = true;
            this.listviewClasses.Size = new System.Drawing.Size(712, 303);
            this.listviewClasses.TabIndex = 5;
            this.listviewClasses.UseCompatibleStateImageBehavior = false;
            this.listviewClasses.View = System.Windows.Forms.View.Details;
            this.listviewClasses.DoubleClick += new System.EventHandler(this.listviewClasses_DoubleClick);
            // 
            // columnheaderRow
            // 
            this.columnheaderRow.Text = "ردیف";
            // 
            // columnheaderCode
            // 
            this.columnheaderCode.Text = "کد کلاس";
            this.columnheaderCode.Width = 100;
            // 
            // columnheaderName
            // 
            this.columnheaderName.Text = "نام کلاس";
            this.columnheaderName.Width = 200;
            // 
            // columnheaderActiveDays
            // 
            this.columnheaderActiveDays.Text = "روزهای کلاس";
            this.columnheaderActiveDays.Width = 120;
            // 
            // columnheaderNumberOfStudents
            // 
            this.columnheaderNumberOfStudents.Text = "تعداد دانشجویان ثبت نامی";
            this.columnheaderNumberOfStudents.Width = 150;
            // 
            // columnheaderDescription
            // 
            this.columnheaderDescription.Text = "توضیحات";
            this.columnheaderDescription.Width = 200;
            // 
            // buttonShowListOfClasses
            // 
            this.buttonShowListOfClasses.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonShowListOfClasses.Location = new System.Drawing.Point(562, 60);
            this.buttonShowListOfClasses.Name = "buttonShowListOfClasses";
            this.buttonShowListOfClasses.Size = new System.Drawing.Size(134, 23);
            this.buttonShowListOfClasses.TabIndex = 4;
            this.buttonShowListOfClasses.Text = "نمایش لیست کلاس ها";
            this.buttonShowListOfClasses.UseVisualStyleBackColor = true;
            this.buttonShowListOfClasses.Click += new System.EventHandler(this.buttonShowListOfClasses_Click);
            // 
            // comboboxGroup
            // 
            this.comboboxGroup.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxGroup.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxGroup.FormattingEnabled = true;
            this.comboboxGroup.Location = new System.Drawing.Point(380, 33);
            this.comboboxGroup.Name = "comboboxGroup";
            this.comboboxGroup.Size = new System.Drawing.Size(316, 21);
            this.comboboxGroup.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(702, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(27, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "گروه";
            // 
            // comboboxTerm
            // 
            this.comboboxTerm.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxTerm.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxTerm.FormattingEnabled = true;
            this.comboboxTerm.Location = new System.Drawing.Point(470, 6);
            this.comboboxTerm.Name = "comboboxTerm";
            this.comboboxTerm.Size = new System.Drawing.Size(226, 21);
            this.comboboxTerm.TabIndex = 1;
            // 
            // labelTerm
            // 
            this.labelTerm.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelTerm.AutoSize = true;
            this.labelTerm.Location = new System.Drawing.Point(702, 9);
            this.labelTerm.Name = "labelTerm";
            this.labelTerm.Size = new System.Drawing.Size(22, 13);
            this.labelTerm.TabIndex = 0;
            this.labelTerm.Text = "ترم";
            // 
            // buttonRefreshTerms
            // 
            this.buttonRefreshTerms.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefreshTerms.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Properties.Resources.view_refresh;
            this.buttonRefreshTerms.Location = new System.Drawing.Point(439, 4);
            this.buttonRefreshTerms.Name = "buttonRefreshTerms";
            this.buttonRefreshTerms.Size = new System.Drawing.Size(25, 25);
            this.buttonRefreshTerms.TabIndex = 6;
            this.buttonRefreshTerms.UseVisualStyleBackColor = true;
            this.buttonRefreshTerms.Click += new System.EventHandler(this.buttonRefreshTerms_Click);
            // 
            // buttonRefreshGroups
            // 
            this.buttonRefreshGroups.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefreshGroups.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Properties.Resources.view_refresh;
            this.buttonRefreshGroups.Location = new System.Drawing.Point(349, 33);
            this.buttonRefreshGroups.Name = "buttonRefreshGroups";
            this.buttonRefreshGroups.Size = new System.Drawing.Size(25, 25);
            this.buttonRefreshGroups.TabIndex = 7;
            this.buttonRefreshGroups.UseVisualStyleBackColor = true;
            this.buttonRefreshGroups.Click += new System.EventHandler(this.buttonRefreshGroups_Click);
            // 
            // formListOfClasses
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(736, 400);
            this.Controls.Add(this.buttonRefreshGroups);
            this.Controls.Add(this.buttonRefreshTerms);
            this.Controls.Add(this.listviewClasses);
            this.Controls.Add(this.buttonShowListOfClasses);
            this.Controls.Add(this.comboboxGroup);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboboxTerm);
            this.Controls.Add(this.labelTerm);
            this.Name = "formListOfClasses";
            this.Text = "قیاس - لیست کلاس ها";
            this.Load += new System.EventHandler(this.formListOfClasses_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelTerm;
        private System.Windows.Forms.ComboBox comboboxTerm;
        private System.Windows.Forms.ComboBox comboboxGroup;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonShowListOfClasses;
        private System.Windows.Forms.ListView listviewClasses;
        private System.Windows.Forms.ColumnHeader columnheaderCode;
        private System.Windows.Forms.ColumnHeader columnheaderName;
        private System.Windows.Forms.ColumnHeader columnheaderActiveDays;
        private System.Windows.Forms.ColumnHeader columnheaderNumberOfStudents;
        private System.Windows.Forms.ColumnHeader columnheaderDescription;
        private System.Windows.Forms.ColumnHeader columnheaderRow;
        private System.Windows.Forms.Button buttonRefreshTerms;
        private System.Windows.Forms.Button buttonRefreshGroups;
    }
}