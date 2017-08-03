package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView now_playing = (TextView)findViewById(R.id.now_playing);

        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nowplayingIntent= new Intent(MainActivity.this,NowPlaying.class);
                startActivity(nowplayingIntent);
            }
        }) ;

        TextView albums = (TextView)findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsIntent=new Intent(MainActivity.this,Albums.class);
                startActivity(albumsIntent);
            }
        });

        TextView artists = (TextView)findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent=new Intent(MainActivity.this,Artists.class);
                startActivity(artistsIntent);
            }
        });

        TextView podcasts = (TextView)findViewById(R.id.podcasts);
        podcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podcastsIntent=new Intent(MainActivity.this,Podcasts.class);
                startActivity(podcastsIntent);
            }
        });

        TextView search = (TextView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(MainActivity.this,Search.class);
                startActivity(searchIntent);
            }
        });

        TextView store = (TextView)findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storeIntent=new Intent(MainActivity.this,Store.class);
                startActivity(storeIntent);
            }
        });


    }
}
