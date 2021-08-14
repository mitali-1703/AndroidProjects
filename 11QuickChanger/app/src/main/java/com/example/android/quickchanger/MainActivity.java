package com.example.android.quickchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.layout);
        radioGroup = findViewById(R.id.rGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.blue: constraintLayout.setBackgroundColor(Color.parseColor("#1B98F5"));
                    break;

                    case R.id.red: constraintLayout.setBackgroundColor(Color.parseColor("#E21717"));
                        break;

                    case R.id.green: constraintLayout.setBackgroundColor(Color.parseColor("#3DBE29"));
                        break;
                }
            }
        });
    }
}