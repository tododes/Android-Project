package com.example.gx60.semiproject;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by GX60 on 17/05/2017.
 */

public class MyService extends Service {
    private Thread thread;
    private MyRunnable myRunnable;
    public static double mapLatitude;
    public static double mapLongitude;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private MediaPlayer mediaPlayer;

    public MyService() {

        super();
    }

    @Override
    public void onCreate() {

        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.my_default_music);

        myRunnable = new MyRunnable(startId);
        thread = new Thread(myRunnable);
        thread.start();
        return START_STICKY;
    }

    private void ActivateLocationUpdate(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates("gps", 0, 0, locationListener);
    }

    @Override
    public void onDestroy() {
        myRunnable.Running = false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class MyRunnable implements Runnable {
        private int serviceID;
        public boolean Running;

        public MyRunnable(int ID) {
            serviceID = ID;
            Running = true;
        }

        @Override
        public void run() {
            synchronized (this) {
                mapLatitude = mapLongitude = 0;

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        mapLatitude = location.getLatitude();
                        mapLongitude = location.getLongitude();
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };
                mediaPlayer.start();
                mediaPlayer.setLooping(true);

                while(Running)
                {
                    try {
                        wait(1000/60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mediaPlayer.stop();
                stopSelf(serviceID);
            }
        }
    }
}
