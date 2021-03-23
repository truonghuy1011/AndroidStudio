package com.example.adapter;

import android.app.Activity;
import android.widget.ArrayAdapter;
import com.example.model.sanpham;
public class sanphamAdapter extends ArrayAdapter<sanpham> {
    Activity context;
    int resource;
    public sanphamAdapter(Activity context,int resource){
        super(context,resource);
        this.context=context;
        this.resource=resource;
    }
}
