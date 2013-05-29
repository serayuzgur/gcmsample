package tr.com.gcmsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		
		TextView textView = (TextView) findViewById(R.id.messageField);
		
		textView.setText(getIntent().getExtras().getString("message"));
	}


}
