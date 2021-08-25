package com.example.android.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
//        Student student = new Student("Mitali","mitaliagrawal4321@gmail.com",5);
//        String json = gson.toJson(student);

        String json = "{\"course_count\":5,\"email\":\"mitaliagrawal4321@gmail.com\",\"name\":\"Mitali\"}";
        Student student = gson.fromJson(json,Student.class) ;
        Log.d("TEST",student.toString());
    }
}