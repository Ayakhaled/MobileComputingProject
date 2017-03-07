package com.example.aya.mobilecomputingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().matches(""))
                    Toast.makeText(Register.this, "Please enter your name", Toast.LENGTH_LONG).show();

                else if (username.getText().toString().matches(""))
                    Toast.makeText(Register.this, "Please enter your username", Toast.LENGTH_LONG).show();

                else if (email.getText().toString().matches(""))
                    Toast.makeText(Register.this, "Please enter your email", Toast.LENGTH_LONG).show();

                else if (password.getText().toString().matches(""))
                    Toast.makeText(Register.this, "Please enter your password", Toast.LENGTH_LONG).show();

                else{
                    Intent intent = new Intent(Register.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }

}
