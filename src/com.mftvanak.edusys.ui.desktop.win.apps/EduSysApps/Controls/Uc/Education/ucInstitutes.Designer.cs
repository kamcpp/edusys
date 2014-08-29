namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcInstitutes
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
            this.datagridviewInstitutes = new System.Windows.Forms.DataGridView();
            this.ucCrudToolbar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar();
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnPersianName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnWebUrl1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewInstitutes)).BeginInit();
            this.SuspendLayout();
            // 
            // datagridviewInstitutes
            // 
            this.datagridviewInstitutes.AllowUserToAddRows = false;
            this.datagridviewInstitutes.AllowUserToDeleteRows = false;
            this.datagridviewInstitutes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewInstitutes.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnId,
            this.columnPersianName,
            this.columnWebUrl1});
            this.datagridviewInstitutes.Dock = System.Windows.Forms.DockStyle.Fill;
            this.datagridviewInstitutes.Location = new System.Drawing.Point(0, 34);
            this.datagridviewInstitutes.MultiSelect = false;
            this.datagridviewInstitutes.Name = "datagridviewInstitutes";
            this.datagridviewInstitutes.ReadOnly = true;
            this.datagridviewInstitutes.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.datagridviewInstitutes.RowHeadersVisible = false;
            this.datagridviewInstitutes.Size = new System.Drawing.Size(547, 272);
            this.datagridviewInstitutes.TabIndex = 4;
            this.datagridviewInstitutes.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridviewInstitutes_CellDoubleClick);
            // 
            // ucCrudToolbar
            // 
            this.ucCrudToolbar.BackColor = System.Drawing.Color.Transparent;
            this.ucCrudToolbar.Dock = System.Windows.Forms.DockStyle.Top;
            this.ucCrudToolbar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucCrudToolbar.Location = new System.Drawing.Point(0, 0);
            this.ucCrudToolbar.Name = "ucCrudToolbar";
            this.ucCrudToolbar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucCrudToolbar.Size = new System.Drawing.Size(547, 34);
            this.ucCrudToolbar.TabIndex = 3;
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
            // columnPersianName
            // 
            this.columnPersianName.HeaderText = "نام موسسه";
            this.columnPersianName.Name = "columnPersianName";
            this.columnPersianName.ReadOnly = true;
            this.columnPersianName.Width = 200;
            // 
            // columnWebUrl1
            // 
            this.columnWebUrl1.HeaderText = "آدرس وب";
            this.columnWebUrl1.Name = "columnWebUrl1";
            this.columnWebUrl1.ReadOnly = true;
            this.columnWebUrl1.Width = 200;
            // 
            // ucInstitutes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.datagridviewInstitutes);
            this.Controls.Add(this.ucCrudToolbar);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucInstitutes";
            this.Size = new System.Drawing.Size(547, 306);
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewInstitutes)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Common.UcCrudToolbar ucCrudToolbar;
        private System.Windows.Forms.DataGridView datagridviewInstitutes;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPersianName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnWebUrl1;
    }
}
