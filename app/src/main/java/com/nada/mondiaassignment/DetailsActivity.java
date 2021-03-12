package com.nada.mondiaassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.nada.mondiaassignment.SearchActivity.EXTRA_ARTIST;
import static com.nada.mondiaassignment.SearchActivity.EXTRA_TITLE;
import static com.nada.mondiaassignment.SearchActivity.EXTRA_TYPE;

public class DetailsActivity extends AppCompatActivity {

    private TextView songTitle;
    private TextView songArtist;
    private TextView songType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        String artist = intent.getStringExtra(EXTRA_ARTIST);
        String type = intent.getStringExtra(EXTRA_TYPE);

        songTitle = (TextView) findViewById(R.id.songTitle);
        songArtist = (TextView) findViewById(R.id.artist);
        songType = (TextView) findViewById(R.id.songType);

        songTitle.setText(title);
        songArtist.setText(artist);
        songType.setText(type);

    }

}
