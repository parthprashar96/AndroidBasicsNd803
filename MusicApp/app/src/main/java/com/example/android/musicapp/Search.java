package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by abc on 17-06-2017.
 */

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView now_playing = (TextView)findViewById(R.id.now_playing);

        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nowplayingIntent= new Intent(Search.this,NowPlaying.class);
                startActivity(nowplayingIntent);
            }
        }) ;


        TextView albums = (TextView)findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsIntent=new Intent(Search.this,Albums.class);
                startActivity(albumsIntent);
            }
        });

        TextView artists = (TextView)findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent=new Intent(Search.this,Artists.class);
                startActivity(artistsIntent);
            }
        });

        TextView podcasts = (TextView)findViewById(R.id.podcasts);
        podcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podcastsIntent=new Intent(Search.this,Podcasts.class);
                startActivity(podcastsIntent);
            }
        });


        TextView store = (TextView)findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeIntent=new Intent(Search.this,Store.class);
                startActivity(storeIntent);
            }
        });


    }
    }
