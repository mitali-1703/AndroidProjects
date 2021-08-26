package com.example.android.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    String name, email;
    int courseCount;
    @SerializedName("course_count")
    Course course;
    List<Video> video;

    public Student(String name, String email, int courseCount, Course course, List<Video> video) {
        this.name = name;
        this.email = email;
        this.courseCount = courseCount;
        this.course = course;
        this.video = video;
    }
}
