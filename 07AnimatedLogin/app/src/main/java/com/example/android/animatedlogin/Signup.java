package com.example.android.animatedlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    EditText editText1,editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editText1 =findViewById(R.id.et1);
        editText2 =findViewById(R.id.et2);
        editText3 =findViewById(R.id.et3);
    }

    public void submit(View view) {
            String name = editText1.getText().toString().trim();
            String email = editText2.getText().toString().trim();
            String password = editText3.getText().toString().trim();

            if(name.isEmpty() ) {
                editText1.setError("This field can't be empty");
                return;
            }
            if(email.isEmpty() ){
                editText2.setError("This field can't be empty");
                return;
            }
            if(password.isEmpty() ){
                editText3.setError("This field can't be empty");
                return;
            }
            Intent intent = new Intent(this,Status.class);

            //Sending data using Bundle
            Bundle bundle = new Bundle();
            bundle.putString("name",name);
            bundle.putString("email",email);
            bundle.putString("password",password);

            intent.putExtras(bundle);
            startActivity(intent);

    }
}