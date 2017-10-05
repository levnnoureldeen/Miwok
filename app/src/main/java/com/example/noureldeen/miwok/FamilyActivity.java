package com.example.noureldeen.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    ArrayList<family> family;
    final String LOG_TAG = FamilyActivity.class.getName();
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
            mediaPlayer = MediaPlayer.create(FamilyActivity.this, family.get(i).getSoundResourceID());
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
        setContentView(R.layout.activity_family);
        family = new ArrayList<family>();
        family.add(new family("father","әpә",R.drawable.family_father,R.raw.family_father));
        family.add(new family("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        family.add(new family("son","angsi",R.drawable.family_son,R.raw.family_son));
        family.add(new family("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new family("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new family("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new family("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new family("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new family("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new family("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        familyAdapter itemsAdapter = new familyAdapter(this, family , R.color.category_family);

        ListView familyListView = (ListView) findViewById(R.id.family_list_view);

        familyListView.setAdapter(itemsAdapter);

       familyListView.setOnItemClickListener(onItemClickListener);

    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
