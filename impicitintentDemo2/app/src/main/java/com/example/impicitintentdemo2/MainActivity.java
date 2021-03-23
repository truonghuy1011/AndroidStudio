package com.example.impicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtPhoneNumber,edtMessage;
    Button btnDial,btnCall,btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews() {
        edtPhoneNumber=findViewById(R.id.edtPhoneNumber);
        edtMessage=findViewById(R.id.edtMessage);
        btnDial=findViewById(R.id.btnDial);
        btnCall=findViewById(R.id.btnCall);
        btnSMS=findViewById(R.id.btnSMS);
    }

    private void addEvents() {
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuliDial();
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuliCall();
            }
        });
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuliSMS();
            }
        });

    }

    private void xuliSMS() {
//        SmsManager smsManager=SmsManager.getDefault();
//        smsManager.sendTextMessage(
//                edtPhoneNumber.getText().toString(),
//                null,
//                edtMessage.getText().toString(),
//                null,null
//        );
        SmsManager smsManager=SmsManager.getDefault();
        Intent intent=new Intent("ACTION_MSG_SENT");
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int kq=getResultCode();
                if(kq== Activity.RESULT_OK){
                    Toast.makeText(MainActivity.this,"Đã gửi thành công",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(MainActivity.this,"Đã gửi thất bại",Toast.LENGTH_LONG).show();
            }
        },new IntentFilter("ACTION_MSG_SENT"));
        smsManager.sendTextMessage(edtPhoneNumber.getText().toString(),null,
                edtMessage.getText().toString(),pendingIntent,null);
    }

    private void xuliCall() {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        Uri uri=Uri.parse("tel:"+edtPhoneNumber.getText().toString());
        intent.setData(uri);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }

    private void xuliDial() {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        Uri uri=Uri.parse("tel:"+edtPhoneNumber.getText().toString());
        intent.setData(uri);
        startActivity(intent);

    }


}
