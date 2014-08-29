namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    partial class UcMyPhoneEntries
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UcMyPhoneEntries));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.toolstripbuttonNewPhoneEntry = new System.Windows.Forms.ToolStripButton();
            this.toolstripbuttonEditPhoneEntry = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.toolstripbuttonRefreshLatestPhoneEntires = new System.Windows.Forms.ToolStripButton();
            this.ucPhoneEntries = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcPhoneEntries();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripbuttonNewPhoneEntry,
            this.toolstripbuttonEditPhoneEntry,
            this.toolStripSeparator1,
            this.toolstripbuttonRefreshLatestPhoneEntires});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(669, 25);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toolstripbuttonNewPhoneEntry
            // 
            this.toolstripbuttonNewPhoneEntry.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolstripbuttonNewPhoneEntry.Image = ((System.Drawing.Image)(resources.GetObject("toolstripbuttonNewPhoneEntry.Image")));
            this.toolstripbuttonNewPhoneEntry.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonNewPhoneEntry.Name = "toolstripbuttonNewPhoneEntry";
            this.toolstripbuttonNewPhoneEntry.Size = new System.Drawing.Size(62, 22);
            this.toolstripbuttonNewPhoneEntry.Text = "تلفن جدید";
            this.toolstripbuttonNewPhoneEntry.Click += new System.EventHandler(this.toolstripbuttonNewPhoneEntry_Click);
            // 
            // toolstripbuttonEditPhoneEntry
            // 
            this.toolstripbuttonEditPhoneEntry.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolstripbuttonEditPhoneEntry.Image = ((System.Drawing.Image)(resources.GetObject("toolstripbuttonEditPhoneEntry.Image")));
            this.toolstripbuttonEditPhoneEntry.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonEditPhoneEntry.Name = "toolstripbuttonEditPhoneEntry";
            this.toolstripbuttonEditPhoneEntry.Size = new System.Drawing.Size(72, 22);
            this.toolstripbuttonEditPhoneEntry.Text = "ویرایش تلفن";
            this.toolstripbuttonEditPhoneEntry.Click += new System.EventHandler(this.toolstripbuttonEditPhoneEntry_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // toolstripbuttonRefreshLatestPhoneEntires
            // 
            this.toolstripbuttonRefreshLatestPhoneEntires.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.toolstripbuttonRefreshLatestPhoneEntires.Image = ((System.Drawing.Image)(resources.GetObject("toolstripbuttonRefreshLatestPhoneEntires.Image")));
            this.toolstripbuttonRefreshLatestPhoneEntires.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolstripbuttonRefreshLatestPhoneEntires.Name = "toolstripbuttonRefreshLatestPhoneEntires";
            this.toolstripbuttonRefreshLatestPhoneEntires.Size = new System.Drawing.Size(44, 22);
            this.toolstripbuttonRefreshLatestPhoneEntires.Text = "بازآوری";
            this.toolstripbuttonRefreshLatestPhoneEntires.Click += new System.EventHandler(this.toolstripbuttonRefreshLatestPhoneEntires_Click);
            // 
            // ucPhoneEntries
            // 
            this.ucPhoneEntries.AutoRefresh = true;
            this.ucPhoneEntries.BackColor = System.Drawing.Color.Transparent;
            this.ucPhoneEntries.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucPhoneEntries.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucPhoneEntries.Location = new System.Drawing.Point(0, 25);
            this.ucPhoneEntries.Name = "ucPhoneEntries";
            this.ucPhoneEntries.PhoneEntries = null;
            this.ucPhoneEntries.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucPhoneEntries.Size = new System.Drawing.Size(669, 309);
            this.ucPhoneEntries.TabIndex = 1;
            this.ucPhoneEntries.DataRefteshNeeded += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcPhoneEntries.DataRefreshNeededEventHandler(this.ucPhoneEntries_DataRefteshNeeded);
            // 
            // ucMyPhoneEntries
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.ucPhoneEntries);
            this.Controls.Add(this.toolStrip1);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucMyPhoneEntries";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(669, 334);
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton toolstripbuttonNewPhoneEntry;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripButton toolstripbuttonRefreshLatestPhoneEntires;
        private System.Windows.Forms.ToolStripButton toolstripbuttonEditPhoneEntry;
        private UcPhoneEntries ucPhoneEntries;
    }
}
