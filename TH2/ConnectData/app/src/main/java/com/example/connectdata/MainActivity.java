package com.example.connectdata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLClientInfoException;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME="product_db.db";
    public  static final String DB_PATH_SUFFIX="/databases/";
    public static SQLiteDatabase sqLiteDatabase=null;

    ListView lvProduct;
    ArrayAdapter<Product> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyDataBase();
        addView();
        loadDataFromDB();
    }

    private void loadDataFromDB() {
        sqLiteDatabase=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
       // Cursor cursor=sq LiteDatabase.rawQuery("SELECT*FROM Product WHERE ProductId=? OR ProductId=?",new String[]{"2","4"});
        Cursor cursor=sqLiteDatabase.query("Product",null,
                "ProductId=? Or ProductId=?",new String[]{"1","2"},
                null,null,null);
        arrayAdapter.clear();
        int productId;
        String productName;
        double productPrice;
        while (cursor.moveToNext()){
            productId=cursor.getInt(0);
            productName=cursor.getString(1);
            productPrice=cursor.getDouble(2);
            Product p=new Product(productId,productName,productPrice+"");
            arrayAdapter.add(p);
        }
        cursor.close();
    }

    private void addView() {
        lvProduct=findViewById(R.id.lvProduct);
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(arrayAdapter);

    }

    private void copyDataBase(){
        try{
            File dbFile=getDatabasePath(DATABASE_NAME);
            if(!dbFile.exists()){
                if(CopyDBFromAsset()){
                    Toast.makeText(this, "Copy database successful", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Copy database fail!", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e){
            Log.e("Error",e.toString());
        }
    }
    private boolean CopyDBFromAsset(){
        String dbPath=getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;
        try{
            InputStream inputStream=getAssets().open(DATABASE_NAME);
            File f=new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream=new FileOutputStream(dbPath);
            byte[] buffer=new byte[1024];
            int length;
            while((length=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return  true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
