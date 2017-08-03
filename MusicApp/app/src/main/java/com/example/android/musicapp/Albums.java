package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by abc on 17-06-2017.
 */

public class Albums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        TextView now_playing = (TextView)findViewById(R.id.now_playing);

        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nowplayingIntent= new Intent(Albums.this,NowPlaying.class);
                startActivity(nowplayingIntent);
            }
        }) ;


        TextView artists = (TextView)findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent=new Intent(Albums.this,Artists.class);
                startActivity(artistsIntent);
            }
        });

        TextView podcasts = (TextView)findViewById(R.id.podcasts);
        podcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podcastsIntent=new Intent(Albums.this,Podcasts.class);
                startActivity(podcastsIntent);
            }
        });

        TextView search = (TextView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(Albums.this,Search.class);
                startActivity(searchIntent);
            }
        });

        TextView store = (TextView)findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeIntent=new Intent(Albums.this,Store.class);
                startActivity(storeIntent);
            }
        });


    }
}
