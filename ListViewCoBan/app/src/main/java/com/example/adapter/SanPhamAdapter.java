package com.example.adapter;


import android.app.Activity;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewcoban.R;
import com.example.model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(@NonNull Activity context, int resource){
        super(context,resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);
        ImageView imghinh = customView.findViewById(R.id.imghinh);
        TextView txtTen = customView.findViewById(R.id.txtTen);
        TextView txtGia = customView.findViewById(R.id.txtGia);
        SanPham sp = getItem(position);
        imghinh.setImageResource(sp.getId());
        txtGia.setText(String.format("%.0f",sp.getGia())+"vnd");
        txtTen.setText(sp.getTen());
        return customView;
    }
}
