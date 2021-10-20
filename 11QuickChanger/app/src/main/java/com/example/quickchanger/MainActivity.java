package com.example.quickchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.layout);
        radioGroup = findViewById(R.id.rGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.blue:
                        relativeLayout.setBackgroundColor(Color.parseColor("blue"));
                        break;
                    case R.id.green:
                        relativeLayout.setBackgroundColor(Color.parseColor("green"));
                        break;
                    case R.id.red:
                        relativeLayout.setBackgroundColor(Color.parseColor("red"));
                        break;
                }
            }
        });
    }
}