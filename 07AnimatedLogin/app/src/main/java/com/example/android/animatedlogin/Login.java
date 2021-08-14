package com.example.android.animatedlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1  = findViewById(R.id.ET1);
        editText2  = findViewById(R.id.ET2);
    }

    public void submit(View view) {
        String email = editText1.getText().toString().trim();
        String password = editText2.getText().toString().trim();

        if(email.isEmpty() ){
            editText1.setError("This field can't be empty");
            return;
        }
        if(password.isEmpty() ){
            editText2.setError("This field can't be empty");
            return;
        }
        Intent intent = new Intent(this,Status.class);

        //Sending data using Intent
        intent.putExtra("email",email);
        intent.putExtra("password",password);

        startActivity(intent);
    }
}