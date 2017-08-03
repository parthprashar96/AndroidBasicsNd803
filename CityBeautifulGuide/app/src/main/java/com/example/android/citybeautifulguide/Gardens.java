
package com.example.android.citybeautifulguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abc on 24-06-2017.
 */


public class Gardens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.rock_garden),R.drawable.rock_garden));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.rose_garden),R.drawable.rose_garden));
        locations.add(new Location(getString(R.string.panchkula), getString(R.string.cactus_garden),R.drawable.cactus_garden));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.silence_garden),R.drawable.silence_garden));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.topiary_garden),R.drawable.topiary_park));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.japanese_garden),R.drawable.japanese_garden));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.botanical_garden),R.drawable.botanical_garden));
        locations.add(new Location(getString(R.string.chandigarh),getString(R.string.fragrance_garden),R.drawable.fragnance_garden));

        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.gardens);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
