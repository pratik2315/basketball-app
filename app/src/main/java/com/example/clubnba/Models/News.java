package com.example.clubnba.Models;

public class News {
    private String mTitle;
    private String mPoster;

    public News(String mTitle, String mPoster) {
        this.mTitle = mTitle;
        this.mPoster = mPoster;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }
}
