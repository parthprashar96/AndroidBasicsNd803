package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by abc on 17-06-2017.
 */

public class Podcasts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcasts);

        TextView now_playing = (TextView)findViewById(R.id.now_playing);

        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nowplayingIntent= new Intent(Podcasts.this,NowPlaying.class);
                startActivity(nowplayingIntent);
            }
        }) ;


        TextView albums = (TextView)findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsIntent=new Intent(Podcasts.this,Albums.class);
                startActivity(albumsIntent);
            }
        });

        TextView artists = (TextView)findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent=new Intent(Podcasts.this,Artists.class);
                startActivity(artistsIntent);
            }
        });



        TextView search = (TextView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(Podcasts.this,Search.class);
                startActivity(searchIntent);
            }
        });

        TextView store = (TextView)findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeIntent=new Intent(Podcasts.this,Store.class);
                startActivity(storeIntent);
            }
        });


    }
    }
