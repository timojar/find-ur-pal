package seproject.tryout;

import seproject.tryout.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdPage extends Activity {
	
	Button btnSendSMS;
    //EditText txtPhoneNo;
	
	String txtPhoneNo;
    EditText txtMessage;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.third);
	
	
	
	//txtPhoneNo = (EditText) findViewById(R.id.EditText02);
	btnSendSMS = (Button) findViewById(R.id.Button05);
	txtMessage = (EditText) findViewById(R.id.EditText01);
	
	btnSendSMS.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {                
            //String phoneNo = txtPhoneNo.getText().toString();
            String phoneNo = "9818457530";
        	//String phoneNo= null;
            String message = txtMessage.getText().toString(); 
            String completemsg = "pf1:"  + phoneNo + "," + message; 
            if (phoneNo.length()>0 && message.length()>0)
            {
                //sendSMS(phoneNo, message); 
            	sendSMS(phoneNo, completemsg);
            Toast.makeText(getBaseContext(), 
                    "Message Sent", 
                    Toast.LENGTH_SHORT).show();
            
            }                
            	
            else
                Toast.makeText(getBaseContext(), 
                    "Please enter phone number.", 
                    Toast.LENGTH_SHORT).show();
        }
    });  
	}
	
	private void sendSMS(String phoneNumber, String message)
    {        
        PendingIntent pi = PendingIntent.getActivity(this, 0,
            new Intent(this, ThirdPage.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);        
    }    
    
	
	
}

