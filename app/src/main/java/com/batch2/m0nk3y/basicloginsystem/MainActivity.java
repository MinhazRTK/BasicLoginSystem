package com.batch2.m0nk3y.basicloginsystem;

import android.content.DialogInterface;
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

                if (username.equals("admin") && password.equals("admin")) {
                    Intent i = new Intent(MainActivity.this, LoggedIn.class);
                    startActivity(i);
                } else {
                    AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                    a.setTitle("Log In");
                    a.setMessage("Username and Password Do Not Match!");
                    a.setCancelable(true);
                    a.setNegativeButton("Try Again!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = a.create();
                    alertDialog.show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ealert = new AlertDialog.Builder(MainActivity.this);
        ealert.setTitle("Exit Application");
        ealert.setMessage("Are you sure want to close the application?");
        ealert.setCancelable(true);
        ealert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        ealert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = ealert.create();
        alertDialog.show();
    }
}
