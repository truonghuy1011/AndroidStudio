package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notificationtest.App.CHANNEL_ID;
import static com.example.notificationtest.App.CHANNEL_ID_2;


public class MainActivity extends AppCompatActivity {
    EditText edtTitle,edtMessage;
    NotificationManagerCompat notificationCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        notificationCompat=NotificationManagerCompat.from(this);
    }

    private void addView() {
        edtTitle=findViewById(R.id.edtTitle);
        edtMessage=findViewById(R.id.edtMessage);
    }

    public void createNotification(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        Intent broadcast=new Intent(this,NotificationReceiver.class);
        broadcast.putExtra("NOTIFICATION",edtMessage.getText().toString());
        PendingIntent actionIntent=PendingIntent.getBroadcast(this,0,broadcast,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_cc)
                .setContentTitle(edtTitle.getText().toString())
                .setContentText(edtMessage.getText().toString())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .addAction(R.mipmap.ic_launcher,"Show",actionIntent)
                .build();
        notificationCompat.notify(1,notification);
    }

    public void createNotification2(View view) {

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_grass)
                .setContentTitle(edtTitle.getText().toString())
                .setContentText(edtMessage.getText().toString())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setStyle(new NotificationCompat.InboxStyle()
//                        .addLine("Line 1")
//                        .addLine("Line 2")
//                        .addLine("Line 3")
//                        .addLine("Line 4")
//                        .addLine("Line 5")
//                )
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Chao mung ban den voi nha tu cua chung toi")
                        .setBigContentTitle("NoNoNo")
                        .setSummaryText("Nhatu......")
                )
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationCompat.notify(2,notification);

    }
}
