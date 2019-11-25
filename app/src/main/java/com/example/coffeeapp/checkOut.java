package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class checkOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent intent = getIntent();
        String full_order = intent.getStringExtra("size") + " " +
                intent.getStringExtra("type") + " with " +
                intent.getStringExtra("milk") + ", " +
                intent.getStringExtra("sugar") + " tbs of suger. At the temp of **";
        TextView textView = findViewById(R.id.text_order);
        textView.setText(full_order);
    }

}
