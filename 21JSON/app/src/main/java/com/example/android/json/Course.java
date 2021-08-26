package com.example.android.json;

import com.google.gson.annotations.SerializedName;

public class Course {
    @SerializedName("name")
    String mName;
    @SerializedName("description")
    String mDescription;

    public Course(String mName, String mDescription) {
        this.mName = mName;
        this.mDescription = mDescription;
    }
}
