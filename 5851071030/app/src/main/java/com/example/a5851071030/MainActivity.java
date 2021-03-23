package com.example.a5851071030;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.Adapter.TaskAdapter;
import com.example.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_Task;
    Database database;
    ArrayList<Task>taskArrayList;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        PrepareDB();
        GetData();
    }

    private void addViews() {

    }

    private void PrepareDB() {
        database=new Database(this,"phones_db.splite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Phones(ID Integer PRIMARY KEY AUTOINCREMENT,PhoneID VARCHAR(20),PhoneName VARCHAR(100))"+",PhoneProducer VARCHAR(100),PhonePrice INTEGER");
        database.QueryData("INSERT INTO Phones VALUES(null,'P01','S20','Samsung',120000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P02','S30','Samsing',130000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P03','S40','Samsong',140000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P05','S50','Samseng',150000)");
    }

    private void GetData() {
        Cursor c=database.GetData("SELECT*FROM Phones");
        taskArrayList.clear();
        while(c.moveToNext()){
            int ID=c.getInt(0);
            String phoneID=c.getString(1);
            String phoneName=c.getString(2);
            String phoneProducer=c.getString(3);
            int phonePrice=c.getInt(4);
            taskArrayList.add(new Task(ID,phoneID,phoneName,phoneProducer,phonePrice));
        }
        taskAdapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add,menu);
        return super.onCreteOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.mnAddTask){
            openDialogAddPhones();
        }
        return super.onOptionsItemSelected(item);
    }

    public Object getSystemService(String layoutInflaterService) {
    }
}
