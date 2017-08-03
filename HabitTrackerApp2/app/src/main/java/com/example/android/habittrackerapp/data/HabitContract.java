package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;


public class HabitContract {
    private HabitContract()
    {
        //An empty private constructor makes sure that the class is not going to be initialised.
    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habit";
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_PERSONNAME = "name";
        public final static String COLUMN_PERSONGENDER = "gender";
        public final static String COLUMN_HABITNAME = "habit";


        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }

}