package com.batch2.m0nk3y.basicloginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LoggedIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        final String[] mylist = {"http://google.com", "http://yahoo.com", "http://facebook.com", "http://gmail.com", "http://ymail.com", "http://outlook.com", "http://twitter.com"};
        //final String[] mylist1 = {"7am","7:10am","7:15am","7:30am","7:50am","1pm","5pm"};


        //ListAdapter myListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);

        ListAdapter myListAdapter = new CustomAdapter(this, mylist);
        ListView listView = findViewById(R.id.mylist);
        listView.setAdapter(myListAdapter);

//        ListAdapter myListAdapter2 = new CustomAdapter(this,mylist1);
//        ListView listView2 = findViewById(R.id.secondtext);
//        listView.setAdapter(myListAdapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mylist = String.valueOf(adapterView.getItemAtPosition(i));
                //Toast.makeText(LoggedIn.this, mylist, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoggedIn.this, WebActivity.class);
                intent.putExtra("WEB_URL", mylist);
                startActivity(intent);
            }
        });
    }
}
