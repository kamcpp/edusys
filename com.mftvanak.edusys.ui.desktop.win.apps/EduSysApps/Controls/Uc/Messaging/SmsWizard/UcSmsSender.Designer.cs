namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcSmsSender
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UcSmsSender));
            this.datagridviewSmsEntries = new System.Windows.Forms.DataGridView();
            this.progressbarSend = new System.Windows.Forms.ProgressBar();
            this.labelReport = new System.Windows.Forms.Label();
            this.imageList = new System.Windows.Forms.ImageList(this.components);
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnStatus = new System.Windows.Forms.DataGridViewImageColumn();
            this.columnTo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnReport = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewSmsEntries)).BeginInit();
            this.SuspendLayout();
            // 
            // datagridviewSmsEntries
            // 
            this.datagridviewSmsEntries.AllowUserToAddRows = false;
            this.datagridviewSmsEntries.AllowUserToDeleteRows = false;
            this.datagridviewSmsEntries.AllowUserToResizeRows = false;
            this.datagridviewSmsEntries.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridviewSmsEntries.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.datagridviewSmsEntries.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewSmsEntries.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnStatus,
            this.columnTo,
            this.columnReport});
            this.datagridviewSmsEntries.Location = new System.Drawing.Point(3, 3);
            this.datagridviewSmsEntries.Name = "datagridviewSmsEntries";
            this.datagridviewSmsEntries.ReadOnly = true;
            this.datagridviewSmsEntries.RowHeadersVisible = false;
            this.datagridviewSmsEntries.Size = new System.Drawing.Size(616, 333);
            this.datagridviewSmsEntries.TabIndex = 0;
            // 
            // progressbarSend
            // 
            this.progressbarSend.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.progressbarSend.Location = new System.Drawing.Point(3, 357);
            this.progressbarSend.Name = "progressbarSend";
            this.progressbarSend.Size = new System.Drawing.Size(616, 12);
            this.progressbarSend.TabIndex = 3;
            // 
            // labelReport
            // 
            this.labelReport.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.labelReport.Location = new System.Drawing.Point(6, 339);
            this.labelReport.Name = "labelReport";
            this.labelReport.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.labelReport.Size = new System.Drawing.Size(616, 15);
            this.labelReport.TabIndex = 4;
            this.labelReport.Text = "پیغام ...";
            // 
            // imageList
            // 
            this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
            this.imageList.TransparentColor = System.Drawing.Color.Transparent;
            this.imageList.Images.SetKeyName(0, "email.png");
            this.imageList.Images.SetKeyName(1, "done.png");
            this.imageList.Images.SetKeyName(2, "not-done.png");
            // 
            // columnNumber
            // 
            this.columnNumber.FillWeight = 10F;
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            // 
            // columnStatus
            // 
            this.columnStatus.FillWeight = 5F;
            this.columnStatus.HeaderText = "";
            this.columnStatus.Name = "columnStatus";
            this.columnStatus.ReadOnly = true;
            // 
            // columnTo
            // 
            this.columnTo.FillWeight = 50F;
            this.columnTo.HeaderText = "اطلاعات";
            this.columnTo.Name = "columnTo";
            this.columnTo.ReadOnly = true;
            // 
            // columnReport
            // 
            this.columnReport.FillWeight = 35F;
            this.columnReport.HeaderText = "گزارش";
            this.columnReport.Name = "columnReport";
            this.columnReport.ReadOnly = true;
            // 
            // UcSmsSender
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.labelReport);
            this.Controls.Add(this.progressbarSend);
            this.Controls.Add(this.datagridviewSmsEntries);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcSmsSender";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(624, 374);
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewSmsEntries)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView datagridviewSmsEntries;
        private System.Windows.Forms.ProgressBar progressbarSend;
        private System.Windows.Forms.Label labelReport;
        private System.Windows.Forms.ImageList imageList;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewImageColumn columnStatus;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnTo;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnReport;
    }
}
