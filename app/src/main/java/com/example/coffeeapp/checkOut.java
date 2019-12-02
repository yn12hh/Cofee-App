package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class checkOut extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent intent = getIntent();

        TextView type = findViewById(R.id.user_type);
        TextView size = findViewById(R.id.user_size);
        TextView milk = findViewById(R.id.user_milk);
        TextView sugar = findViewById(R.id.user_sugar);
        TextView temp = findViewById(R.id.user_temp);
        type.setText(intent.getStringExtra("type"));
        size.setText(intent.getStringExtra("size"));
        milk.setText(intent.getStringExtra("milk"));
        sugar.setText(intent.getStringExtra("sugar"));
        temp.setText(intent.getStringExtra("temp"));
    }
    public void finishOrder(View view) {
        Intent intent = new Intent(this, endScreen.class);
        startActivity(intent);
    }

}
