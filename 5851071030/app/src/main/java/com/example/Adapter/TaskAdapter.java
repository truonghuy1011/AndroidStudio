package com.example.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a5851071030.MainActivity;
import com.example.a5851071030.R;
import com.example.model.Task;

import org.w3c.dom.Text;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private MainActivity mainActivity;
    private int layout;
    private List<Task>taskList;
    private Context context;
    private Layout main;

    public TaskAdapter(MainActivity mainActivity, int layout, List<Task> taskList) {
        this.mainActivity = mainActivity;
        this.layout = layout;
        this.taskList = taskList;
    }
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
        ImageView imgEdit,imgDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
                    holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txtId=convertView.findViewById(R.id.txtId);
            holder.txtName=convertView.findViewById(R.id.txtName);
            holder.txtProducer=convertView.findViewById(R.id.txtProducer);
            holder.txtPrice=convertView.findViewById(R.id.txtPrice);
            holder.imgEdit=convertView.findViewById(R.id.imgEdit);
            holder.imgDelete=convertView.findViewById(R.id.imgDelete);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        final Task b=taskList.get(position);
        holder.txtId.setText(b.getIdTask());
        holder.txtName.setText(b.getNameTask());
        holder.txtProducer.setText(b.getProducerTask());
        holder.txtPrice.setText(String.valueOf(b.getPriceTask()));
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.OpenDialogEditTask(b.getID(),b.getNameTask(),b.getIdTask(),b.getProducerTask(),b.getPriceTask());
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.deletePhone(b.getID(),b.getNameTask());
            }
        });
        return convertView;
    }
}
