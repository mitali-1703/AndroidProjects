package com.example.android.burgerrating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.text);
    }

    public void submit(View view) {
        float ratingValue = ratingBar.getRating();
        if (ratingValue<2){
            textView.setText("Rating: "+ratingValue+"\n"+"We will try improving it next time!");
            }
        else if (ratingValue>=2 && ratingValue<=3){
            textView.setText("Rating: "+ratingValue+"\n"+"We will surely improve it!");
        }
        else if (ratingValue>3 && ratingValue<=4){
            textView.setText("Rating: "+ratingValue+"\n"+"We will give our best next time!");
        }
        else if (ratingValue>4 && ratingValue<=5){
            textView.setText("Rating: "+ratingValue+"\n"+"Good to know you liked our service!");
        }
    }
}