package com.example.dragonsage.tickandtrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;

/**
 * Created by DragonSage on 8/19/2017.
 */

public class RunithOs extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")){

            GlobalInfo globalInfo = new GlobalInfo(context);
            globalInfo.LoadData();

            //start location track
            if (!TrackLocation.isRunning){
                TrackLocation trackLocation = new TrackLocation();
                LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,trackLocation);
            }
            //start location track
            if (!MyService.IsRunning){
                Intent locationIntent=new Intent(context,MyService.class);
                context.startService(locationIntent);
            }
        }
    }
}
