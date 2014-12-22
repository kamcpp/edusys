using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Controls.Classes.Wizard
{
    public class MobileNumber
    {
        public static bool operator ==(MobileNumber mobileNumber1, MobileNumber mobileNumber2)
        {
            return mobileNumber1.Equals(mobileNumber2);
        }

        public static bool operator !=(MobileNumber mobileNumber1, MobileNumber mobileNumber2)
        {
            return !mobileNumber1.Equals(mobileNumber2);
        }

        private bool _isMobile;
        private string _originalNumber;
        private string _validatedNumber;

        public bool IsMobile
        {
            get { return _isMobile; }
        }

        public string OriginalNumber
        {
            get { return _originalNumber; }
            set
            {
                _originalNumber = value;
                ValidateNumber(_originalNumber);
            }
        }

        public string ValidatedNumber
        {
            get { return _validatedNumber; }
        }

        public MobileNumber(string number)
        {
            _isMobile = false;
            OriginalNumber = number;
        }

        public override int GetHashCode()
        {
            return _validatedNumber.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj == this)
            {
                return true;
            }
            if (obj is MobileNumber)
            {
                return ((obj as MobileNumber).ValidatedNumber.Equals(_validatedNumber));
            }
            else
            {
                return false;
            }
        }

        private void ValidateNumber(string originalNumber)
        {
            _validatedNumber = originalNumber;
            _validatedNumber = _validatedNumber.Trim().Replace("-", "").Replace(" ", "").Replace("_", "");
            if (_validatedNumber.Length == 10 && _validatedNumber.StartsWith("9"))
            {
                _validatedNumber = "0" + _validatedNumber;
            }
            if (_validatedNumber.Length > 11)
            {
                _validatedNumber = _validatedNumber.Substring(0, 11);
            }
            _isMobile = _validatedNumber.StartsWith("09") && _validatedNumber.Length == 11;
        }
    }
}
