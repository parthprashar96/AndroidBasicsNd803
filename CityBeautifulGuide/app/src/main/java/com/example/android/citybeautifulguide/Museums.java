package com.example.android.citybeautifulguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abc on 24-06-2017.
 */

public class Museums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m1)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m2)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m3)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m4)));
        locations.add(new Location(getString(R.string.mohali),getString(R.string.m5)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m6)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m7)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m8)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m9)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.m10)));

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.museums);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


    }
}