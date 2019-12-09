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

        SharedPreferences user_info = getSharedPreferences("UserInfo", MODE_PRIVATE);

        userNickname.setText(user_info.getString("User Name", ""));
        userPhone.setText(user_info.getString("Phone Number", ""));
        userID.setText(user_info.getString("User ID", ""));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences user_info_on_pause = getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor infoEdit = user_info_on_pause.edit();
        infoEdit.putString("Phone Number", userPhone.getText().toString());
        infoEdit.putString("User ID", userID.getText().toString());
        infoEdit.putString("User Name", userNickname.getText().toString());
        infoEdit.putBoolean("Registered",!anyFiledNotFiled());
        infoEdit.apply();
    }


    public void finishRegestration (View view) {
        if(anyFiledNotFiled()) {
            Toast.makeText(this, "Please enter your info before placing an order", Toast.LENGTH_LONG).show();
        }
        else {
            finish();
        }
    }
    public boolean anyFiledNotFiled(){
        return userNickname.getText().toString().isEmpty() || userPhone.getText().toString().isEmpty() || userID.getText().toString().isEmpty();
    }

}

