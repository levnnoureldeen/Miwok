package com.example.noureldeen.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    ArrayList<colors> colors;
    final String LOG_TAG = ColorsActivity.class.getName();
    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(ColorsActivity.this, colors.get(i).getSoundResource());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        }
    };
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        colors = new ArrayList<colors>();
        colors.add(new colors("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new colors("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new colors("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new colors("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new colors("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new colors("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new colors("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new colors("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colorsAdapter itemsAdapter = new colorsAdapter(this,colors, R.color.category_colors);
        ListView colorsListView = (ListView) findViewById(R.id.colors_list_view);
        colorsListView.setAdapter(itemsAdapter);
        colorsListView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
