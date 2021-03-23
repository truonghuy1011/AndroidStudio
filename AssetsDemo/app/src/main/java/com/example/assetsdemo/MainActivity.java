package com.example.assetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtInfo;
    ListView lvFonts;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addViews();
        addEvents();
    }

    private void addEvents() {
        lvFonts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/"+adapter.getItem(position));
                txtInfo.setTypeface(typeface);
                playAudio();
            }
        });
    }

    private void playAudio() {
        try {
            AssetFileDescriptor descriptor=getAssets().openFd("audios/ting.mp3");
            MediaPlayer player=new MediaPlayer();
            player.setDataSource(descriptor.getFileDescriptor(),
                    descriptor.getStartOffset(),
                    descriptor.getLength());
            descriptor.close();

            player.prepare();
            player.start();
        }catch (Exception e){
            Log.e("Error",e.toString());
        }
    }

    private void addViews() {
        txtInfo=findViewById(R.id.txtInfo);
        lvFonts=findViewById(R.id.lvFonts);
        adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1);
        lvFonts.setAdapter(adapter);

        try {
            AssetManager assetManager=getAssets();
            String[] fontList=assetManager.list("fonts");
            adapter.addAll(fontList);
        }catch (Exception e){
            Log.e("Error:",e.toString());
        }
    }
}
