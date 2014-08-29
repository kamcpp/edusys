namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging
{
    partial class UcAssignedTodoItems
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UcAssignedTodoItems));
            this.datagridviewTodoItems = new System.Windows.Forms.DataGridView();
            this.toolstrip = new System.Windows.Forms.ToolStrip();
            this.toolstripbuttonRefresh = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonNewTodoItem = new System.Windows.Forms.ToolStripButton();
            this.imageList = new System.Windows.Forms.ImageList(this.components);
            this.columnCounter = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnCategory = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDone = new System.Windows.Forms.DataGridViewImageColumn();
            this.columnPriority = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnSubmitDateTime = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnReceiverFullName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDeadlineDateTime = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnSubject = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnResponse = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDescription = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewTodoItems)).BeginInit();
            this.toolstrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // datagridviewTodoItems
            // 
            this.datagridviewTodoItems.AllowUserToAddRows = false;
            this.datagridviewTodoItems.AllowUserToDeleteRows = false;
            this.datagridviewTodoItems.AllowUserToResizeRows = false;
            this.datagridviewTodoItems.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.datagridviewTodoItems.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewTodoItems.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnCounter,
            this.columnCategory,
            this.columnDone,
            this.columnPriority,
            this.columnSubmitDateTime,
            this.columnReceiverFullName,
            this.columnDeadlineDateTime,
            this.columnSubject,
            this.columnResponse,
            this.columnDescription,
            this.columnId});
            this.datagridviewTodoItems.Location = new System.Drawing.Point(0, 28);
            this.datagridviewTodoItems.MultiSelect = false;
            this.datagridviewTodoItems.Name = "datagridviewTodoItems";
            this.datagridviewTodoItems.ReadOnly = true;
            this.datagridviewTodoItems.RowHeadersVisible = false;
            this.datagridviewTodoItems.Size = new System.Drawing.Size(818, 330);
            this.datagridviewTodoItems.TabIndex = 0;
            this.datagridviewTodoItems.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridviewTodoItems_CellDoubleClick);
            // 
            // toolstrip
            // 
            this.toolstrip.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolstrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripbuttonRefresh,
            this.toolstripbuttonNewTodoItem});
            this.toolstrip.Location = new System.Drawing.Point(0, 0);
            this.toolstrip.Name = "toolstrip";
            this.toolstrip.Size = new System.Drawing.Size(818, 25);
            this.toolstrip.TabIndex = 1;
            this.toolstrip.Text = "toolStrip1";
            // 
            // toolstripbuttonRefresh
            // 
            this.toolstripbuttonRefresh.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolstripbuttonRefresh.Image = ((System.Drawing.Image)(resources.GetObject("toolstripbuttonRefresh.Image")));
            this.toolstripbuttonRefresh.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonRefresh.Name = "toolstripbuttonRefresh";
            this.toolstripbuttonRefresh.Size = new System.Drawing.Size(44, 22);
            this.toolstripbuttonRefresh.Text = "بازآوری";
            this.toolstripbuttonRefresh.Click += new System.EventHandler(this.toolstripbuttonRefresh_Click);
            // 
            // toolstripbuttonNewTodoItem
            // 
            this.toolstripbuttonNewTodoItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolstripbuttonNewTodoItem.Image = ((System.Drawing.Image)(resources.GetObject("toolstripbuttonNewTodoItem.Image")));
            this.toolstripbuttonNewTodoItem.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonNewTodoItem.Name = "toolstripbuttonNewTodoItem";
            this.toolstripbuttonNewTodoItem.Size = new System.Drawing.Size(86, 22);
            this.toolstripbuttonNewTodoItem.Text = "تعریف کار جدید";
            this.toolstripbuttonNewTodoItem.Click += new System.EventHandler(this.toolstripbuttonNewTodoItem_Click);
            // 
            // imageList
            // 
            this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
            this.imageList.TransparentColor = System.Drawing.Color.Transparent;
            this.imageList.Images.SetKeyName(0, "done.png");
            this.imageList.Images.SetKeyName(1, "not-done.png");
            // 
            // columnCounter
            // 
            this.columnCounter.HeaderText = "ردیف";
            this.columnCounter.Name = "columnCounter";
            this.columnCounter.ReadOnly = true;
            this.columnCounter.Width = 50;
            // 
            // columnCategory
            // 
            this.columnCategory.HeaderText = "";
            this.columnCategory.Name = "columnCategory";
            this.columnCategory.ReadOnly = true;
            this.columnCategory.Width = 30;
            // 
            // columnDone
            // 
            this.columnDone.HeaderText = "وضعیت";
            this.columnDone.Name = "columnDone";
            this.columnDone.ReadOnly = true;
            this.columnDone.Width = 50;
            // 
            // columnPriority
            // 
            this.columnPriority.HeaderText = "اولویت";
            this.columnPriority.Name = "columnPriority";
            this.columnPriority.ReadOnly = true;
            // 
            // columnSubmitDateTime
            // 
            this.columnSubmitDateTime.HeaderText = "تاریخ درج";
            this.columnSubmitDateTime.Name = "columnSubmitDateTime";
            this.columnSubmitDateTime.ReadOnly = true;
            this.columnSubmitDateTime.Width = 150;
            // 
            // columnReceiverFullName
            // 
            this.columnReceiverFullName.HeaderText = "نام گیرنده";
            this.columnReceiverFullName.Name = "columnReceiverFullName";
            this.columnReceiverFullName.ReadOnly = true;
            this.columnReceiverFullName.Width = 200;
            // 
            // columnDeadlineDateTime
            // 
            this.columnDeadlineDateTime.HeaderText = "تاریخ نهایی";
            this.columnDeadlineDateTime.Name = "columnDeadlineDateTime";
            this.columnDeadlineDateTime.ReadOnly = true;
            this.columnDeadlineDateTime.Width = 150;
            // 
            // columnSubject
            // 
            this.columnSubject.HeaderText = "موضوع";
            this.columnSubject.Name = "columnSubject";
            this.columnSubject.ReadOnly = true;
            this.columnSubject.Width = 200;
            // 
            // columnResponse
            // 
            this.columnResponse.HeaderText = "پاسخ";
            this.columnResponse.Name = "columnResponse";
            this.columnResponse.ReadOnly = true;
            this.columnResponse.Width = 200;
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
            this.columnId.HeaderText = "مشخصه پایگاه داده";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            this.columnId.Width = 150;
            // 
            // ucAssignedTodoItems
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.toolstrip);
            this.Controls.Add(this.datagridviewTodoItems);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucAssignedTodoItems";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(818, 358);
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewTodoItems)).EndInit();
            this.toolstrip.ResumeLayout(false);
            this.toolstrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView datagridviewTodoItems;
        private System.Windows.Forms.ToolStrip toolstrip;
        private System.Windows.Forms.ToolStripButton toolstripbuttonRefresh;
        private System.Windows.Forms.ToolStripButton toolstripbuttonNewTodoItem;
        private System.Windows.Forms.ImageList imageList;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnCounter;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnCategory;
        private System.Windows.Forms.DataGridViewImageColumn columnDone;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnPriority;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnSubmitDateTime;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnReceiverFullName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDeadlineDateTime;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnSubject;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnResponse;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDescription;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
    }
}
