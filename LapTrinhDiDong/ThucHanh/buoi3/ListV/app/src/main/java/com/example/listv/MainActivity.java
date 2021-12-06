package com.example.listv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listv.adapter.CustomAdapter;
import com.example.listv.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contact> arrayList = new ArrayList<>();
        lvContact = (ListView) findViewById(R.id.lv_Contact);
        Contact contact5 = new Contact("van","Vancutequa");
        Contact contact1 = new Contact("ablum1","luonquanthai");
        Contact contact2 = new Contact("ablum2","Ktuanmongmo");
        Contact contact3 = new Contact("ablum3","Kpop");
        Contact contact4 = new Contact("ablum4","Kpop");

        arrayList.add(contact5);
        arrayList.add(contact1);
        arrayList.add(contact2);
        arrayList.add(contact3);
        arrayList.add(contact4);

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.list, arrayList);
        lvContact.setAdapter(customAdapter);

    }
}