package com.example.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Task;
import com.example.BTTH.MainActivity;
import com.example.BTTH.R;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private MainActivity mainActivity;
    private int layout;
    private List<Task> taskList;
    private Context context;
    private Layout main;
    public TaskAdapter(MainActivity mainActivity, int layout, List<Task> taskList)
    {
        this.mainActivity=mainActivity;
        this.layout=layout;
        this.taskList = taskList;
    }
    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
        TextView txt_Name,txt_ID,txt_Producer,txt_price;
        ImageView img_Edit,img_Delete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder =new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txt_ID=convertView.findViewById(R.id.txt_ID);
            holder.txt_Name=convertView.findViewById(R.id.txt_name);
            holder.txt_Producer=convertView.findViewById(R.id.txt_producer);
            holder.txt_price=convertView.findViewById(R.id.txt_price);
            holder.img_Edit=convertView.findViewById(R.id.img_edit);
            holder.img_Delete=convertView.findViewById(R.id.img_delete);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
        final Task b= taskList.get(position);
        holder.txt_Name.setText(b.getNameTask());
        holder.txt_ID.setText(b.getIdTask());
        holder.txt_Producer.setText(b.getProducerTask());
        holder.txt_price.setText(String.valueOf(b.getPriceTask()));
        holder.img_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.OpenDialogEditTask(b.getID(),b.getNameTask(),b.getIdTask(),b.getProducerTask(),b.getPriceTask());
            }
        });
        holder.img_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.deletePhone(b.getID(),b.getNameTask());
            }
        });
        return convertView;
    }
}
