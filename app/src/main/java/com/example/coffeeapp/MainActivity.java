package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public static final int TEXT_REQUEST = 1;
public static final int REG_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void usualOrder(View view) {
        Intent intent = new Intent(this, orderActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    public void registerNow(View view) {
        Intent intent = new Intent(this, registration.class);
        startActivity(intent);
    }
}
