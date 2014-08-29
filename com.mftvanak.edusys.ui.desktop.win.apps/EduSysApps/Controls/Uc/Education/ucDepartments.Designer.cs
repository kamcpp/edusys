namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcDepartments
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
            this.datagridviewDepartments = new System.Windows.Forms.DataGridView();
            this.ucCrudToolbar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar();
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnEnglishName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnColor = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnOrder = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDepartments)).BeginInit();
            this.SuspendLayout();
            // 
            // datagridviewDepartments
            // 
            this.datagridviewDepartments.AllowUserToAddRows = false;
            this.datagridviewDepartments.AllowUserToDeleteRows = false;
            this.datagridviewDepartments.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewDepartments.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnId,
            this.columnName,
            this.columnEnglishName,
            this.columnColor,
            this.columnOrder});
            this.datagridviewDepartments.Dock = System.Windows.Forms.DockStyle.Fill;
            this.datagridviewDepartments.Location = new System.Drawing.Point(0, 33);
            this.datagridviewDepartments.Name = "datagridviewDepartments";
            this.datagridviewDepartments.ReadOnly = true;
            this.datagridviewDepartments.Size = new System.Drawing.Size(631, 255);
            this.datagridviewDepartments.TabIndex = 1;
            this.datagridviewDepartments.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridviewDepartments_CellDoubleClick);
            // 
            // ucCrudToolbar
            // 
            this.ucCrudToolbar.BackColor = System.Drawing.Color.Transparent;
            this.ucCrudToolbar.Dock = System.Windows.Forms.DockStyle.Top;
            this.ucCrudToolbar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucCrudToolbar.Location = new System.Drawing.Point(0, 0);
            this.ucCrudToolbar.Name = "ucCrudToolbar";
            this.ucCrudToolbar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucCrudToolbar.Size = new System.Drawing.Size(631, 33);
            this.ucCrudToolbar.TabIndex = 0;
            this.ucCrudToolbar.AfterAddClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterAddClickedEventHandler(this.ucCrudToolbar_AfterAddClicked);
            this.ucCrudToolbar.AfterEditClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterEditClickedEventHandler(this.ucCrudToolbar_AfterEditClicked);
            this.ucCrudToolbar.AfterRefreshClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterRefreshClickedEventHandler(this.ucCrudToolbar_AfterRefreshClicked);
            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 50;
            // 
            // columnId
            // 
            this.columnId.HeaderText = "مشخصه";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            this.columnId.Width = 70;
            // 
            // columnName
            // 
            this.columnName.HeaderText = "نام";
            this.columnName.Name = "columnName";
            this.columnName.ReadOnly = true;
            this.columnName.Width = 250;
            // 
            // columnEnglishName
            // 
            this.columnEnglishName.HeaderText = "نام انگلیسی";
            this.columnEnglishName.Name = "columnEnglishName";
            this.columnEnglishName.ReadOnly = true;
            this.columnEnglishName.Width = 250;
            // 
            // columnColor
            // 
            this.columnColor.HeaderText = "رنگ";
            this.columnColor.Name = "columnColor";
            this.columnColor.ReadOnly = true;
            // 
            // columnOrder
            // 
            this.columnOrder.HeaderText = "ترتیب";
            this.columnOrder.Name = "columnOrder";
            this.columnOrder.ReadOnly = true;
            this.columnOrder.Width = 50;
            // 
            // ucDepartments
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.datagridviewDepartments);
            this.Controls.Add(this.ucCrudToolbar);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucDepartments";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(631, 288);
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDepartments)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Common.UcCrudToolbar ucCrudToolbar;
        private System.Windows.Forms.DataGridView datagridviewDepartments;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnEnglishName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnColor;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnOrder;
    }
}
