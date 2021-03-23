package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.advancedgridviewexample.R;
import com.example.model.SanPham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource,null);
        ImageView imgPhoto = customView.findViewById(R.id.imgPhoto);
        TextView txtTen = customView.findViewById(R.id.txtTen);

        SanPham sp = getItem(position);
        imgPhoto.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());

        return customView;
    }
    public void onBindViewHolder
}
