package com.example.android.textrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button backButton;
    TextView resultTextView;
    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backButton = findViewById(R.id.back_button);
        resultTextView = findViewById(R.id.result_textview);

        //Getting text recognized by TextDetection's RESULT_TEXT into ResultActivity using intent
        resultText = getIntent().getStringExtra(TextDetection.RESULT_TEXT);

        resultTextView.setText(resultText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}