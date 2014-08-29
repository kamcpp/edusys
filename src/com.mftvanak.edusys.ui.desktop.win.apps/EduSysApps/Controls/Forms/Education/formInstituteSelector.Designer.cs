namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Education
{
    partial class FormInstituteSelector
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
            this.comboboxInstitutes = new System.Windows.Forms.ComboBox();
            this.buttonSelect = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // comboboxInstitutes
            // 
            this.comboboxInstitutes.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxInstitutes.FormattingEnabled = true;
            this.comboboxInstitutes.Location = new System.Drawing.Point(12, 12);
            this.comboboxInstitutes.Name = "comboboxInstitutes";
            this.comboboxInstitutes.Size = new System.Drawing.Size(291, 21);
            this.comboboxInstitutes.TabIndex = 0;
            // 
            // buttonSelect
            // 
            this.buttonSelect.Location = new System.Drawing.Point(309, 10);
            this.buttonSelect.Name = "buttonSelect";
            this.buttonSelect.Size = new System.Drawing.Size(109, 23);
            this.buttonSelect.TabIndex = 1;
            this.buttonSelect.Text = "انتخاب";
            this.buttonSelect.UseVisualStyleBackColor = true;
            this.buttonSelect.Click += new System.EventHandler(this.buttonSelect_Click);
            // 
            // formInstituteSelector
            // 
            this.AcceptButton = this.buttonSelect;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(425, 43);
            this.Controls.Add(this.buttonSelect);
            this.Controls.Add(this.comboboxInstitutes);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "formInstituteSelector";
            this.Text = "انتخاب موسسه";
            this.Load += new System.EventHandler(this.formInstituteSelector_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ComboBox comboboxInstitutes;
        private System.Windows.Forms.Button buttonSelect;
    }
}