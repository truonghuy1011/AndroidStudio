package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Sach;
import com.example.sqlitesach.MainActivity;
import com.example.sqlitesach.R;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Sach> sachList;

    public SachAdapter(MainActivity context, int layout, List<Sach> sachList) {
        this.context = context;
        this.layout = layout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            viewHolder.txtsachName=convertView.findViewById(R.id.txtsachName);
            viewHolder.imvDelete=convertView.findViewById(R.id.imvDelete);
            viewHolder.imvEdit=convertView.findViewById(R.id.imvEdit);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
            final Sach sach=sachList.get(position);
            viewHolder.txtsachName.setText(sach.getSachName());

            viewHolder.imvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


        return null;
    }
    private static class ViewHolder{
        TextView txtsachName;
        ImageView imvDelete,imvEdit;
    }
}
