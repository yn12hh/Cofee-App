package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

//import android.widget.Toast;

public class orderActivity extends AppCompatActivity {
    private ImageView selected_coffee;
    private String selected_milk = "No milk";
    private ImageView selected_sugar;
    private ImageView selected_size;
    private Button make_order_button;
    private ImageView selected_intensity;
    private TextView set_title;
    private String type_string = "No Choice";
    private String size_string = "Small";
    private String sugar_string = "No";
    private String intensity_string = "Regular";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
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

    public void sugarChoiceReset() {
        selected_sugar = (ImageView) findViewById(R.id.no_sugar);
        selected_sugar.setImageResource(R.drawable.no_sugar_bw);
        selected_sugar = (ImageView) findViewById(R.id.one_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_1_bw);
        selected_sugar = (ImageView) findViewById(R.id.two_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_2_bw);
        selected_sugar = (ImageView) findViewById(R.id.three_sugar);
        selected_sugar.setImageResource(R.drawable.sugar_3_bw);
    }

    public void intesityChoiseReset() {
        selected_sugar = (ImageView) findViewById(R.id.decaff);
        selected_sugar.setImageResource(R.drawable.no_sugar_bw);
        selected_sugar = (ImageView) findViewById(R.id.one_caff);
        selected_sugar.setImageResource(R.drawable.coffee_strength_1_bw);
        selected_sugar = (ImageView) findViewById(R.id.two_caff);
        selected_sugar.setImageResource(R.drawable.coffee_strength_2_bw);
        selected_sugar = (ImageView) findViewById(R.id.three_caff);
        selected_sugar.setImageResource(R.drawable.coffee_strength_3_bw);
    }

    public void sugarChoice(View view) {
        sugarChoiceReset();
        selected_sugar = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.no_sugar):
                selected_sugar.setImageResource(R.drawable.no_sugar_red);
                sugar_string = "No";
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


    public void milkRadioChoice(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.no_milk_radio:
                if (checked)
                    selected_milk = "No Milk";
                break;
            case R.id.soy_milk_radio:
                if (checked)
                    selected_milk = "Soy Milk";
                break;
            case R.id.cow_milk_radio:
                if (checked)
                    selected_milk = "Cow Milk";
                break;
            case R.id.almond_milk_radio:
                if (checked)
                    selected_milk = "Almonds Milk";
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
            Toast.makeText(this, "Order Sent!", Toast.LENGTH_LONG).show();
        }
        }


    public void intensityChoice(View view) {
        intesityChoiseReset();
        selected_intensity = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.decaff):
                selected_intensity.setImageResource(R.drawable.no_sugar_red);
                intensity_string = "Decaff";
                break;
            case (R.id.one_caff):
                selected_intensity.setImageResource(R.drawable.coffee_strength_1_color);
                intensity_string = "Regular";
                break;
            case (R.id.two_caff):
                selected_intensity.setImageResource(R.drawable.coffee_strength_2_color);
                intensity_string = "Double";
                break;
            case (R.id.three_caff):
                selected_intensity.setImageResource(R.drawable.coffee_strength_3_color);
                intensity_string = "Triple";
                break;
        }
        set_title = findViewById(R.id.intesity_title);
        set_title.setText("Intensity: " + intensity_string);
    }
}
