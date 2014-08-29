namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    partial class UcPhoneEntries
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UcPhoneEntries));
            this.checkboxAutoRefresh = new System.Windows.Forms.CheckBox();
            this.timer = new System.Windows.Forms.Timer(this.components);
            this.imageList = new System.Windows.Forms.ImageList(this.components);
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnCategory = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnInstituteName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDepartment = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnSubmitDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPhone = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnSeen = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPrivate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnRegistered = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnOwnerName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDescription = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ucEduSysDataGridView = new Controls.Uc.Common.UcEduSysDataGridView();
            this.SuspendLayout();
            // 
            // checkboxAutoRefresh
            // 
            this.checkboxAutoRefresh.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxAutoRefresh.AutoSize = true;
            this.checkboxAutoRefresh.Location = new System.Drawing.Point(753, 5);
            this.checkboxAutoRefresh.Name = "checkboxAutoRefresh";
            this.checkboxAutoRefresh.Size = new System.Drawing.Size(152, 17);
            this.checkboxAutoRefresh.TabIndex = 3;
            this.checkboxAutoRefresh.Text = "بازآوری خودکار (هر 1 دقیقه)";
            this.checkboxAutoRefresh.UseVisualStyleBackColor = true;
            // 
            // timer
            // 
            this.timer.Interval = 60000;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // imageList
            // 
            this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
            this.imageList.TransparentColor = System.Drawing.Color.Transparent;
            this.imageList.Images.SetKeyName(0, "done.png");
            this.imageList.Images.SetKeyName(1, "not-done.png");
            // 
            // columnNumber
            // 
            this.columnNumber.FillWeight = 10F;
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 50;
            // 
            // columnCategory
            // 
            this.columnCategory.HeaderText = "";
            this.columnCategory.Name = "columnCategory";
            this.columnCategory.ReadOnly = true;
            this.columnCategory.Width = 30;
            // 
            // columnInstituteName
            // 
            this.columnInstituteName.HeaderText = "موسسه";
            this.columnInstituteName.Name = "columnInstituteName";
            this.columnInstituteName.ReadOnly = true;
            // 
            // columnDepartment
            // 
            this.columnDepartment.FillWeight = 30F;
            this.columnDepartment.HeaderText = "دپارتمان";
            this.columnDepartment.Name = "columnDepartment";
            this.columnDepartment.ReadOnly = true;
            this.columnDepartment.Width = 200;
            // 
            // columnSubmitDate
            // 
            this.columnSubmitDate.HeaderText = "تاریخ درج";
            this.columnSubmitDate.Name = "columnSubmitDate";
            this.columnSubmitDate.ReadOnly = true;
            this.columnSubmitDate.Width = 150;
            // 
            // columnName
            // 
            this.columnName.FillWeight = 30F;
            this.columnName.HeaderText = "نام";
            this.columnName.Name = "columnName";
            this.columnName.ReadOnly = true;
            this.columnName.Width = 150;
            // 
            // columnPhone
            // 
            this.columnPhone.FillWeight = 30F;
            this.columnPhone.HeaderText = "شماره تلفن";
            this.columnPhone.Name = "columnPhone";
            this.columnPhone.ReadOnly = true;
            this.columnPhone.Width = 150;
            // 
            // columnSeen
            // 
            this.columnSeen.HeaderText = "دیده شد";
            this.columnSeen.Name = "columnSeen";
            this.columnSeen.ReadOnly = true;
            // 
            // columnPrivate
            // 
            this.columnPrivate.HeaderText = "خصوصی";
            this.columnPrivate.Name = "columnPrivate";
            this.columnPrivate.ReadOnly = true;
            this.columnPrivate.Width = 50;
            // 
            // columnRegistered
            // 
            this.columnRegistered.HeaderText = "ثبت نام شده";
            this.columnRegistered.Name = "columnRegistered";
            this.columnRegistered.ReadOnly = true;
            this.columnRegistered.Width = 90;
            // 
            // columnOwnerName
            // 
            this.columnOwnerName.HeaderText = "نام ثبت کننده";
            this.columnOwnerName.Name = "columnOwnerName";
            this.columnOwnerName.ReadOnly = true;
            this.columnOwnerName.Width = 150;
            // 
            // columnDescription
            // 
            this.columnDescription.HeaderText = "توضیحات";
            this.columnDescription.Name = "columnDescription";
            this.columnDescription.ReadOnly = true;
            this.columnDescription.Width = 300;
            // 
            // columnId
            // 
            this.columnId.HeaderText = "مشخصه";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            // 
            // ucEduSysDataGridView
            // 
            this.ucEduSysDataGridView.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucEduSysDataGridView.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEduSysDataGridView.Location = new System.Drawing.Point(0, 28);
            this.ucEduSysDataGridView.Name = "ucEduSysDataGridView";
            this.ucEduSysDataGridView.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEduSysDataGridView.Size = new System.Drawing.Size(905, 284);
            this.ucEduSysDataGridView.TabIndex = 4;
            this.ucEduSysDataGridView.CellDoubleClick += new Controls.Uc.Common.UcEduSysDataGridView.CellDoubleClickHandler(this.ucEduSysDataGridView_CellDoubleClick);
            // 
            // ucPhoneEntries
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.ucEduSysDataGridView);
            this.Controls.Add(this.checkboxAutoRefresh);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucPhoneEntries";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(908, 312);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox checkboxAutoRefresh;
        private System.Windows.Forms.Timer timer;
        private System.Windows.Forms.ImageList imageList;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnCategory;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnInstituteName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDepartment;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnSubmitDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPhone;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnSeen;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPrivate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnRegistered;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnOwnerName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDescription;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private Controls.Uc.Common.UcEduSysDataGridView ucEduSysDataGridView;
    }
}
