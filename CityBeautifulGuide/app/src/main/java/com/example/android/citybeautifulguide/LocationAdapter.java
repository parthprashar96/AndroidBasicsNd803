package com.example.android.citybeautifulguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by abc on 23-06-2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    private int mColorResourceId;

        public LocationAdapter(Context context, ArrayList<Location> locations, int colorResourceId) {
            super(context, 0, locations);
            mColorResourceId = colorResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View locationItemView = convertView;
            if (locationItemView == null) {
                locationItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.location_item, parent, false);
            }

            Location currentLocation = getItem(position);

            TextView locationTextView = (TextView) locationItemView.findViewById(R.id.location_text_view);
            locationTextView.setText(currentLocation.getLocation());

            TextView defaultTextView = (TextView) locationItemView.findViewById(R.id.location_address_text_view);
            defaultTextView.setText(currentLocation.getLocationAddress());

            ImageView imageView = (ImageView) locationItemView.findViewById(R.id.image);

            if (currentLocation.hasImage()) {
                imageView.setImageResource(currentLocation.getImageResourceId());
                imageView.setVisibility(View.VISIBLE);
            }
            else {
                imageView.setVisibility(View.GONE);
            }

            View textContainer = locationItemView.findViewById(R.id.location_container);
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
                   textContainer.setBackgroundColor(color);

            return locationItemView;
    }
  }