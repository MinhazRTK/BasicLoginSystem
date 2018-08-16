package com.batch2.m0nk3y.basicloginsystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.batch2.m0nk3y.basicloginsystem.R;

public class CustomAdapter extends ArrayAdapter {

    public CustomAdapter(@NonNull Context context, String[] mylist) {
        super(context, R.layout.custom_row,mylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_row,parent,false);

        String mylist  = (String) getItem(position);
        TextView textView = customView.findViewById(R.id.adaptertext);
        ImageView imageView = customView.findViewById(R.id.adapterimage);
        textView.setText(mylist);


//        String mylist1  = (String) getItem(position);
//        TextView textView1 = customView.findViewById(R.id.secondtext);
//        textView1.setText(mylist1);



        imageView.setImageResource(R.drawable.m0nk3y);
        return customView;
    }
}
