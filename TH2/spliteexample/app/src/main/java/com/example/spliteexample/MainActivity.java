package com.example.spliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.TaskAdapter;
import com.example.model.Task;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    Databases databases;
    ListView lvTask;
    ArrayList<Object> taskArrayList;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        PrepDB();
        getDatabase();
    }



    private void getDatabase() {
        Cursor c=databases.Getdata("Select * From works");
        taskArrayList.clear();
        while (c.moveToNext()){
            int taskId=c.getInt(0);
            String taskName=c.getString(1);
            taskArrayList.add(new Task(taskId,taskName));
        }
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void openDialog(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);//thoat man hinh khong bi tat

        final EditText edtTask=dialog.findViewById(R.id.edtTask);
        Button btnOk=dialog.findViewById(R.id.btnOk);
        Button btnCancel=dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName=edtTask.getText().toString();
                if (taskName.equals("")){
                    Toast.makeText(MainActivity.this,"Added task successful !",Toast.LENGTH_SHORT).show();
                }else{
                    databases.Querydata("INSERT INTO Works VALUES(null,'"+taskName+"')");
                    Toast.makeText(MainActivity.this,"Add Task successful !",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    getDatabase();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void openDialogEditTask(final int taskId,String taskName){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        final EditText edtTaskName=dialog.findViewById(R.id.edtTask);
        Button btnedtTaskName=dialog.findViewById(R.id.btnEdit);
        Button btnCancels=dialog.findViewById(R.id.btnCancels);
        edtTaskName.setText(taskName);
        btnedtTaskName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTaskName=edtTaskName.getText().toString();
                databases.Querydata("Update works set WorksName='"+newTaskName+"'where ID='"+taskId+"'");
                Toast.makeText(MainActivity.this,"Edit text successful!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDatabase();
            }
        });
        btnCancels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void deleteTask(final int taskId,String taskName){
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Bạn muốn xóa tên này đúng không?""+")
    }

    private void addView() {
        lvTask=findViewById(R.id.lvTask);
        taskArrayList=new ArrayList<>();
        taskAdapter=new TaskAdapter(this,R.layout.item_row,taskArrayList);
        lvTask.setAdapter(taskAdapter);
    }
    private void PrepDB() {
        //create database
        databases=new Databases(this,"note_db.sqlite",null,1);
        //create data
        databases.Querydata("CREATE TABLE IF NOT EXISTS works(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"WorksName Varchar(200))");
        //insert data
        databases.Querydata("Insert into works values(null,'fix bugs')");
        databases.Querydata("Insert into works values(null,'coding')");
        databases.Querydata("Insert into works values(null,'wedding')");
    }

    }

