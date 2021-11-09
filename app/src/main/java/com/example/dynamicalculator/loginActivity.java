package com.example.dynamicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {
    Button loginbtn;
    EditText email;
    EditText password;
    Button signUpbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn=findViewById(R.id.Loginbtn);
        email=findViewById(R.id.emailId);
        password=findViewById(R.id.password_edit_text);
        signUpbtn=findViewById(R.id.SignUpbtn);
        //authentication code

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}