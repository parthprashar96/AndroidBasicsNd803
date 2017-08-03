package com.example.android.citybeautifulguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abc on 24-06-2017.
 */

public class Temples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.panchkula),getString(R.string.t1)));
        locations.add(new Location(getString(R.string.panchkula),getString(R.string.t2)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t3)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t4)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t5)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t6)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t7)));
        locations.add(new Location(getString(R.string.panchkula),getString(R.string.t8)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t9)));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.t10)));

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.temples);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}