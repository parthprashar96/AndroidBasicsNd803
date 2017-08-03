package com.example.android.bookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.searchButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                EditText edittext = (EditText) findViewById(R.id.search);
                String book = edittext.getText().toString();
                Intent intent = new Intent(getBaseContext(), BookActivity.class);
                intent.putExtra("Query",book);
                startActivity(intent);

            }
        } );

    }
}