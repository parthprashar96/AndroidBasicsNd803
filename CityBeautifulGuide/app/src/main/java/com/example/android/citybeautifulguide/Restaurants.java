package com.example.android.citybeautifulguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abc on 24-06-2017.
 */

public class Restaurants extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r1)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r2)));
        locations.add(new Location(getString(R.string.panchkula),getString(R.string.r3)));
        locations.add(new Location(getString(R.string.panchkula),getString(R.string.r4)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r5)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r6)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r7)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r8)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r9)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.r10)));

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
 }