namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Controls
{
    partial class ucEduSysDataGridView
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
            this.datagridview = new System.Windows.Forms.DataGridView();
            this.toolstrip = new System.Windows.Forms.ToolStrip();
            this.toolstripbuttonExportToExcel = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.toolstriplabelSearch = new System.Windows.Forms.ToolStripLabel();
            this.toolstriptextboxSearch = new System.Windows.Forms.ToolStripTextBox();
            this.labelNumberOfRecords = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.datagridview)).BeginInit();
            this.toolstrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // datagridview
            // 
            this.datagridview.AllowUserToAddRows = false;
            this.datagridview.AllowUserToDeleteRows = false;
            this.datagridview.AllowUserToResizeRows = false;
            this.datagridview.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridview.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridview.Location = new System.Drawing.Point(3, 28);
            this.datagridview.Name = "datagridview";
            this.datagridview.ReadOnly = true;
            this.datagridview.RowHeadersVisible = false;
            this.datagridview.Size = new System.Drawing.Size(752, 317);
            this.datagridview.TabIndex = 0;
            this.datagridview.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridview_CellDoubleClick);
            // 
            // toolstrip
            // 
            this.toolstrip.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolstrip.GripStyle = System.Windows.Forms.ToolStripGripStyle.Hidden;
            this.toolstrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripbuttonExportToExcel,
            this.toolStripButton1,
            this.toolStripButton2,
            this.toolStripSeparator2,
            this.toolstriplabelSearch,
            this.toolstriptextboxSearch});
            this.toolstrip.Location = new System.Drawing.Point(0, 0);
            this.toolstrip.Name = "toolstrip";
            this.toolstrip.Size = new System.Drawing.Size(758, 29);
            this.toolstrip.TabIndex = 1;
            this.toolstrip.Text = "toolStrip1";
            // 
            // toolstripbuttonExportToExcel
            // 
            this.toolstripbuttonExportToExcel.Enabled = false;
            this.toolstripbuttonExportToExcel.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.excel;
            this.toolstripbuttonExportToExcel.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.toolstripbuttonExportToExcel.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonExportToExcel.Name = "toolstripbuttonExportToExcel";
            this.toolstripbuttonExportToExcel.Size = new System.Drawing.Size(103, 26);
            this.toolstripbuttonExportToExcel.Text = "خروجی Excel";
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.Enabled = false;
            this.toolStripButton1.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.sms;
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(91, 26);
            this.toolStripButton1.Text = "ارسال پیامک";
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.Enabled = false;
            this.toolStripButton2.Image = global::Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Properties.Resources.email;
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(88, 26);
            this.toolStripButton2.Text = "ارسال ایمیل";
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(6, 29);
            // 
            // toolstriplabelSearch
            // 
            this.toolstriplabelSearch.Name = "toolstriplabelSearch";
            this.toolstriplabelSearch.Size = new System.Drawing.Size(65, 26);
            this.toolstriplabelSearch.Text = "جست و جو";
            // 
            // toolstriptextboxSearch
            // 
            this.toolstriptextboxSearch.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.toolstriptextboxSearch.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolstriptextboxSearch.Name = "toolstriptextboxSearch";
            this.toolstriptextboxSearch.Size = new System.Drawing.Size(150, 29);
            this.toolstriptextboxSearch.KeyDown += new System.Windows.Forms.KeyEventHandler(this.toolstriptextboxSearch_KeyDown);
            this.toolstriptextboxSearch.TextChanged += new System.EventHandler(this.toolstriptextboxSearch_TextChanged);
            // 
            // labelNumberOfRecords
            // 
            this.labelNumberOfRecords.AutoSize = true;
            this.labelNumberOfRecords.BackColor = System.Drawing.Color.Transparent;
            this.labelNumberOfRecords.Location = new System.Drawing.Point(16, 8);
            this.labelNumberOfRecords.Name = "labelNumberOfRecords";
            this.labelNumberOfRecords.Size = new System.Drawing.Size(80, 13);
            this.labelNumberOfRecords.TabIndex = 5;
            this.labelNumberOfRecords.Text = "تعداد رکوردها: 0";
            // 
            // ucEduSysDataGridView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.labelNumberOfRecords);
            this.Controls.Add(this.toolstrip);
            this.Controls.Add(this.datagridview);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucEduSysDataGridView";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(758, 348);
            ((System.ComponentModel.ISupportInitialize)(this.datagridview)).EndInit();
            this.toolstrip.ResumeLayout(false);
            this.toolstrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolstrip;
        private System.Windows.Forms.ToolStripLabel toolstriplabelSearch;
        private System.Windows.Forms.ToolStripTextBox toolstriptextboxSearch;
        private System.Windows.Forms.ToolStripButton toolstripbuttonExportToExcel;
        private System.Windows.Forms.DataGridView datagridview;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.Label labelNumberOfRecords;
    }
}
