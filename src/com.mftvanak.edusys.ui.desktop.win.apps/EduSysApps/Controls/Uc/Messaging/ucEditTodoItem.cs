using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.TodoWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Common;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging
{
    public partial class UcEditTodoItem : UserControl
    {
        private bool _isNew;
        private DateTime _submitDateTime;
        private TodoItemType _todoItem;

        public bool IsNew
        {
            get { return _isNew; }
            set { _isNew = value; }
        }

        public TodoItemType TodoItem
        {
            get { return _todoItem; }
            set
            {
                _todoItem = value;
                if (_todoItem != null)
                {
                    _isNew = false;
                    labelOwnerValue.Text = _todoItem.OwnerFullName;
                    textboxSubject.Text = _todoItem.Subject;
                    textboxDescription.Text = _todoItem.Description != null ? _todoItem.Description.Replace("\n", "\r\n") : null;
                    textboxDescription.Select(0, 0);
                    textboxResponse.Text = _todoItem.Response != null ? _todoItem.Response.Replace("\n", "\r\n") : null;
                    textboxResponse.Select(0, 0);
                    string stringPersianSubmitDate = "ERROR";
                    try
                    {
                        DateTime submitDateTime = new DateTime(_todoItem.SubmitDateYear, _todoItem.SubmitDateMonth, _todoItem.SubmitDateDay, _todoItem.SubmitDateHour, _todoItem.SubmitDateMinute, _todoItem.SubmitDateSecond, _todoItem.SubmitDateMilliSecond);
                        stringPersianSubmitDate = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(submitDateTime.ToLocalTime()).ToString();
                    }
                    catch
                    {
                    }
                    labelSubmitDateValue.Text = stringPersianSubmitDate;
                    if (_todoItem.HasDeadlineDateTime)
                    {
                        try
                        {
                            fadatepickerDeadlineDateTime.SelectedDateTime = new DateTime(_todoItem.DeadlineDateYear.Value, _todoItem.DeadlineDateMonth.Value, _todoItem.DeadlineDateDay.Value, _todoItem.DeadlineDateHour.Value, _todoItem.DeadlineDateMinute.Value, _todoItem.DeadlineDateSecond.Value, _todoItem.DeadlineDateMilliSecond.Value).ToLocalTime();
                        }
                        catch
                        {
                        }
                    }
                    else
                    {
                        fadatepickerDeadlineDateTime.IsNull = true;
                    }
                    if (_todoItem.Priority == 2)
                    {
                        comboboxPriority.SelectedIndex = 0;
                    }
                    else if (_todoItem.Priority == 1)
                    {
                        comboboxPriority.SelectedIndex = 1;
                    }
                    else if (_todoItem.Priority == 0)
                    {
                        comboboxPriority.SelectedIndex = 2;
                    }
                    if (_todoItem.Color != null)
                    {
                        if (_todoItem.Color.Value == ColorType.Blue)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Blue;
                        }
                        else if (_todoItem.Color.Value == ColorType.Green)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Green;
                        }
                        else if (_todoItem.Color.Value == ColorType.Orange)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Orange;
                        }
                        else if (_todoItem.Color.Value == ColorType.Pink)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Pink;
                        }
                        else if (_todoItem.Color.Value == ColorType.Purple)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Purple;
                        }
                        else if (_todoItem.Color.Value == ColorType.Red)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Red;
                        }
                        else if (_todoItem.Color.Value == ColorType.Yellow)
                        {
                            colorcomboboxCategory.SelectedColor = Color.Yellow;
                        }
                    }
                    checkboxDone.Checked = _todoItem.Done;
                }
            }
        }

        public UcEditTodoItem()
        {
            InitializeComponent();

            comboboxPriority.Items.Clear();
            comboboxPriority.Items.Add(new PriorityComboBoxItem() { Text = "بالا", Priority = 2 });
            comboboxPriority.Items.Add(new PriorityComboBoxItem() { Text = "عادی", Priority = 1 });
            comboboxPriority.Items.Add(new PriorityComboBoxItem() { Text = "پایین", Priority = 0 });
            comboboxPriority.SelectedIndex = 1;

            colorcomboboxCategory.Items.Clear();
            colorcomboboxCategory.AddNullItem();
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "آبی", Value = "Blue", ForeColor = Color.Blue });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "قرمز", Value = "Red", ForeColor = Color.Red });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "زرد", Value = "Yellow", ForeColor = Color.Yellow });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "سبز", Value = "Green", ForeColor = Color.Green });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "نارنجی", Value = "Orange", ForeColor = Color.Orange });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "بنفش", Value = "Purple", ForeColor = Color.Purple });
            colorcomboboxCategory.Items.Add(new ColorComboBoxItem() { Text = "صورتی", Value = "Pink", ForeColor = Color.Pink });
            colorcomboboxCategory.SelectedIndex = 0;
        }

        private void ucEditTodoItem_Load(object sender, EventArgs e)
        {
            if (!DesignMode)
            {
                _submitDateTime = DateTime.UtcNow;
                if (_isNew)
                {
                    labelOwnerValue.Text = AuthenticationContext.DefaultContext.CurrentPrinciple.FullName;
                    labelSubmitDateValue.Text = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(_submitDateTime.ToLocalTime()).ToString();
                }
                if (!ucpersonscomboboxReceiver.Loaded)
                {
                } ucpersonscomboboxReceiver.LoadPersons();
            }
        }

        private void colorcomboboxCategory_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (colorcomboboxCategory.SelectedIndex <= 0)
            {
                pictureboxCategory.BackColor = Color.White;
                return;
            }
            pictureboxCategory.BackColor = (colorcomboboxCategory.SelectedItem as ColorComboBoxItem).ForeColor;
        }

        private void ucpersonscomboboxReceiver_LoadFinished(object sender)
        {
            if (!_isNew)
            {
                if (ucpersonscomboboxReceiver.InvokeRequired)
                {
                    ucpersonscomboboxReceiver.Invoke(new MethodInvoker(delegate { ucpersonscomboboxReceiver.PersonId = _todoItem.OwnerId; }));
                }
                else
                {
                    ucpersonscomboboxReceiver.PersonId = _todoItem.OwnerId;
                }
            }
        }

        public void DisableEditing()
        {
            ucpersonscomboboxReceiver.Enabled = false;
            textboxSubject.Enabled = false;
            textboxDescription.ReadOnly = true;
            colorcomboboxCategory.Enabled = false;
            comboboxPriority.Enabled = false;
            fadatepickerDeadlineDateTime.Enabled = false;
            textboxResponse.ReadOnly = false;
        }

        public bool ValidateInformation()
        {
            string errorMessage = "";
            bool hasError = false;

            if (!ucpersonscomboboxReceiver.PersonId.HasValue)
            {
                errorMessage = "فرد دریافت کننده می بایست انتخاب شود";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxSubject.Text))
            {
                errorMessage = "عنوان الزامی است.";
                hasError = true;
            }
            if (!hasError && string.IsNullOrEmpty(textboxDescription.Text))
            {
                errorMessage = "پیغام الزامی است.";
                hasError = true;
            }
            if (hasError)
            {
                MessageBox.Show(errorMessage, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return !hasError;
        }

        public bool Save()
        {
            try
            {
                TodoService service = new TodoService();
                if (colorcomboboxCategory.SelectedColor.HasValue)
                {
                    if (colorcomboboxCategory.SelectedColor == Color.Blue)
                    {
                        _todoItem.Color = ColorType.Blue;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Blue)
                    {
                        _todoItem.Color = ColorType.Blue;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Green)
                    {
                        _todoItem.Color = ColorType.Green;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Orange)
                    {
                        _todoItem.Color = ColorType.Orange;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Pink)
                    {
                        _todoItem.Color = ColorType.Pink;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Purple)
                    {
                        _todoItem.Color = ColorType.Purple;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Red)
                    {
                        _todoItem.Color = ColorType.Red;
                    }
                    else if (colorcomboboxCategory.SelectedColor == Color.Yellow)
                    {
                        _todoItem.Color = ColorType.Yellow;
                    }
                }
                else
                {
                    _todoItem.Color = null;
                }
                if (!fadatepickerDeadlineDateTime.IsNull)
                {
                    _todoItem.HasDeadlineDateTime = true;
                    _todoItem.DeadlineDateMilliSecond = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Millisecond;
                    _todoItem.DeadlineDateSecond = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Second;
                    _todoItem.DeadlineDateMinute = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Minute;
                    _todoItem.DeadlineDateHour = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Hour;
                    _todoItem.DeadlineDateDay = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Day;
                    _todoItem.DeadlineDateMonth = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Month;
                    _todoItem.DeadlineDateYear = fadatepickerDeadlineDateTime.SelectedDateTime.ToUniversalTime().Year;
                }
                else
                {
                    _todoItem.HasDeadlineDateTime = false;
                }
                _todoItem.Description = textboxDescription.Text;
                _todoItem.Response = textboxResponse.Text;
                _todoItem.Done = checkboxDone.Checked;
                _todoItem.Priority = (comboboxPriority.SelectedItem as PriorityComboBoxItem).Priority;
                _todoItem.Subject = textboxSubject.Text;

                if (_isNew)
                {
                    _todoItem.SubmitDateMilliSecond = _submitDateTime.Millisecond;
                    _todoItem.SubmitDateSecond = _submitDateTime.Second;
                    _todoItem.SubmitDateMinute = _submitDateTime.Minute;
                    _todoItem.SubmitDateHour = _submitDateTime.Hour;
                    _todoItem.SubmitDateDay = _submitDateTime.Day;
                    _todoItem.SubmitDateMonth = _submitDateTime.Month;
                    _todoItem.SubmitDateYear = _submitDateTime.Year;
                    _todoItem.ReceiverId = ucpersonscomboboxReceiver.PersonId.Value;
                    _todoItem.ReceiverFullName = ucpersonscomboboxReceiver.PersonFullName;
                    _todoItem.OwnerId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                    _todoItem.OwnerFullName = AuthenticationContext.DefaultContext.CurrentPrinciple.FullName;

                    AddTodoItemRequest request = new AddTodoItemRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.TodoItem = _todoItem;
                    AddTodoItemResponse response = service.AddTodoItem(request);
                    _todoItem.Id = response.TodoItemId;
                    _isNew = false;
                }
                else
                {
                    UpdateTodoItemRequest request = new UpdateTodoItemRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.TodoItem = _todoItem;
                    UpdateTodoItemResponse response = service.UpdateTodoItem(request);
                }
                return true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
    }

    public class PriorityComboBoxItem
    {
        private string _text;
        private int _priority;

        public string Text
        {
            get { return _text; }
            set { _text = value; }
        }

        public int Priority
        {
            get { return _priority; }
            set { _priority = value; }
        }

        public override string ToString()
        {
            return _text;
        }
    }
}
