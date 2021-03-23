package com.example.sqlite2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
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
    ArrayList taskArrayList;
    TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        PreparedDB();
        getData();
    }
    private void getData() {
        Cursor cursor=databases.GetData("select * from Works");
        taskArrayList.clear();
        int taskId;
        String taskName;
        while (cursor.moveToNext()){
            taskId=cursor.getInt(0);
            taskName=cursor.getString(1);
            taskArrayList.add(new Task(taskId,taskName));
        }
        taskAdapter.notifyDataSetChanged();
    }

    private void addViews() {
        lvTask=findViewById(R.id.lvTask);
        taskArrayList=new ArrayList<>();
        taskAdapter=new TaskAdapter(this, R.layout.item_row,taskArrayList);
        lvTask.setAdapter(taskAdapter);
    }
    private void PreparedDB() {
        databases =new Databases(this,"note_db.sqlite",null,1);

        databases.QueryData("CREATE TABLE IF NOT EXISTS Works (Id INTEGER PRIMARY KEY AUTOINCREMENT, "+" WorkName VARCHAR(200))");
//        databases.QueryData("insert into Works values (null, 'Fix bugs')");
//        databases.QueryData("insert into Works values (null, 'Coding')");
//        databases.QueryData("insert into Works values (null, 'Meeting')");
//        databases.QueryData("insert into Works values (null, 'Walking')");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuAddTask){
            openDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtTastName=dialog.findViewById(R.id.edtTask);
        Button btnOK=dialog.findViewById(R.id.btnOK);
        Button btnCancel=dialog.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName=edtTastName.getText().toString();
                if(taskName.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter task name", Toast.LENGTH_SHORT).show();
                }else{
                    databases.QueryData("insert into Works values (null, '"+taskName+"')");
                    Toast.makeText(MainActivity.this, "Added task successful", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getData();
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
    public void openDialogEditTask(final int taskId, String taskName){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_edit);

        final EditText edtTaskName=dialog.findViewById(R.id.edtTaskEdit);
        Button btnEdit=dialog.findViewById(R.id.btnEdit);
        Button btnCancel=dialog.findViewById(R.id.btnCancelEdit);

        edtTaskName.setText(taskName);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName=edtTaskName.getText().toString();
                databases.QueryData("update Works set Workname='"+newName+"' where Id="+taskId);
                Toast.makeText(MainActivity.this, "Edit task successful", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getData();
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
    public void openDeleteTask(final int taskId, final String taskName){
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to delete this task"+taskName+"?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databases.QueryData("delete from Works where Id="+taskId);
                Toast.makeText(MainActivity.this, "Deleted task successful", Toast.LENGTH_SHORT).show();
                getData();
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
