package seproject.tryout;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SEprojectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
           }
    
  /*  public void onClick(View view) {
		Intent i = new Intent(this, SecondPage.class);
		startActivity(i);
		
	}*/
    
    public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.Button01:
			//intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.vogella.de"));
			intent = new Intent(this, SecondPage.class);
			startActivity(intent);
			break;
		case R.id.Button02:
			//intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:(+49)12345789"));
			intent = new Intent(this, FifthPage.class);
			startActivity(intent);
			//Toast.makeText(this, "HELLO!", Toast.LENGTH_LONG).show();
			break;
		}
	}

}