package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Task;
import com.example.spliteexample.MainActivity;
import com.example.spliteexample.R;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Task>taskList;

    public TaskAdapter(MainActivity context, int layout, List<Task> taskList) {
        this.context = context;
        this.layout = layout;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txtTastName=convertView.findViewById(R.id.TaskName);
            holder.imvDelete=convertView.findViewById(R.id.imvDelete);
            holder.imvEdit=convertView.findViewById(R.id.imvEdit);
            convertView.setTag(holder);


        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        final Task t=taskList.get(position);
        holder.txtTastName.setText(t.getTaskName());
        holder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.openDialogEditTask(t.getTaskId(),t.getTaskName());
            }
        });
        holder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.deleteTask(t.getTaskId(),t.getTaskName());
            }
        });

        return convertView;
    }
    private static class ViewHolder{
        TextView txtTastName;
        ImageView imvDelete,imvEdit;
    }
}
