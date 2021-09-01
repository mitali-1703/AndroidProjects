package com.example.android.rockpaperscissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.rockpaperscissors.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef = db.getReference();
    DatabaseReference gameRef = myRef.child("game");

    @Override
    protected void onStart() {
        super.onStart();

        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //Getting value from Realtime Database and setting it onto textview
                String text = snapshot.getValue().toString();
                b.tv.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("TAG","Something went wrong!!");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

//        myRef.setValue("hello");
//        myRef.child("User1").setValue("Mitali");
//        myRef.child("Users").child("01").child("Name").setValue("Mits");
//        myRef.child("Users").child("01").child("Age").setValue("21");

        gameRef.setValue("cool");
    }

    public void Scissors(View view) {
        gameRef.setValue("SCISSORS");
    }

    public void Paper(View view) {
        gameRef.setValue("PAPER");
    }

    public void Rock(View view) {
        gameRef.setValue("ROCK");
    }
}