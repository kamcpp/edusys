using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Messaging.SmsSender;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.ServiceClients.SendRequestWebReference;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Uc.Messaging.SmsWizard
{
    public partial class UcSmsSender : UserControl
    {
        public delegate void OperationAbortedEventHandler(object sender);
        public delegate void SendIgnoredEventHandler(object sender, string ignoredTo);
        public delegate void SendSuccessfulEventHandler(object sender);

        public event OperationAbortedEventHandler OperationAborted;
        public event SendIgnoredEventHandler SendIgnored;
        public event SendSuccessfulEventHandler SendSuccessful;

        protected virtual void OnOperationAborted()
        {
            if (OperationAborted != null)
            {
                OperationAborted(this);
            }
        }

        protected virtual void OnSendIgnored(string ignoredTo)
        {
            if (SendIgnored != null)
            {
                SendIgnored(this, ignoredTo);
            }
        }

        protected virtual void OnSendSuccessful()
        {
            if (SendSuccessful != null)
            {
                SendSuccessful(this);
            }
        }

        private string _message;
        private DataGridViewRow _sendRequestRow;
        private List<string> _tos;
        private Dictionary<int, DataGridViewRow> _rowsDictionary;

        public string Message
        {
            get { return _message; }
            set { _message = value; }
        }

        public List<string> Tos
        {
            get { return _tos; }
            set
            {
                _tos = value;
                if (_tos != null)
                {
                    progressbarSend.Minimum = 0;
                    progressbarSend.Maximum = _tos.Count;

                    if (datagridviewSmsEntries.InvokeRequired)
                    {
                        datagridviewSmsEntries.Invoke(new MethodInvoker(delegate { datagridviewSmsEntries.Rows.Clear(); }));
                    }
                    else
                    {
                        datagridviewSmsEntries.Rows.Clear();
                    }

                    _sendRequestRow = new DataGridViewRow();
                    _sendRequestRow.Cells.Add(new DataGridViewTextBoxCell() { Value = 1, ValueType = typeof(int) });
                    _sendRequestRow.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[0] });
                    _sendRequestRow.Cells.Add(new DataGridViewTextBoxCell() { Value = "ارسال اطلاعات درخواست ارسال پیامک ...", ValueType = typeof(string) });
                    _sendRequestRow.Cells.Add(new DataGridViewTextBoxCell() { Value = "فرستاده نشده" });
                    if (datagridviewSmsEntries.InvokeRequired)
                    {
                        datagridviewSmsEntries.Invoke(new MethodInvoker(delegate { datagridviewSmsEntries.Rows.Add(_sendRequestRow); }));
                    }
                    else
                    {
                        datagridviewSmsEntries.Rows.Add(_sendRequestRow);
                    }

                    int counter = 1;
                    _rowsDictionary = new Dictionary<int, DataGridViewRow>();
                    foreach (string number in _tos)
                    {
                        DataGridViewRow row = new DataGridViewRow();
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = counter + 1, ValueType = typeof(int) });
                        row.Cells.Add(new DataGridViewImageCell() { Value = imageList.Images[0] });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = number, ValueType = typeof(string) });
                        row.Cells.Add(new DataGridViewTextBoxCell() { Value = "فرستاده نشده" });

                        if (datagridviewSmsEntries.InvokeRequired)
                        {
                            datagridviewSmsEntries.Invoke(new MethodInvoker(delegate { datagridviewSmsEntries.Rows.Add(row); }));
                        }
                        else
                        {
                            datagridviewSmsEntries.Rows.Add(row);
                        }
                        _rowsDictionary.Add(counter, row);
                        counter++;
                    }
                }
            }
        }

        public UcSmsSender()
        {
            InitializeComponent();
        }

        public void Start()
        {
            Thread thread = new Thread(DoStart);
            thread.Start();
        }

        public void DoStart()
        {
            bool cont = true;
            while (cont)
            {
                try
                {
                    SendRequestService service = new SendRequestService();
                    AddSendRequestRequest request = new AddSendRequestRequest();
                    ClientInformation.FillWithClientInformation(request);
                    request.Token = AuthenticationContext.DefaultContext.CurrentPrinciple.Token;
                    request.SendRequest = new SendRequestType();
                    // request.SendRequest.Name =
                    cont = false;
                    _sendRequestRow.Cells[1].Value = imageList.Images[1];
                    _sendRequestRow.Cells[3].Value = "با موفقیت فرستاده شد.";
                }
                catch (Exception ex)
                {
                    DialogResult result = MessageBox.Show(ex.Message, "خطا هنگام درج درخواست ارسال", MessageBoxButtons.AbortRetryIgnore, MessageBoxIcon.Error);
                    if (result == DialogResult.Abort || result == DialogResult.Ignore)
                    {
                        OnOperationAborted();
                        return;
                    }
                }
            }
            EduSysSmsSender smsSender = new EduSysSmsSender();
            int i = 0;
            while (i < _tos.Count)
            {
                try
                {
                    smsSender.submitSms(_tos[i], _message);
                    i++;
                    _rowsDictionary[i].Cells[1].Value = imageList.Images[1];
                    _rowsDictionary[i].Cells[3].Value = "با موفقیت فرستاده شد.";
                    if (progressbarSend.InvokeRequired)
                    {
                        progressbarSend.Invoke(new MethodInvoker(delegate { progressbarSend.Value = i; }));
                    }
                    else
                    {
                        progressbarSend.Value = i;
                    }
                }
                catch (Exception ex)
                {
                    DialogResult result = MessageBox.Show(ex.Message, "خطا هنگام ارسال", MessageBoxButtons.AbortRetryIgnore, MessageBoxIcon.Error);
                    if (result == DialogResult.Abort)
                    {
                        OnOperationAborted();
                    }
                    else if (result == DialogResult.Ignore)
                    {                       
                        OnSendIgnored(_tos[i]);
                        i++;
                        _rowsDictionary[i].Cells[1].Value = imageList.Images[2];
                        _rowsDictionary[i].Cells[3].Value = "توسط کاربر لغو شد.";
                    }
                }
            }
            OnSendSuccessful();
        }
    }
}
