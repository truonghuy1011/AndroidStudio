package com.example.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.letruonghuy.MainActivity;
import com.example.letruonghuy.R;
import com.example.model.Task;

import java.util.List;

public class TaskAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private int layout;
    private List<Task>taskList;


    public TaskAdapter(MainActivity mainActivity, int layout, List<Task> taskList) {
        this.mainActivity = mainActivity;
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
    public static class ViewHolder{
        TextView txtName,txtId,txtProducer,txtPrice;
        ImageButton img_edit,img_delete;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txtId=convertView.findViewById(R.id.txtId);
            holder.txtName=convertView.findViewById(R.id.txtName);
            holder.txtProducer=convertView.findViewById(R.id.txtProducer);
            holder.txtPrice=convertView.findViewById(R.id.txtPrice);
            holder.img_edit=convertView.findViewById(R.id.img_edit);
            holder.img_delete=convertView.findViewById(R.id.img_delete);
            convertView.setTag(holder);

        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        final Task b=taskList.get(position);
        holder.txtId.setText(b.getIdTask());
        holder.txtName.setText(b.getNameTask());
        holder.txtProducer.setText(b.getProducerTask());
        holder.txtPrice.setText(String.valueOf(b.getPriceTask()));
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
mainActivity.OpenDialogEditTask(b.getID(),b.getPriceTask(),b.getIdTask(),b.getProducerTask(),b.getPriceTask());
            }
        });
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.deletePhone(b.getID(),b.getNameTask());
            }
        });
        return convertView;
    }
}
