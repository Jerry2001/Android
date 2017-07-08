package com.example.jerry2001.contentproviderdemo;

import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class show_contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        showall();
    }
    public void showall(){
        Uri U = Uri.parse("content://contacts/people");
        ArrayList<String> ls = new ArrayList<String>();
        CursorLoader loader = new CursorLoader(this, U, null, null, null, null);
        Cursor c1 = loader.loadInBackground();
        c1.moveToFirst();
        while (c1.isAfterLast() == false){
            String s = "";
            String idName = ContactsContract.Contacts._ID;
            int idIndex = c1.getColumnIndex(idName);
            s= c1.getString(idIndex) + " - ";
            String nameCol = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = c1.getColumnIndex(nameCol);
            s+= c1.getString(nameIndex);
            c1.moveToNext();
            ls.add(s);
        }
        c1.close();
        ListView lv=(ListView) findViewById(R.id.ls);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls);
        lv.setAdapter(adapter);
    }
}
