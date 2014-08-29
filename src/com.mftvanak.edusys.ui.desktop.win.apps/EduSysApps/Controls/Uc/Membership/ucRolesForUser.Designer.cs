namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    partial class UcRolesForUser
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
            this.buttonRemoveRole = new System.Windows.Forms.Button();
            this.buttonAddRole = new System.Windows.Forms.Button();
            this.comboboxRoles = new System.Windows.Forms.ComboBox();
            this.listviewRoles = new System.Windows.Forms.ListView();
            this.columnheaderRoleName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.buttonRefresh = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // buttonRemoveRole
            // 
            this.buttonRemoveRole.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRemoveRole.Location = new System.Drawing.Point(369, 4);
            this.buttonRemoveRole.Name = "buttonRemoveRole";
            this.buttonRemoveRole.Size = new System.Drawing.Size(75, 23);
            this.buttonRemoveRole.TabIndex = 1;
            this.buttonRemoveRole.Text = "حذف";
            this.buttonRemoveRole.UseVisualStyleBackColor = true;
            this.buttonRemoveRole.Click += new System.EventHandler(this.buttonRemoveRole_Click);
            // 
            // buttonAddRole
            // 
            this.buttonAddRole.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonAddRole.Location = new System.Drawing.Point(288, 4);
            this.buttonAddRole.Name = "buttonAddRole";
            this.buttonAddRole.Size = new System.Drawing.Size(75, 23);
            this.buttonAddRole.TabIndex = 0;
            this.buttonAddRole.Text = "اضافه کردن";
            this.buttonAddRole.UseVisualStyleBackColor = true;
            this.buttonAddRole.Click += new System.EventHandler(this.buttonAddRole_Click);
            // 
            // comboboxRoles
            // 
            this.comboboxRoles.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxRoles.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxRoles.FormattingEnabled = true;
            this.comboboxRoles.Location = new System.Drawing.Point(97, 4);
            this.comboboxRoles.Name = "comboboxRoles";
            this.comboboxRoles.Size = new System.Drawing.Size(185, 21);
            this.comboboxRoles.TabIndex = 2;
            // 
            // listviewRoles
            // 
            this.listviewRoles.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.listviewRoles.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnheaderRoleName});
            this.listviewRoles.FullRowSelect = true;
            this.listviewRoles.GridLines = true;
            this.listviewRoles.Location = new System.Drawing.Point(3, 31);
            this.listviewRoles.Name = "listviewRoles";
            this.listviewRoles.RightToLeftLayout = true;
            this.listviewRoles.Size = new System.Drawing.Size(441, 186);
            this.listviewRoles.TabIndex = 4;
            this.listviewRoles.UseCompatibleStateImageBehavior = false;
            this.listviewRoles.View = System.Windows.Forms.View.Details;
            // 
            // columnheaderRoleName
            // 
            this.columnheaderRoleName.Text = "نقش";
            this.columnheaderRoleName.Width = 250;
            // 
            // buttonRefresh
            // 
            this.buttonRefresh.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRefresh.Location = new System.Drawing.Point(67, 1);
            this.buttonRefresh.Name = "buttonRefresh";
            this.buttonRefresh.Size = new System.Drawing.Size(24, 24);
            this.buttonRefresh.TabIndex = 3;
            this.buttonRefresh.UseVisualStyleBackColor = true;
            this.buttonRefresh.Click += new System.EventHandler(this.buttonRefresh_Click);
            // 
            // ucRolesForUser
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.buttonRefresh);
            this.Controls.Add(this.buttonRemoveRole);
            this.Controls.Add(this.buttonAddRole);
            this.Controls.Add(this.comboboxRoles);
            this.Controls.Add(this.listviewRoles);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucRolesForUser";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(447, 220);
            this.Load += new System.EventHandler(this.ucRolesForUser_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button buttonRemoveRole;
        private System.Windows.Forms.Button buttonAddRole;
        private System.Windows.Forms.ComboBox comboboxRoles;
        private System.Windows.Forms.ListView listviewRoles;
        private System.Windows.Forms.ColumnHeader columnheaderRoleName;
        private System.Windows.Forms.Button buttonRefresh;
    }
}
