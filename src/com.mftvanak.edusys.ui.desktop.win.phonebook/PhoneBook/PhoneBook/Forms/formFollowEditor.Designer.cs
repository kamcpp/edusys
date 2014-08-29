namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    partial class formFollowEditor
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
            this.labelFollowsTypes = new System.Windows.Forms.Label();
            this.comboboxFollowTypes = new System.Windows.Forms.ComboBox();
            this.labelFollower = new System.Windows.Forms.Label();
            this.labelFollowerValue = new System.Windows.Forms.Label();
            this.labelFollowDate = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.labelDescription = new System.Windows.Forms.Label();
            this.textboxDescription = new System.Windows.Forms.TextBox();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.buttonSave = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelFollowsTypes
            // 
            this.labelFollowsTypes.AutoSize = true;
            this.labelFollowsTypes.Location = new System.Drawing.Point(372, 9);
            this.labelFollowsTypes.Name = "labelFollowsTypes";
            this.labelFollowsTypes.Size = new System.Drawing.Size(57, 13);
            this.labelFollowsTypes.TabIndex = 0;
            this.labelFollowsTypes.Text = "نوع پیگیری";
            // 
            // comboboxFollowTypes
            // 
            this.comboboxFollowTypes.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxFollowTypes.FormattingEnabled = true;
            this.comboboxFollowTypes.Items.AddRange(new object[] {
            "سیب",
            "سیب",
            "سیب",
            "سیب",
            "صثق",
            "صثیسی",
            "بصثق"});
            this.comboboxFollowTypes.Location = new System.Drawing.Point(104, 6);
            this.comboboxFollowTypes.Name = "comboboxFollowTypes";
            this.comboboxFollowTypes.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.comboboxFollowTypes.Size = new System.Drawing.Size(262, 21);
            this.comboboxFollowTypes.TabIndex = 1;
            // 
            // labelFollower
            // 
            this.labelFollower.AutoSize = true;
            this.labelFollower.Location = new System.Drawing.Point(372, 37);
            this.labelFollower.Name = "labelFollower";
            this.labelFollower.Size = new System.Drawing.Size(66, 13);
            this.labelFollower.TabIndex = 2;
            this.labelFollower.Text = "پیگیری کننده";
            // 
            // labelFollowerValue
            // 
            this.labelFollowerValue.AutoSize = true;
            this.labelFollowerValue.ForeColor = System.Drawing.Color.DarkGreen;
            this.labelFollowerValue.Location = new System.Drawing.Point(303, 37);
            this.labelFollowerValue.Name = "labelFollowerValue";
            this.labelFollowerValue.Size = new System.Drawing.Size(63, 13);
            this.labelFollowerValue.TabIndex = 3;
            this.labelFollowerValue.Text = "<Follower>";
            // 
            // labelFollowDate
            // 
            this.labelFollowDate.AutoSize = true;
            this.labelFollowDate.Location = new System.Drawing.Point(372, 61);
            this.labelFollowDate.Name = "labelFollowDate";
            this.labelFollowDate.Size = new System.Drawing.Size(63, 13);
            this.labelFollowDate.TabIndex = 4;
            this.labelFollowDate.Text = "تاریخ پیگیری";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(287, 61);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "<Follow Date>";
            // 
            // labelDescription
            // 
            this.labelDescription.AutoSize = true;
            this.labelDescription.Location = new System.Drawing.Point(372, 87);
            this.labelDescription.Name = "labelDescription";
            this.labelDescription.Size = new System.Drawing.Size(47, 13);
            this.labelDescription.TabIndex = 6;
            this.labelDescription.Text = "توضیحات";
            // 
            // textboxDescription
            // 
            this.textboxDescription.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxDescription.Location = new System.Drawing.Point(104, 85);
            this.textboxDescription.Multiline = true;
            this.textboxDescription.Name = "textboxDescription";
            this.textboxDescription.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxDescription.Size = new System.Drawing.Size(262, 89);
            this.textboxDescription.TabIndex = 8;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(12, 37);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(86, 23);
            this.buttonCancel.TabIndex = 11;
            this.buttonCancel.Text = "لغو";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(12, 8);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(86, 23);
            this.buttonSave.TabIndex = 10;
            this.buttonSave.Text = "ذخیره کردن";
            this.buttonSave.UseVisualStyleBackColor = true;
            // 
            // formFollowEditor
            // 
            this.AcceptButton = this.buttonSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(447, 181);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.textboxDescription);
            this.Controls.Add(this.labelDescription);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.labelFollowDate);
            this.Controls.Add(this.labelFollowerValue);
            this.Controls.Add(this.labelFollower);
            this.Controls.Add(this.comboboxFollowTypes);
            this.Controls.Add(this.labelFollowsTypes);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "formFollowEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "پیگیری";
            this.Load += new System.EventHandler(this.formFollowEditor_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelFollowsTypes;
        private System.Windows.Forms.ComboBox comboboxFollowTypes;
        private System.Windows.Forms.Label labelFollower;
        private System.Windows.Forms.Label labelFollowerValue;
        private System.Windows.Forms.Label labelFollowDate;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelDescription;
        private System.Windows.Forms.TextBox textboxDescription;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.Button buttonSave;
    }
}