package com.example.android.animatedlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Status extends AppCompatActivity {

    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        textView3 = findViewById(R.id.tv3);

        String str1 = getIntent().getStringExtra("name");
        if(str1==null){
            textView1.setVisibility(View.GONE);
        }

        textView1.setText("The entered name is: "+str1);

        String str2 = getIntent().getStringExtra("email");
        textView2.setText("The entered email is: "+str2);

        String str3 = getIntent().getStringExtra("password");
        textView3.setText("The entered password is: "+str3);

    }
}