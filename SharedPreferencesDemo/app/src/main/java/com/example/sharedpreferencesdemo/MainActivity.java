package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String preferencesName="my_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Save(View view) {
        SharedPreferences preferences=getSharedPreferences(preferencesName,MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        editor.putInt("int",8);
        editor.putBoolean("boolean",true);
        editor.putFloat("f",6.8f);
        editor.putLong("l",68);
        editor.putString("s","Welcome to UTC2");

        Set<String>ds=new HashSet<>();
        ds.add("Ionic");
        ds.add("Flutter");
        ds.add("React Native");
        editor.putStringSet("string_set",ds);

        editor.apply();
    }

    public void Load(View view) {
        SharedPreferences preferences=getSharedPreferences(preferencesName,MODE_PRIVATE);
        int i=preferences.getInt("int",0);
        boolean b=preferences.getBoolean("boolean",false);
        float f=preferences.getFloat("f",0.0f);
        long l=preferences.getLong("l",0);
        String s=preferences.getString("s","");

        Set<String>ds=preferences.getStringSet("String_set",null);
        TextView txtContent=findViewById(R.id.txtContent);
        txtContent.setText("");
        txtContent.append("i="+i+"\n");
        txtContent.append("b="+b+"\n");
        txtContent.append("f="+f+"\n");
        txtContent.append("l="+l+"\n");
        txtContent.append("s="+s+"\n");

        txtContent.append("String Set:\n");
        StringBuilder builder=new StringBuilder();
        for(String x:ds){
            builder.append(x).append("\n");
        }
        txtContent.append(builder.toString());

    }
}
