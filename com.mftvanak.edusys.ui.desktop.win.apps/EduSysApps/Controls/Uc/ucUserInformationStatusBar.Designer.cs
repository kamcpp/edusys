namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc
{
    partial class UcUserInformationStatusBar
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
            this.statusStrip = new System.Windows.Forms.StatusStrip();
            this.toolstripstatuslabelUsername = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolstripstatuslabelFullName = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolStripStatusLabel2 = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolstripstatuslabelEmail = new System.Windows.Forms.ToolStripStatusLabel();
            this.statusStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // statusStrip
            // 
            this.statusStrip.Dock = System.Windows.Forms.DockStyle.Fill;
            this.statusStrip.Font = new System.Drawing.Font("Tahoma", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.statusStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolstripstatuslabelUsername,
            this.toolStripStatusLabel1,
            this.toolstripstatuslabelFullName,
            this.toolStripStatusLabel2,
            this.toolstripstatuslabelEmail});
            this.statusStrip.Location = new System.Drawing.Point(0, 0);
            this.statusStrip.Name = "statusStrip";
            this.statusStrip.RenderMode = System.Windows.Forms.ToolStripRenderMode.Professional;
            this.statusStrip.Size = new System.Drawing.Size(543, 22);
            this.statusStrip.SizingGrip = false;
            this.statusStrip.TabIndex = 0;
            // 
            // toolstripstatuslabelUsername
            // 
            this.toolstripstatuslabelUsername.Name = "toolstripstatuslabelUsername";
            this.toolstripstatuslabelUsername.Size = new System.Drawing.Size(13, 17);
            this.toolstripstatuslabelUsername.Text = "؟";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(11, 17);
            this.toolStripStatusLabel1.Text = "-";
            // 
            // toolstripstatuslabelFullName
            // 
            this.toolstripstatuslabelFullName.Name = "toolstripstatuslabelFullName";
            this.toolstripstatuslabelFullName.Size = new System.Drawing.Size(13, 17);
            this.toolstripstatuslabelFullName.Text = "؟";
            // 
            // toolStripStatusLabel2
            // 
            this.toolStripStatusLabel2.Name = "toolStripStatusLabel2";
            this.toolStripStatusLabel2.Size = new System.Drawing.Size(11, 17);
            this.toolStripStatusLabel2.Text = "-";
            // 
            // toolstripstatuslabelEmail
            // 
            this.toolstripstatuslabelEmail.LinkBehavior = System.Windows.Forms.LinkBehavior.AlwaysUnderline;
            this.toolstripstatuslabelEmail.Name = "toolstripstatuslabelEmail";
            this.toolstripstatuslabelEmail.Size = new System.Drawing.Size(13, 17);
            this.toolstripstatuslabelEmail.Text = "؟";
            // 
            // ucUserInformationStatusBar
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.statusStrip);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucUserInformationStatusBar";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(543, 22);
            this.statusStrip.ResumeLayout(false);
            this.statusStrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.StatusStrip statusStrip;
        private System.Windows.Forms.ToolStripStatusLabel toolstripstatuslabelUsername;
        private System.Windows.Forms.ToolStripStatusLabel toolstripstatuslabelEmail;
        private System.Windows.Forms.ToolStripStatusLabel toolstripstatuslabelFullName;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel2;
    }
}
