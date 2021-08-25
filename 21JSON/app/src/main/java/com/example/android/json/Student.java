package com.example.android.json;

import com.google.gson.annotations.SerializedName;

public class Student {
    String name, email;
    @SerializedName("course_count")
    int courseCount;

    public Student(String name, String email, int course_count) {
        this.name = name;
        this.email = email;
        this.courseCount = course_count;
    }
}
