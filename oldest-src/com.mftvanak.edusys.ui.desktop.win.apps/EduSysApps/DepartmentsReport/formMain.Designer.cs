namespace DepartmentsReport
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
            this.tabcontrolmain = new System.Windows.Forms.TabControl();
            this.tabpageDepartmentsReport = new System.Windows.Forms.TabPage();
            this.labelEnd = new System.Windows.Forms.Label();
            this.maskedtextboxEnd = new System.Windows.Forms.MaskedTextBox();
            this.maskedtextboxStart = new System.Windows.Forms.MaskedTextBox();
            this.labelStart = new System.Windows.Forms.Label();
            this.buttonRefresh = new System.Windows.Forms.Button();
            this.datagridviewDepartmentsReport = new System.Windows.Forms.DataGridView();
            this.tabpageDepartmentDetails = new System.Windows.Forms.TabPage();
            this.labelDepartmentCode = new System.Windows.Forms.Label();
            this.labelEnd2 = new System.Windows.Forms.Label();
            this.maskedtextboxEnd2 = new System.Windows.Forms.MaskedTextBox();
            this.maskedtextboxStart2 = new System.Windows.Forms.MaskedTextBox();
            this.labelStart2 = new System.Windows.Forms.Label();
            this.buttonRefresh2 = new System.Windows.Forms.Button();
            this.datagridviewDetails = new System.Windows.Forms.DataGridView();
            this.comboboxDepartments = new System.Windows.Forms.ComboBox();
            this.tabcontrolmain.SuspendLayout();
            this.tabpageDepartmentsReport.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDepartmentsReport)).BeginInit();
            this.tabpageDepartmentDetails.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDetails)).BeginInit();
            this.SuspendLayout();
            // 
            // tabcontrolmain
            // 
            this.tabcontrolmain.Controls.Add(this.tabpageDepartmentsReport);
            this.tabcontrolmain.Controls.Add(this.tabpageDepartmentDetails);
            this.tabcontrolmain.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabcontrolmain.Location = new System.Drawing.Point(0, 0);
            this.tabcontrolmain.Name = "tabcontrolmain";
            this.tabcontrolmain.SelectedIndex = 0;
            this.tabcontrolmain.Size = new System.Drawing.Size(644, 354);
            this.tabcontrolmain.TabIndex = 0;
            // 
            // tabpageDepartmentsReport
            // 
            this.tabpageDepartmentsReport.Controls.Add(this.labelEnd);
            this.tabpageDepartmentsReport.Controls.Add(this.maskedtextboxEnd);
            this.tabpageDepartmentsReport.Controls.Add(this.maskedtextboxStart);
            this.tabpageDepartmentsReport.Controls.Add(this.labelStart);
            this.tabpageDepartmentsReport.Controls.Add(this.buttonRefresh);
            this.tabpageDepartmentsReport.Controls.Add(this.datagridviewDepartmentsReport);
            this.tabpageDepartmentsReport.Location = new System.Drawing.Point(4, 22);
            this.tabpageDepartmentsReport.Name = "tabpageDepartmentsReport";
            this.tabpageDepartmentsReport.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageDepartmentsReport.Size = new System.Drawing.Size(627, 348);
            this.tabpageDepartmentsReport.TabIndex = 0;
            this.tabpageDepartmentsReport.Text = "Departments Report";
            this.tabpageDepartmentsReport.UseVisualStyleBackColor = true;
            // 
            // labelEnd
            // 
            this.labelEnd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelEnd.AutoSize = true;
            this.labelEnd.Location = new System.Drawing.Point(517, 13);
            this.labelEnd.Name = "labelEnd";
            this.labelEnd.Size = new System.Drawing.Size(29, 13);
            this.labelEnd.TabIndex = 6;
            this.labelEnd.Text = "End:";
            // 
            // maskedtextboxEnd
            // 
            this.maskedtextboxEnd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.maskedtextboxEnd.Location = new System.Drawing.Point(552, 10);
            this.maskedtextboxEnd.Mask = "00/00/00";
            this.maskedtextboxEnd.Name = "maskedtextboxEnd";
            this.maskedtextboxEnd.Size = new System.Drawing.Size(67, 21);
            this.maskedtextboxEnd.TabIndex = 5;
            this.maskedtextboxEnd.Text = "930431";
            // 
            // maskedtextboxStart
            // 
            this.maskedtextboxStart.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.maskedtextboxStart.Location = new System.Drawing.Point(443, 10);
            this.maskedtextboxStart.Mask = "00/00/00";
            this.maskedtextboxStart.Name = "maskedtextboxStart";
            this.maskedtextboxStart.Size = new System.Drawing.Size(67, 21);
            this.maskedtextboxStart.TabIndex = 4;
            this.maskedtextboxStart.Text = "930401";
            // 
            // labelStart
            // 
            this.labelStart.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelStart.AutoSize = true;
            this.labelStart.Location = new System.Drawing.Point(405, 13);
            this.labelStart.Name = "labelStart";
            this.labelStart.Size = new System.Drawing.Size(35, 13);
            this.labelStart.TabIndex = 3;
            this.labelStart.Text = "Start:";
            // 
            // buttonRefresh
            // 
            this.buttonRefresh.Location = new System.Drawing.Point(8, 6);
            this.buttonRefresh.Name = "buttonRefresh";
            this.buttonRefresh.Size = new System.Drawing.Size(88, 27);
            this.buttonRefresh.TabIndex = 1;
            this.buttonRefresh.Text = "Refresh";
            this.buttonRefresh.UseVisualStyleBackColor = true;
            this.buttonRefresh.Click += new System.EventHandler(this.buttonRefresh_Click);
            // 
            // datagridviewDepartmentsReport
            // 
            this.datagridviewDepartmentsReport.AllowUserToAddRows = false;
            this.datagridviewDepartmentsReport.AllowUserToDeleteRows = false;
            this.datagridviewDepartmentsReport.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridviewDepartmentsReport.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.datagridviewDepartmentsReport.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewDepartmentsReport.Location = new System.Drawing.Point(8, 35);
            this.datagridviewDepartmentsReport.MultiSelect = false;
            this.datagridviewDepartmentsReport.Name = "datagridviewDepartmentsReport";
            this.datagridviewDepartmentsReport.ReadOnly = true;
            this.datagridviewDepartmentsReport.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.datagridviewDepartmentsReport.Size = new System.Drawing.Size(613, 307);
            this.datagridviewDepartmentsReport.TabIndex = 0;
            // 
            // tabpageDepartmentDetails
            // 
            this.tabpageDepartmentDetails.Controls.Add(this.comboboxDepartments);
            this.tabpageDepartmentDetails.Controls.Add(this.labelDepartmentCode);
            this.tabpageDepartmentDetails.Controls.Add(this.labelEnd2);
            this.tabpageDepartmentDetails.Controls.Add(this.maskedtextboxEnd2);
            this.tabpageDepartmentDetails.Controls.Add(this.maskedtextboxStart2);
            this.tabpageDepartmentDetails.Controls.Add(this.labelStart2);
            this.tabpageDepartmentDetails.Controls.Add(this.buttonRefresh2);
            this.tabpageDepartmentDetails.Controls.Add(this.datagridviewDetails);
            this.tabpageDepartmentDetails.Location = new System.Drawing.Point(4, 22);
            this.tabpageDepartmentDetails.Name = "tabpageDepartmentDetails";
            this.tabpageDepartmentDetails.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageDepartmentDetails.Size = new System.Drawing.Size(636, 328);
            this.tabpageDepartmentDetails.TabIndex = 1;
            this.tabpageDepartmentDetails.Text = "Department Details";
            this.tabpageDepartmentDetails.UseVisualStyleBackColor = true;
            // 
            // labelDepartmentCode
            // 
            this.labelDepartmentCode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDepartmentCode.AutoSize = true;
            this.labelDepartmentCode.Location = new System.Drawing.Point(243, 13);
            this.labelDepartmentCode.Name = "labelDepartmentCode";
            this.labelDepartmentCode.Size = new System.Drawing.Size(96, 13);
            this.labelDepartmentCode.TabIndex = 14;
            this.labelDepartmentCode.Text = "Department Code:";
            // 
            // labelEnd2
            // 
            this.labelEnd2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelEnd2.AutoSize = true;
            this.labelEnd2.Location = new System.Drawing.Point(525, 13);
            this.labelEnd2.Name = "labelEnd2";
            this.labelEnd2.Size = new System.Drawing.Size(29, 13);
            this.labelEnd2.TabIndex = 12;
            this.labelEnd2.Text = "End:";
            // 
            // maskedtextboxEnd2
            // 
            this.maskedtextboxEnd2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.maskedtextboxEnd2.Location = new System.Drawing.Point(560, 10);
            this.maskedtextboxEnd2.Mask = "00/00/00";
            this.maskedtextboxEnd2.Name = "maskedtextboxEnd2";
            this.maskedtextboxEnd2.Size = new System.Drawing.Size(67, 21);
            this.maskedtextboxEnd2.TabIndex = 11;
            this.maskedtextboxEnd2.Text = "930431";
            // 
            // maskedtextboxStart2
            // 
            this.maskedtextboxStart2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.maskedtextboxStart2.Location = new System.Drawing.Point(451, 10);
            this.maskedtextboxStart2.Mask = "00/00/00";
            this.maskedtextboxStart2.Name = "maskedtextboxStart2";
            this.maskedtextboxStart2.Size = new System.Drawing.Size(67, 21);
            this.maskedtextboxStart2.TabIndex = 10;
            this.maskedtextboxStart2.Text = "930401";
            // 
            // labelStart2
            // 
            this.labelStart2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelStart2.AutoSize = true;
            this.labelStart2.Location = new System.Drawing.Point(413, 13);
            this.labelStart2.Name = "labelStart2";
            this.labelStart2.Size = new System.Drawing.Size(35, 13);
            this.labelStart2.TabIndex = 9;
            this.labelStart2.Text = "Start:";
            // 
            // buttonRefresh2
            // 
            this.buttonRefresh2.Location = new System.Drawing.Point(7, 6);
            this.buttonRefresh2.Name = "buttonRefresh2";
            this.buttonRefresh2.Size = new System.Drawing.Size(88, 27);
            this.buttonRefresh2.TabIndex = 8;
            this.buttonRefresh2.Text = "Refresh";
            this.buttonRefresh2.UseVisualStyleBackColor = true;
            this.buttonRefresh2.Click += new System.EventHandler(this.buttonRefresh2_Click);
            // 
            // datagridviewDetails
            // 
            this.datagridviewDetails.AllowUserToAddRows = false;
            this.datagridviewDetails.AllowUserToDeleteRows = false;
            this.datagridviewDetails.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridviewDetails.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.datagridviewDetails.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewDetails.Location = new System.Drawing.Point(7, 35);
            this.datagridviewDetails.MultiSelect = false;
            this.datagridviewDetails.Name = "datagridviewDetails";
            this.datagridviewDetails.ReadOnly = true;
            this.datagridviewDetails.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.datagridviewDetails.Size = new System.Drawing.Size(622, 287);
            this.datagridviewDetails.TabIndex = 7;
            // 
            // comboboxDepartments
            // 
            this.comboboxDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxDepartments.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxDepartments.FormattingEnabled = true;
            this.comboboxDepartments.Location = new System.Drawing.Point(345, 10);
            this.comboboxDepartments.Name = "comboboxDepartments";
            this.comboboxDepartments.Size = new System.Drawing.Size(62, 21);
            this.comboboxDepartments.TabIndex = 15;
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(644, 354);
            this.Controls.Add(this.tabcontrolmain);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "formMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Departments Report";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.tabcontrolmain.ResumeLayout(false);
            this.tabpageDepartmentsReport.ResumeLayout(false);
            this.tabpageDepartmentsReport.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDepartmentsReport)).EndInit();
            this.tabpageDepartmentDetails.ResumeLayout(false);
            this.tabpageDepartmentDetails.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewDetails)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabcontrolmain;
        private System.Windows.Forms.TabPage tabpageDepartmentsReport;
        private System.Windows.Forms.Button buttonRefresh;
        private System.Windows.Forms.DataGridView datagridviewDepartmentsReport;
        private System.Windows.Forms.TabPage tabpageDepartmentDetails;
        private System.Windows.Forms.Label labelEnd;
        private System.Windows.Forms.MaskedTextBox maskedtextboxEnd;
        private System.Windows.Forms.MaskedTextBox maskedtextboxStart;
        private System.Windows.Forms.Label labelStart;
        private System.Windows.Forms.Label labelDepartmentCode;
        private System.Windows.Forms.Label labelEnd2;
        private System.Windows.Forms.MaskedTextBox maskedtextboxEnd2;
        private System.Windows.Forms.MaskedTextBox maskedtextboxStart2;
        private System.Windows.Forms.Label labelStart2;
        private System.Windows.Forms.Button buttonRefresh2;
        private System.Windows.Forms.DataGridView datagridviewDetails;
        private System.Windows.Forms.ComboBox comboboxDepartments;
    }
}

