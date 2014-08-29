
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Personnel;
namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official
{
    partial class UcEmployeeEditor
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
            this.tabcontrol = new System.Windows.Forms.TabControl();
            this.tabpagePersonalInformation = new System.Windows.Forms.TabPage();
            this.ucEditPerson = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Personnel.UcEditPerson();
            this.tabpageUserInformation = new System.Windows.Forms.TabPage();
            this.ucEditUser = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Membership.UcEditUser();
            this.tabpageEmployeeInformation = new System.Windows.Forms.TabPage();
            this.ucEditEmployee = new Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Official.UcEditEmployee();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.tabcontrol.SuspendLayout();
            this.tabpagePersonalInformation.SuspendLayout();
            this.tabpageUserInformation.SuspendLayout();
            this.tabpageEmployeeInformation.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabcontrol
            // 
            this.tabcontrol.Controls.Add(this.tabpagePersonalInformation);
            this.tabcontrol.Controls.Add(this.tabpageUserInformation);
            this.tabcontrol.Controls.Add(this.tabpageEmployeeInformation);
            this.tabcontrol.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabcontrol.Location = new System.Drawing.Point(3, 3);
            this.tabcontrol.Name = "tabcontrol";
            this.tabcontrol.RightToLeftLayout = true;
            this.tabcontrol.SelectedIndex = 0;
            this.tabcontrol.Size = new System.Drawing.Size(579, 477);
            this.tabcontrol.TabIndex = 0;
            // 
            // tabpagePersonalInformation
            // 
            this.tabpagePersonalInformation.Controls.Add(this.ucEditPerson);
            this.tabpagePersonalInformation.Location = new System.Drawing.Point(4, 22);
            this.tabpagePersonalInformation.Name = "tabpagePersonalInformation";
            this.tabpagePersonalInformation.Padding = new System.Windows.Forms.Padding(3);
            this.tabpagePersonalInformation.Size = new System.Drawing.Size(571, 451);
            this.tabpagePersonalInformation.TabIndex = 0;
            this.tabpagePersonalInformation.Text = "اطلاعات فردی";
            this.tabpagePersonalInformation.UseVisualStyleBackColor = true;
            // 
            // ucEditPerson
            // 
            this.ucEditPerson.BackColor = System.Drawing.Color.Transparent;
            this.ucEditPerson.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEditPerson.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEditPerson.IsNew = true;
            this.ucEditPerson.Location = new System.Drawing.Point(3, 3);
            this.ucEditPerson.Name = "ucEditPerson";
            this.ucEditPerson.Person = null;
            this.ucEditPerson.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.ucEditPerson.Size = new System.Drawing.Size(565, 445);
            this.ucEditPerson.TabIndex = 0;
            // 
            // tabpageUserInformation
            // 
            this.tabpageUserInformation.Controls.Add(this.ucEditUser);
            this.tabpageUserInformation.Location = new System.Drawing.Point(4, 22);
            this.tabpageUserInformation.Name = "tabpageUserInformation";
            this.tabpageUserInformation.Padding = new System.Windows.Forms.Padding(3);
            this.tabpageUserInformation.Size = new System.Drawing.Size(571, 451);
            this.tabpageUserInformation.TabIndex = 1;
            this.tabpageUserInformation.Text = "اطلاعات کاربری";
            this.tabpageUserInformation.UseVisualStyleBackColor = true;
            // 
            // ucEditUser
            // 
            this.ucEditUser.BackColor = System.Drawing.Color.Transparent;
            this.ucEditUser.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEditUser.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEditUser.IsNew = true;
            this.ucEditUser.Location = new System.Drawing.Point(3, 3);
            this.ucEditUser.Name = "ucEditUser";
            this.ucEditUser.Size = new System.Drawing.Size(565, 445);
            this.ucEditUser.TabIndex = 0;
            this.ucEditUser.User = null;
            // 
            // tabpageEmployeeInformation
            // 
            this.tabpageEmployeeInformation.Controls.Add(this.ucEditEmployee);
            this.tabpageEmployeeInformation.Location = new System.Drawing.Point(4, 22);
            this.tabpageEmployeeInformation.Name = "tabpageEmployeeInformation";
            this.tabpageEmployeeInformation.Size = new System.Drawing.Size(571, 451);
            this.tabpageEmployeeInformation.TabIndex = 2;
            this.tabpageEmployeeInformation.Text = "اطلاعات پرسنلی";
            this.tabpageEmployeeInformation.UseVisualStyleBackColor = true;
            // 
            // ucEditEmployee
            // 
            this.ucEditEmployee.BackColor = System.Drawing.Color.Transparent;
            this.ucEditEmployee.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucEditEmployee.Employee = null;
            this.ucEditEmployee.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ucEditEmployee.IsNew = true;
            this.ucEditEmployee.Location = new System.Drawing.Point(0, 0);
            this.ucEditEmployee.Name = "ucEditEmployee";
            this.ucEditEmployee.Size = new System.Drawing.Size(571, 451);
            this.ucEditEmployee.TabIndex = 0;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Controls.Add(this.tabcontrol, 0, 0);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 483F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(585, 483);
            this.tableLayoutPanel1.TabIndex = 1;
            // 
            // ucEmployeeEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Transparent;
            this.Controls.Add(this.tableLayoutPanel1);
            this.Font = new System.Drawing.Font("Tahoma", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "ucEmployeeEditor";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Size = new System.Drawing.Size(585, 483);
            this.tabcontrol.ResumeLayout(false);
            this.tabpagePersonalInformation.ResumeLayout(false);
            this.tabpageUserInformation.ResumeLayout(false);
            this.tabpageEmployeeInformation.ResumeLayout(false);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabcontrol;
        private System.Windows.Forms.TabPage tabpageUserInformation;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.TabPage tabpageEmployeeInformation;
        private System.Windows.Forms.TabPage tabpagePersonalInformation;
        private UcEditPerson ucEditPerson;
        private UcEditUser ucEditUser;
        private UcEditEmployee ucEditEmployee;
    }
}
