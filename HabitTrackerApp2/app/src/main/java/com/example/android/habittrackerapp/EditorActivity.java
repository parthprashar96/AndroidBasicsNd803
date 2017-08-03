package com.example.android.habittrackerapp;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.android.habittrackerapp.data.HabitContract;
import com.example.android.habittrackerapp.data.HabitDbHelper;


public class EditorActivity extends AppCompatActivity{
    private EditText mNameEditText;
    private Spinner mGenderSpinner;
    private EditText mHabitNameEditText;
    private int mGender = HabitContract.HabitEntry.GENDER_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mNameEditText = (EditText) findViewById(R.id.edit_personName);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);
        mHabitNameEditText = (EditText) findViewById(R.id.edit_habitName);

        setupSpinner();
    }
    private void setupSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = HabitContract.HabitEntry.GENDER_MALE;
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = HabitContract.HabitEntry.GENDER_FEMALE;
                    } else {
                        mGender = HabitContract.HabitEntry.GENDER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = HabitContract.HabitEntry.GENDER_UNKNOWN;
            }
        });
    }
    private void insertHabit() {
        String nameString = mNameEditText.getText().toString().trim();
        String habitString = mHabitNameEditText.getText().toString().trim();

        HabitDbHelper mDbHelper = new HabitDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_PERSONNAME, nameString);
        values.put(HabitContract.HabitEntry.COLUMN_PERSONGENDER, mGender);
        values.put(HabitContract.HabitEntry.COLUMN_HABITNAME, habitString);
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertHabit();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}