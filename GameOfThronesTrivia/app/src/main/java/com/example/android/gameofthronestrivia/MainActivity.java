package com.example.android.gameofthronestrivia;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int totalScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {

        EditText text = (EditText) findViewById(R.id.name);
        String name = text.getText().toString();

        if (name.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }

        CheckBox Q1_cb1 = (CheckBox) findViewById(R.id.Q1_c1);
        boolean Q1_cb1_checked = Q1_cb1.isChecked();

        CheckBox Q1_cb2 = (CheckBox) findViewById(R.id.Q1_c2);
        boolean Q1_cb2_checked = Q1_cb2.isChecked();

        CheckBox Q1_cb3 = (CheckBox) findViewById(R.id.Q1_c3);
        boolean Q1_cb3_checked = Q1_cb3.isChecked();

        CheckBox Q1_cb4 = (CheckBox) findViewById(R.id.Q1_c4);
        boolean Q1_cb4_checked = Q1_cb4.isChecked();

        CheckBox Q2_cb1 = (CheckBox) findViewById(R.id.Q2_c1);
        boolean Q2_cb1_checked = Q2_cb1.isChecked();

        CheckBox Q2_cb2 = (CheckBox) findViewById(R.id.Q2_c2);
        boolean Q2_cb2_checked = Q2_cb2.isChecked();

        CheckBox Q2_cb3 = (CheckBox) findViewById(R.id.Q2_c3);
        boolean Q2_cb3_checked = Q2_cb3.isChecked();

        CheckBox Q2_cb4 = (CheckBox) findViewById(R.id.Q2_c4);
        boolean Q2_cb4_checked = Q2_cb4.isChecked();



        RadioButton Q3_r1 = (RadioButton) findViewById(R.id.Q3_r1);
        boolean Q3_r1_checked = Q3_r1.isChecked();

        RadioButton Q3_r2 = (RadioButton) findViewById(R.id.Q3_r2);
        boolean Q3_r2_checked = Q3_r2.isChecked();

        RadioButton Q3_r3 = (RadioButton) findViewById(R.id.Q3_r3);
        boolean Q3_r3_checked = Q3_r3.isChecked();

        RadioButton Q3_r4 = (RadioButton) findViewById(R.id.Q3_r4);
        boolean Q3_r4_checked = Q3_r4.isChecked();


        RadioButton Q4_r1 = (RadioButton) findViewById(R.id.Q4_r1);
        boolean Q4_r1_checked = Q4_r1.isChecked();

        RadioButton Q4_r2 = (RadioButton) findViewById(R.id.Q4_r2);
        boolean Q4_r2_checked = Q4_r2.isChecked();

        RadioButton Q4_r3 = (RadioButton) findViewById(R.id.Q4_r3);
        boolean Q4_r3_checked = Q4_r3.isChecked();

        RadioButton Q4_r4 = (RadioButton) findViewById(R.id.Q4_r4);
        boolean Q4_r4_checked = Q4_r4.isChecked();


        RadioButton Q5_r1 = (RadioButton) findViewById(R.id.Q5_r1);
        boolean Q5_r1_checked = Q5_r1.isChecked();

        RadioButton Q5_r2 = (RadioButton) findViewById(R.id.Q5_r2);
        boolean Q5_r2_checked = Q5_r2.isChecked();

        RadioButton Q5_r3 = (RadioButton) findViewById(R.id.Q5_r3);
        boolean Q5_r3_checked = Q5_r3.isChecked();

        RadioButton Q5_r4 = (RadioButton) findViewById(R.id.Q5_r4);
        boolean Q5_r4_checked = Q5_r4.isChecked();


        RadioButton Q6_r1 = (RadioButton) findViewById(R.id.Q6_r1);
        boolean Q6_r1_checked = Q6_r1.isChecked();

        RadioButton Q6_r2 = (RadioButton) findViewById(R.id.Q6_r2);
        boolean Q6_r2_checked = Q6_r2.isChecked();

        RadioButton Q6_r3 = (RadioButton) findViewById(R.id.Q6_r3);
        boolean Q6_r3_checked = Q6_r3.isChecked();

        RadioButton Q6_r4 = (RadioButton) findViewById(R.id.Q6_r4);
        boolean Q6_r4_checked = Q6_r4.isChecked();


        EditText textAnswer = (EditText) findViewById(R.id.Q7);
        String nameMatch = textAnswer.getText().toString();



        int counter = calculateResult(Q1_cb1_checked, Q1_cb2_checked, Q1_cb3_checked, Q1_cb4_checked,
                Q2_cb1_checked, Q2_cb2_checked, Q2_cb3_checked, Q2_cb4_checked,
                Q3_r1_checked, Q3_r2_checked,Q3_r3_checked, Q3_r4_checked,
                Q4_r1_checked, Q4_r2_checked, Q4_r3_checked,Q4_r4_checked,
                Q5_r1_checked, Q5_r2_checked,Q5_r3_checked, Q5_r4_checked,
                Q6_r1_checked, Q6_r2_checked,Q6_r3_checked, Q6_r4_checked,
                nameMatch);
        Toast.makeText(this, name + " your Score: " + counter, Toast.LENGTH_LONG).show();

        totalScore = 0;

    }

    private int calculateResult(boolean Q1_cb1, boolean Q1_cb2, boolean Q1_cb3, boolean Q1_cb4,
                                boolean Q2_cb1, boolean Q2_cb2, boolean Q2_cb3, boolean Q2_cb4,
                                boolean Q3_r1, boolean Q3_r2,  boolean Q3_r3, boolean Q3_r4,
                                boolean Q4_r1, boolean Q4_r2, boolean Q4_r3, boolean Q4_r4,
                                boolean Q5_r1, boolean Q5_r2, boolean Q5_r3,  boolean Q5_r4,
                                boolean Q6_r1, boolean Q6_r2, boolean Q6_r3,  boolean Q6_r4,
                                String nameMatch) {

        if (nameMatch.equalsIgnoreCase("Emilia Clarke")) {
            totalScore += 10;
        } else {
            totalScore -= 5;
        }

        if(Q1_cb1 && !Q1_cb2 && Q1_cb3 && !Q1_cb4 ){
            totalScore+=10;
        }
        else {
            totalScore-=5;
        }

        if(!Q2_cb1 && Q2_cb2 && !Q2_cb3 && Q2_cb4 ){
            totalScore+=10;
        }
        else {
            totalScore-=5;
        }

        if (Q3_r4) {
            totalScore += 10;
        } else {
            totalScore -= 5;
        }

        if (Q4_r2) {
            totalScore += 10;
        } else {
            totalScore -= 5;
        }

        if (Q5_r3) {
            totalScore += 10;
        } else {
            totalScore -= 5;
        }

        if (Q6_r1) {
            totalScore += 10;
        } else {
            totalScore -= 5;
        }


        return totalScore;
    }


}
