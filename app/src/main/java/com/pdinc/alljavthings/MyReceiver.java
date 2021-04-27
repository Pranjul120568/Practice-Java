package com.pdinc.alljavthings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //A broadcast receiver used for letting the user know wether the charger is disconnected or connected

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        //to check wether charging or not
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

        if(isCharging){
            Log.d("FRCHRGR","CHARGING");
            Toast.makeText(context,"CHarging",Toast.LENGTH_SHORT).show();
        }else{
            Log.d("FRCHRGR","Not Charging");
            Toast.makeText(context,"Not Charging",Toast.LENGTH_SHORT).show();
        }

        //a Broadcast receiver which helps a user by showing up a taste when the language of the input is changed
        Log.d("RCV","LOCALE");
        Toast.makeText(context,"Language Changed",Toast.LENGTH_SHORT).show();

        //This lIne starts the app whenever the language is changed
        context.startActivity(new Intent(context,MainActivity.class));

//        throw new UnsupportedOperationException("Not yet implemented");
    }
}