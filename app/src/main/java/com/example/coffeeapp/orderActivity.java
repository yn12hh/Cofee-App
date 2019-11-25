package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

//import android.widget.Toast;

public class orderActivity extends AppCompatActivity {
    private ImageView selected_coffee;
    private String selected_milk = "No milk";
    private ImageView selected_sugar;
    private ImageView selected_size;
    private Button make_order_button;

    private String type_string;
    private String size_string = "Small";
    private String sugar_string = "No";
    private int temp_int;


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
        make_order_button = (Button) findViewById(R.id.make_order);
        make_order_button.setEnabled(true);

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


    public void sugarChoice(View view) {
        sugarChoiceReset();
        selected_sugar = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case (R.id.no_sugar):
                selected_sugar.setImageResource(R.drawable.no_sugar_red);
                sugar_string = "no";
                break;
            case (R.id.one_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_1_color);
                sugar_string = "one";
                break;
            case (R.id.two_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_2_color);
                sugar_string = "two";
                break;
            case (R.id.three_sugar):
                selected_sugar.setImageResource(R.drawable.sugar_3_color);
                sugar_string = "three";
                break;
        }
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
    }

    public void sendOrder(View view) {
        Intent intent = new Intent(this, checkOut.class);
        intent.putExtra("type", type_string);
        intent.putExtra("milk", selected_milk);
        intent.putExtra("size", size_string);
        intent.putExtra("sugar", sugar_string);
        intent.putExtra("temp", temp_int);
        startActivity(intent);
    }
}
