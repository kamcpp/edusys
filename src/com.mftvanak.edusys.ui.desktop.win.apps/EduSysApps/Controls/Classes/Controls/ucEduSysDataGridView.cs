using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Controls
{
    public partial class ucEduSysDataGridView : UserControl
    {
        public delegate void CellDoubleClickHandler(object sender, DataGridViewCellEventArgs e);

        public event CellDoubleClickHandler CellDoubleClick;

        protected virtual void OnCellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (CellDoubleClick != null)
            {
                CellDoubleClick(sender, e);
            }
        }

        public int NumberOfRecords
        {
            set { labelNumberOfRecords.Text = "تعداد رکورد: " + value; }
        }

        public DataGridView DataGrid
        {
            get { return datagridview; }
        }

        public DataGridViewColumnCollection Columns
        {
            get { return datagridview.Columns; }
        }

        public ucEduSysDataGridView()
        {
            InitializeComponent();
        }

        private void toolstriptextboxSearch_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
            }
        }

        private void toolstriptextboxSearch_TextChanged(object sender, EventArgs e)
        {
            int counter = 0;
            if (string.IsNullOrEmpty(toolstriptextboxSearch.Text.Trim()))
            {
                datagridview.CurrentCell = null;
                foreach (DataGridViewRow row in datagridview.Rows)
                {
                    row.Visible = true;
                    counter++;
                }
                NumberOfRecords = counter;
                return;
            }

            string[] tokens = toolstriptextboxSearch.Text.Trim().Split(' ');

            datagridview.CurrentCell = null;
            foreach (DataGridViewRow row in datagridview.Rows)
            {
                row.Visible = true;
                bool found = false;
                foreach (DataGridViewCell cell in row.Cells)
                {
                    if (!found)
                    {
                        foreach (string token in tokens)
                        {
                            if (!string.IsNullOrEmpty(token))
                            {
                                found = found || cell.Value.ToString().Trim().ToUpper().Contains(token.Trim().ToUpper());
                            }
                        }
                    }
                }
                row.Visible = found;
                if (found)
                {                    
                    counter++;
                }
            }
            NumberOfRecords = counter;
        }

        private void datagridview_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            OnCellDoubleClick(sender, e);
        }
    }
}
