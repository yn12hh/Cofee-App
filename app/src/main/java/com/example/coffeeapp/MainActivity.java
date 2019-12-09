package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final int TEXT_REQUEST = 1;
public static final int REG_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void usualOrder(View view) { //this function is called when "take an order" button is pressed
        SharedPreferences user_info = getSharedPreferences("UserInfo", MODE_PRIVATE);
        if(user_info.getBoolean("Registered", false)) {
            Intent intent = new Intent(this, orderActivity.class);
            startActivityForResult(intent, TEXT_REQUEST);
        }
        else {
            Toast.makeText(this, "register first please", Toast.LENGTH_LONG).show();
            registerFunction();
        }
    }
    public void registerNow(View view) {
        registerFunction();
    }
    public void registerFunction() { //this function is called when "registration" button is pressed
        Intent intent = new Intent(this, registration.class);
        startActivity(intent);
    }
}
