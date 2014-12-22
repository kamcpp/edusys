namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    partial class UcSearchPhoneEntries
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
            this.groupboxSearch = new System.Windows.Forms.GroupBox();
            this.ucDepartmentSelector = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcDepartmentSelector();
            this.buttonSearch = new System.Windows.Forms.Button();
            this.ucPhoneEntries = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcPhoneEntries();
            this.checkboxSelectAllDepartments = new System.Windows.Forms.CheckBox();
            this.fadatepickerSubmitDateStart = new FarsiLibrary.Win.Controls.FADatePicker();
            this.labelSubmitDateStart = new System.Windows.Forms.Label();
            this.labelSubmitDateEnd = new System.Windows.Forms.Label();
            this.fadatepickerSubmitDateEnd = new FarsiLibrary.Win.Controls.FADatePicker();
            this.groupboxSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupboxSearch
            // 
            this.groupboxSearch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupboxSearch.Controls.Add(this.labelSubmitDateEnd);
            this.groupboxSearch.Controls.Add(this.fadatepickerSubmitDateEnd);
            this.groupboxSearch.Controls.Add(this.labelSubmitDateStart);
            this.groupboxSearch.Controls.Add(this.fadatepickerSubmitDateStart);
            this.groupboxSearch.Controls.Add(this.checkboxSelectAllDepartments);
            this.groupboxSearch.Controls.Add(this.ucDepartmentSelector);
            this.groupboxSearch.Controls.Add(this.buttonSearch);
            this.groupboxSearch.Location = new System.Drawing.Point(3, 3);
            this.groupboxSearch.Name = "groupboxSearch";
            this.groupboxSearch.Size = new System.Drawing.Size(807, 147);
            this.groupboxSearch.TabIndex = 0;
            this.groupboxSearch.TabStop = false;
            this.groupboxSearch.Text = "جست و جو";
            // 
            // ucDepartmentSelector
            // 
            this.ucDepartmentSelector.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucDepartmentSelector.BackColor = System.Drawing.Color.Transparent;
            this.ucDepartmentSelector.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucDepartmentSelector.Location = new System.Drawing.Point(183, 41);
            this.ucDepartmentSelector.Name = "ucDepartmentSelector";
            this.ucDepartmentSelector.Size = new System.Drawing.Size(618, 59);
            this.ucDepartmentSelector.TabIndex = 2;
            // 
            // buttonSearch
            // 
            this.buttonSearch.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.buttonSearch.Location = new System.Drawing.Point(6, 118);
            this.buttonSearch.Name = "buttonSearch";
            this.buttonSearch.Size = new System.Drawing.Size(124, 23);
            this.buttonSearch.TabIndex = 1;
            this.buttonSearch.Text = "جست و جو";
            this.buttonSearch.UseVisualStyleBackColor = true;
            this.buttonSearch.Click += new System.EventHandler(this.buttonSearch_Click);
            // 
            // ucPhoneEntries
            // 
            this.ucPhoneEntries.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucPhoneEntries.AutoRefresh = false;
            this.ucPhoneEntries.BackColor = System.Drawing.Color.Transparent;
            this.ucPhoneEntries.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucPhoneEntries.Location = new System.Drawing.Point(0, 156);
            this.ucPhoneEntries.Name = "ucPhoneEntries";
            this.ucPhoneEntries.PhoneEntries = null;
            this.ucPhoneEntries.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucPhoneEntries.Size = new System.Drawing.Size(810, 270);
            this.ucPhoneEntries.TabIndex = 1;
            this.ucPhoneEntries.DataRefteshNeeded += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcPhoneEntries.DataRefreshNeededEventHandler(this.ucPhoneEntries_DataRefteshNeeded);
            // 
            // checkboxSelectAllDepartments
            // 
            this.checkboxSelectAllDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxSelectAllDepartments.AutoSize = true;
            this.checkboxSelectAllDepartments.Location = new System.Drawing.Point(614, 20);
            this.checkboxSelectAllDepartments.Name = "checkboxSelectAllDepartments";
            this.checkboxSelectAllDepartments.Size = new System.Drawing.Size(131, 17);
            this.checkboxSelectAllDepartments.TabIndex = 3;
            this.checkboxSelectAllDepartments.Text = "انتخاب همه دپارتمان ها";
            this.checkboxSelectAllDepartments.UseVisualStyleBackColor = true;
            this.checkboxSelectAllDepartments.CheckedChanged += new System.EventHandler(this.checkboxSelectAllDepartments_CheckedChanged);
            // 
            // fadatepickerSubmitDateStart
            // 
            this.fadatepickerSubmitDateStart.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.fadatepickerSubmitDateStart.Location = new System.Drawing.Point(604, 106);
            this.fadatepickerSubmitDateStart.Name = "fadatepickerSubmitDateStart";
            this.fadatepickerSubmitDateStart.Size = new System.Drawing.Size(120, 20);
            this.fadatepickerSubmitDateStart.TabIndex = 4;
            // 
            // labelSubmitDateStart
            // 
            this.labelSubmitDateStart.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelSubmitDateStart.AutoSize = true;
            this.labelSubmitDateStart.Location = new System.Drawing.Point(730, 108);
            this.labelSubmitDateStart.Name = "labelSubmitDateStart";
            this.labelSubmitDateStart.Size = new System.Drawing.Size(58, 13);
            this.labelSubmitDateStart.TabIndex = 5;
            this.labelSubmitDateStart.Text = "تاریخ ثبت از";
            // 
            // labelSubmitDateEnd
            // 
            this.labelSubmitDateEnd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelSubmitDateEnd.AutoSize = true;
            this.labelSubmitDateEnd.Location = new System.Drawing.Point(561, 108);
            this.labelSubmitDateEnd.Name = "labelSubmitDateEnd";
            this.labelSubmitDateEnd.Size = new System.Drawing.Size(37, 13);
            this.labelSubmitDateEnd.TabIndex = 7;
            this.labelSubmitDateEnd.Text = "تا تاریخ";
            // 
            // fadatepickerSubmitDateEnd
            // 
            this.fadatepickerSubmitDateEnd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.fadatepickerSubmitDateEnd.Location = new System.Drawing.Point(435, 106);
            this.fadatepickerSubmitDateEnd.Name = "fadatepickerSubmitDateEnd";
            this.fadatepickerSubmitDateEnd.Size = new System.Drawing.Size(120, 20);
            this.fadatepickerSubmitDateEnd.TabIndex = 6;
            // 
            // ucSearchPhoneEntries
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.Controls.Add(this.ucPhoneEntries);
            this.Controls.Add(this.groupboxSearch);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucSearchPhoneEntries";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(813, 429);
            this.groupboxSearch.ResumeLayout(false);
            this.groupboxSearch.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupboxSearch;
        private UcPhoneEntries ucPhoneEntries;
        private System.Windows.Forms.Button buttonSearch;
        private Education.UcDepartmentSelector ucDepartmentSelector;
        private System.Windows.Forms.CheckBox checkboxSelectAllDepartments;
        private System.Windows.Forms.Label labelSubmitDateEnd;
        private FarsiLibrary.Win.Controls.FADatePicker fadatepickerSubmitDateEnd;
        private System.Windows.Forms.Label labelSubmitDateStart;
        private FarsiLibrary.Win.Controls.FADatePicker fadatepickerSubmitDateStart;
    }
}
