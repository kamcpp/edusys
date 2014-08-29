using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.TestApp.Forms
{
    public partial class formEduSysDataGridViewTest : FormBase
    {
        public formEduSysDataGridViewTest()
        {
            InitializeComponent();
        }

        private void formEduSysDataGridViewTest_Load(object sender, EventArgs e)
        {
            List<Person> persons = new List<Person>();
            persons.Add(new Person() { Id = 1, Name = "John", Family = "Jackson" });
            persons.Add(new Person() { Id = 2, Name = "Alex", Family = "Texas" });
            persons.Add(new Person() { Id = 3, Name = "Mat", Family = "Davis" });
            persons.Add(new Person() { Id = 4, Name = "Jane", Family = "Harrison" });

            ucEduSysDataGridView1.DataGrid.DataSource = persons;
        }
    }

    class Person
    {
        private long _id;

        public long Id
        {
            get { return _id; }
            set { _id = value; }
        }
        private string _name;

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
        private string _family;

        public string Family
        {
            get { return _family; }
            set { _family = value; }
        }
    }
}
