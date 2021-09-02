package com.example.android.fireusersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText userName, name,email;
    Button button;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = db.getReference();
    DatabaseReference myRef = rootRef.child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUsername = userName.getText().toString().trim();
                if(myUsername.isEmpty()){
                    userName.setError("Please enter a username");
                    return;
                }
                String myName = name.getText().toString().trim();
                if(myName.isEmpty()){
                    name.setError("Please enter a name");
                    return;
                }
                String myEmail = email.getText().toString().trim();
                if(myEmail.isEmpty()){
                    email.setError("Please enter a email");
                    return;
                }

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("Username",myUsername);
                hashMap.put("Name",myName);
                hashMap.put("Email",myEmail);

                //THIS WILL REWRITE THE PREVIOUS USER EVERYTIME WE CREATE A NEW ONE AS WE HAVE A SINGLE REFERENCE OF DATABASE
//                myRef.child("01").setValue(hashMap);

                /* EFFICIENT WAY */
                /*THIS CREATES A NEW OBJECT WITH A UNIQUE KEY EVERYTIME AND SO THE PREVIOUS OBJECT DOESN'T GET OVERWRITTEN*/
                myRef.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "SUCCESS!!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "FAILED!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}