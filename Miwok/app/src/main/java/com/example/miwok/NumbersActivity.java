package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer audioplayer = new MediaPlayer();

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||
                            focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        audioplayer.pause();
                        audioplayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        audioplayer.start();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("one", "lutti",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("one", "lutti",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("one", "lutti",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("one", "lutti",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("one", "lutti",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("one", "lutti",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("one", "lutti",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("one", "lutti", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("one", "lutti",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    audioplayer = MediaPlayer.create(NumbersActivity.this, word.geAudioResourceID());
                    audioplayer.start();
                    audioplayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (audioplayer != null) {
            audioplayer.release();
            audioplayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
