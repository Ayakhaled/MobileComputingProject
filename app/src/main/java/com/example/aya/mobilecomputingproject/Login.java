package com.example.aya.mobilecomputingproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().matches("")){
                    Toast.makeText(Login.this, "Please enter your username", Toast.LENGTH_LONG).show();
                }
                else if (password.getText().toString().matches(""))
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_LONG).show();
                else{
                    sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("LoggedIn", true);
                    editor.commit();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            }
        });

    }

}
