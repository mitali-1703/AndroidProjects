package com.example.android.firebaselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.email);
        editText2 = findViewById(R.id.password);
        button = findViewById(R.id.register);

        String emailValidate = editText1.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+";
        if(emailValidate.matches(emailPattern)){
            editText1.setText(emailValidate);
        }
        else{
            editText1.setError("Invalid email address!!");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}