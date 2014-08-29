using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace DepartmentsReport
{
    public partial class formMain : Form
    {
        public formMain()
        {
            InitializeComponent();

            DataTable dt = new DataTable();
            dt.Columns.Add("Id");
            dt.Columns.Add("Name");

            dt.Rows.Add(new object[] { 56, "WEB" });
            dt.Rows.Add(new object[] { 58, "ART" });
            dt.Rows.Add(new object[] { 54, "LANG" });
            dt.Rows.Add(new object[] { 57, "NET" });
            dt.Rows.Add(new object[] { 53, "ENG" });
            dt.Rows.Add(new object[] { 55, "GRAPH" });
            dt.Rows.Add(new object[] { 52, "IT" });
            dt.Rows.Add(new object[] { 60, "ACC" });
            dt.Rows.Add(new object[] { 62, "EXAM" });

            comboboxDepartments.DisplayMember = "Name";
            comboboxDepartments.ValueMember = "Id";
            comboboxDepartments.DataSource = dt;
        }

        private SqlConnection GetConnection()
        {
            return new SqlConnection("Data Source = 10.10.2.8; Initial Catalog = seyagh; User Id = edusys; Password = edusyspass;");
        }

        private void buttonRefresh_Click(object sender, EventArgs e)
        {
            buttonRefresh.Enabled = false;
            buttonRefresh.Text = "Please wait ...";
            Thread t = new Thread(GetReport);
            t.Start();
        }

        private void buttonRefresh2_Click(object sender, EventArgs e)
        {
            buttonRefresh2.Enabled = false;
            buttonRefresh2.Text = "Please wait ...";
            Thread t = new Thread(GetDetails);
            t.Start();
        }

        private void GetReport()
        {
            try
            {
                SqlConnection connection = GetConnection();
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                String query = ConfigurationManager.AppSettings["query1"];
                command.CommandText = String.Format(query, maskedtextboxStart.Text, maskedtextboxEnd.Text);
                SqlDataReader reader = command.ExecuteReader();
                DataTable dt = new DataTable();
                dt.Load(reader);

                if (tabpageDepartmentsReport.InvokeRequired)
                {
                    tabpageDepartmentsReport.Invoke(new MethodInvoker(delegate
                    {
                        tabpageDepartmentsReport.Text = "Departments Rpeort (" + dt.Rows.Count + ")";
                    }));
                }
                if (datagridviewDepartmentsReport.InvokeRequired)
                {
                    datagridviewDepartmentsReport.Invoke(new MethodInvoker(delegate
                    {
                        datagridviewDepartmentsReport.DataSource = dt;
                    }));
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                if (buttonRefresh.InvokeRequired)
                {
                    buttonRefresh.Invoke(new MethodInvoker(delegate
                    {
                        buttonRefresh.Enabled = true;
                        buttonRefresh.Text = "Refresh";
                    }));
                }
            }
        }

        private void GetDetails()
        {
            try
            {
                String deptId = "56";
                if (comboboxDepartments.InvokeRequired)
                {
                    comboboxDepartments.Invoke(new MethodInvoker(delegate
                    {
                        deptId = comboboxDepartments.SelectedValue.ToString();
                    }));
                }

                SqlConnection connection = GetConnection();
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                String query = ConfigurationManager.AppSettings["query2"];
                command.CommandText = String.Format(query, deptId, maskedtextboxStart2.Text, maskedtextboxEnd2.Text);
                SqlDataReader reader = command.ExecuteReader();
                DataTable dt = new DataTable();
                dt.Load(reader);

                if (tabpageDepartmentDetails.InvokeRequired)
                {
                    tabpageDepartmentDetails.Invoke(new MethodInvoker(delegate
                    {
                        tabpageDepartmentDetails.Text = "Department Details (" + dt.Rows.Count + ")";
                    }));
                }
                if (datagridviewDetails.InvokeRequired)
                {
                    datagridviewDetails.Invoke(new MethodInvoker(delegate
                    {
                        datagridviewDetails.DataSource = dt;
                    }));
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                if (buttonRefresh2.InvokeRequired)
                {
                    buttonRefresh2.Invoke(new MethodInvoker(delegate
                    {
                        buttonRefresh2.Enabled = true;
                        buttonRefresh2.Text = "Refresh";
                    }));
                }
            }
        }
    }
}
