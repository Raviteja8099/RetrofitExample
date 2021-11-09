package com.example.dynamicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed((Runnable) () -> {
            Intent i = new Intent(Splashscreen.this,loginActivity.class);
            startActivity(i);
            finish();
        },5000);
    }
}