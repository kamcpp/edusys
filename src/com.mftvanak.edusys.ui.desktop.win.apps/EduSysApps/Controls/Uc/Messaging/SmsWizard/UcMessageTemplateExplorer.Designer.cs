namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcMessageTemplateExplorer
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
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabpageMine = new System.Windows.Forms.TabPage();
            this.buttonNewMessageTemplate = new System.Windows.Forms.Button();
            this.buttonRefreshMyMessageTemplates = new System.Windows.Forms.Button();
            this.tabpageAll = new System.Windows.Forms.TabPage();
            this.buttonRefreshAllMessageTemplates = new System.Windows.Forms.Button();
            this.ucmessagetemplatesMine = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcMessageTemplates();
            this.ucmessagetemplatesAll = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcMessageTemplates();
            this.buttonRemoveMessageTemplate = new System.Windows.Forms.Button();
            this.tabControl.SuspendLayout();
            this.tabpageMine.SuspendLayout();
            this.tabpageAll.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabpageMine);
            this.tabControl.Controls.Add(this.tabpageAll);
            this.tabControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabControl.Location = new System.Drawing.Point(0, 0);
            this.tabControl.Name = "tabControl";
            this.tabControl.RightToLeftLayout = true;
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(677, 358);
            this.tabControl.TabIndex = 0;
            // 
            // tabpageMine
            // 
            this.tabpageMine.Controls.Add(this.buttonRemoveMessageTemplate);
            this.tabpageMine.Controls.Add(this.buttonNewMessageTemplate);
            this.tabpageMine.Controls.Add(this.buttonRefreshMyMessageTemplates);
            this.tabpageMine.Controls.Add(this.ucmessagetemplatesMine);
            this.tabpageMine.Location = new System.Drawing.Point(4, 22);
            this.tabpageMine.Name = "tabpageMine";
            this.tabpageMine.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageMine.Size = new System.Drawing.Size(669, 332);
            this.tabpageMine.TabIndex = 0;
            this.tabpageMine.Text = "قالب های من";
            this.tabpageMine.UseVisualStyleBackColor = true;
            // 
            // buttonNewMessageTemplate
            // 
            this.buttonNewMessageTemplate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonNewMessageTemplate.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonNewMessageTemplate.Location = new System.Drawing.Point(588, 6);
            this.buttonNewMessageTemplate.Name = "buttonNewMessageTemplate";
            this.buttonNewMessageTemplate.Size = new System.Drawing.Size(75, 23);
            this.buttonNewMessageTemplate.TabIndex = 2;
            this.buttonNewMessageTemplate.Text = "قالب جدید";
            this.buttonNewMessageTemplate.UseVisualStyleBackColor = true;
            this.buttonNewMessageTemplate.Click += new System.EventHandler(this.buttonNewMessageTemplate_Click);
            // 
            // buttonRefreshMyMessageTemplates
            // 
            this.buttonRefreshMyMessageTemplates.Location = new System.Drawing.Point(6, 6);
            this.buttonRefreshMyMessageTemplates.Name = "buttonRefreshMyMessageTemplates";
            this.buttonRefreshMyMessageTemplates.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshMyMessageTemplates.TabIndex = 1;
            this.buttonRefreshMyMessageTemplates.Text = "بازآوری";
            this.buttonRefreshMyMessageTemplates.UseVisualStyleBackColor = true;
            this.buttonRefreshMyMessageTemplates.Click += new System.EventHandler(this.buttonRefreshMyMessageTemplates_Click);
            // 
            // tabpageAll
            // 
            this.tabpageAll.Controls.Add(this.buttonRefreshAllMessageTemplates);
            this.tabpageAll.Controls.Add(this.ucmessagetemplatesAll);
            this.tabpageAll.Location = new System.Drawing.Point(4, 22);
            this.tabpageAll.Name = "tabpageAll";
            this.tabpageAll.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageAll.Size = new System.Drawing.Size(669, 332);
            this.tabpageAll.TabIndex = 1;
            this.tabpageAll.Text = "تمامی قالب ها";
            this.tabpageAll.UseVisualStyleBackColor = true;
            // 
            // buttonRefreshAllMessageTemplates
            // 
            this.buttonRefreshAllMessageTemplates.Location = new System.Drawing.Point(6, 6);
            this.buttonRefreshAllMessageTemplates.Name = "buttonRefreshAllMessageTemplates";
            this.buttonRefreshAllMessageTemplates.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshAllMessageTemplates.TabIndex = 2;
            this.buttonRefreshAllMessageTemplates.Text = "بازآوری";
            this.buttonRefreshAllMessageTemplates.UseVisualStyleBackColor = true;
            this.buttonRefreshAllMessageTemplates.Click += new System.EventHandler(this.buttonRefreshAllMessageTemplates_Click);
            // 
            // ucmessagetemplatesMine
            // 
            this.ucmessagetemplatesMine.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucmessagetemplatesMine.Editable = true;
            this.ucmessagetemplatesMine.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucmessagetemplatesMine.Location = new System.Drawing.Point(6, 34);
            this.ucmessagetemplatesMine.MessageTemplates = null;
            this.ucmessagetemplatesMine.MessageTemplateType = Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.MessageTemplateTypeEnum.Both;
            this.ucmessagetemplatesMine.Name = "ucmessagetemplatesMine";
            this.ucmessagetemplatesMine.Size = new System.Drawing.Size(657, 292);
            this.ucmessagetemplatesMine.TabIndex = 0;
            this.ucmessagetemplatesMine.NeedsRefresh += new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.UcMessageTemplates.NeedsRefreshEventHandler(this.ucmessagetemplatesMine_NeedsRefresh);
            // 
            // ucmessagetemplatesAll
            // 
            this.ucmessagetemplatesAll.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucmessagetemplatesAll.Editable = false;
            this.ucmessagetemplatesAll.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucmessagetemplatesAll.Location = new System.Drawing.Point(6, 34);
            this.ucmessagetemplatesAll.MessageTemplates = null;
            this.ucmessagetemplatesAll.MessageTemplateType = Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard.MessageTemplateTypeEnum.Both;
            this.ucmessagetemplatesAll.Name = "ucmessagetemplatesAll";
            this.ucmessagetemplatesAll.Size = new System.Drawing.Size(657, 292);
            this.ucmessagetemplatesAll.TabIndex = 1;
            // 
            // buttonRemoveMessageTemplate
            // 
            this.buttonRemoveMessageTemplate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRemoveMessageTemplate.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonRemoveMessageTemplate.Location = new System.Drawing.Point(507, 6);
            this.buttonRemoveMessageTemplate.Name = "buttonRemoveMessageTemplate";
            this.buttonRemoveMessageTemplate.Size = new System.Drawing.Size(75, 23);
            this.buttonRemoveMessageTemplate.TabIndex = 3;
            this.buttonRemoveMessageTemplate.Text = "حذف قالب";
            this.buttonRemoveMessageTemplate.UseVisualStyleBackColor = true;
            this.buttonRemoveMessageTemplate.Click += new System.EventHandler(this.buttonRemoveMessageTemplate_Click);
            // 
            // UcMessageTemplateExplorer
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.tabControl);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcMessageTemplateExplorer";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(677, 358);
            this.tabControl.ResumeLayout(false);
            this.tabpageMine.ResumeLayout(false);
            this.tabpageAll.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl;
        private System.Windows.Forms.TabPage tabpageMine;
        private System.Windows.Forms.TabPage tabpageAll;
        private UcMessageTemplates ucmessagetemplatesMine;
        private UcMessageTemplates ucmessagetemplatesAll;
        private System.Windows.Forms.Button buttonRefreshMyMessageTemplates;
        private System.Windows.Forms.Button buttonNewMessageTemplate;
        private System.Windows.Forms.Button buttonRefreshAllMessageTemplates;
        private System.Windows.Forms.Button buttonRemoveMessageTemplate;
    }
}
