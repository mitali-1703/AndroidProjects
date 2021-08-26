package com.example.android.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        // Only Student class

//        Student student = new Student("Mitali","mitaliagrawal4321@gmail.com",5);
//        String json = gson.toJson(student);
        //        Log.d("TEST",json);


//        String json = "{\"course_count\":5,\"email\":\"mitaliagrawal4321@gmail.com\",\"name\":\"Mitali\"}";
//        Student student = gson.fromJson(json,Student.class) ;
//        Log.d("TEST",student.toString());

        // Student + Course classes

//        Course course = new Course("JAVA","BOOTCAMP");
//        Student student = new Student("Mitali","helloji@17.com",4,course);
//        String json = gson.toJson(student);
//        Log.d("TEST",json);


//        String json = "{\"course\":{\"description\":\"BOOTCAMP\",\"name\":\"JAVA\"},\"course_count\":4,\"email\":\"helloji@17.com\",\"name\":\"Mitali\"}";
//        Student student = gson.fromJson(json,Student.class);
//        Log.d("TEST",student.toString());

        // Student + Course + Video classes

//        List<Video> videos = new ArrayList<>();
//        videos.add(new Video("Intro",8));
//        videos.add(new Video("Installation",10));
//        videos.add(new Video("Application",6));
//
//        Course course = new Course("JAVA","BOOTCAMP");
//        Student student = new Student("Minty","minty@1234.com",3,course,videos);
//        String json = gson.toJson(student);
//        Log.d("TESTING",json);


//        String json="{\"course\":{\"description\":\"BOOTCAMP\",\"name\":\"JAVA\"}," +
//                "\"course_count\":3,\"email\":\"minty@1234.com\",\"name\":\"Minty\"," +
//                "\"video\":[{\"duration\":8,\"name\":\"Intro\"}," +
//                "{\"duration\":10,\"name\":\"Installation\"}," +
//                "{\"duration\":6,\"name\":\"Application\"}]}\n";
//        Student student = gson.fromJson(json,Student.class);
//        Log.d("TESTING",student.toString());
    }
}