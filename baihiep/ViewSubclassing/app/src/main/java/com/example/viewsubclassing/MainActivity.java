package com.example.viewsubclassing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
//        AddEvents();
    }

//    private void AddEvents() {
//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                LinearLayout linearLayout = new LinearLayout( getApplicationContext());
//                linearLayout.setLayoutParams(layoutParams);
//                linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//                TextView textView = new TextView(getApplicationContext());
//                textView.setTextSize(24);
//                textView.setText("Chao mung den voi UTC2");
//                linearLayout.addView(textView);
//
//                Button btnBack = new androidx.appcompat.widget.AppCompatButton(getApplicationContext()){
//                    @Override
//                    public boolean performClick() {
////                        Toast.makeText(getApplicationContext(), "Thong bao", Toast.LENGTH_SHORT).show();
//                        setContentView(R.layout.activity_main);
//                        return super.performClick();
//                    }
//                };
//
//                btnBack.setText("back");
//                btnBack.setLayoutParams(layoutParams);
//                linearLayout.addView(btnBack);
//
//                setContentView(linearLayout);
//            }
//        });
//    }

    private void addViews() {
        btnShow = findViewById(R.id.btnShoww);
    }

    public void xuLy(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout( this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(this);
        textView.setTextSize(24);
        textView.setText("Chao mung den voi UTC2");
        linearLayout.addView(textView);

        Button btnBack = new androidx.appcompat.widget.AppCompatButton(this){
            @Override
            public boolean performClick() {
//              Toast.makeText(getApplicationContext(), "Thong bao", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_main);
                return super.performClick();
            }
        };

        btnBack.setText("back");
        btnBack.setLayoutParams(layoutParams);
        linearLayout.addView(btnBack);

        setContentView(linearLayout);
    }
}
