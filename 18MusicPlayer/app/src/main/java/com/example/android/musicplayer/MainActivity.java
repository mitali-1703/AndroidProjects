package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    
    // AudioManager provides access to volume and ringer mode control.
    AudioManager audioManager;

    public void playMe(View v){
        mediaPlayer.start();
    }
    public void pauseMe(View v){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.testaudio);

        //Get context from audio service
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //Set context to Seekbar - volumeRocker
        SeekBar volumeRocker = findViewById(R.id.seekBar);
        volumeRocker.setMax(maxVolume);
        volumeRocker.setProgress(currentVolume);

        //Set a listener on volumeRocker
        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Timeline part of MusicApp
        SeekBar timeLine = findViewById(R.id.timeline);
        timeLine.setMax(mediaPlayer.getDuration());

        timeLine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                
                //seekTo is for wherever I push the seekbar just go on there
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Customize the timeline seekbar
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                //Setting the progress of timeline seekbar for every sec w/o any delay
                // to the current position of mediaPlayer
                timeLine.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);
    }
}
