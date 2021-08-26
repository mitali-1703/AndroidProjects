package com.example.android.json;

import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("name")
    String mName;
    @SerializedName("duration")
    int mDuration;

    public Video(String mName, int mDuration) {
        this.mName = mName;
        this.mDuration = mDuration;
    }
}
