namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    partial class formReport
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
            this.groupboxSearch = new System.Windows.Forms.GroupBox();
            this.listviewPhones = new System.Windows.Forms.ListView();
            this.columnName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnPhone = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnRegistrar = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnDate = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnDescription = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.labelDepartment = new System.Windows.Forms.Label();
            this.textboxDepartment = new System.Windows.Forms.TextBox();
            this.labelRegistrar = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.buttonSave = new System.Windows.Forms.Button();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.groupboxSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupboxSearch
            // 
            this.groupboxSearch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupboxSearch.Controls.Add(this.textBox4);
            this.groupboxSearch.Controls.Add(this.label3);
            this.groupboxSearch.Controls.Add(this.buttonSave);
            this.groupboxSearch.Controls.Add(this.textBox3);
            this.groupboxSearch.Controls.Add(this.label2);
            this.groupboxSearch.Controls.Add(this.textBox2);
            this.groupboxSearch.Controls.Add(this.label1);
            this.groupboxSearch.Controls.Add(this.textBox1);
            this.groupboxSearch.Controls.Add(this.labelRegistrar);
            this.groupboxSearch.Controls.Add(this.textboxDepartment);
            this.groupboxSearch.Controls.Add(this.labelDepartment);
            this.groupboxSearch.Location = new System.Drawing.Point(12, 12);
            this.groupboxSearch.Name = "groupboxSearch";
            this.groupboxSearch.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.groupboxSearch.Size = new System.Drawing.Size(683, 113);
            this.groupboxSearch.TabIndex = 0;
            this.groupboxSearch.TabStop = false;
            this.groupboxSearch.Text = "پنل جست و جو";
            // 
            // listviewPhones
            // 
            this.listviewPhones.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.listviewPhones.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnName,
            this.columnPhone,
            this.columnRegistrar,
            this.columnDate,
            this.columnDescription});
            this.listviewPhones.FullRowSelect = true;
            this.listviewPhones.GridLines = true;
            this.listviewPhones.Location = new System.Drawing.Point(12, 131);
            this.listviewPhones.MultiSelect = false;
            this.listviewPhones.Name = "listviewPhones";
            this.listviewPhones.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewPhones.RightToLeftLayout = true;
            this.listviewPhones.Size = new System.Drawing.Size(683, 335);
            this.listviewPhones.TabIndex = 1;
            this.listviewPhones.UseCompatibleStateImageBehavior = false;
            this.listviewPhones.View = System.Windows.Forms.View.Details;
            // 
            // columnName
            // 
            this.columnName.Text = "نام";
            this.columnName.Width = 100;
            // 
            // columnPhone
            // 
            this.columnPhone.Text = "تلفن";
            this.columnPhone.Width = 100;
            // 
            // columnRegistrar
            // 
            this.columnRegistrar.Text = "ثبت کننده";
            this.columnRegistrar.Width = 100;
            // 
            // columnDate
            // 
            this.columnDate.Text = "تاریخ";
            this.columnDate.Width = 70;
            // 
            // columnDescription
            // 
            this.columnDescription.Text = "توضیحات";
            this.columnDescription.Width = 200;
            // 
            // labelDepartment
            // 
            this.labelDepartment.AutoSize = true;
            this.labelDepartment.Location = new System.Drawing.Point(623, 27);
            this.labelDepartment.Name = "labelDepartment";
            this.labelDepartment.Size = new System.Drawing.Size(42, 13);
            this.labelDepartment.TabIndex = 0;
            this.labelDepartment.Text = "دپارتمان";
            // 
            // textboxDepartment
            // 
            this.textboxDepartment.Location = new System.Drawing.Point(424, 24);
            this.textboxDepartment.Name = "textboxDepartment";
            this.textboxDepartment.Size = new System.Drawing.Size(193, 21);
            this.textboxDepartment.TabIndex = 1;
            // 
            // labelRegistrar
            // 
            this.labelRegistrar.AutoSize = true;
            this.labelRegistrar.Location = new System.Drawing.Point(367, 27);
            this.labelRegistrar.Name = "labelRegistrar";
            this.labelRegistrar.Size = new System.Drawing.Size(51, 13);
            this.labelRegistrar.TabIndex = 2;
            this.labelRegistrar.Text = "ثبت کننده";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(246, 24);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(115, 21);
            this.textBox1.TabIndex = 3;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(99, 24);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(113, 21);
            this.textBox2.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(218, 27);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(20, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "نام";
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(470, 51);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(147, 21);
            this.textBox3.TabIndex = 7;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(623, 54);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "شماره";
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(13, 22);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(80, 23);
            this.buttonSave.TabIndex = 9;
            this.buttonSave.Text = "جست و جو";
            this.buttonSave.UseVisualStyleBackColor = true;
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(99, 51);
            this.textBox4.Multiline = true;
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(312, 48);
            this.textBox4.TabIndex = 11;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(417, 54);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(47, 13);
            this.label3.TabIndex = 10;
            this.label3.Text = "توضیحات";
            // 
            // formReport
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(707, 478);
            this.Controls.Add(this.listviewPhones);
            this.Controls.Add(this.groupboxSearch);
            this.Name = "formReport";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "گزارشات";
            this.groupboxSearch.ResumeLayout(false);
            this.groupboxSearch.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupboxSearch;
        private System.Windows.Forms.ListView listviewPhones;
        private System.Windows.Forms.ColumnHeader columnName;
        private System.Windows.Forms.ColumnHeader columnPhone;
        private System.Windows.Forms.ColumnHeader columnRegistrar;
        private System.Windows.Forms.ColumnHeader columnDate;
        private System.Windows.Forms.ColumnHeader columnDescription;
        private System.Windows.Forms.TextBox textboxDepartment;
        private System.Windows.Forms.Label labelDepartment;
        private System.Windows.Forms.Label labelRegistrar;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.Label label3;
    }
}