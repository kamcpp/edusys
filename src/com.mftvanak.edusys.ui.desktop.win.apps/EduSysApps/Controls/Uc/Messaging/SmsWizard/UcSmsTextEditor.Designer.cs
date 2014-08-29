namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    partial class UcSmsTextEditor
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
            this.labelSmsCount = new System.Windows.Forms.Label();
            this.textboxText = new System.Windows.Forms.TextBox();
            this.labelSmsCountValue = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // labelSmsCount
            // 
            this.labelSmsCount.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.labelSmsCount.AutoSize = true;
            this.labelSmsCount.Location = new System.Drawing.Point(358, 194);
            this.labelSmsCount.Name = "labelSmsCount";
            this.labelSmsCount.Size = new System.Drawing.Size(77, 13);
            this.labelSmsCount.TabIndex = 4;
            this.labelSmsCount.Text = "طول متن پیامک";
            // 
            // textboxText
            // 
            this.textboxText.AcceptsReturn = true;
            this.textboxText.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textboxText.Location = new System.Drawing.Point(3, 3);
            this.textboxText.Multiline = true;
            this.textboxText.Name = "textboxText";
            this.textboxText.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.textboxText.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.textboxText.Size = new System.Drawing.Size(430, 190);
            this.textboxText.TabIndex = 3;
            this.textboxText.TextChanged += new System.EventHandler(this.textboxText_TextChanged);
            // 
            // labelSmsCountValue
            // 
            this.labelSmsCountValue.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.labelSmsCountValue.AutoSize = true;
            this.labelSmsCountValue.Location = new System.Drawing.Point(318, 194);
            this.labelSmsCountValue.Name = "labelSmsCountValue";
            this.labelSmsCountValue.Size = new System.Drawing.Size(35, 13);
            this.labelSmsCountValue.TabIndex = 5;
            this.labelSmsCountValue.Text = "label2";
            // 
            // UcSmsTextEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.labelSmsCountValue);
            this.Controls.Add(this.labelSmsCount);
            this.Controls.Add(this.textboxText);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcSmsTextEditor";
            this.Size = new System.Drawing.Size(436, 209);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelSmsCount;
        private System.Windows.Forms.TextBox textboxText;
        private System.Windows.Forms.Label labelSmsCountValue;
    }
}
