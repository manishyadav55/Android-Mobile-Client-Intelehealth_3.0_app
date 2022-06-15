package org.intelehealth.app.services.firebase_services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class RestartServiceReceiver extends BroadcastReceiver {

    private static final String TAG = RestartServiceReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive");
        /*if (!CallListenerBackgroundService.isInstanceCreated()) {
            Intent serviceIntent = new Intent(context, CallListenerBackgroundService.class);
            ContextCompat.startForegroundService(context, serviceIntent);
        }*/

        if (!CallListenerBackgroundService.isInstanceCreated()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Intent serviceIntent = new Intent(context, CallListenerBackgroundService.class);
                ContextCompat.startForegroundService(context, serviceIntent);
            } else {
                context.startService(new Intent(context, CallListenerBackgroundService.class));
            }
        }
    }
}