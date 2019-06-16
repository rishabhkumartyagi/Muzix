package com.projects.rishabhkumartyagi.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView im1,im2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       im1 = (ImageView) findViewById(R.id.imageView3);
        im1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your code here
                Intent goToSongs = new Intent(getApplicationContext(), Songs.class);
                startActivity(goToSongs);
            }
        });

        im2 = (ImageView) findViewById(R.id.imageView4);
        im2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your code here
                Intent goToRecom = new Intent(getApplicationContext(), SongRec.class);
                startActivity(goToRecom);
            }
        });



    }
}
