namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    partial class UcEditPhoneEntry
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
            Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.NullColorComboBoxItem nullColorComboBoxItem1 = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.NullColorComboBoxItem();
            this.buttonFollow = new System.Windows.Forms.Button();
            this.listviewFollows = new System.Windows.Forms.ListView();
            this.columnDate = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnFollower = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnType = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnDescription = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.labelFollows = new System.Windows.Forms.Label();
            this.labelRegisterDateValue = new System.Windows.Forms.Label();
            this.labelRegisterDate = new System.Windows.Forms.Label();
            this.labelRegistrarValue = new System.Windows.Forms.Label();
            this.labelRegistrar = new System.Windows.Forms.Label();
            this.textboxDescription = new System.Windows.Forms.TextBox();
            this.labelDescription = new System.Windows.Forms.Label();
            this.textboxName = new System.Windows.Forms.TextBox();
            this.labelName = new System.Windows.Forms.Label();
            this.textboxNumber = new System.Windows.Forms.TextBox();
            this.labelNumber = new System.Windows.Forms.Label();
            this.comboboxMethodDeConnaissance = new System.Windows.Forms.ComboBox();
            this.labelMethodDeConnaissance = new System.Windows.Forms.Label();
            this.checkboxSeen = new System.Windows.Forms.CheckBox();
            this.checkboxShouldBeFollowed = new System.Windows.Forms.CheckBox();
            this.checkboxRegistered = new System.Windows.Forms.CheckBox();
            this.labelColor = new System.Windows.Forms.Label();
            this.checkboxPrivate = new System.Windows.Forms.CheckBox();
            this.colorcomboboxColor = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.ColorComboBox();
            this.ucDepartmentSelector = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education.UcDepartmentSelector();
            this.SuspendLayout();
            // 
            // buttonFollow
            // 
            this.buttonFollow.Enabled = false;
            this.buttonFollow.Location = new System.Drawing.Point(3, 306);
            this.buttonFollow.Name = "buttonFollow";
            this.buttonFollow.Size = new System.Drawing.Size(83, 23);
            this.buttonFollow.TabIndex = 5;
            this.buttonFollow.Text = "ثبت پیگیری";
            this.buttonFollow.UseVisualStyleBackColor = true;
            // 
            // listviewFollows
            // 
            this.listviewFollows.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.listviewFollows.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnDate,
            this.columnFollower,
            this.columnType,
            this.columnDescription});
            this.listviewFollows.FullRowSelect = true;
            this.listviewFollows.GridLines = true;
            this.listviewFollows.Location = new System.Drawing.Point(92, 306);
            this.listviewFollows.MultiSelect = false;
            this.listviewFollows.Name = "listviewFollows";
            this.listviewFollows.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewFollows.RightToLeftLayout = true;
            this.listviewFollows.Size = new System.Drawing.Size(449, 122);
            this.listviewFollows.TabIndex = 4;
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
            // labelFollows
            // 
            this.labelFollows.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelFollows.AutoSize = true;
            this.labelFollows.Location = new System.Drawing.Point(546, 311);
            this.labelFollows.Name = "labelFollows";
            this.labelFollows.Size = new System.Drawing.Size(53, 13);
            this.labelFollows.TabIndex = 31;
            this.labelFollows.Text = "پیگیری ها";
            // 
            // labelRegisterDateValue
            // 
            this.labelRegisterDateValue.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRegisterDateValue.Location = new System.Drawing.Point(289, 90);
            this.labelRegisterDateValue.Name = "labelRegisterDateValue";
            this.labelRegisterDateValue.Size = new System.Drawing.Size(252, 13);
            this.labelRegisterDateValue.TabIndex = 30;
            this.labelRegisterDateValue.Text = "<Register Date>";
            this.labelRegisterDateValue.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelRegisterDate
            // 
            this.labelRegisterDate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRegisterDate.AutoSize = true;
            this.labelRegisterDate.Location = new System.Drawing.Point(546, 90);
            this.labelRegisterDate.Name = "labelRegisterDate";
            this.labelRegisterDate.Size = new System.Drawing.Size(48, 13);
            this.labelRegisterDate.TabIndex = 29;
            this.labelRegisterDate.Text = "تاریخ ثبت";
            // 
            // labelRegistrarValue
            // 
            this.labelRegistrarValue.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRegistrarValue.ForeColor = System.Drawing.Color.DarkGreen;
            this.labelRegistrarValue.Location = new System.Drawing.Point(292, 67);
            this.labelRegistrarValue.Name = "labelRegistrarValue";
            this.labelRegistrarValue.Size = new System.Drawing.Size(249, 13);
            this.labelRegistrarValue.TabIndex = 28;
            this.labelRegistrarValue.Text = "<Registrar>";
            this.labelRegistrarValue.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelRegistrar
            // 
            this.labelRegistrar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRegistrar.AutoSize = true;
            this.labelRegistrar.Location = new System.Drawing.Point(546, 67);
            this.labelRegistrar.Name = "labelRegistrar";
            this.labelRegistrar.Size = new System.Drawing.Size(51, 13);
            this.labelRegistrar.TabIndex = 27;
            this.labelRegistrar.Text = "ثبت کننده";
            // 
            // textboxDescription
            // 
            this.textboxDescription.AcceptsReturn = true;
            this.textboxDescription.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxDescription.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxDescription.Location = new System.Drawing.Point(92, 219);
            this.textboxDescription.Multiline = true;
            this.textboxDescription.Name = "textboxDescription";
            this.textboxDescription.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxDescription.Size = new System.Drawing.Size(449, 81);
            this.textboxDescription.TabIndex = 3;
            // 
            // labelDescription
            // 
            this.labelDescription.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDescription.AutoSize = true;
            this.labelDescription.Location = new System.Drawing.Point(546, 221);
            this.labelDescription.Name = "labelDescription";
            this.labelDescription.Size = new System.Drawing.Size(47, 13);
            this.labelDescription.TabIndex = 23;
            this.labelDescription.Text = "توضیحات";
            // 
            // textboxName
            // 
            this.textboxName.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxName.Location = new System.Drawing.Point(289, 111);
            this.textboxName.Name = "textboxName";
            this.textboxName.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxName.Size = new System.Drawing.Size(251, 21);
            this.textboxName.TabIndex = 1;
            // 
            // labelName
            // 
            this.labelName.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelName.AutoSize = true;
            this.labelName.Location = new System.Drawing.Point(546, 113);
            this.labelName.Name = "labelName";
            this.labelName.Size = new System.Drawing.Size(20, 13);
            this.labelName.TabIndex = 21;
            this.labelName.Text = "نام";
            // 
            // textboxNumber
            // 
            this.textboxNumber.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxNumber.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textboxNumber.Location = new System.Drawing.Point(392, 138);
            this.textboxNumber.Name = "textboxNumber";
            this.textboxNumber.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxNumber.Size = new System.Drawing.Size(148, 21);
            this.textboxNumber.TabIndex = 2;
            // 
            // labelNumber
            // 
            this.labelNumber.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelNumber.AutoSize = true;
            this.labelNumber.Location = new System.Drawing.Point(546, 140);
            this.labelNumber.Name = "labelNumber";
            this.labelNumber.Size = new System.Drawing.Size(37, 13);
            this.labelNumber.TabIndex = 19;
            this.labelNumber.Text = "شماره";
            // 
            // comboboxMethodDeConnaissance
            // 
            this.comboboxMethodDeConnaissance.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxMethodDeConnaissance.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxMethodDeConnaissance.FormattingEnabled = true;
            this.comboboxMethodDeConnaissance.Location = new System.Drawing.Point(289, 192);
            this.comboboxMethodDeConnaissance.Name = "comboboxMethodDeConnaissance";
            this.comboboxMethodDeConnaissance.Size = new System.Drawing.Size(252, 21);
            this.comboboxMethodDeConnaissance.TabIndex = 32;
            // 
            // labelMethodDeConnaissance
            // 
            this.labelMethodDeConnaissance.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelMethodDeConnaissance.AutoSize = true;
            this.labelMethodDeConnaissance.Location = new System.Drawing.Point(546, 195);
            this.labelMethodDeConnaissance.Name = "labelMethodDeConnaissance";
            this.labelMethodDeConnaissance.Size = new System.Drawing.Size(65, 13);
            this.labelMethodDeConnaissance.TabIndex = 33;
            this.labelMethodDeConnaissance.Text = "نحوه آشنایی";
            // 
            // checkboxSeen
            // 
            this.checkboxSeen.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxSeen.AutoSize = true;
            this.checkboxSeen.Location = new System.Drawing.Point(218, 112);
            this.checkboxSeen.Name = "checkboxSeen";
            this.checkboxSeen.Size = new System.Drawing.Size(65, 17);
            this.checkboxSeen.TabIndex = 34;
            this.checkboxSeen.Text = "دیده شد";
            this.checkboxSeen.UseVisualStyleBackColor = true;
            // 
            // checkboxShouldBeFollowed
            // 
            this.checkboxShouldBeFollowed.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxShouldBeFollowed.AutoSize = true;
            this.checkboxShouldBeFollowed.Checked = true;
            this.checkboxShouldBeFollowed.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkboxShouldBeFollowed.Location = new System.Drawing.Point(130, 112);
            this.checkboxShouldBeFollowed.Name = "checkboxShouldBeFollowed";
            this.checkboxShouldBeFollowed.Size = new System.Drawing.Size(82, 17);
            this.checkboxShouldBeFollowed.TabIndex = 35;
            this.checkboxShouldBeFollowed.Text = "پیگیری شود";
            this.checkboxShouldBeFollowed.UseVisualStyleBackColor = true;
            // 
            // checkboxRegistered
            // 
            this.checkboxRegistered.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxRegistered.AutoSize = true;
            this.checkboxRegistered.Location = new System.Drawing.Point(131, 135);
            this.checkboxRegistered.Name = "checkboxRegistered";
            this.checkboxRegistered.Size = new System.Drawing.Size(79, 17);
            this.checkboxRegistered.TabIndex = 36;
            this.checkboxRegistered.Text = "ثبت نام شد";
            this.checkboxRegistered.UseVisualStyleBackColor = true;
            // 
            // labelColor
            // 
            this.labelColor.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelColor.AutoSize = true;
            this.labelColor.Location = new System.Drawing.Point(546, 168);
            this.labelColor.Name = "labelColor";
            this.labelColor.Size = new System.Drawing.Size(25, 13);
            this.labelColor.TabIndex = 38;
            this.labelColor.Text = "رنگ";
            // 
            // checkboxPrivate
            // 
            this.checkboxPrivate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.checkboxPrivate.AutoSize = true;
            this.checkboxPrivate.Location = new System.Drawing.Point(216, 135);
            this.checkboxPrivate.Name = "checkboxPrivate";
            this.checkboxPrivate.Size = new System.Drawing.Size(67, 17);
            this.checkboxPrivate.TabIndex = 39;
            this.checkboxPrivate.Text = "خصوصی";
            this.checkboxPrivate.UseVisualStyleBackColor = true;
            // 
            // colorcomboboxColor
            // 
            this.colorcomboboxColor.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.colorcomboboxColor.DrawMode = System.Windows.Forms.DrawMode.OwnerDrawFixed;
            this.colorcomboboxColor.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.colorcomboboxColor.FormattingEnabled = true;
            this.colorcomboboxColor.Items.AddRange(new object[] {
            nullColorComboBoxItem1});
            this.colorcomboboxColor.Location = new System.Drawing.Point(409, 164);
            this.colorcomboboxColor.Name = "colorcomboboxColor";
            this.colorcomboboxColor.SelectedColor = null;
            this.colorcomboboxColor.Size = new System.Drawing.Size(131, 22);
            this.colorcomboboxColor.TabIndex = 40;
            // 
            // ucDepartmentSelector
            // 
            this.ucDepartmentSelector.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.ucDepartmentSelector.BackColor = System.Drawing.Color.Transparent;
            this.ucDepartmentSelector.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucDepartmentSelector.HasNullDepartment = true;
            this.ucDepartmentSelector.Location = new System.Drawing.Point(132, 5);
            this.ucDepartmentSelector.Name = "ucDepartmentSelector";
            this.ucDepartmentSelector.Size = new System.Drawing.Size(471, 59);
            this.ucDepartmentSelector.TabIndex = 0;
            // 
            // ucEditPhoneEntry
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.colorcomboboxColor);
            this.Controls.Add(this.checkboxPrivate);
            this.Controls.Add(this.labelColor);
            this.Controls.Add(this.checkboxRegistered);
            this.Controls.Add(this.checkboxShouldBeFollowed);
            this.Controls.Add(this.checkboxSeen);
            this.Controls.Add(this.labelMethodDeConnaissance);
            this.Controls.Add(this.comboboxMethodDeConnaissance);
            this.Controls.Add(this.ucDepartmentSelector);
            this.Controls.Add(this.buttonFollow);
            this.Controls.Add(this.listviewFollows);
            this.Controls.Add(this.labelFollows);
            this.Controls.Add(this.labelRegisterDateValue);
            this.Controls.Add(this.labelRegisterDate);
            this.Controls.Add(this.labelRegistrarValue);
            this.Controls.Add(this.labelRegistrar);
            this.Controls.Add(this.textboxDescription);
            this.Controls.Add(this.labelDescription);
            this.Controls.Add(this.textboxName);
            this.Controls.Add(this.labelName);
            this.Controls.Add(this.textboxNumber);
            this.Controls.Add(this.labelNumber);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucEditPhoneEntry";
            this.Size = new System.Drawing.Size(614, 439);
            this.Load += new System.EventHandler(this.ucEditPhoneEntry_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonFollow;
        private System.Windows.Forms.ListView listviewFollows;
        private System.Windows.Forms.ColumnHeader columnDate;
        private System.Windows.Forms.ColumnHeader columnFollower;
        private System.Windows.Forms.ColumnHeader columnType;
        private System.Windows.Forms.ColumnHeader columnDescription;
        private System.Windows.Forms.Label labelFollows;
        private System.Windows.Forms.Label labelRegisterDateValue;
        private System.Windows.Forms.Label labelRegisterDate;
        private System.Windows.Forms.Label labelRegistrarValue;
        private System.Windows.Forms.Label labelRegistrar;
        private System.Windows.Forms.TextBox textboxDescription;
        private System.Windows.Forms.Label labelDescription;
        private System.Windows.Forms.TextBox textboxName;
        private System.Windows.Forms.Label labelName;
        private System.Windows.Forms.TextBox textboxNumber;
        private System.Windows.Forms.Label labelNumber;
        private Education.UcDepartmentSelector ucDepartmentSelector;
        private System.Windows.Forms.ComboBox comboboxMethodDeConnaissance;
        private System.Windows.Forms.Label labelMethodDeConnaissance;
        private System.Windows.Forms.CheckBox checkboxSeen;
        private System.Windows.Forms.CheckBox checkboxShouldBeFollowed;
        private System.Windows.Forms.CheckBox checkboxRegistered;
        private System.Windows.Forms.Label labelColor;
        private System.Windows.Forms.CheckBox checkboxPrivate;
        private Common.ColorComboBox colorcomboboxColor;
    }
}
