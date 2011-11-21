using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;

namespace Find_Your_Pal
{
    public partial class Student : PhoneApplicationPage
    {
        public Student()
        {
            InitializeComponent();
        }
        //Locate
        private void button2_Click(object sender, RoutedEventArgs e)
        {
            SmsComposeTask sms = new SmsComposeTask();
            sms.To = "+918826561956";
            sms.Body = "PF2:";
            sms.Show();
        }
        //Connect
        private void button1_Click(object sender, RoutedEventArgs e)
        {
            SmsComposeTask sms = new SmsComposeTask();
            sms.To = "+918826561956";
            sms.Body = "PF1:";
            sms.Show();
        }
    }
}