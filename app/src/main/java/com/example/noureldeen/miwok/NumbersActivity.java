package com.example.noureldeen.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    final String LOG_TAG = NumbersActivity.class.getName();
    ArrayList<word> words;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer.stop();
                releaseMediaPlayer();
            } else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        }
    };
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
            int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request permanent focus.
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(i).getSoundResourceID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
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
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        words = new ArrayList<word>();
        words.add(new word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new word("Two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new word("Four", "oyyiisa", R.drawable.number_four, R.raw.number_four));
        words.add(new word("Five", "massoka", R.drawable.number_five, R.raw.number_five));
        words.add(new word("Six", "temmoka", R.drawable.number_six, R.raw.number_six));
        words.add(new word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        wordAdapter itemsAdapter = new wordAdapter(this, words, R.color.category_numbers);

        ListView numberListView = (ListView) findViewById(R.id.numbers_list_view);

        numberListView.setAdapter(itemsAdapter);
        numberListView.setOnItemClickListener(onItemClickListener);
    }

    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


}
