package seproject.tryout;

import seproject.tryout.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondPage extends Activity {
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.second);
	}

	 public void click(View view) {
			Intent intent = null;
			switch (view.getId()) {
			case R.id.Button03:
				//intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.vogella.de"));
				intent = new Intent(this, ThirdPage.class);
				startActivity(intent);
				break;
				
			case R.id.Button04:
				//intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:(+49)12345789"));
				//startActivity(intent);
				//Toast.makeText(this, "PLEASE!", Toast.LENGTH_LONG).show();
				intent = new Intent(this, FourthPage.class);
				startActivity(intent);
				break;
			}
		}
}
