namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Gheyas
{
    partial class FormEditDaneshgahField
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
            this.labelFullName = new System.Windows.Forms.Label();
            this.labelFullNameValue = new System.Windows.Forms.Label();
            this.textboxDaneshgahField = new System.Windows.Forms.TextBox();
            this.labelDaneshgahField = new System.Windows.Forms.Label();
            this.buttonSave = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.labelCodeKaramuz = new System.Windows.Forms.Label();
            this.labelCodeKaramuzValue = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // labelFullName
            // 
            this.labelFullName.AutoSize = true;
            this.labelFullName.Location = new System.Drawing.Point(276, 36);
            this.labelFullName.Name = "labelFullName";
            this.labelFullName.Size = new System.Drawing.Size(89, 13);
            this.labelFullName.TabIndex = 2;
            this.labelFullName.Text = "نام و نام خانوادگی";
            // 
            // labelFullNameValue
            // 
            this.labelFullNameValue.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelFullNameValue.Location = new System.Drawing.Point(12, 36);
            this.labelFullNameValue.Name = "labelFullNameValue";
            this.labelFullNameValue.Size = new System.Drawing.Size(258, 13);
            this.labelFullNameValue.TabIndex = 3;
            this.labelFullNameValue.Text = "نام و نام خانوادگی";
            this.labelFullNameValue.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // textboxDaneshgahField
            // 
            this.textboxDaneshgahField.Location = new System.Drawing.Point(12, 61);
            this.textboxDaneshgahField.Name = "textboxDaneshgahField";
            this.textboxDaneshgahField.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxDaneshgahField.Size = new System.Drawing.Size(281, 21);
            this.textboxDaneshgahField.TabIndex = 5;
            // 
            // labelDaneshgahField
            // 
            this.labelDaneshgahField.AutoSize = true;
            this.labelDaneshgahField.Location = new System.Drawing.Point(299, 64);
            this.labelDaneshgahField.Name = "labelDaneshgahField";
            this.labelDaneshgahField.Size = new System.Drawing.Size(66, 13);
            this.labelDaneshgahField.TabIndex = 4;
            this.labelDaneshgahField.Text = "فیلد دانشگاه";
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(290, 88);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(75, 23);
            this.buttonSave.TabIndex = 0;
            this.buttonSave.Text = "ذخیره";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(12, 88);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 1;
            this.buttonCancel.Text = "لغو";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // labelCodeKaramuz
            // 
            this.labelCodeKaramuz.AutoSize = true;
            this.labelCodeKaramuz.Location = new System.Drawing.Point(314, 9);
            this.labelCodeKaramuz.Name = "labelCodeKaramuz";
            this.labelCodeKaramuz.Size = new System.Drawing.Size(51, 13);
            this.labelCodeKaramuz.TabIndex = 6;
            this.labelCodeKaramuz.Text = "کد کارآموز";
            // 
            // labelCodeKaramuzValue
            // 
            this.labelCodeKaramuzValue.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelCodeKaramuzValue.Location = new System.Drawing.Point(15, 9);
            this.labelCodeKaramuzValue.Name = "labelCodeKaramuzValue";
            this.labelCodeKaramuzValue.Size = new System.Drawing.Size(293, 13);
            this.labelCodeKaramuzValue.TabIndex = 7;
            this.labelCodeKaramuzValue.Text = "کد کارآموز";
            this.labelCodeKaramuzValue.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // FormEditDaneshgahField
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(377, 121);
            this.Controls.Add(this.labelCodeKaramuzValue);
            this.Controls.Add(this.labelCodeKaramuz);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.labelDaneshgahField);
            this.Controls.Add(this.textboxDaneshgahField);
            this.Controls.Add(this.labelFullNameValue);
            this.Controls.Add(this.labelFullName);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FormEditDaneshgahField";
            this.Text = "ویرایش فیلد دانشگاه";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelFullName;
        private System.Windows.Forms.Label labelFullNameValue;
        private System.Windows.Forms.TextBox textboxDaneshgahField;
        private System.Windows.Forms.Label labelDaneshgahField;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.Label labelCodeKaramuz;
        private System.Windows.Forms.Label labelCodeKaramuzValue;
    }
}