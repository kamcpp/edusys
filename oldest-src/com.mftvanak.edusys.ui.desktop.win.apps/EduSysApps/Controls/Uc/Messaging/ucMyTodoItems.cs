using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.TodoWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms.Messaging;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging
{
    public partial class UcMyTodoItems : UserControl
    {
        private long _personId;

        [Browsable(false)]
        [DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
        public long PersonId
        {
            get { return _personId; }
            set { _personId = value; }
        }

        public UcMyTodoItems()
        {
            InitializeComponent();
        }

        private void toolstripbuttonRefresh_Click(object sender, EventArgs e)
        {
            LoadTooItems();
        }

        private void datagridviewTodoItems_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (datagridviewTodoItems.SelectedCells.Count == 0)
            {
                return;
            }
            if (e.RowIndex < 0)
            {
                return;
            }

            long todoItemId = long.Parse(datagridviewTodoItems.Rows[datagridviewTodoItems.SelectedCells[0].RowIndex].Tag.ToString());
            try
            {
                TodoService service = new TodoService();
                GetTodoItemByIdRequest request = new GetTodoItemByIdRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.TodoItemId = todoItemId;
                GetTodoItemByIdResponse response = service.GetTodoItemById(request);

                FormEditTodoItem form = new FormEditTodoItem();
                form.TodoItem = response.TodoItem;
                form.IsNew = false;
                form.DisableEditing();
                if (form.ShowDialog() == DialogResult.OK)
                {
                    LoadTooItems();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        public void LoadTooItems()
        {
            LoadingManager.Show();
            Thread thread = new Thread(DoLoadTodoItems);
            thread.Start();
        }

        private void DoLoadTodoItems()
        {
            try
            {
                TodoService todoService = new TodoService();
                GetTodoItemsForPersonRequest request = new GetTodoItemsForPersonRequest();
                ClientInformation.FillWithClientInformation(request);
                request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                request.PersonId = AuthenticationContext.DefaultContext.CurrentPrinciple.UserId;
                request.Count = 0;
                TodoItemType[] todoItemTypes = todoService.GetTodoItemsForPerson(request);
                if (datagridviewTodoItems.InvokeRequired)
                {
                    datagridviewTodoItems.Invoke(new MethodInvoker(delegate { datagridviewTodoItems.Rows.Clear(); }));
                }
                else
                {
                    datagridviewTodoItems.Rows.Clear();
                }
                int counter = 1;
                foreach (TodoItemType todoItemType in todoItemTypes)
                {
                    DataGridViewRow row = new DataGridViewRow();
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter, ValueType = typeof(int) });
                    DataGridViewTextBoxCell categoryow = new DataGridViewTextBoxCell() { Value = "", ValueType = typeof(int) };
                    if (todoItemType.Color == ColorType.Blue)
                    {
                        categoryow.Style.BackColor = Color.LightBlue;
                    }
                    else if (todoItemType.Color == ColorType.Green)
                    {
                        categoryow.Style.BackColor = Color.LightGreen;
                    }
                    else if (todoItemType.Color == ColorType.Orange)
                    {
                        categoryow.Style.BackColor = Color.Orange;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (todoItemType.Color == ColorType.Pink)
                    {
                        categoryow.Style.BackColor = Color.Pink;
                    }
                    else if (todoItemType.Color == ColorType.Purple)
                    {
                        categoryow.Style.BackColor = Color.Purple;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (todoItemType.Color == ColorType.Red)
                    {
                        categoryow.Style.BackColor = Color.DarkRed;
                        categoryow.Style.ForeColor = Color.White;
                    }
                    else if (todoItemType.Color == ColorType.Yellow)
                    {
                        categoryow.Style.BackColor = Color.Yellow;
                    }
                    row.Cells.Add(categoryow);
                    row.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[todoItemType.Done ? 0 : 1] });
                    string priorityString = "نا معلوم";
                    if (todoItemType.Priority == 2)
                    {
                        priorityString = "بالا";
                    }
                    else if (todoItemType.Priority == 1)
                    {
                        priorityString = "عادی";
                    }
                    else if (todoItemType.Priority == 0)
                    {
                        priorityString = "پایین";
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = priorityString, ValueType = typeof(int) });
                    string stringPersianSubmitDate = "ERROR";
                    try
                    {
                        DateTime submitDateTime = new DateTime(todoItemType.SubmitDateYear, todoItemType.SubmitDateMonth, todoItemType.SubmitDateDay, todoItemType.SubmitDateHour, todoItemType.SubmitDateMinute, todoItemType.SubmitDateSecond, todoItemType.SubmitDateMilliSecond);
                        stringPersianSubmitDate = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(submitDateTime.ToLocalTime()).ToString();
                    }
                    catch
                    {
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = stringPersianSubmitDate, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = todoItemType.OwnerFullName, ValueType = typeof(string) });
                    string stringPersianDeadlineDate = "تعیین نشده";
                    if (todoItemType.HasDeadlineDateTime)
                    {
                        try
                        {
                            DateTime deadlineDateTime = new DateTime(todoItemType.DeadlineDateYear.Value, todoItemType.DeadlineDateMonth.Value, todoItemType.DeadlineDateDay.Value, todoItemType.DeadlineDateHour.Value, todoItemType.DeadlineDateMinute.Value, todoItemType.DeadlineDateSecond.Value, todoItemType.DeadlineDateMilliSecond.Value);
                            stringPersianDeadlineDate = FarsiLibrary.Utils.PersianDateConverter.ToPersianDate(deadlineDateTime.ToLocalTime()).ToString();
                        }
                        catch
                        {
                        }
                    }
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = stringPersianDeadlineDate, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = todoItemType.Subject, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = todoItemType.Response, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = todoItemType.Description, ValueType = typeof(string) });
                    row.Cells.Add(new DataGridViewTextBoxCell() { Value = todoItemType.Id, ValueType = typeof(long) });
                    row.Tag = todoItemType.Id;
                    if (datagridviewTodoItems.InvokeRequired)
                    {
                        datagridviewTodoItems.Invoke(new MethodInvoker(delegate { datagridviewTodoItems.Rows.Add(row); }));
                    }
                    else
                    {
                        datagridviewTodoItems.Rows.Add(row);
                    }
                    counter++;
                }
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
}
