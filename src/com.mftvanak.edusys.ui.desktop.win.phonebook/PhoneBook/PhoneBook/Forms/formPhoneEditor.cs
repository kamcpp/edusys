using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Com.Mftvanak.Edusys.Ui.Desktop.PhoneBook.Forms
{
    public partial class formPhoneEditor : formBase
    {
        public formPhoneEditor()
        {
            InitializeComponent();
        }

        private void buttonFollow_Click(object sender, EventArgs e)
        {
            formFollowEditor form = new formFollowEditor();
            form.ShowDialog();
        }
    }
}
