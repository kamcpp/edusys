using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common
{
    public class AddClickedEventArgs : EventArgs
    {
        public bool Canceled { get; set; }
    }

    public class DeleteClickedEventArgs : EventArgs
    {
        public bool Canceled { get; set; }
    }

    public class EditClickedEventArgs : EventArgs
    {
        public bool Canceled { get; set; }
    }

    public partial class UcCrudToolbar : UserControl
    {
        public delegate void BeforeAddClickedEventHanlder(object sender, AddClickedEventArgs e);
        public delegate void AfterAddClickedEventHandler(object sender);
        public delegate void BeforeEditClickedEventHandler(object sender, EditClickedEventArgs e);
        public delegate void AfterEditClickedEventHandler(object sender);
        public delegate void BeforeDeleteClickedEventHandler(object sender, DeleteClickedEventArgs e);
        public delegate void AfterDeleteClickedEventHandler(object sender);
        public delegate void AfterRefreshClickedEventHandler(object sender);

        public event BeforeAddClickedEventHanlder BeforeAddClicked;
        public event AfterAddClickedEventHandler AfterAddClicked;
        public event BeforeEditClickedEventHandler BeforeEditClicked;
        public event AfterEditClickedEventHandler AfterEditClicked;
        public event BeforeDeleteClickedEventHandler BeforeDeleteClicked;
        public event AfterDeleteClickedEventHandler AfterDeleteClicked;
        public event AfterRefreshClickedEventHandler AfterRefreshClicked;

        protected void OnBeforeAddClicked(AddClickedEventArgs e)
        {
            if (BeforeAddClicked != null)
            {
                BeforeAddClicked(this, e);
            }
        }

        protected void OnAfterAddClicked()
        {
            if (AfterAddClicked != null)
            {
                AfterAddClicked(this);
            }
        }

        protected void OnBeforeEditClicked(EditClickedEventArgs e)
        {
            if (BeforeEditClicked != null)
            {
                BeforeEditClicked(this, e);
            }
        }

        protected void OnAfterEditClicked()
        {
            if (AfterEditClicked != null)
            {
                AfterEditClicked(this);
            }
        }

        protected void OnBeforeDeleteClicked(DeleteClickedEventArgs e)
        {
            if (BeforeDeleteClicked != null)
            {
                BeforeDeleteClicked(this, e);
            }
        }

        protected void OnAfterDeleteClicked()
        {
            if (AfterDeleteClicked != null)
            {
                AfterDeleteClicked(this);
            }
        }

        protected void OnAfterRefreshClicked()
        {
            if (AfterRefreshClicked != null)
            {
                AfterRefreshClicked(this);
            }
        }

        public UcCrudToolbar()
        {
            InitializeComponent();
        }

        private void toolstripbuttonAdd_Click(object sender, EventArgs e)
        {
            AddClickedEventArgs eventArgs = new AddClickedEventArgs();
            eventArgs.Canceled = false;
            OnBeforeAddClicked(eventArgs);
            if (!eventArgs.Canceled)
            {
                OnAfterAddClicked();
            }
        }

        private void toolstripbuttonEdit_Click(object sender, EventArgs e)
        {
            EditClickedEventArgs eventArgs = new EditClickedEventArgs();
            eventArgs.Canceled = false;
            OnBeforeEditClicked(eventArgs);
            if (!eventArgs.Canceled)
            {
                OnAfterEditClicked();
            }
        }

        private void toolstripbuttonDelete_Click(object sender, EventArgs e)
        {
            DeleteClickedEventArgs eventArgs = new DeleteClickedEventArgs();
            eventArgs.Canceled = false;
            OnBeforeDeleteClicked(eventArgs);
            if (!eventArgs.Canceled)
            {
                OnAfterDeleteClicked();
            }
        }

        private void toolstripbuttonRefresh_Click(object sender, EventArgs e)
        {
            OnAfterRefreshClicked();
        }
    }
}
