namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common
{
    partial class UcCrudToolbar
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
            this.toolstripMain = new System.Windows.Forms.ToolStrip();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.toolstripbuttonAdd = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonEdit = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonDelete = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonRefresh = new System.Windows.Forms.ToolStripButton();
            this.toolstripMain.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolstripMain
            // 
            this.toolstripMain.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolstripMain.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripbuttonRefresh,
            this.toolStripSeparator1,
            this.toolstripbuttonAdd,
            this.toolstripbuttonEdit,
            this.toolstripbuttonDelete});
            this.toolstripMain.Location = new System.Drawing.Point(0, 0);
            this.toolstripMain.Name = "toolstripMain";
            this.toolstripMain.Size = new System.Drawing.Size(513, 25);
            this.toolstripMain.TabIndex = 0;
            this.toolstripMain.Text = "toolStrip1";
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // toolstripbuttonAdd
            // 
            this.toolstripbuttonAdd.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonAdd.Name = "toolstripbuttonAdd";
            this.toolstripbuttonAdd.Size = new System.Drawing.Size(52, 22);
            this.toolstripbuttonAdd.Text = "جدید";
            this.toolstripbuttonAdd.Click += new System.EventHandler(this.toolstripbuttonAdd_Click);
            // 
            // toolstripbuttonEdit
            // 
            this.toolstripbuttonEdit.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonEdit.Name = "toolstripbuttonEdit";
            this.toolstripbuttonEdit.Size = new System.Drawing.Size(62, 22);
            this.toolstripbuttonEdit.Text = "ویرایش";
            this.toolstripbuttonEdit.Click += new System.EventHandler(this.toolstripbuttonEdit_Click);
            // 
            // toolstripbuttonDelete
            // 
            this.toolstripbuttonDelete.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonDelete.Name = "toolstripbuttonDelete";
            this.toolstripbuttonDelete.Size = new System.Drawing.Size(52, 22);
            this.toolstripbuttonDelete.Text = "حذف";
            this.toolstripbuttonDelete.Click += new System.EventHandler(this.toolstripbuttonDelete_Click);
            // 
            // toolstripbuttonRefresh
            //           
            this.toolstripbuttonRefresh.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonRefresh.Name = "toolstripbuttonRefresh";
            this.toolstripbuttonRefresh.Size = new System.Drawing.Size(101, 22);
            this.toolstripbuttonRefresh.Text = "بازآوری داده ها";
            this.toolstripbuttonRefresh.Click += new System.EventHandler(this.toolstripbuttonRefresh_Click);
            // 
            // ucCrudToolbar
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.toolstripMain);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucCrudToolbar";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(513, 33);
            this.toolstripMain.ResumeLayout(false);
            this.toolstripMain.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolstripMain;
        private System.Windows.Forms.ToolStripButton toolstripbuttonAdd;
        private System.Windows.Forms.ToolStripButton toolstripbuttonEdit;
        private System.Windows.Forms.ToolStripButton toolstripbuttonDelete;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripButton toolstripbuttonRefresh;
    }
}
