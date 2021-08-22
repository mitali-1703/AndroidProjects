package com.example.android.recyclercards;

public class ItemsList {
    private int mImageResource;
    private String mText;

    public ItemsList(int mImageResource, String mText) {
        this.mImageResource = mImageResource;
        this.mText = mText;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
