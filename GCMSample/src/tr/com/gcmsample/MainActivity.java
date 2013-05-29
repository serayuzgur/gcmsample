package tr.com.gcmsample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	protected static final String SENDER_ID = "YOUR_SENDER_PROJECT_ID(NUMERIC)";
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
			GCMRegistrar.register(this, SENDER_ID);
		} else {
			Log.v(TAG, "Already registered");
		}
		Log.i(TAG, regId);

		Button unregister = (Button) findViewById(R.id.button1);
		unregister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				unRegisterFromGCM();
			}
		});
	}

	public void unRegisterFromGCM() {
		GCMRegistrar.unregister(this);
	}

}
