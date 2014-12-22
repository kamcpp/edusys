using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging.SmsWizard;
using System.Text.RegularExpressions;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers;
using System.IO;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common
{
    public partial class UcEduSysDataGridView : UserControl
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

        public UcEduSysDataGridView()
        {
            InitializeComponent();
            if (AuthenticationContext.DefaultContext.CurrentPrinciple != null)
            {
                toolstripbuttonSendSms.Visible = AuthenticationContext.DefaultContext.CurrentPrinciple.HashRole("ROLE_SMS");
            }
        }

        private void toolstriptextboxSearch_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                DoSearch();
            }
        }

        private void toolstriptextboxSearch_TextChanged(object sender, EventArgs e)
        {

        }

        private void datagridview_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            OnCellDoubleClick(sender, e);
        }

        private void DoSearch()
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
                                if (cell.Value != null)
                                {
                                    String compatibleToken = StringHelper.MakeCompatibleString(token);
                                    found = found || cell.Value.ToString().Trim().ToUpper().Contains(compatibleToken.Trim().ToUpper());
                                }
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

        private void toolstripbuttonSendSms_Click(object sender, EventArgs e)
        {
            Regex regex = new Regex(@"(\d+)");
            FormSmsWizard form = new FormSmsWizard();
            foreach (DataGridViewRow row in datagridview.Rows)
            {
                if (row.Visible)
                {
                    foreach (DataGridViewCell cell in row.Cells)
                    {
                        if (cell.Value != null)
                        {
                            string toSearch = cell.Value.ToString().Trim().Replace("-", "").Replace(" ", "");
                            Match match = regex.Match(toSearch);
                            if (match.Success)
                            {
                                foreach (Group g in match.Groups)
                                {
                                    if (g.Length >= 8)
                                    {
                                        form.AddMobileNumber(g.Value);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            form.ShowDialog();
        }

        private void datagridview_CellMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.ColumnIndex >= 0 && e.RowIndex >= 0)
            {
                datagridview.SelectedCells[0].Selected = false;
                datagridview.Rows[e.RowIndex].Cells[e.ColumnIndex].Selected = true;
            }
        }

        private void toolstripbuttonExportToExcel_Click(object sender, EventArgs e)
        {
            SaveFileDialog dialog = new SaveFileDialog();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                ToCsV(datagridview, dialog.FileName);
            }
        }

        private void ToCsV(DataGridView dGV, string filename)
        {
            string stOutput = "";
            string sHeaders = "";

            for (int j = 0; j < dGV.Columns.Count; j++)
            {
                sHeaders = sHeaders.ToString() + Convert.ToString(dGV.Columns[j].HeaderText) + "\t";
            }
            stOutput += sHeaders + "\r\n";

            for (int i = 0; i < dGV.RowCount - 1; i++)
            {
                string stLine = "";
                for (int j = 0; j < dGV.Rows[i].Cells.Count; j++)
                    stLine = stLine.ToString() + Convert.ToString(dGV.Rows[i].Cells[j].Value) + "\t";
                stOutput += stLine + "\r\n";
            }

            Encoding utf16 = Encoding.GetEncoding(1254);
            byte[] output = utf16.GetBytes(stOutput);
            FileStream fs = new FileStream(filename, FileMode.Create);
            BinaryWriter bw = new BinaryWriter(fs);
            bw.Write(output, 0, output.Length);
            bw.Flush();
            bw.Close();
            fs.Close();
        }
    }
}
