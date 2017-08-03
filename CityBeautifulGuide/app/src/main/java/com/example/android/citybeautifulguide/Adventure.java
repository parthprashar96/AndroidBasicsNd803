package com.example.android.citybeautifulguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abc on 24-06-2017.
 */

public class Adventure  extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
                setContentView(R.layout.location_list);

                ArrayList<Location> locations = new ArrayList<Location>();

                locations.add(new Location(getString(R.string.chandigarh), getString(R.string.ad_1)));
                locations.add(new Location(getString(R.string.chandigarh), getString(R.string.ad_2)));
                locations.add(new Location(getString(R.string.chandigarh), getString(R.string.ad_3)));
                locations.add(new Location(getString(R.string.panchkula), getString(R.string.ad_4)));
                locations.add(new Location(getString(R.string.chandigarh), getString(R.string.ad_5)));
                locations.add(new Location(getString(R.string.mohali),getString(R.string.ad_6)));
                locations.add(new Location(getString(R.string.mohali), getString(R.string.ad_7)));
                locations.add(new Location(getString(R.string.mohali),getString(R.string.ad_8)));
                locations.add(new Location(getString(R.string.chandigarh),getString(R.string.ad_9)));
                locations.add(new Location(getString(R.string.chandigarh),getString(R.string.ad_10)));

                LocationAdapter adapter = new LocationAdapter(this, locations, R.color.adventure);
                ListView listView = (ListView) findViewById(R.id.list);

                listView.setAdapter(adapter);
        }
}