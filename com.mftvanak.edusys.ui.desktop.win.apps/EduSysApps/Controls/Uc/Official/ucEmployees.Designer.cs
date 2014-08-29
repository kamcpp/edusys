using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    partial class UcEmployees
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
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.ucCrudToolbar = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar();
            this.ucEduSysDataGridView = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcEduSysDataGridView();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Controls.Add(this.ucCrudToolbar, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.ucEduSysDataGridView, 0, 1);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 30F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(614, 418);
            this.tableLayoutPanel1.TabIndex = 1;
            // 
            // ucCrudToolbar
            // 
            this.ucCrudToolbar.BackColor = System.Drawing.Color.Transparent;
            this.ucCrudToolbar.Dock = System.Windows.Forms.DockStyle.Top;
            this.ucCrudToolbar.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucCrudToolbar.Location = new System.Drawing.Point(3, 3);
            this.ucCrudToolbar.Name = "ucCrudToolbar";
            this.ucCrudToolbar.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucCrudToolbar.Size = new System.Drawing.Size(608, 24);
            this.ucCrudToolbar.TabIndex = 0;
            this.ucCrudToolbar.AfterAddClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterAddClickedEventHandler(this.ucCrudToolbar_AfterAddClicked);
            this.ucCrudToolbar.AfterRefreshClicked += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcCrudToolbar.AfterRefreshClickedEventHandler(this.ucCrudToolbar_AfterRefreshClicked);
            // 
            // ucEduSysDataGridView
            // 
            this.ucEduSysDataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEduSysDataGridView.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEduSysDataGridView.Location = new System.Drawing.Point(3, 33);
            this.ucEduSysDataGridView.Name = "ucEduSysDataGridView";
            this.ucEduSysDataGridView.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEduSysDataGridView.Size = new System.Drawing.Size(608, 382);
            this.ucEduSysDataGridView.TabIndex = 2;
            this.ucEduSysDataGridView.CellDoubleClick += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcEduSysDataGridView.CellDoubleClickHandler(this.ucEduSysDataGridView_CellDoubleClick);
            // 
            // UcEmployees
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.tableLayoutPanel1);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcEmployees";
            this.Size = new System.Drawing.Size(614, 418);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private UcCrudToolbar ucCrudToolbar;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private UcEduSysDataGridView ucEduSysDataGridView;
    }
}
