using System;
using System.Collections.Generic;
using System.Text;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Helpers
{
    public static class DateHelper
    {
        public static DateTime ConvertJavaMsToDotNetDateTime(long javaMs)
        {
            DateTime utcBaseTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            DateTime dt = utcBaseTime.Add(new TimeSpan(javaMs * TimeSpan.TicksPerMillisecond)).ToLocalTime();
            return dt;
        }
    }
}
