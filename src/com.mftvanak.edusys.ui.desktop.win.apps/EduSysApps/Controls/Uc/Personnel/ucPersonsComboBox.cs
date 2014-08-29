using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.PersonWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Personnel
{
    public partial class UcPersonsComboBox : UserControl
    {
        public delegate void LoadFinishedEventHandler(object sender);

        public event LoadFinishedEventHandler LoadFinished;
        
        private bool _loaded;

        public bool Loaded
        {
            get { return _loaded; }
            set { _loaded = value; }
        }

        [Browsable(false)]
        [DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
        public long? PersonId
        {
            get { return comboboxPersons.SelectedIndex == 0 ? null : (comboboxPersons.SelectedItem as PersonComboBoxItem).Id as long?; }
            set
            {
                if (comboboxPersons.Items.Count == 0)
                {
                    return;
                }
                if (value == null)
                {
                    comboboxPersons.SelectedIndex = 0;
                    return;
                }
                foreach (PersonComboBoxItem item in comboboxPersons.Items)
                {
                    if (item.Id == value)
                    {
                        comboboxPersons.SelectedItem = item;
                        return;
                    }
                }
            }
        }

        public string Caption
        {
            get { return labelCaption.Text; }
            set { labelCaption.Text = value; }
        }

        public string PersonFullName
        {
            get { return comboboxPersons.Text; }
        }

        public UcPersonsComboBox()
        {
            InitializeComponent();
            _loaded = false;
        }

        protected virtual void OnLoadFinished()
        {
            if (LoadFinished != null)
            {
                LoadFinished(this);
            }
        }

        public void LoadPersons()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoLoadPersons);
            thread.Start();
        }

        private void DoLoadPersons()
        {
            try
            {
                PersonService personService = new PersonService();
                GetPersonsRequest request = new GetPersonsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                PersonType[] persons = personService.GetPersons(request);
                if (comboboxPersons.InvokeRequired)
                {
                    comboboxPersons.Invoke(new MethodInvoker(delegate { comboboxPersons.Items.Clear(); }));
                }
                else
                {
                    comboboxPersons.Items.Clear();
                }
                if (persons.Length > 0)
                {
                    if (comboboxPersons.InvokeRequired)
                    {
                        comboboxPersons.Invoke(new MethodInvoker(delegate { comboboxPersons.Items.Add(new PersonComboBoxItem() { Id = 0, Name = "----------" }); }));
                    }
                    else
                    {
                        comboboxPersons.Items.Add(new PersonComboBoxItem() { Id = 0, Name = "----------" });
                    }

                    foreach (PersonType personType in persons)
                    {
                        if (comboboxPersons.InvokeRequired)
                        {
                            comboboxPersons.Invoke(new MethodInvoker(delegate { comboboxPersons.Items.Add(new PersonComboBoxItem() { Id = personType.Id, Name = personType.PersianName + " " + personType.PersianFamily }); }));
                        }
                        else
                        {
                            comboboxPersons.Items.Add(new PersonComboBoxItem() { Id = personType.Id, Name = personType.PersianName + " " + personType.PersianFamily });
                        }
                    }
                    if (comboboxPersons.InvokeRequired)
                    {
                        comboboxPersons.Invoke(new MethodInvoker(delegate { comboboxPersons.SelectedIndex = 0; }));
                    }
                    else
                    {
                        comboboxPersons.SelectedIndex = 0;
                    }
                }
                _loaded = true;
                OnLoadFinished();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                LoadingManager.Hide();
            }
        }
    }

    public class PersonComboBoxItem
    {
        private long _id;
        private string _name;

        public long Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public override string ToString()
        {
            return _name;
        }
    }
}
