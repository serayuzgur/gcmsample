package tr.com.gcmsample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {

	// This intent service will be called by the GCMBroadcastReceiver (which is
	// provided by the GCM library), as shown in the next step. It must be a
	// subclass of com.google.android.gcm.GCMBaseIntentService, must contain a
	// public constructor, and should be named my_app_package.GCMIntentService
	// (unless you use a subclass of GCMBroadcastReceiver that overrides the
	// method used to name the service).

	public GCMIntentService() {
		super(MainActivity.SENDER_ID);
	}


	@Override
	protected void onError(Context arg0, String errorId) {
		
		Log.i("errorId",errorId);

	}

	@Override
	protected void onMessage(Context arg0, Intent intent) {
		String message = intent.getExtras().get("message").toString();
		Log.i("message",message);
		Intent messageActivity = new Intent(getApplicationContext(), MessageActivity.class);
		//This flag is required to open activity from outside. This can connect to notification manager.
		messageActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		messageActivity.putExtras(intent.getExtras());
		startActivity(messageActivity);


	}

	@Override
	protected void onRegistered(Context context, String regId) {
		Log.i("regid",regId);
		//You have to send this id to your sender

	}

	@Override
	protected void onUnregistered(Context context, String regId) {
		Log.i("regid",regId);
		
	}
}