package com.example.android.drumpadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.android.drumpadapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MediaPlayer m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12;

    //To release resources
    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        m1 = MediaPlayer.create(this,R.raw.one);
        m2 = MediaPlayer.create(this,R.raw.two);
        m3 = MediaPlayer.create(this,R.raw.three);
        m4 = MediaPlayer.create(this,R.raw.four);
        m5 = MediaPlayer.create(this,R.raw.fv);
        m6 = MediaPlayer.create(this,R.raw.sixth);
        m7 = MediaPlayer.create(this,R.raw.seventh);
        m8 = MediaPlayer.create(this,R.raw.eighth);
        m9 = MediaPlayer.create(this,R.raw.fv);
        m10 = MediaPlayer.create(this,R.raw.two);
        m11 = MediaPlayer.create(this,R.raw.sixth);
        m12 = MediaPlayer.create(this,R.raw.one);
    }

    public void submit(View v){
            switch (v.getId()){
                    case R.id.imageButton1:
                        m1.start();
                        break;

                    case R.id.imageButton2:
                        m2.start();
                        break;

                    case R.id.imageButton3:
                        m3.start();
                        break;

                    case R.id.imageButton4:
                        m4.start();
                        break;

                    case R.id.imageButton5:
                        m5.start();
                        break;

                    case R.id.imageButton6:
                        m6.start();
                        break;

                    case R.id.imageButton7:
                        m7.start();
                        break;

                    case R.id.imageButton8:
                        m8.start();
                        break;

                    case R.id.imageButton9:
                        m9.start();
                        break;

                    case R.id.imageButton10:
                        m10.start();
                        break;

                    case R.id.imageButton11:
                        m11.start();
                        break;

                    case R.id.imageButton12:
                        m12.start();
                        break;


            }
    }
}