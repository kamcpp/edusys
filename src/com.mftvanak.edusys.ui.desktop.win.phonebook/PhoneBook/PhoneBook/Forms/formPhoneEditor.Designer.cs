namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    partial class formPhoneEditor
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
            this.labelDepartment = new System.Windows.Forms.Label();
            this.comboboxDepartments = new System.Windows.Forms.ComboBox();
            this.labelNumber = new System.Windows.Forms.Label();
            this.textboxNumber = new System.Windows.Forms.TextBox();
            this.labelName = new System.Windows.Forms.Label();
            this.textboxName = new System.Windows.Forms.TextBox();
            this.labelDescription = new System.Windows.Forms.Label();
            this.textboxDescription = new System.Windows.Forms.TextBox();
            this.buttonSave = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.labelRegistrar = new System.Windows.Forms.Label();
            this.labelRegistrarValue = new System.Windows.Forms.Label();
            this.labelRegisterDate = new System.Windows.Forms.Label();
            this.labelRegisterDateValue = new System.Windows.Forms.Label();
            this.labelFollows = new System.Windows.Forms.Label();
            this.listviewFollows = new System.Windows.Forms.ListView();
            this.columnDate = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnFollower = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnType = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnDescription = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.buttonFollow = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelDepartment
            // 
            this.labelDepartment.AutoSize = true;
            this.labelDepartment.Location = new System.Drawing.Point(427, 9);
            this.labelDepartment.Name = "labelDepartment";
            this.labelDepartment.Size = new System.Drawing.Size(42, 13);
            this.labelDepartment.TabIndex = 0;
            this.labelDepartment.Text = "دپارتمان";
            // 
            // comboboxDepartments
            // 
            this.comboboxDepartments.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxDepartments.FormattingEnabled = true;
            this.comboboxDepartments.Location = new System.Drawing.Point(114, 6);
            this.comboboxDepartments.Name = "comboboxDepartments";
            this.comboboxDepartments.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.comboboxDepartments.Size = new System.Drawing.Size(307, 21);
            this.comboboxDepartments.TabIndex = 1;
            // 
            // labelNumber
            // 
            this.labelNumber.AutoSize = true;
            this.labelNumber.Location = new System.Drawing.Point(427, 108);
            this.labelNumber.Name = "labelNumber";
            this.labelNumber.Size = new System.Drawing.Size(37, 13);
            this.labelNumber.TabIndex = 2;
            this.labelNumber.Text = "شماره";
            // 
            // textboxNumber
            // 
            this.textboxNumber.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxNumber.Location = new System.Drawing.Point(272, 106);
            this.textboxNumber.Name = "textboxNumber";
            this.textboxNumber.Size = new System.Drawing.Size(149, 21);
            this.textboxNumber.TabIndex = 3;
            // 
            // labelName
            // 
            this.labelName.AutoSize = true;
            this.labelName.Location = new System.Drawing.Point(427, 81);
            this.labelName.Name = "labelName";
            this.labelName.Size = new System.Drawing.Size(20, 13);
            this.labelName.TabIndex = 4;
            this.labelName.Text = "نام";
            // 
            // textboxName
            // 
            this.textboxName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxName.Location = new System.Drawing.Point(169, 79);
            this.textboxName.Name = "textboxName";
            this.textboxName.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxName.Size = new System.Drawing.Size(252, 21);
            this.textboxName.TabIndex = 5;
            // 
            // labelDescription
            // 
            this.labelDescription.AutoSize = true;
            this.labelDescription.Location = new System.Drawing.Point(427, 135);
            this.labelDescription.Name = "labelDescription";
            this.labelDescription.Size = new System.Drawing.Size(47, 13);
            this.labelDescription.TabIndex = 6;
            this.labelDescription.Text = "توضیحات";
            // 
            // textboxDescription
            // 
            this.textboxDescription.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxDescription.Location = new System.Drawing.Point(148, 133);
            this.textboxDescription.Multiline = true;
            this.textboxDescription.Name = "textboxDescription";
            this.textboxDescription.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxDescription.Size = new System.Drawing.Size(273, 102);
            this.textboxDescription.TabIndex = 7;
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(12, 6);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(87, 23);
            this.buttonSave.TabIndex = 8;
            this.buttonSave.Text = "ذخیره کردن";
            this.buttonSave.UseVisualStyleBackColor = true;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(12, 35);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(87, 23);
            this.buttonCancel.TabIndex = 9;
            this.buttonCancel.Text = "لغو";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // labelRegistrar
            // 
            this.labelRegistrar.AutoSize = true;
            this.labelRegistrar.Location = new System.Drawing.Point(427, 35);
            this.labelRegistrar.Name = "labelRegistrar";
            this.labelRegistrar.Size = new System.Drawing.Size(51, 13);
            this.labelRegistrar.TabIndex = 10;
            this.labelRegistrar.Text = "ثبت کننده";
            // 
            // labelRegistrarValue
            // 
            this.labelRegistrarValue.AutoSize = true;
            this.labelRegistrarValue.ForeColor = System.Drawing.Color.DarkGreen;
            this.labelRegistrarValue.Location = new System.Drawing.Point(354, 35);
            this.labelRegistrarValue.Name = "labelRegistrarValue";
            this.labelRegistrarValue.Size = new System.Drawing.Size(67, 13);
            this.labelRegistrarValue.TabIndex = 11;
            this.labelRegistrarValue.Text = "<Registrar>";
            // 
            // labelRegisterDate
            // 
            this.labelRegisterDate.AutoSize = true;
            this.labelRegisterDate.Location = new System.Drawing.Point(427, 58);
            this.labelRegisterDate.Name = "labelRegisterDate";
            this.labelRegisterDate.Size = new System.Drawing.Size(48, 13);
            this.labelRegisterDate.TabIndex = 12;
            this.labelRegisterDate.Text = "تاریخ ثبت";
            // 
            // labelRegisterDateValue
            // 
            this.labelRegisterDateValue.AutoSize = true;
            this.labelRegisterDateValue.Location = new System.Drawing.Point(332, 58);
            this.labelRegisterDateValue.Name = "labelRegisterDateValue";
            this.labelRegisterDateValue.Size = new System.Drawing.Size(89, 13);
            this.labelRegisterDateValue.TabIndex = 13;
            this.labelRegisterDateValue.Text = "<Register Date>";
            // 
            // labelFollows
            // 
            this.labelFollows.AutoSize = true;
            this.labelFollows.Location = new System.Drawing.Point(427, 246);
            this.labelFollows.Name = "labelFollows";
            this.labelFollows.Size = new System.Drawing.Size(53, 13);
            this.labelFollows.TabIndex = 14;
            this.labelFollows.Text = "پیگیری ها";
            // 
            // listviewFollows
            // 
            this.listviewFollows.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnDate,
            this.columnFollower,
            this.columnType,
            this.columnDescription});
            this.listviewFollows.FullRowSelect = true;
            this.listviewFollows.GridLines = true;
            this.listviewFollows.Location = new System.Drawing.Point(105, 241);
            this.listviewFollows.MultiSelect = false;
            this.listviewFollows.Name = "listviewFollows";
            this.listviewFollows.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewFollows.RightToLeftLayout = true;
            this.listviewFollows.Size = new System.Drawing.Size(316, 144);
            this.listviewFollows.TabIndex = 15;
            this.listviewFollows.UseCompatibleStateImageBehavior = false;
            this.listviewFollows.View = System.Windows.Forms.View.Details;
            // 
            // columnDate
            // 
            this.columnDate.Text = "تاریخ";
            this.columnDate.Width = 70;
            // 
            // columnFollower
            // 
            this.columnFollower.Text = "پیگیری کننده";
            this.columnFollower.Width = 100;
            // 
            // columnType
            // 
            this.columnType.Text = "نوع پیگیری";
            this.columnType.Width = 100;
            // 
            // columnDescription
            // 
            this.columnDescription.Text = "توضیحات";
            this.columnDescription.Width = 200;
            // 
            // buttonFollow
            // 
            this.buttonFollow.Location = new System.Drawing.Point(12, 241);
            this.buttonFollow.Name = "buttonFollow";
            this.buttonFollow.Size = new System.Drawing.Size(87, 23);
            this.buttonFollow.TabIndex = 16;
            this.buttonFollow.Text = "ثبت پیگیری";
            this.buttonFollow.UseVisualStyleBackColor = true;
            this.buttonFollow.Click += new System.EventHandler(this.buttonFollow_Click);
            // 
            // formPhoneEditor
            // 
            this.AcceptButton = this.buttonSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(490, 399);
            this.Controls.Add(this.buttonFollow);
            this.Controls.Add(this.listviewFollows);
            this.Controls.Add(this.labelFollows);
            this.Controls.Add(this.labelRegisterDateValue);
            this.Controls.Add(this.labelRegisterDate);
            this.Controls.Add(this.labelRegistrarValue);
            this.Controls.Add(this.labelRegistrar);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.textboxDescription);
            this.Controls.Add(this.labelDescription);
            this.Controls.Add(this.textboxName);
            this.Controls.Add(this.labelName);
            this.Controls.Add(this.textboxNumber);
            this.Controls.Add(this.labelNumber);
            this.Controls.Add(this.comboboxDepartments);
            this.Controls.Add(this.labelDepartment);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "formPhoneEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "تلفن";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelDepartment;
        private System.Windows.Forms.ComboBox comboboxDepartments;
        private System.Windows.Forms.Label labelNumber;
        private System.Windows.Forms.TextBox textboxNumber;
        private System.Windows.Forms.Label labelName;
        private System.Windows.Forms.TextBox textboxName;
        private System.Windows.Forms.Label labelDescription;
        private System.Windows.Forms.TextBox textboxDescription;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.Label labelRegistrar;
        private System.Windows.Forms.Label labelRegistrarValue;
        private System.Windows.Forms.Label labelRegisterDate;
        private System.Windows.Forms.Label labelRegisterDateValue;
        private System.Windows.Forms.Label labelFollows;
        private System.Windows.Forms.ListView listviewFollows;
        private System.Windows.Forms.ColumnHeader columnDate;
        private System.Windows.Forms.ColumnHeader columnFollower;
        private System.Windows.Forms.ColumnHeader columnType;
        private System.Windows.Forms.ColumnHeader columnDescription;
        private System.Windows.Forms.Button buttonFollow;
    }
}