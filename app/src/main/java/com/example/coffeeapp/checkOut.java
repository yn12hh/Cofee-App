package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class checkOut extends AppCompatActivity {

    private TextView locationInput;
    private TextView timeInput;


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
        locationInput = findViewById(R.id.location_input);
        timeInput = findViewById(R.id.time_input);

        timeInput.setText(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" +Calendar.getInstance().get(Calendar.MINUTE));
    }
    public void finishOrder(View view) {
        Intent intent = new Intent(this, endScreen.class);
        intent.putExtra("location", locationInput.getText().toString());
        intent.putExtra("time", timeInput.getText().toString());
        startActivity(intent);
    }

}
