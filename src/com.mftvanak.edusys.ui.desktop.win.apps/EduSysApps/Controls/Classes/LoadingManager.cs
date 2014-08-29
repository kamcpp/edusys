using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Forms;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes
{
    public static class LoadingManager
    {
        private static LoadingShower _loadingShower;

        public static LoadingShower LoadingShower
        {
            get { return LoadingManager._loadingShower; }
            set { LoadingManager._loadingShower = value; }
        }

        public static void Show()
        {
            _loadingShower.ShowLoading();
        }

        public static void Hide()
        {
            _loadingShower.HideLoading();
        }
    }
}
