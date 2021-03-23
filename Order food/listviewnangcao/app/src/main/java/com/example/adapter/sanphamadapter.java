package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewnangcao.R;
import com.example.model.sanpham;

public class sanphamadapter extends ArrayAdapter<sanpham>{
    Activity context;
    int resource;
    public sanphamadapter(@NonNull Activity context, int resource) {
        super(context,resource);
        this.context = context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);
        ImageView imgHinh = customView.findViewById(R.id.imghinh);
        TextView txtTen = customView.findViewById(R.id.txttensanpham);
        TextView txtGia = customView.findViewById(R.id.txtgia);
        sanpham sp = getItem(position);
        imgHinh.setImageResource(sp.getImgId());
        txtGia.setText(String.format("%.0f",sp.getGia())+"vnd");
        txtTen.setText(sp.getTen());
        return customView;
    }
}
