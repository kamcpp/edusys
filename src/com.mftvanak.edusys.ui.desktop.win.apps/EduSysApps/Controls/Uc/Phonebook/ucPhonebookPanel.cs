using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Phonebook
{
    public partial class UcPhonebookPanel : UserControl
    {
        public UcPhonebookPanel()
        {
            InitializeComponent();
        }

        public void LoadData()
        {
            ucMyPhoneEntries.LoadPhoneEntries();
            ucSearchPhoneEntries.LoadControl();
        }
    }
}
