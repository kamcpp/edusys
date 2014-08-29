using System;
using System.Collections.Generic;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.GheyasManager.Classes
{
    class Context
    {
        private static Context _defaultContext;

        public static Context DefaultContext
        {
            get
            {
                if (_defaultContext == null)
                {
                    _defaultContext = new Context();
                }
                return _defaultContext;
            }
        }

        private IAuthenticationManager _authenticationManager;

        internal IAuthenticationManager AuthenticationManager
        {
            get { return _authenticationManager; }
            set { _authenticationManager = value; }
        }

        private Principle _currentPrinciple;

        internal Principle CurrentPrinciple
        {
            get { return _currentPrinciple; }
            set { _currentPrinciple = value; }
        }
    }
}
