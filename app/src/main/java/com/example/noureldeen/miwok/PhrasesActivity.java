package com.example.noureldeen.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    ArrayList<phrases> phrases;
    final String LOG_TAG = PhrasesActivity.class.getName();
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
            mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrases.get(i).getSoundResourceID());
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
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        phrases = new ArrayList<phrases>();
        phrases.add(new phrases("Where are you going?","minto wuksus" , R.raw.phrase_where_are_you_going));
        phrases.add(new phrases("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new phrases("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new phrases("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new phrases("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new phrases("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new phrases("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new phrases("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        phrases.add(new phrases("Come here.","әnni'nem", R.raw.phrase_come_here));

        phrasesAdapter itemsAdapter = new phrasesAdapter(this, phrases, R.color.category_phrases);

        ListView phrasesListView = (ListView) findViewById(R.id.phrases_list_view);

        phrasesListView.setAdapter(itemsAdapter);
        phrasesListView.setOnItemClickListener(onItemClickListener);
    }
}
