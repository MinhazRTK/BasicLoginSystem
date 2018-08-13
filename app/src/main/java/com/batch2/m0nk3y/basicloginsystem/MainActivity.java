package com.batch2.m0nk3y.basicloginsystem;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText id = findViewById(R.id.username);
        final EditText pass = findViewById(R.id.pass);
        Button btn = findViewById(R.id.btn);
        final TextView forgot = findViewById(R.id.forgot_pass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = id.getText().toString();
                String password = pass.getText().toString();

                if(username.equals("m0nk3y") && password.equals("admin")){
                    Intent i = new Intent(MainActivity.this,LoggedIn.class);
                    startActivity(i);
                }
                else {
                    AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                    a.setTitle("Error!");
                    a.setMessage("Wrong Credentials!");
                    a.show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(i);
            }
        });
    }
}
