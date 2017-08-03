package com.example.android.habittrackerapp;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        mDbHelper = new HabitDbHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    public Cursor readAllHabits() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_PERSONNAME,
                HabitEntry.COLUMN_PERSONGENDER,
                HabitEntry.COLUMN_HABITNAME
        };
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }

    private void displayDatabaseInfo() {
        Cursor cursor = readAllHabits();
        TextView displayView = (TextView) findViewById(R.id.text_view_pet);
        try {
            displayView.setText("The Habit table contains " + cursor.getCount() + " habits.\n\n");
            displayView.append(HabitEntry._ID + " - " +
                    HabitEntry.COLUMN_PERSONNAME + " - " +
                    HabitEntry.COLUMN_PERSONGENDER + " - " +
                    HabitEntry.COLUMN_HABITNAME + "\n");

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int personNameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_PERSONNAME);
            int personGenderColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_PERSONGENDER);
            int habitNameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABITNAME);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentPersonName = cursor.getString(personNameColumnIndex);
                int currentGender = cursor.getInt(personGenderColumnIndex);
                String currentHabitName = cursor.getString(habitNameColumnIndex);
                displayView.append(("\n" + currentID + " - " +
                        currentPersonName + " - " +
                        currentGender + " - " +
                        currentHabitName));
            }
        } finally {
            cursor.close();
        }


    }
}