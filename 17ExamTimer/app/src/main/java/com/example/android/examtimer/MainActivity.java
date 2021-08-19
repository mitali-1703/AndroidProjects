package com.example.android.examtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer m;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m = MediaPlayer.create(this,R.raw.three);
        textView1 = findViewById(R.id.number);
        textView2 = findViewById(R.id.done);

        //To set Countdown Timer
        new CountDownTimer(15000,2000){

            @Override
            public void onTick(long millisUntilFinished) {
                textView1.setText("Time: "+String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                textView2.setText("Done !!");
                m.start();
            }
        }.start();
    }
}