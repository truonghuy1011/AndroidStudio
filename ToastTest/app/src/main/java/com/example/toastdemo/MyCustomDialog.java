package com.example.toastdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class MyCustomDialog extends Dialog {
    ImageView imgOK, imgCancel;
    Activity context;

    public MyCustomDialog(@NonNull Context context){
        super(context);
        this.context = (Activity) context;
        setContentView(R.layout.custom_dialog);
        addView();
        //setCanceledOnTouchOutside(false);
        addEvents();
    }

    private void addEvents() {
        imgOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();
            }
        });

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void addView() {
        imgOK = findViewById(R.id.imgOk);
        imgCancel = findViewById(R.id.imgCancel);
    }
}
