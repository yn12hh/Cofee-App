package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class registration extends AppCompatActivity {

    private EditText userNickname;
    private EditText userPhone;
    private EditText userID;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userNickname = (EditText) findViewById(R.id.user_name);
        userPhone = (EditText) findViewById(R.id.user_phone_number);
        userID = (EditText) findViewById(R.id.user_employeeID);

    }
    public void finishRegestration (View view) {
        if(userNickname.getText().toString().isEmpty() || userPhone.getText().toString().isEmpty() || userID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your info before placing an order", Toast.LENGTH_LONG).show();
        }
        else {
            finish();
        }
    }

}

