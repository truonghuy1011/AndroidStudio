package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Task;
import com.example.sqlite2.MainActivity;
import com.example.sqlite2.R;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Task> taskList;

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
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            viewHolder.txtTaskName=convertView.findViewById(R.id.txtTaskName);
            viewHolder.imvDelete=convertView.findViewById(R.id.imvDelete);
            viewHolder.imvEdit=convertView.findViewById(R.id.imvEdit);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        final Task t=taskList.get(position);
        viewHolder.txtTaskName.setText(t.getTaskName());

        viewHolder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.openDialogEditTask(t.getTaskId(),t.getTaskName());
            }
        });
        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.openDeleteTask(t.getTaskId(),t.getTaskName());
            }
        });

        return convertView;
    }
    private static class ViewHolder{
        TextView txtTaskName;
        ImageView imvDelete,imvEdit;
    }
}
