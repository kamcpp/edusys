namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Personnel
{
    partial class UcPersonsComboBox
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
            this.comboboxPersons = new System.Windows.Forms.ComboBox();
            this.labelCaption = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // comboboxPersons
            // 
            this.comboboxPersons.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxPersons.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxPersons.FormattingEnabled = true;
            this.comboboxPersons.Location = new System.Drawing.Point(6, 3);
            this.comboboxPersons.Name = "comboboxPersons";
            this.comboboxPersons.Size = new System.Drawing.Size(381, 21);
            this.comboboxPersons.TabIndex = 0;
            // 
            // labelCaption
            // 
            this.labelCaption.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelCaption.AutoSize = true;
            this.labelCaption.Location = new System.Drawing.Point(393, 6);
            this.labelCaption.Name = "labelCaption";
            this.labelCaption.Size = new System.Drawing.Size(64, 13);
            this.labelCaption.TabIndex = 1;
            this.labelCaption.Text = "فرد مورد نظر";
            // 
            // ucPersonsComboBox
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.labelCaption);
            this.Controls.Add(this.comboboxPersons);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucPersonsComboBox";
            this.Size = new System.Drawing.Size(462, 28);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboboxPersons;
        private System.Windows.Forms.Label labelCaption;
    }
}
