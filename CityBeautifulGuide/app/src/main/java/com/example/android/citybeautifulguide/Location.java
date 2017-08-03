package com.example.android.citybeautifulguide;

/**
 * Created by abc on 23-06-2017.
 */

public class Location {
    private String mLocationAddress;
    private String mLocation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

        public Location(String locationAddress, String location) {
            mLocationAddress = locationAddress;
            mLocation = location;
        }

        public Location(String locationAddress, String location, int imageResourceId) {
            mLocationAddress  = locationAddress;
            mLocation = location;
            mImageResourceId = imageResourceId;
        }
        public String getLocationAddress() {
            return mLocationAddress;
        }
        public String getLocation() {
            return mLocation;
        }

        public int getImageResourceId() {
            return mImageResourceId;
        }

        public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }
    }
