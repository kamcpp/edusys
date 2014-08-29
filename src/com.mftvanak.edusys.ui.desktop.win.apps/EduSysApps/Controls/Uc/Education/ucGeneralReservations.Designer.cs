namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcGeneralReservations
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
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnClassName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnEmail = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPhone = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnText = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.buttonSearchGeneralReservations = new System.Windows.Forms.Button();
            this.comboboxDepartments = new System.Windows.Forms.ComboBox();
            this.labelDepartments = new System.Windows.Forms.Label();
            this.ucEduSysDataGridView1 = new Controls.Uc.Common.UcEduSysDataGridView();
            this.SuspendLayout();
            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 60;
            // 
            // columnId
            // 
            this.columnId.HeaderText = "مشخصه";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            this.columnId.Width = 60;
            // 
            // columnName
            // 
            this.columnName.HeaderText = "نام";
            this.columnName.Name = "columnName";
            this.columnName.ReadOnly = true;
            this.columnName.Width = 200;
            // 
            // columnDate
            // 
            this.columnDate.HeaderText = "تاریخ";
            this.columnDate.Name = "columnDate";
            this.columnDate.ReadOnly = true;
            this.columnDate.Width = 150;
            // 
            // columnClassName
            // 
            this.columnClassName.HeaderText = "درس مورد نظر";
            this.columnClassName.Name = "columnClassName";
            this.columnClassName.ReadOnly = true;
            this.columnClassName.Width = 350;
            // 
            // columnEmail
            // 
            this.columnEmail.HeaderText = "ایمیل";
            this.columnEmail.Name = "columnEmail";
            this.columnEmail.ReadOnly = true;
            this.columnEmail.Width = 200;
            // 
            // columnPhone
            // 
            this.columnPhone.HeaderText = "تلفن";
            this.columnPhone.Name = "columnPhone";
            this.columnPhone.ReadOnly = true;
            this.columnPhone.Width = 150;
            // 
            // columnText
            // 
            this.columnText.HeaderText = "توضیحات";
            this.columnText.Name = "columnText";
            this.columnText.ReadOnly = true;
            this.columnText.Width = 300;
            // 
            // buttonSearchGeneralReservations
            // 
            this.buttonSearchGeneralReservations.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonSearchGeneralReservations.Location = new System.Drawing.Point(312, 13);
            this.buttonSearchGeneralReservations.Name = "buttonSearchGeneralReservations";
            this.buttonSearchGeneralReservations.Size = new System.Drawing.Size(75, 23);
            this.buttonSearchGeneralReservations.TabIndex = 1;
            this.buttonSearchGeneralReservations.Text = "جست و جو";
            this.buttonSearchGeneralReservations.UseVisualStyleBackColor = true;
            this.buttonSearchGeneralReservations.Click += new System.EventHandler(this.buttonSearchGeneralReservations_Click);
            // 
            // comboboxDepartments
            // 
            this.comboboxDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxDepartments.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxDepartments.FormattingEnabled = true;
            this.comboboxDepartments.Location = new System.Drawing.Point(393, 15);
            this.comboboxDepartments.Name = "comboboxDepartments";
            this.comboboxDepartments.Size = new System.Drawing.Size(194, 21);
            this.comboboxDepartments.TabIndex = 2;
            // 
            // labelDepartments
            // 
            this.labelDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDepartments.AutoSize = true;
            this.labelDepartments.Location = new System.Drawing.Point(593, 18);
            this.labelDepartments.Name = "labelDepartments";
            this.labelDepartments.Size = new System.Drawing.Size(42, 13);
            this.labelDepartments.TabIndex = 3;
            this.labelDepartments.Text = "دپارتمان";
            // 
            // ucEduSysDataGridView1
            // 
            this.ucEduSysDataGridView1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucEduSysDataGridView1.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEduSysDataGridView1.Location = new System.Drawing.Point(3, 42);
            this.ucEduSysDataGridView1.Name = "ucEduSysDataGridView1";
            this.ucEduSysDataGridView1.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEduSysDataGridView1.Size = new System.Drawing.Size(632, 320);
            this.ucEduSysDataGridView1.TabIndex = 5;
            // 
            // ucGeneralReservations
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.ucEduSysDataGridView1);
            this.Controls.Add(this.labelDepartments);
            this.Controls.Add(this.comboboxDepartments);
            this.Controls.Add(this.buttonSearchGeneralReservations);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucGeneralReservations";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(638, 362);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonSearchGeneralReservations;
        private System.Windows.Forms.ComboBox comboboxDepartments;
        private System.Windows.Forms.Label labelDepartments;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnClassName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnEmail;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPhone;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnText;
        private Controls.Uc.Common.UcEduSysDataGridView ucEduSysDataGridView1;
    }
}
