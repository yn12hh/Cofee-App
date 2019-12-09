package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
public static final int TEXT_REQUEST = 1;
public static final int REG_REQUEST = 2;
private TextView welcome;
private String welcomeString;
private SharedPreferences user_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_info = getSharedPreferences("UserInfo", MODE_PRIVATE);
        updateWelcomeMessage();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateWelcomeMessage();
    }

    public void updateWelcomeMessage(){
        welcome = (TextView) findViewById(R.id.welcome_name);
        welcomeString = "Welcome";
        if(user_info.getBoolean("Registered", false))
            welcomeString += " back";
        welcomeString += ",\n" + user_info.getString("User Name", "New User");
        welcome.setText(welcomeString);
    }

    public void usualOrder(View view) {
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
    public void registerFunction() {
        Intent intent = new Intent(this, registration.class);
        startActivity(intent);
    }
}
