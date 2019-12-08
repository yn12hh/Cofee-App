package com.example.coffeeapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.AlertDialog;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;


public class checkOut extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TextView locationInput;
    private Button timeInput;
    private Date now =  new Date();
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final Calendar c = Calendar.getInstance();
    private int orderHour = c.get(Calendar.HOUR_OF_DAY);
    private int orderMinute = c.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Intent intent = getIntent();

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TextView type = findViewById(R.id.user_type);
        TextView size = findViewById(R.id.user_size);
        TextView milk = findViewById(R.id.user_milk);
        TextView sugar = findViewById(R.id.user_sugar);
        TextView temp = findViewById(R.id.user_intensity);
        type.setText(intent.getStringExtra("type"));
        size.setText(intent.getStringExtra("size"));
        milk.setText(intent.getStringExtra("milk"));
        sugar.setText(intent.getStringExtra("sugar"));
        temp.setText(intent.getStringExtra("intensity"));
        locationInput = findViewById(R.id.location_input);
        timeInput = findViewById(R.id.time_input);
        timeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });
        timeInput.setText("now - " + timeFormat.format(now) + " (tap to edit)");
    }
    public void finishOrder(View view) {
        Intent intent = new Intent(this, endScreen.class);
        intent.putExtra("location", locationInput.getText().toString());
        intent.putExtra("time", timeInput.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String orderTime = "";
        orderHour = hourOfDay;
        orderMinute = minute;
        if(orderHour < 10)
            orderTime += "0";
        orderTime += orderHour;
        orderTime += ":";
        if(orderMinute < 10)
            orderTime += "0";
        orderTime += orderMinute;
        timeInput.setText(orderTime);
    }
}
