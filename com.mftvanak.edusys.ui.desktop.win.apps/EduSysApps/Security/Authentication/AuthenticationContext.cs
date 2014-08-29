using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication
{
    public class AuthenticationContext
    {
        private static AuthenticationContext _defaultContext;

        public static AuthenticationContext DefaultContext
        {
            get
            {
                if (_defaultContext == null)
                {
                    _defaultContext = new AuthenticationContext();
                }
                return _defaultContext;
            }
        }

        private IAuthenticationManager _authenticationManager;
        private IAuthorizationManager _authorizationManager;
        private ApplicationInformation _applicationInformation;
        private Principle _currentPrinciple;

        public IAuthenticationManager AuthenticationManager
        {
            get { return _authenticationManager; }
            set { _authenticationManager = value; }
        }

        public IAuthorizationManager AuthorizationManager
        {
            get { return _authorizationManager; }
            set { _authorizationManager = value; }
        }

        public ApplicationInformation ApplicationInformation
        {
            get { return _applicationInformation; }
            set { _applicationInformation = value; }
        }

        public Principle CurrentPrinciple
        {
            get { return _currentPrinciple; }
            set { _currentPrinciple = value; }
        }
    }
}
