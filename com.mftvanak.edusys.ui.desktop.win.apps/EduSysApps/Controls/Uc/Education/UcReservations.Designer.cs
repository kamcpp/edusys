namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    partial class UcReservations
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
            this.labelDepartments = new System.Windows.Forms.Label();
            this.comboboxDepartments = new System.Windows.Forms.ComboBox();
            this.buttonSearchReservations = new System.Windows.Forms.Button();
            this.labelReservationPlan = new System.Windows.Forms.Label();
            this.comboboxReservationPlans = new System.Windows.Forms.ComboBox();
            this.ucEduSysDataGridView = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common.UcEduSysDataGridView();
            this.SuspendLayout();
            // 
            // labelDepartments
            // 
            this.labelDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDepartments.AutoSize = true;
            this.labelDepartments.Location = new System.Drawing.Point(639, 13);
            this.labelDepartments.Name = "labelDepartments";
            this.labelDepartments.Size = new System.Drawing.Size(42, 13);
            this.labelDepartments.TabIndex = 6;
            this.labelDepartments.Text = "دپارتمان";
            // 
            // comboboxDepartments
            // 
            this.comboboxDepartments.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxDepartments.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxDepartments.FormattingEnabled = true;
            this.comboboxDepartments.Location = new System.Drawing.Point(383, 10);
            this.comboboxDepartments.Name = "comboboxDepartments";
            this.comboboxDepartments.Size = new System.Drawing.Size(250, 21);
            this.comboboxDepartments.TabIndex = 5;
            // 
            // buttonSearchReservations
            // 
            this.buttonSearchReservations.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonSearchReservations.Location = new System.Drawing.Point(31, 8);
            this.buttonSearchReservations.Name = "buttonSearchReservations";
            this.buttonSearchReservations.Size = new System.Drawing.Size(75, 23);
            this.buttonSearchReservations.TabIndex = 4;
            this.buttonSearchReservations.Text = "جست و جو";
            this.buttonSearchReservations.UseVisualStyleBackColor = true;
            this.buttonSearchReservations.Click += new System.EventHandler(this.buttonSearchReservations_Click);
            // 
            // labelReservationPlan
            // 
            this.labelReservationPlan.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelReservationPlan.AutoSize = true;
            this.labelReservationPlan.Location = new System.Drawing.Point(311, 13);
            this.labelReservationPlan.Name = "labelReservationPlan";
            this.labelReservationPlan.Size = new System.Drawing.Size(66, 13);
            this.labelReservationPlan.TabIndex = 9;
            this.labelReservationPlan.Text = "پلان تبلیغاتی";
            // 
            // comboboxReservationPlans
            // 
            this.comboboxReservationPlans.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.comboboxReservationPlans.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboboxReservationPlans.FormattingEnabled = true;
            this.comboboxReservationPlans.Location = new System.Drawing.Point(112, 10);
            this.comboboxReservationPlans.Name = "comboboxReservationPlans";
            this.comboboxReservationPlans.Size = new System.Drawing.Size(193, 21);
            this.comboboxReservationPlans.TabIndex = 8;
            // 
            // ucEduSysDataGridView
            // 
            this.ucEduSysDataGridView.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.ucEduSysDataGridView.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEduSysDataGridView.Location = new System.Drawing.Point(3, 37);
            this.ucEduSysDataGridView.Name = "ucEduSysDataGridView";
            this.ucEduSysDataGridView.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEduSysDataGridView.Size = new System.Drawing.Size(684, 363);
            this.ucEduSysDataGridView.TabIndex = 7;
            // 
            // UcReservations
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.labelReservationPlan);
            this.Controls.Add(this.comboboxReservationPlans);
            this.Controls.Add(this.ucEduSysDataGridView);
            this.Controls.Add(this.labelDepartments);
            this.Controls.Add(this.comboboxDepartments);
            this.Controls.Add(this.buttonSearchReservations);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "UcReservations";
            this.Size = new System.Drawing.Size(687, 403);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelDepartments;
        private System.Windows.Forms.ComboBox comboboxDepartments;
        private System.Windows.Forms.Button buttonSearchReservations;
        private Common.UcEduSysDataGridView ucEduSysDataGridView;
        private System.Windows.Forms.Label labelReservationPlan;
        private System.Windows.Forms.ComboBox comboboxReservationPlans;
    }
}
