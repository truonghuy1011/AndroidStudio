package com.example.notificationtest;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_ID="Channel 1";
    public static final String CHANNEL_ID_2="Channel 2";
    @Override
    public void onCreate() {
        super.onCreate();

        createnottificationChanel();
    }

    private void createnottificationChanel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"Channel 1"
                    , NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("This is my channel 1");
            NotificationChannel channel2=new NotificationChannel(CHANNEL_ID_2,"Channel 2"
                    , NotificationManager.IMPORTANCE_LOW);
            channel.setDescription("This is my channel 2");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channel2);

        }
    }
}
