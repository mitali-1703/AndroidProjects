package com.example.android.truthdaregame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

    }

    public void spin(View view) {
        int newDirection = random.nextInt(3600)+360;
        float pivotX = imageView.getWidth()/2;
        float pivotY = imageView.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(2000);
        //Keeps the image static after its been rotated
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
//                button.setBackgroundColor(Color.parseColor("#CAD5E2"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
//                button.setBackgroundColor(Color.parseColor("#0A77DB"));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //So that the image doesn't reset itself to what it was when we first rotated it
        lastDirection = newDirection;

        imageView.startAnimation(rotate);
    }
}