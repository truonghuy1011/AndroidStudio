package com.example.sqliteexample1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.TaskAdapter;
import com.example.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Databases databases;
    ListView lvTask;
    ArrayList<Task>taskArrayList;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrepareDB();
        addViews();
        GetData();
    }

    private void addViews() {
        lvTask=findViewById(R.id.lvTask);
        taskArrayList=new ArrayList<>();
        taskAdapter=new TaskAdapter(this,R.layout.item_row,taskArrayList);
        lvTask.setAdapter(taskAdapter);
    }

    private void PrepareDB() {
        databases=new Databases(this,"note_db.sqLite",null,1);
        databases.QueryData(
                "CREATE TABLE IF NOT EXISTS Works(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "WorkName VARCHAR(200))"
        );

//        databases.QueryData("INSERT INTO Works VALUES(Null,'FIX bugs')");
//        databases.QueryData("INSERT INTO Works VALUES(Null,'Coding')");
//        databases.QueryData("INSERT INTO Works VALUES(Null,'Meeting')");
//        databases.QueryData("INSERT INTO Works VALUE(Null,'Walking')");

    }

    private void GetData(){
        Cursor c=databases.GetData("SELECT * FROM Works");
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
        getMenuInflater().inflate(R.menu.add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAddTask){
            openDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    private void openDialog(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.add_task);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtTaskName = dialog.findViewById(R.id.edtTask);
        Button btnOK=dialog.findViewById(R.id.btnOK);
        Button btnCancel=dialog.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName=edtTaskName.getText().toString();
                if(taskName.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter task name!",Toast.LENGTH_LONG).show();
                }else {
                    databases.QueryData("INSERT INTO Works VALUES(null,'" + taskName + "')");
                    Toast.makeText(MainActivity.this,"Added task successful!",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    GetData();
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
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.edit_task);

        final EditText edtTaskName=dialog.findViewById(R.id.edtTaskEdit);
        Button btnEditTask=dialog.findViewById(R.id.btnOKEdit);
        Button btnCancel=dialog.findViewById(R.id.btnCancelEdit);

        edtTaskName.setText(taskName);

        btnEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTaskName=edtTaskName.getText().toString();
                databases.QueryData("UPDATE Works SET WorkName = '" + newTaskName + "' WHERE Id = " + taskId);
                Toast.makeText(MainActivity.this,"Edit task successful!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
                GetData();
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
    public void deleteTask(final int taskId,String taskName){
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to delete this task: " + taskName + "?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databases.QueryData("DELETE FROM Works WHERE Id = " + taskId);
                Toast.makeText(MainActivity.this,"Deleted task successful!",Toast.LENGTH_LONG).show();
                GetData();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}