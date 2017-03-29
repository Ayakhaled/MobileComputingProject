package com.example.aya.mobilecomputingproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Landing extends AppCompatActivity{
    private Button login;
    private Button register;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        login = (Button) findViewById(R.id.login_btn);
        register = (Button) findViewById(R.id.register_btn);

        sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
        boolean loggedIn = sharedPreferences.getBoolean("LoggedIn", false);
        if (loggedIn){
            startActivity(new Intent(Landing.this, Home.class));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, Register.class);
                startActivity(intent);
            }
        });
    }

}
