using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership
{
    partial class UcRoles
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
            this.listviewRoles = new System.Windows.Forms.ListView();
            this.columnheaderNumber = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderId = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnheaderNodeId = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ucCrudToolbar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar();
            this.SuspendLayout();
            // 
            // listviewRoles
            // 
            this.listviewRoles.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnheaderNumber,
            this.columnheaderId,
            this.columnheaderNodeId,
            this.columnheaderName});
            this.listviewRoles.FullRowSelect = true;
            this.listviewRoles.GridLines = true;
            this.listviewRoles.Location = new System.Drawing.Point(3, 31);
            this.listviewRoles.MultiSelect = false;
            this.listviewRoles.Name = "listviewRoles";
            this.listviewRoles.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.listviewRoles.RightToLeftLayout = true;
            this.listviewRoles.Size = new System.Drawing.Size(546, 284);
            this.listviewRoles.TabIndex = 1;
            this.listviewRoles.UseCompatibleStateImageBehavior = false;
            this.listviewRoles.View = System.Windows.Forms.View.Details;
            this.listviewRoles.DoubleClick += new System.EventHandler(this.listviewRoles_DoubleClick);
            // 
            // columnheaderNumber
            // 
            this.columnheaderNumber.Text = "ردیف";
            // 
            // columnheaderId
            // 
            this.columnheaderId.Text = "مشخصه";
            // 
            // columnheaderName
            // 
            this.columnheaderName.Text = "نام";
            this.columnheaderName.Width = 150;
            // 
            // columnheaderNodeId
            // 
            this.columnheaderNodeId.Text = "مشخصه نقش";
            this.columnheaderNodeId.Width = 250;
            // 
            // ucCrudToolbar
            // 
            this.ucCrudToolbar.BackColor = System.Drawing.Color.Transparent;
            this.ucCrudToolbar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucCrudToolbar.Location = new System.Drawing.Point(3, 3);
            this.ucCrudToolbar.Name = "ucCrudToolbar";
            this.ucCrudToolbar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucCrudToolbar.Size = new System.Drawing.Size(546, 33);
            this.ucCrudToolbar.TabIndex = 0;
            this.ucCrudToolbar.AfterAddClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterAddClickedEventHandler(this.ucCrudToolbar_AfterAddClicked);
            this.ucCrudToolbar.AfterEditClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterEditClickedEventHandler(this.ucCrudToolbar_AfterEditClicked);
            this.ucCrudToolbar.AfterDeleteClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterDeleteClickedEventHandler(this.ucCrudToolbar_AfterDeleteClicked);
            this.ucCrudToolbar.AfterRefreshClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterRefreshClickedEventHandler(this.ucCrudToolbar_AfterRefreshClicked);
            // 
            // ucRoles
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.listviewRoles);
            this.Controls.Add(this.ucCrudToolbar);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucRoles";
            this.Size = new System.Drawing.Size(552, 318);
            this.ResumeLayout(false);

        }

        #endregion

        private UcCrudToolbar ucCrudToolbar;
        private System.Windows.Forms.ListView listviewRoles;
        private System.Windows.Forms.ColumnHeader columnheaderNumber;
        private System.Windows.Forms.ColumnHeader columnheaderId;
        private System.Windows.Forms.ColumnHeader columnheaderName;
        private System.Windows.Forms.ColumnHeader columnheaderNodeId;
    }
}
