using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.InstituteWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.DepartmentWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Education
{
    public partial class UcDepartmentSelector : UserControl
    {
        private bool _loaded;
        private bool _hasNullDepartment;

        public bool Loaded
        {
            get { return _loaded; }
        }

        public bool HasNullDepartment
        {
            get { return _hasNullDepartment; }
            set { _hasNullDepartment = value; }
        }

        [DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
        public long? InstituteId
        {
            get { return Institute.Id; }
            set
            {
                if (!DesignMode)
                {
                    if (comboboxInstitutes.Items.Count > 0)
                    {
                        for (int i = 0; i < comboboxInstitutes.Items.Count; i++)
                        {
                            if ((comboboxInstitutes.Items[i] as ComboBoxInstituteItem).Institute.Id == value)
                            {
                                comboboxInstitutes.SelectedIndex = i;
                                return;
                            }
                        }
                        comboboxInstitutes.SelectedIndex = 0;
                    }
                }
            }
        }

        [DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
        public long? DepartmentId
        {
            get { return Department != null ? Department.Id : (long?)null; }
            set
            {
                if (!DesignMode)
                {
                    if (comboboxDepartments.Items.Count > 0)
                    {
                        if (value == null && _hasNullDepartment)
                        {
                            comboboxDepartments.SelectedIndex = 0;
                        }
                        for (int i = 0; i < comboboxDepartments.Items.Count; i++)
                        {
                            if (comboboxDepartments.Items[i] is ComboBoxDepartmentItem)
                            {
                                if ((comboboxDepartments.Items[i] as ComboBoxDepartmentItem).Department.Id == value)
                                {
                                    comboboxDepartments.SelectedIndex = i;
                                    return;
                                }
                            }
                        }
                        comboboxDepartments.SelectedIndex = 0;
                    }
                }
            }
        }

        public InstituteType Institute
        {
            get
            {
                return (comboboxInstitutes.SelectedItem as ComboBoxInstituteItem).Institute;
            }
        }

        public DepartmentType Department
        {
            get
            {
                if (_hasNullDepartment && comboboxDepartments.SelectedIndex == 0)
                {
                    return null;
                }
                return (comboboxDepartments.SelectedItem as ComboBoxDepartmentItem).Department;
            }
        }
        public UcDepartmentSelector()
        {
            _hasNullDepartment = false;
            InitializeComponent();
            _loaded = false;
        }

        private void buttonRefreshInstitutes_Click(object sender, EventArgs e)
        {
            LoadInstitutes();
        }

        private void buttonRefreshDepartments_Click(object sender, EventArgs e)
        {
            LoadDepartments();
        }

        private void comboboxInstitutes_SelectedIndexChanged(object sender, EventArgs e)
        {
            LoadDepartments();
        }

        public void LoadInstitutes()
        {
            try
            {
                InstituteServiceService instituteService = new InstituteServiceService();
                GetInstitutesRequest request = new GetInstitutesRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                InstituteType[] institutes = instituteService.GetInstitutes(request);
                comboboxInstitutes.Items.Clear();
                if (institutes.Length > 0)
                {
                    foreach (InstituteType institute in institutes)
                    {
                        if (GeneralSettings.InstituteIds.Contains(institute.Id))
                        {
                            comboboxInstitutes.Items.Add(new ComboBoxInstituteItem() { Institute = institute });
                        }
                    }
                    comboboxInstitutes.SelectedIndex = 0;
                }
                _loaded = true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void LoadDepartments()
        {
            try
            {
                DepartmentServiceService service = new DepartmentServiceService();
                GetDepartmentsRequest request = new GetDepartmentsRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.InstituteId = Institute.Id;
                DepartmentType[] departments = service.GetDepartments(request);
                comboboxDepartments.Items.Clear();
                if (departments.Length > 0)
                {
                    if (_hasNullDepartment)
                    {
                        comboboxDepartments.Items.Add("---------");
                    }
                    foreach (DepartmentType departmentType in departments)
                    {
                        comboboxDepartments.Items.Add(new ComboBoxDepartmentItem() { Department = departmentType });
                    }
                    comboboxDepartments.SelectedIndex = 0;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }

    public class ComboBoxInstituteItem
    {
        public InstituteType Institute;

        public override string ToString()
        {
            return Institute.PersianName;
        }
    }

    public class ComboBoxDepartmentItem
    {
        public DepartmentType Department;

        public override string ToString()
        {
            return Department.PersianName;
        }
    }
}
