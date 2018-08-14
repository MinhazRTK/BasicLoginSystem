package com.batch2.m0nk3y.basicloginsystem;

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
        final String[] mylist = {"Wake up","Brushing","Breakfast","Go to University","Take Lunch","Finish Lab","Return Home"};

        //ListAdapter myListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mylist);
        ListAdapter myListAdapter = new CustomAdapter(this,mylist);
        ListView listView = findViewById(R.id.mylist);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mylist = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(LoggedIn.this, mylist, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
