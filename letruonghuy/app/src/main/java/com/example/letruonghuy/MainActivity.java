package com.example.letruonghuy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.adapter.TaskAdapter;
import com.example.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_task;
    Database database;
    ArrayList<Task>taskArrayList;
    TaskAdapter taskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        PrepareDB();
        GetData();
    }

    private void addView() {
        lv_task=findViewById(R.id.lv_task);
        taskArrayList=new ArrayList<>();
        taskAdapter=new TaskAdapter(this,R.layout.row,taskArrayList);
        lv_task.setAdapter(taskAdapter);
    }

    private void PrepareDB() {
        database=new Database(this,"phones_db.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Phones(ID Integer PRIMARY KEY AUTOINCREMENT,PhoneID VARCHAR(20),"+"PhoneName VARCHAR(100)"+",PhoneProducer VARCHAR(100),PhonePrice INTEGER)");
        database.QueryData("INSERT INTO Phones VALUE(null,'P01','Galaxy S10','Samsung',1300000)");
        database.QueryData("INSERT INTO Phones VALUE(null,'P02','Galaxy S20','Samsing',1400000)");
        database.QueryData("INSERT INTO Phones VALUE(null,'P03','Galaxy S30','Samsong',1500000)");
        database.QueryData("INSERT INTO Phones VALUE(null,'P04','Galaxy S40','Samseng',1600000)");

    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId()==R.id.mnAddTask){
            openDialogAddPhones();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDialogAddPhones() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.activity_add);
        dialog.setCanceledOnTouchOutside(false);

        final EditText addPhoneName=dialog.findViewById(R.id.txt_adName);
        final EditText addPhoneID=dialog.findViewById(R.id.txt_adId);
        final EditText addPhoneProducer=dialog.findViewById(R.id.txt_adProducer);
        final EditText addPhonePrice=dialog.findViewById(R.id.txt_adPrice);


    }

    private void GetData(){
        Cursor c=database.GetData("SELECT * FROM Phones");
        taskArrayList.clear();
        while (c.moveToNext()){
            int ID=c.getInt(0);
            String phoneID=c.getString(1);
            String phoneName=c.getString(2);
            String phoneProducer=c.getString(3);
            int phonePrice=c.getInt(4);
            taskArrayList.add(new Task(ID,phoneID,phoneName,phoneProducer,phonePrice));

        }
        taskAdapter.notifyDataSetChanged();
    }

}
