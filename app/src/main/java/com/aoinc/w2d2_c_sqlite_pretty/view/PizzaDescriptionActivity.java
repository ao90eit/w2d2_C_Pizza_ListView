package com.aoinc.w2d2_c_sqlite_pretty.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.w2d2_c_sqlite_pretty.R;
import com.bumptech.glide.Glide;

public class PizzaDescriptionActivity extends AppCompatActivity {

    private ImageView pizzaImage;
    private TextView pizzaFlavor;
    private TextView pizzaIngredients;
    private TextView pizzaCalories;
    private TextView pizzaPrice;
    private TextView pizzaImageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_description);

        pizzaImage = findViewById(R.id.pizza_page_imageView);
        pizzaFlavor = findViewById(R.id.pizza_page_title_textView);
        pizzaIngredients = findViewById(R.id.pizza_page_ingredients_textView);
        pizzaCalories = findViewById(R.id.pizza_page_calories_textView);
        pizzaPrice = findViewById(R.id.pizza_page_price_textView);
        pizzaImageURL = findViewById(R.id.pizza_page_url_textView);

        Intent thisIntent = getIntent();
        pizzaImageURL.setText(thisIntent.getStringExtra("imageURL"));
        Glide.with(this).load(pizzaImageURL.getText().toString()).into(pizzaImage);

        pizzaFlavor.setText(thisIntent.getStringExtra("flavor"));
        String ingredients = "Ingredients:\n\n-- " + thisIntent.getStringExtra("ingredients").replace(", ", "\n -- ");

        Resources res = getResources();
        pizzaIngredients.setText(String.format(res.getString(R.string.ingredients_list),
                thisIntent.getStringExtra("ingredients").replace(", ", "\n-- ")));

        pizzaCalories.setText(String.format(res.getString(R.string.calories_text),
                thisIntent.getIntExtra("calories", -1)));

        pizzaPrice.setText(String.format(res.getString(R.string.price_text),
                thisIntent.getDoubleExtra("price", -1)));
    }
}
