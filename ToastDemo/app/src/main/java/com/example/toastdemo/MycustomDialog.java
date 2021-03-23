package com.example.toastdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class MycustomDialog extends Dialog {
    Button btnOK,btnCancel;
    Activity context;

    public MycustomDialog(@NonNull Context context){
        super(context);
        this.context=(Activity) context;
        setContentView(R.id.custom);
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void addViews() {
        btnOK = findViewById(R.id.btnOK);
        btnCancel = findViewById(R.id.btnCancel);

    }
}
