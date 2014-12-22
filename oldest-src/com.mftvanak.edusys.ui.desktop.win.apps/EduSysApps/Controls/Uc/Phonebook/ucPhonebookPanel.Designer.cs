namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    partial class UcPhonebookPanel
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
            this.tabcontrol = new System.Windows.Forms.TabControl();
            this.tabpageMyPhoneEntries = new System.Windows.Forms.TabPage();
            this.ucMyPhoneEntries = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcMyPhoneEntries();
            this.tabpageSearchPhoneEntires = new System.Windows.Forms.TabPage();
            this.ucSearchPhoneEntries = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcSearchPhoneEntries();
            this.tabcontrol.SuspendLayout();
            this.tabpageMyPhoneEntries.SuspendLayout();
            this.tabpageSearchPhoneEntires.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabcontrol
            // 
            this.tabcontrol.Controls.Add(this.tabpageMyPhoneEntries);
            this.tabcontrol.Controls.Add(this.tabpageSearchPhoneEntires);
            this.tabcontrol.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabcontrol.Location = new System.Drawing.Point(0, 0);
            this.tabcontrol.Multiline = true;
            this.tabcontrol.Name = "tabcontrol";
            this.tabcontrol.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.tabcontrol.RightToLeftLayout = true;
            this.tabcontrol.SelectedIndex = 0;
            this.tabcontrol.Size = new System.Drawing.Size(787, 461);
            this.tabcontrol.TabIndex = 0;
            // 
            // tabpageMyPhoneEntries
            // 
            this.tabpageMyPhoneEntries.Controls.Add(this.ucMyPhoneEntries);
            this.tabpageMyPhoneEntries.Location = new System.Drawing.Point(4, 22);
            this.tabpageMyPhoneEntries.Name = "tabpageMyPhoneEntries";
            this.tabpageMyPhoneEntries.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageMyPhoneEntries.Size = new System.Drawing.Size(779, 435);
            this.tabpageMyPhoneEntries.TabIndex = 0;
            this.tabpageMyPhoneEntries.Text = "تلفن های من";
            this.tabpageMyPhoneEntries.UseVisualStyleBackColor = true;
            // 
            // ucMyPhoneEntries
            // 
            this.ucMyPhoneEntries.BackColor = System.Drawing.Color.Transparent;
            this.ucMyPhoneEntries.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucMyPhoneEntries.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucMyPhoneEntries.Location = new System.Drawing.Point(3, 3);
            this.ucMyPhoneEntries.Name = "ucMyPhoneEntries";
            this.ucMyPhoneEntries.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucMyPhoneEntries.Size = new System.Drawing.Size(773, 429);
            this.ucMyPhoneEntries.TabIndex = 0;
            // 
            // tabpageSearchPhoneEntires
            // 
            this.tabpageSearchPhoneEntires.Controls.Add(this.ucSearchPhoneEntries);
            this.tabpageSearchPhoneEntires.Location = new System.Drawing.Point(4, 22);
            this.tabpageSearchPhoneEntires.Name = "tabpageSearchPhoneEntires";
            this.tabpageSearchPhoneEntires.Size = new System.Drawing.Size(779, 435);
            this.tabpageSearchPhoneEntires.TabIndex = 2;
            this.tabpageSearchPhoneEntires.Text = "جست و جوی تلفن ها";
            this.tabpageSearchPhoneEntires.UseVisualStyleBackColor = true;
            // 
            // ucSearchPhoneEntries
            // 
            this.ucSearchPhoneEntries.BackColor = System.Drawing.Color.Transparent;
            this.ucSearchPhoneEntries.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucSearchPhoneEntries.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucSearchPhoneEntries.Location = new System.Drawing.Point(0, 0);
            this.ucSearchPhoneEntries.Name = "ucSearchPhoneEntries";
            this.ucSearchPhoneEntries.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucSearchPhoneEntries.Size = new System.Drawing.Size(779, 435);
            this.ucSearchPhoneEntries.TabIndex = 0;
            // 
            // ucPhonebookPanel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.tabcontrol);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucPhonebookPanel";
            this.Size = new System.Drawing.Size(787, 461);
            this.tabcontrol.ResumeLayout(false);
            this.tabpageMyPhoneEntries.ResumeLayout(false);
            this.tabpageSearchPhoneEntires.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabcontrol;
        private System.Windows.Forms.TabPage tabpageMyPhoneEntries;
        private UcMyPhoneEntries ucMyPhoneEntries;
        private System.Windows.Forms.TabPage tabpageSearchPhoneEntires;
        private UcSearchPhoneEntries ucSearchPhoneEntries;
    }
}
