namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcDepartmentSelector
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
            this.labelInsitute = new System.Windows.Forms.Label();
            this.labelDepartment = new System.Windows.Forms.Label();
            this.comboboxInstitutes = new System.Windows.Forms.ComboBox();
            this.comboboxDepartments = new System.Windows.Forms.ComboBox();
            this.buttonRefreshInstitutes = new System.Windows.Forms.Button();
            this.buttonRefreshDepartments = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelInsitute
            // 
            this.labelInsitute.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelInsitute.AutoSize = true;
            this.labelInsitute.Location = new System.Drawing.Point(313, 8);
            this.labelInsitute.Name = "labelInsitute";
            this.labelInsitute.Size = new System.Drawing.Size(47, 13);
            this.labelInsitute.TabIndex = 0;
            this.labelInsitute.Text = "موسسه";
            // 
            // labelDepartment
            // 
            this.labelDepartment.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDepartment.AutoSize = true;
            this.labelDepartment.Location = new System.Drawing.Point(313, 35);
            this.labelDepartment.Name = "labelDepartment";
            this.labelDepartment.Size = new System.Drawing.Size(42, 13);
            this.labelDepartment.TabIndex = 1;
            this.labelDepartment.Text = "دپارتمان";
            // 
            // comboboxInstitutes
            // 
            this.comboboxInstitutes.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxInstitutes.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxInstitutes.FormattingEnabled = true;
            this.comboboxInstitutes.Location = new System.Drawing.Point(84, 5);
            this.comboboxInstitutes.Name = "comboboxInstitutes";
            this.comboboxInstitutes.Size = new System.Drawing.Size(223, 21);
            this.comboboxInstitutes.TabIndex = 2;
            this.comboboxInstitutes.SelectedIndexChanged += new System.EventHandler(this.comboboxInstitutes_SelectedIndexChanged);
            // 
            // comboboxDepartments
            // 
            this.comboboxDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxDepartments.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxDepartments.FormattingEnabled = true;
            this.comboboxDepartments.Location = new System.Drawing.Point(84, 32);
            this.comboboxDepartments.Name = "comboboxDepartments";
            this.comboboxDepartments.Size = new System.Drawing.Size(223, 21);
            this.comboboxDepartments.TabIndex = 3;
            // 
            // buttonRefreshInstitutes
            // 
            this.buttonRefreshInstitutes.Location = new System.Drawing.Point(3, 3);
            this.buttonRefreshInstitutes.Name = "buttonRefreshInstitutes";
            this.buttonRefreshInstitutes.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshInstitutes.TabIndex = 4;
            this.buttonRefreshInstitutes.Text = "بازآوری";
            this.buttonRefreshInstitutes.UseVisualStyleBackColor = true;
            this.buttonRefreshInstitutes.Click += new System.EventHandler(this.buttonRefreshInstitutes_Click);
            // 
            // buttonRefreshDepartments
            // 
            this.buttonRefreshDepartments.Location = new System.Drawing.Point(3, 30);
            this.buttonRefreshDepartments.Name = "buttonRefreshDepartments";
            this.buttonRefreshDepartments.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshDepartments.TabIndex = 5;
            this.buttonRefreshDepartments.Text = "بازآوری";
            this.buttonRefreshDepartments.UseVisualStyleBackColor = true;
            this.buttonRefreshDepartments.Click += new System.EventHandler(this.buttonRefreshDepartments_Click);
            // 
            // ucDepartmentSelector
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.buttonRefreshDepartments);
            this.Controls.Add(this.buttonRefreshInstitutes);
            this.Controls.Add(this.comboboxDepartments);
            this.Controls.Add(this.comboboxInstitutes);
            this.Controls.Add(this.labelDepartment);
            this.Controls.Add(this.labelInsitute);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucDepartmentSelector";
            this.Size = new System.Drawing.Size(363, 59);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelInsitute;
        private System.Windows.Forms.Label labelDepartment;
        private System.Windows.Forms.ComboBox comboboxInstitutes;
        private System.Windows.Forms.ComboBox comboboxDepartments;
        private System.Windows.Forms.Button buttonRefreshInstitutes;
        private System.Windows.Forms.Button buttonRefreshDepartments;
    }
}
