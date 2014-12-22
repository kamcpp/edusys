namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.TestApp.Forms
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
            this.buttonEduSysDataGridViewTest = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // buttonEduSysDataGridViewTest
            // 
            this.buttonEduSysDataGridViewTest.Location = new System.Drawing.Point(12, 12);
            this.buttonEduSysDataGridViewTest.Name = "buttonEduSysDataGridViewTest";
            this.buttonEduSysDataGridViewTest.Size = new System.Drawing.Size(170, 23);
            this.buttonEduSysDataGridViewTest.TabIndex = 0;
            this.buttonEduSysDataGridViewTest.Text = "EduSysDataGridView Test";
            this.buttonEduSysDataGridViewTest.UseVisualStyleBackColor = true;
            this.buttonEduSysDataGridViewTest.Click += new System.EventHandler(this.buttonEduSysDataGridViewTest_Click);
            // 
            // formMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(716, 348);
            this.Controls.Add(this.buttonEduSysDataGridViewTest);
            this.Name = "formMain";
            this.Text = "formMain";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button buttonEduSysDataGridViewTest;
    }
}