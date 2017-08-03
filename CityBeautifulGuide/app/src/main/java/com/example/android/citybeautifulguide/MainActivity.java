package com.example.android.citybeautifulguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView adventure = (TextView) findViewById(R.id.adventure);

        adventure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent adventureIntent = new Intent(MainActivity.this, Adventure.class);

                startActivity(adventureIntent);
            }
        });


        TextView gardens = (TextView) findViewById(R.id.gardens);

       gardens.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent gardensIntent = new Intent(MainActivity.this, Gardens.class);

                startActivity(gardensIntent);
            }
        });


        TextView museums = (TextView) findViewById(R.id.museums);

        museums.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent museumsIntent = new Intent(MainActivity.this, Museums.class);

                startActivity(museumsIntent);
            }
        });


        TextView restaurants = (TextView) findViewById(R.id.restaurants);

        restaurants.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent restaurantsIntent = new Intent(MainActivity.this, Restaurants.class);

                startActivity(restaurantsIntent);
            }
        });


        TextView temples = (TextView) findViewById(R.id.temples);

        temples.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent templesIntent = new Intent(MainActivity.this, Temples.class);

                startActivity(templesIntent);
            }
        });
    }
}
