package com.example.BTTH;

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

import java.util.ArrayList;

import com.example.adapter.TaskAdapter;
import com.example.model.Task;
import com.example.BTTH.R;

public class MainActivity extends AppCompatActivity {

    ListView lv_task;
    Database database;
    ArrayList<Task> taskArrayList;
    TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        PrepareDB();
        GetData();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAddTask){
            openDialogAddPhones();
        }
        return super.onOptionsItemSelected(item);
    }

    private void GetData() {
        Cursor c= database.GetData("SELECT * FROM Phones");
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

    private void PrepareDB() {
        database = new Database(this, "phones_db.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Phones(ID Integer PRIMARY KEY AUTOINCREMENT, PhoneID VARCHAR(20)," +
                "PhoneName VARCHAR(100)" +
                ",PhoneProducer VARCHAR(100),PhonePrice INTEGER)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P01','Galaxy S10','Samsung',1300000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P02','iPhone 11 Pro Max','Apple',2950000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P03','Active 1','Vsmart',3700000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P04','Lumia 950 XL','Nokia',8700000)");
        database.QueryData("INSERT INTO Phones VALUES(null,'P05','M3','Sony',6700000)");
    }

    private void addView() {
        lv_task=findViewById(R.id.lv_task);
        taskArrayList =new ArrayList<>();
        taskAdapter =new TaskAdapter(this,R.layout.row, taskArrayList);
        lv_task.setAdapter(taskAdapter);
    }
    public void openDialogAddPhones() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.activity_add);
        dialog.setCanceledOnTouchOutside(false);

        final EditText addPhoneName=dialog.findViewById(R.id.txt_adName);
        final EditText addPhoneID=dialog.findViewById(R.id.txt_adID);
        final EditText addPhoneProducer=dialog.findViewById(R.id.txt_adProducer);
        final EditText addPhonePrice=dialog.findViewById(R.id.txt_adPrice);

        Button btn_ok=dialog.findViewById(R.id.bnt_okAdd);
        Button btn_cancel=dialog.findViewById(R.id.btn_cancel);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=addPhoneName.getText().toString();
                String ID=addPhoneID.getText().toString();
                String Producer=addPhoneProducer.getText().toString();
                String Price=(addPhonePrice.getText().toString());
                if(name.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Phone Name !",Toast.LENGTH_LONG).show();
                }
                else if(ID.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Phone ID !",Toast.LENGTH_LONG).show();
                }
                else if(Producer.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Phone Producer !",Toast.LENGTH_LONG).show();
                }
                else if(Price.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Phone Price !",Toast.LENGTH_LONG).show();
                }
                else {
                     int price=Integer.parseInt(Price);
                    database.QueryData("INSERT INTO Phones VALUES(null,'"+ ID+"','"+ name+"','"+ Producer+"',"+price+")");
                    Toast.makeText(MainActivity.this,"Added Phone successful !",Toast.LENGTH_LONG).show();
                    GetData();
                    dialog.dismiss();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void OpenDialogEditTask(final  int ID,String PhoneName,String PhoneID,String PhoneProducer,int PhonePrice)
    {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.activity_edit);
        dialog.setCanceledOnTouchOutside(false);

        final EditText editPhoneName=dialog.findViewById(R.id.txt_edName);
        final EditText editPhoneID=dialog.findViewById(R.id.txt_edID);
        final EditText editPhoneProducer=dialog.findViewById(R.id.txt_edProducer);
        final EditText editPhonePrice=dialog.findViewById(R.id.txt_edPrice);

        Button btn_ok=dialog.findViewById(R.id.bnt_edEdit);
        Button btn_cancel=dialog.findViewById(R.id.btn_edcancel);

        editPhoneID.setText(PhoneID);
        editPhoneName.setText(PhoneName);
        editPhoneProducer.setText(PhoneProducer);
        editPhonePrice.setText(String.valueOf(PhonePrice));
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=editPhoneID.getText().toString();
                String name=editPhoneName.getText().toString();
                String producer=editPhoneProducer.getText().toString();
                int price=Integer.parseInt(editPhonePrice.getText().toString());

                if(name.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Name !",Toast.LENGTH_LONG).show();
                }
                else if(id.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter ID !",Toast.LENGTH_LONG).show();
                }
                else if(producer.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter Producer !",Toast.LENGTH_LONG).show();
                }
                else if(price<0)
                {
                    Toast.makeText(MainActivity.this,"Please enter Price !",Toast.LENGTH_LONG).show();
                }
                else {
                    database.QueryData("UPDATE Phones SET PhoneName='"+name+"', PhoneID='"+id+"',PhoneProducer='"+producer+"',PhonePrice="+price+" WHERE ID="+ID);
                    Toast.makeText(MainActivity.this,"EDITED Phone successful!",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    GetData();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void deletePhone(final  int PhoneID,String PhoneName){
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setMessage("Are you sure you want to delete: "+PhoneName+" ?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM Phones WHERE ID="+PhoneID);
                Toast.makeText(MainActivity.this,"DELETED successful !",Toast.LENGTH_LONG).show();
                GetData();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }



}
