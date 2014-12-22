using System;
using System.Collections.Generic;
using System.Net;
using System.Net.NetworkInformation;
using System.Text;
using Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security.Authentication;

namespace Com.MftVanak.EduSys.Ui.Desktop.Win.Apps.Security
{
    public static class ClientInformation
    {
        public static void FillWithClientInformation(object obj)
        {
            DateTime now = DateTime.UtcNow;
            Type type = obj.GetType();
            type.GetProperty("ClientDateTimeYear").SetValue(obj, now.Year, null);
            type.GetProperty("ClientDateTimeMonth").SetValue(obj, now.Month, null);
            type.GetProperty("ClientDateTimeDay").SetValue(obj, now.Day, null);
            type.GetProperty("ClientDateTimeHour").SetValue(obj, now.Hour, null);
            type.GetProperty("ClientDateTimeMinute").SetValue(obj, now.Minute, null);
            type.GetProperty("ClientDateTimeSecond").SetValue(obj, now.Second, null);
            type.GetProperty("ClientDateTimeMilliSecond").SetValue(obj, now.Millisecond, null);
            type.GetProperty("ClientMacAddress").SetValue(obj, ClientInformation.GetClientMacAddress(), null);
            type.GetProperty("ClientIpAddress").SetValue(obj, ClientInformation.GetClientIpAddress(), null);
            type.GetProperty("ClientComputerName").SetValue(obj, ClientInformation.GetClientComputerName(), null);
            type.GetProperty("ApplicationName").SetValue(obj, AuthenticationContext.DefaultContext.ApplicationInformation.GetApplicationName(), null);
        }

        public static string GetClientMacAddress()
        {
            int nicCounter = 0;
            string toReturn = "";
            foreach (NetworkInterface nic in NetworkInterface.GetAllNetworkInterfaces())
            {
                int counter = 0;
                string dhcpAddresses = "";
                foreach (var dhcpAddress in nic.GetIPProperties().DhcpServerAddresses)
                {
                    dhcpAddresses += dhcpAddress.ToString();
                    if (++counter < nic.GetIPProperties().DhcpServerAddresses.Count)
                    {
                        dhcpAddresses += ",";
                    }
                }
                counter = 0;
                string anycastAddresses = "";
                foreach (var anycastAddress in nic.GetIPProperties().AnycastAddresses)
                {
                    anycastAddresses += anycastAddress.ToString();
                    if (++counter < nic.GetIPProperties().AnycastAddresses.Count)
                    {
                        anycastAddresses += ",";
                    }
                }
                counter = 0;
                string dnsAddresses = "";
                foreach (var dnsAddress in nic.GetIPProperties().DnsAddresses)
                {
                    dnsAddresses += dnsAddress.ToString();
                    if (++counter < nic.GetIPProperties().DnsAddresses.Count)
                    {
                        dnsAddresses += ",";
                    }
                }
                counter = 0;
                string gatewayAddresses = "";
                foreach (var gatewayAddress in nic.GetIPProperties().GatewayAddresses)
                {
                    gatewayAddresses += gatewayAddress.Address.ToString();
                    if (++counter < nic.GetIPProperties().GatewayAddresses.Count)
                    {
                        gatewayAddresses += ",";
                    }
                }
                counter = 0;
                string multicastAddresses = "";
                foreach (var multicastAddress in nic.GetIPProperties().MulticastAddresses)
                {
                    multicastAddresses += multicastAddress.Address.ToString();
                    if (++counter < nic.GetIPProperties().MulticastAddresses.Count)
                    {
                        multicastAddresses += ",";
                    }
                }
                counter = 0;
                string unicastAddresses = "";
                foreach (var unicastAddress in nic.GetIPProperties().UnicastAddresses)
                {
                    unicastAddresses += unicastAddress.Address.ToString();
                    if (++counter < nic.GetIPProperties().UnicastAddresses.Count)
                    {
                        unicastAddresses += ",";
                    }
                }
                toReturn += string.Format("NIC: {{Name: \"{0}\", OperationalStatus: \"{1}\", Type: \"{2}\", Mac: \"{3}\", DhcpAddresses: \"{4}\", AnycastAddresses: \"{5}\", DnsAddresses: \"{6}\", GatewayAddresses: \"{7}\", MulticastAddresses: \"{8}\", UnicastAddresses: \"{9}\"}}", nic.Name, nic.OperationalStatus, nic.NetworkInterfaceType, GetMacAddressString(nic), dhcpAddresses, anycastAddresses, dnsAddresses, gatewayAddresses, multicastAddresses, unicastAddresses) + " ";
                if (++nicCounter < NetworkInterface.GetAllNetworkInterfaces().GetLength(0))
                {
                    toReturn += "\r\n\r\n";
                }
            }
            return toReturn;
        }

        public static string GetClientIpAddress()
        {
            string toReturn = "";
            IPHostEntry host = Dns.GetHostEntry(Dns.GetHostName());
            foreach (IPAddress ip in host.AddressList)
            {
                toReturn += ip.ToString() + ",";
            }
            return toReturn;
        }

        public static string GetClientComputerName()
        {
            return System.Environment.MachineName;
        }

        private static string GetMacAddressString(NetworkInterface nic)
        {
            string macNotAligned = nic.GetPhysicalAddress().ToString();
            if (macNotAligned.Length == 12)
            {
                return macNotAligned.Substring(0, 2) + ":" + macNotAligned.Substring(2, 2) + ":" + macNotAligned.Substring(4, 2) + ":" + macNotAligned.Substring(6, 2) + ":" + macNotAligned.Substring(8, 2) + ":" + macNotAligned.Substring(10, 2) + ":";
            }
            else
            {
                return macNotAligned;
            }
        }
    }
}
