package com.example.contentproviderexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.model.Contact;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayAdapter<Contact> contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        loadContacts();
        addEvents();
    }

    private void addEvents() {
        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contactAdapter.getItem(position);
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + contact.getPhone());
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
    }

    private void loadContacts() {
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        contactAdapter.clear();
        assert cursor!=null;
        while (cursor.moveToNext()){
            //Get Name
            int nameIndex=cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name=cursor.getString(nameIndex);
            //Get Phone Number
            int phoneIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String phone=cursor.getString(phoneIndex);

            Contact contact=new Contact(name,phone);
            contactAdapter.add(contact);

        }
    }

    private void addViews() {
        lvDanhBa=findViewById(R.id.lvDanhBa);
        contactAdapter=new ArrayAdapter<Contact>(MainActivity.this,android.R.layout.simple_list_item_1);
        lvDanhBa.setAdapter(contactAdapter);
    }
}
