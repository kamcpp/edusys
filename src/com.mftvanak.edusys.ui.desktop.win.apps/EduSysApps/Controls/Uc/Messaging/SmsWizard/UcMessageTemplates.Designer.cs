namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcMessageTemplates
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
            this.datagridviewMessageTemplates = new System.Windows.Forms.DataGridView();
            this.columnNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnOwnerFullName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnText = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.columnDescription = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewMessageTemplates)).BeginInit();
            this.SuspendLayout();
            // 
            // datagridviewMessageTemplates
            // 
            this.datagridviewMessageTemplates.AllowUserToAddRows = false;
            this.datagridviewMessageTemplates.AllowUserToDeleteRows = false;
            this.datagridviewMessageTemplates.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datagridviewMessageTemplates.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.columnNumber,
            this.columnId,
            this.columnName,
            this.columnOwnerFullName,
            this.columnText,
            this.columnDescription});
            this.datagridviewMessageTemplates.Dock = System.Windows.Forms.DockStyle.Fill;
            this.datagridviewMessageTemplates.Location = new System.Drawing.Point(0, 0);
            this.datagridviewMessageTemplates.Name = "datagridviewMessageTemplates";
            this.datagridviewMessageTemplates.ReadOnly = true;
            this.datagridviewMessageTemplates.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.datagridviewMessageTemplates.Size = new System.Drawing.Size(772, 273);
            this.datagridviewMessageTemplates.TabIndex = 0;
            this.datagridviewMessageTemplates.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.datagridviewMessageTemplates_CellDoubleClick);
            // 
            // columnNumber
            // 
            this.columnNumber.HeaderText = "ردیف";
            this.columnNumber.Name = "columnNumber";
            this.columnNumber.ReadOnly = true;
            this.columnNumber.Width = 60;
            // 
            // columnId
            // 
            this.columnId.HeaderText = "شناسه";
            this.columnId.Name = "columnId";
            this.columnId.ReadOnly = true;
            this.columnId.Width = 60;
            // 
            // columnName
            // 
            this.columnName.HeaderText = "نام";
            this.columnName.Name = "columnName";
            this.columnName.ReadOnly = true;
            this.columnName.Width = 150;
            // 
            // columnOwnerFullName
            // 
            this.columnOwnerFullName.HeaderText = "نام سازنده";
            this.columnOwnerFullName.Name = "columnOwnerFullName";
            this.columnOwnerFullName.ReadOnly = true;
            this.columnOwnerFullName.Width = 150;
            // 
            // columnText
            // 
            this.columnText.HeaderText = "متن قالب";
            this.columnText.Name = "columnText";
            this.columnText.ReadOnly = true;
            this.columnText.Width = 350;
            // 
            // columnDescription
            // 
            this.columnDescription.HeaderText = "توضیحات";
            this.columnDescription.Name = "columnDescription";
            this.columnDescription.ReadOnly = true;
            this.columnDescription.Width = 400;
            // 
            // UcMessageTemplates
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.datagridviewMessageTemplates);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcMessageTemplates";
            this.Size = new System.Drawing.Size(772, 273);
            ((System.ComponentModel.ISupportInitialize)(this.datagridviewMessageTemplates)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView datagridviewMessageTemplates;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnId;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnOwnerFullName;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnText;
        private System.Windows.Forms.DataGridViewTextBoxColumn columnDescription;
    }
}
