namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Gheyas
{
    partial class UcSearchStudent
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
            this.groupboxSearch = new System.Windows.Forms.GroupBox();
            this.buttonSearch = new System.Windows.Forms.Button();
            this.textboxFamily = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textboxName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.ucStudents = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcStudents();
            this.groupboxSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupboxSearch
            // 
            this.groupboxSearch.Controls.Add(this.buttonSearch);
            this.groupboxSearch.Controls.Add(this.textboxFamily);
            this.groupboxSearch.Controls.Add(this.label2);
            this.groupboxSearch.Controls.Add(this.textboxName);
            this.groupboxSearch.Controls.Add(this.label1);
            this.groupboxSearch.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupboxSearch.Location = new System.Drawing.Point(0, 0);
            this.groupboxSearch.Name = "groupboxSearch";
            this.groupboxSearch.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.groupboxSearch.Size = new System.Drawing.Size(801, 59);
            this.groupboxSearch.TabIndex = 2;
            this.groupboxSearch.TabStop = false;
            this.groupboxSearch.Text = "جست و جوی دانشجو";
            // 
            // buttonSearch
            // 
            this.buttonSearch.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonSearch.Location = new System.Drawing.Point(264, 24);
            this.buttonSearch.Name = "buttonSearch";
            this.buttonSearch.Size = new System.Drawing.Size(111, 23);
            this.buttonSearch.TabIndex = 2;
            this.buttonSearch.Text = "جست و جو";
            this.buttonSearch.UseVisualStyleBackColor = true;
            this.buttonSearch.Click += new System.EventHandler(this.buttonSearch_Click);
            // 
            // textboxFamily
            // 
            this.textboxFamily.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxFamily.Location = new System.Drawing.Point(381, 26);
            this.textboxFamily.Name = "textboxFamily";
            this.textboxFamily.Size = new System.Drawing.Size(150, 21);
            this.textboxFamily.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(537, 29);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "نام خانوادگی";
            // 
            // textboxName
            // 
            this.textboxName.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxName.Location = new System.Drawing.Point(608, 26);
            this.textboxName.Name = "textboxName";
            this.textboxName.Size = new System.Drawing.Size(150, 21);
            this.textboxName.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(764, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(23, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "نام ";
            // 
            // ucStudents
            // 
            this.ucStudents.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucStudents.Location = new System.Drawing.Point(0, 65);
            this.ucStudents.Name = "ucStudents";
            this.ucStudents.Size = new System.Drawing.Size(801, 319);
            this.ucStudents.Students = null;
            this.ucStudents.TabIndex = 3;
            this.ucStudents.NeedData += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcStudents.NeedDataEventHandler(this.ucStudents_NeedData);
            this.ucStudents.LoadDone += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcStudents.LoadDoneEventHandler(this.ucStudents_LoadDone);
            // 
            // UcSearchStudent
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.ucStudents);
            this.Controls.Add(this.groupboxSearch);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcSearchStudent";
            this.Size = new System.Drawing.Size(801, 384);
            this.groupboxSearch.ResumeLayout(false);
            this.groupboxSearch.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupboxSearch;
        private System.Windows.Forms.Button buttonSearch;
        private System.Windows.Forms.TextBox textboxFamily;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textboxName;
        private System.Windows.Forms.Label label1;
        private Education.UcStudents ucStudents;
    }
}
