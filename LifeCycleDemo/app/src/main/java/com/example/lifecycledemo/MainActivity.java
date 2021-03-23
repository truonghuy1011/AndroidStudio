package com.example.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");

    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(MainActivity.this,"onStart",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onStar");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestar");
    }

    public void moManhinhToanbo(View view) {

        Intent intent=new Intent(MainActivity.this,sub1Activity1.class);
        startActivity(intent);
    }

    public void momanhinhMotphan(View view) {
        Intent intent=new Intent(MainActivity.this,sub2Activity2.class);
        startActivity(intent);
    }
}
