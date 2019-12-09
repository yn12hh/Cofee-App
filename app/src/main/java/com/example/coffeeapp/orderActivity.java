package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

//import android.widget.Toast;

public class orderActivity extends AppCompatActivity {
    private ImageView selected_coffee;
    private String selected_milk;
    private ImageView selected_sugar;
    private ImageView selected_size;
    private Button make_order_button;
    private ImageView selected_intensity;
    private TextView set_title;
    private String type_string;
    private String size_string;
    private String sugar_string;
    private String intensity_string;
    private ImageView selected_milk_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        loadMilkChoice();
        loadCoffeeType();
        loadCoffeeSize();
        loadSugarChoice();
        loadIntensityChoice();
    }

    private void loadIntensityChoice() {
        SharedPreferences shared_intensity = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        intensity_string = shared_intensity.getString("INTENSITY", "Regular");
        switch (intensity_string) {
            case ("Decaff"):
                intensityChoice(findViewById(R.id.decaff));
                break;
            case ("Regular"):
                intensityChoice(findViewById(R.id.one_caff));
                break;
            case ("Double"):
                intensityChoice(findViewById(R.id.two_caff));
                break;
        }
    }

    private void loadSugarChoice() {
        SharedPreferences shared_sugar = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        sugar_string = shared_sugar.getString("SUGAR", "No Sugar");
        switch (sugar_string) {
            case ("No Sugar"):
                sugarChoice(findViewById(R.id.no_sugar));
                break;
            case ("One"):
                sugarChoice(findViewById(R.id.one_sugar));
                break;
            case ("Two"):
                sugarChoice(findViewById(R.id.two_sugar));
                break;
            case ("Three"):
                sugarChoice(findViewById(R.id.three_sugar));
                break;
        }
    }

    private void loadCoffeeSize() {
        SharedPreferences shared_size = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        size_string = shared_size.getString("SIZE", "Small");
        switch (size_string) {
            case ("Small"):
                sizeChoice(findViewById(R.id.small_size));
                break;
            case ("Large"):
                sizeChoice(findViewById(R.id.large_size));
                break;
        }
    }

    private void loadCoffeeType() {
        SharedPreferences shared_type = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        type_string = shared_type.getString("TYPE", "No Choice");
        switch (type_string) {
            case ("Americano"):
                coffeeChoice(findViewById(R.id.amricano));
                break;
            case ("Cappuccino"):
                coffeeChoice(findViewById(R.id.cappuchino));
                break;
            case ("Espresso"):
                coffeeChoice(findViewById(R.id.essprersso));
                break;
            case ("Latte"):
                coffeeChoice(findViewById(R.id.latte));
                break;
        }

    }

    private void loadMilkChoice() {
        SharedPreferences shared_milk = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        selected_milk = shared_milk.getString("MILK", "No Milk");
        switch (selected_milk){
            case ("No Milk"):
                milkChoice(findViewById(R.id.no_milk));
                break;
            case ("Soy Milk"):
                milkChoice(findViewById(R.id.soy_milk));
                break;
            case ("Cow Milk"):
                milkChoice(findViewById(R.id.cow_milk));
                break;
            case ("Almond Milk"):
                milkChoice(findViewById(R.id.almonds_milk));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences Sharedonpause = getSharedPreferences("OrderInfo", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = Sharedonpause.edit();
        myEdit.putString("SIZE", size_string);
        myEdit.putString("MILK", selected_milk);
        myEdit.putString("TYPE", type_string);
        myEdit.putString("SUGAR", sugar_string);
        myEdit.putString("INTENSITY", intensity_string);
        myEdit.apply();
    }


    public void coffeeChoice(View view) {
        coffeeChoiceReset();
        selected_coffee = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.amricano):
                selected_coffee.setImageResource(R.drawable.amricano_color);
                type_string = "Americano";
                break;
            case (R.id.cappuchino):
                selected_coffee.setImageResource(R.drawable.cappuccino_color);
                type_string = "Cappuccino";
                break;
            case (R.id.essprersso):
                selected_coffee.setImageResource(R.drawable.esspres_color);
                type_string = "Espresso";
                break;
            case (R.id.latte):
                selected_coffee.setImageResource(R.drawable.latte_color);
                type_string = "Latte";
                break;
        }
        set_title = findViewById(R.id.coffee_type_title);
        set_title.setText("Type: " + type_string);
        make_order_button = (Button) findViewById(R.id.make_order);
        // make_order_button.setEnabled(true);
        make_order_button.setBackgroundResource(R.drawable.order_button_backround_color

        );
    }

    public void coffeeChoiceReset() {
        selected_coffee = (ImageView) findViewById(R.id.amricano);
        selected_coffee.setImageResource(R.drawable.amricano_bw);
        selected_coffee = (ImageView) findViewById(R.id.cappuchino);
        selected_coffee.setImageResource(R.drawable.cappuccino_bw);
        selected_coffee = (ImageView) findViewById(R.id.latte);
        selected_coffee.setImageResource(R.drawable.latte_bw);
        selected_coffee = (ImageView) findViewById(R.id.essprersso);
        selected_coffee.setImageResource(R.drawable.esspreso_bw);
    }

    public void coffeeSizeReset() {
        selected_size = (ImageView) findViewById(R.id.small_size);
        selected_size.setImageResource(R.drawable.size_s_bw);
        selected_size = (ImageView) findViewById(R.id.large_size);
        selected_size.setImageResource(R.drawable.size_l_bw);
    }
    public void milkChoiceReset() {
        selected_milk_img = (ImageView) findViewById(R.id.no_milk);
        selected_milk_img.setImageResource(R.drawable.no_bw);
        selected_milk_img = (ImageView) findViewById(R.id.cow_milk);
        selected_milk_img.setImageResource(R.drawable.regular_bw);
        selected_milk_img = (ImageView) findViewById(R.id.soy_milk);
        selected_milk_img.setImageResource(R.drawable.soy_bw);
        selected_milk_img = (ImageView) findViewById(R.id.almonds_milk);
        selected_milk_img.setImageResource(R.drawable.almond_bw);
    }
    public void sugarChoiceReset() {
        selected_sugar = (ImageView) findViewById(R.id.no_sugar);
        selected_sugar.setImageResource(R.drawable.no_bw);
        selected_sugar = (ImageView) findViewById(R.id.one_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_1_bw);
        selected_sugar = (ImageView) findViewById(R.id.two_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_2_bw);
        selected_sugar = (ImageView) findViewById(R.id.three_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_3_bw);
    }

    public void intensityChoiceReset() {
        selected_sugar = (ImageView) findViewById(R.id.decaff);
        selected_sugar.setImageResource(R.drawable.no_bw);
        selected_sugar = (ImageView) findViewById(R.id.one_caff);
        selected_sugar.setImageResource(R.drawable.regular_intesity_bw);
        selected_sugar = (ImageView) findViewById(R.id.two_caff);
        selected_sugar.setImageResource(R.drawable.double_intensity_bw);
    }

    public void sugarChoice(View view) {
        sugarChoiceReset();
        selected_sugar = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.no_sugar):
                selected_sugar.setImageResource(R.drawable.no_color);
                sugar_string = "No Sugar";
                break;
            case (R.id.one_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_1_color);
                sugar_string = "One";
                break;
            case (R.id.two_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_2_color);
                sugar_string = "Two";
                break;
            case (R.id.three_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_3_color);
                sugar_string = "Three";
                break;
        }
        set_title = findViewById(R.id.sugar_title);
        set_title.setText("Sugar: " + sugar_string);
    }


    public void milkChoice(View view) {
        milkChoiceReset();
        selected_milk_img = (ImageView) findViewById(view.getId());
        switch (view.getId()) {

            case (R.id.no_milk):
                selected_milk_img.setImageResource(R.drawable.no_color);
                selected_milk = "No Milk";
                break;
            case (R.id.soy_milk):
                selected_milk_img.setImageResource(R.drawable.soy_color);
                selected_milk = "Soy Milk";
                break;
            case (R.id.cow_milk):
                selected_milk_img.setImageResource(R.drawable.regular_color);
                selected_milk = "Cow Milk";
                break;
            case (R.id.almonds_milk):
                selected_milk_img.setImageResource(R.drawable.almond_color);
                selected_milk = "Almond Milk";
                break;
        }
        set_title = findViewById(R.id.milk_type_title);
        set_title.setText("Milk: " + selected_milk);
    }

    public void sizeChoice(View view) {
        coffeeSizeReset();
        selected_size = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.small_size):
                selected_size.setImageResource(R.drawable.small_color);
                size_string = "Small";
                break;
            case (R.id.large_size):
                selected_size.setImageResource(R.drawable.large_color);
                size_string = "Large";
                break;
        }
        set_title = findViewById(R.id.size_title);
        set_title.setText("Size: " + size_string);
    }

    public void sendOrder(View view) {
        if (type_string.equals("No Choice"))
            Toast.makeText(this, "Please select coffee type first", Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(this, checkOut.class);
            intent.putExtra("type", type_string);
            intent.putExtra("milk", selected_milk);
            intent.putExtra("size", size_string);
            intent.putExtra("sugar", sugar_string);
            intent.putExtra("intensity", intensity_string);
            startActivity(intent);
        }
    }


    public void intensityChoice(View view) {
        intensityChoiceReset();
        selected_intensity = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.decaff):
                selected_intensity.setImageResource(R.drawable.no_color);
                intensity_string = "Decaff";
                break;
            case (R.id.one_caff):
                selected_intensity.setImageResource(R.drawable.regular_intesity_color);
                intensity_string = "Regular";
                break;
            case (R.id.two_caff):
                selected_intensity.setImageResource(R.drawable.double_intensity_color);
                intensity_string = "Double";
                break;
        }
        set_title = findViewById(R.id.intesity_title);
        set_title.setText("Intensity: " + intensity_string);
    }
}