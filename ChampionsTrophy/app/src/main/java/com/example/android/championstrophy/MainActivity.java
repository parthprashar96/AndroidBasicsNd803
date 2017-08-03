package com.example.android.championstrophy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.championstrophy.R;

public class MainActivity extends AppCompatActivity {
    int scoreIND=0;
    int scorePAK=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  resetScore(View v){
        scoreIND=0;
        scorePAK=0;
        displayForIND(scoreIND);
        displayForPAK(scorePAK);


    }


    public void displayForIND(int scoreIND) {
        TextView scoreView = (TextView) findViewById(R.id.team_ind_score);
        scoreView.setText(String.valueOf(scoreIND));
    }
    public void SixForIND(View v){
        scoreIND=scoreIND+6;
        displayForIND(scoreIND);
    }

    public void FourForIND(View v){
        scoreIND=scoreIND+4;
        displayForIND(scoreIND);
    }

    public void SingleForIND(View v){
        scoreIND=scoreIND+1;
        displayForIND(scoreIND);
    }

    public void displayForPAK(int scorePAK) {
        TextView scoreView = (TextView) findViewById(R.id.team_pak_score);
        scoreView.setText(String.valueOf(scorePAK));
    }
    public void SixForPAK(View v){
        scorePAK=scorePAK+6;
        displayForPAK(scorePAK);
    }

    public void FourForPAK(View v){
        scorePAK=scorePAK+4;
        displayForPAK(scorePAK);
    }

    public void SingleForPAK(View v){
        scorePAK=scorePAK+1;
        displayForPAK(scorePAK);
    }

}
