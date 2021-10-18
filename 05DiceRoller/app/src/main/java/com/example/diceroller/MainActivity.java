package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    TextView textView1, textView2;
    Button button;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        textView1 = findViewById(R.id.t1);
        textView2 = findViewById(R.id.t2);
        button = findViewById(R.id.button);

//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rollDice();
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice1();
                rollDice2();
            }
        });
    }

    private void rollDice2() {
        int myRandomNumber = random.nextInt(6) + 1;
        switch (myRandomNumber) {
            case 1:
                imageView2.setImageResource(R.drawable.dice1);
                textView2.setText("Its a " + myRandomNumber);
                break;

            case 2:
                imageView2.setImageResource(R.drawable.dice2);
                textView2.setText("Its a " + myRandomNumber);
                break;

            case 3:
                imageView2.setImageResource(R.drawable.dice3);
                textView2.setText("Its a " + myRandomNumber);
                break;

            case 4:
                imageView2.setImageResource(R.drawable.dice4);
                textView2.setText("Its a " + myRandomNumber);
                break;

            case 5:
                imageView2.setImageResource(R.drawable.dice5);
                textView2.setText("Its a " + myRandomNumber);
                break;

            case 6:
                imageView2.setImageResource(R.drawable.dice6);
                textView2.setText("Its a " + myRandomNumber);

        }
    }

    private void rollDice1() {
        int myRandomNumber = random.nextInt(6) + 1;
        switch (myRandomNumber){
            case 1: imageView1.setImageResource(R.drawable.dice1);
                    textView1.setText("Its a "+myRandomNumber);
                break;

            case 2: imageView1.setImageResource(R.drawable.dice2);
                textView1.setText("Its a "+myRandomNumber);
                break;

            case 3: imageView1.setImageResource(R.drawable.dice3);
                textView1.setText("Its a "+myRandomNumber);
                break;

            case 4: imageView1.setImageResource(R.drawable.dice4);
                textView1.setText("Its a "+myRandomNumber);
                break;

            case 5: imageView1.setImageResource(R.drawable.dice5);
                textView1.setText("Its a "+myRandomNumber);
                break;

            case 6: imageView1.setImageResource(R.drawable.dice6);
                textView1.setText("Its a "+myRandomNumber);

        }
    }
}