package com.example.listviewcoban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<SanPham> arrayAdapter;
    ListView lvsanpham;
    View loadMoreView;
    boolean isloading=false;
    myHandler myHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
        addViews();
        addEvent();
    }

    private void addViews() {
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        loadMoreView=layoutInflater.inflate(R.layout.load_more,null);
        myHandler=new myHandler();
        lvsanpham=findViewById(R.id.lvsanpham);
        arrayAdapter=new SanPhamAdapter(MainActivity.this,R.layout.activity_main);
//        arrayAdapter.add(new SanPham(R.drawable.cocacola,"Nước ngọt",20000));
//        arrayAdapter.add(new SanPham(R.drawable.donuts,"Bánh donut",22000));
//        arrayAdapter.add(new SanPham(R.drawable.garan,"Gà rán",70000));
//        arrayAdapter.add(new SanPham(R.drawable.hamburger,"Hamburger",50000));
//        arrayAdapter.add(new SanPham(R.drawable.khoaitaychien,"Khoai tây chiên",21000));
//        arrayAdapter.add(new SanPham(R.drawable.sinhto,"Sinh tố",14000));
        lvsanpham.setAdapter(arrayAdapter);
    }

    private void addEvent() {
        lvsanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp=arrayAdapter.getItem(position);
                Toast.makeText(MainActivity.this,sp.getTen(),Toast.LENGTH_SHORT).show();
            }
        });
        lvsanpham.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(view.getLastVisiblePosition()==totalItemCount -1&&!isloading){
                    isloading=true;
                    Thread thread=new ThreadData();
                    thread.start();;
                }
            }
        });

    }
    public void LoadingNewItems(ArrayList<SanPham>newItems){
        arrayAdapter.addAll(newItems);
    }
    public class myHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch(msg.what){
                case 0:
                    lvsanpham.addFooterView(loadMoreView);
                    break;
                case 1:
                    lvsanpham.removeFooterView(loadMoreView);
                    LoadingNewItems((ArrayList<SanPham>)msg.obj);
                    isloading=false;
                    break;

            }

        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0);
            ArrayList<SanPham> data=getMoredata();
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Message message=myHandler.obtainMessage(1,data);
            myHandler.sendMessage(message);
        }

    }
    public ArrayList<SanPham> getMoredata(){
           ArrayList<SanPham> ds = new ArrayList<>();
        ds.add(new SanPham(R.drawable.cocacola,"Nước ngọt",20000));
        ds.add(new SanPham(R.drawable.donuts,"Bánh donut",22000));
        ds.add(new SanPham(R.drawable.garan,"Gà rán",70000));
        ds.add(new SanPham(R.drawable.hamburger,"Hamburger",50000));
        ds.add(new SanPham(R.drawable.khoaitaychien,"Khoai tây chiên",21000));
        ds.add(new SanPham(R.drawable.sinhto,"Sinh tố",14000));
        return ds;
    }

}
