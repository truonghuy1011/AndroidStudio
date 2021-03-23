package com.example.sqlitesach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.SachAdapter;
import com.example.model.Sach;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Databases databases;
    ListView lvSach;
    ArrayList sachArrayList;
    SachAdapter sachAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        PreparedData();
        getData();

    }

    private void getData() {
        Cursor cursor=databases.GetData("select * from Works");
        sachArrayList.clear();
        int sachId;
        String sachName;
        String sachNxb;
        Double sachPrice;
        while (cursor.moveToNext()){
            sachId=cursor.getInt(0);
            sachName=cursor.getString(1);
            sachNxb=cursor.getString(2);
            sachPrice=cursor.getDouble(3);
            sachArrayList.add(new Sach(sachId,sachName,sachNxb,sachPrice));
        }
        sachAdapter.notifyDataSetChanged();
    }

    private void PreparedData() {
        databases =new Databases(this,"note_db.sqlite",null,1);

        databases.QueryData("CREATE TABLE IF NOT EXISTS Works (Idsach INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " "+" sachName VARCHAR(200)"+"\" sachNXB VARCHAR(200)"+"\" sachPrices DOUBLE");

        databases.QueryData("insert into Works values (null, 'Ban muon lam vua','Kim Dong','3000')");
        databases.QueryData("insert into Works values (null, 'Cach lam giau','NXB Tre','4000')");
        databases.QueryData("insert into Works values (null, 'Chung khoan','NXB Gia','5000')");
        databases.QueryData("insert into Works values (null, 'Marketing','Thanh Nien','6000')");

    }

    private void addViews() {
        lvSach=findViewById(R.id.lvSach);
        sachArrayList=new ArrayList<>();
        sachAdapter=new SachAdapter(this,R.layout.item_row,sachArrayList);
        lvSach.setAdapter(sachAdapter);
    }
    private void openDialog(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtSachName=dialog.findViewById(R.id.edtSachEdit);
        final EditText edtSachNXB=dialog.findViewById(R.id.edtNXBEdit);
        final EditText edtSachPrices=dialog.findViewById(R.id.edtPriceEdit);

        Button btnOK=dialog.findViewById(R.id.btnOK);
        Button btnCancel=dialog.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sachName=edtSachName.getText().toString();
                String sachNXB=edtSachNXB.getText().toString();
                Double sachPrices= Double.valueOf(edtSachPrices.getText().toString());
                if(sachName.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter sach name", Toast.LENGTH_SHORT).show();
                }else{
                    databases.QueryData("insert into Works values (null, '\+sachName+\',,'\+sachNXB+\',,'\+Prices+\')");
                    Toast.makeText(MainActivity.this, "Added sach successful", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getData();
                }
            }
        });
    }
}
