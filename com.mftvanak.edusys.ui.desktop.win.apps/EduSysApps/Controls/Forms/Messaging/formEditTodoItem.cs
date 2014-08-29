using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.TodoWebReference;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging
{
    public partial class FormEditTodoItem : FormBase
    {
        public bool IsNew
        {
            get { return ucEditTodoItem.IsNew; }
            set { ucEditTodoItem.IsNew = value; }
        }

        public TodoItemType TodoItem
        {
            get { return ucEditTodoItem.TodoItem; }
            set { ucEditTodoItem.TodoItem = value; }
        }

        public FormEditTodoItem()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            if (ucEditTodoItem.ValidateInformation() && ucEditTodoItem.Save())
            {
                this.DialogResult = System.Windows.Forms.DialogResult.OK;
            }
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
        }

        public void DisableEditing()
        {
            ucEditTodoItem.DisableEditing();
        }
    }
}
