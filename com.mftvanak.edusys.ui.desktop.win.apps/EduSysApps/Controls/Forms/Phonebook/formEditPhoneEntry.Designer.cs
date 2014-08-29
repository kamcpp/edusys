namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Phonebook
{
    partial class FormEditPhoneEntry
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
            this.ucEditPhoneEntry = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook.UcEditPhoneEntry();
            this.buttonSave = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // ucEditPhoneEntry
            // 
            this.ucEditPhoneEntry.BackColor = System.Drawing.Color.Transparent;
            this.ucEditPhoneEntry.Dock = System.Windows.Forms.DockStyle.Top;
            this.ucEditPhoneEntry.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEditPhoneEntry.IsNew = false;
            this.ucEditPhoneEntry.Location = new System.Drawing.Point(0, 0);
            this.ucEditPhoneEntry.Name = "ucEditPhoneEntry";
            this.ucEditPhoneEntry.PhoneEntry = null;
            this.ucEditPhoneEntry.Size = new System.Drawing.Size(551, 392);
            this.ucEditPhoneEntry.TabIndex = 0;
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(464, 398);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(75, 23);
            this.buttonSave.TabIndex = 1;
            this.buttonSave.Text = "ذخیره";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(383, 398);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 2;
            this.buttonCancel.Text = "لغو";
            this.buttonCancel.UseVisualStyleBackColor = true;
            this.buttonCancel.Click += new System.EventHandler(this.buttonCancel_Click);
            // 
            // formEditPhoneEntry
            // 
            this.AcceptButton = this.buttonSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(551, 427);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.ucEditPhoneEntry);
            this.Name = "formEditPhoneEntry";
            this.Text = "ویرایش تماس";
            this.Load += new System.EventHandler(this.formEditPhoneEntry_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Uc.Phonebook.UcEditPhoneEntry ucEditPhoneEntry;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Button buttonCancel;
    }
}