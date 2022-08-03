package com.tr_reny.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Reny Kipkoech on 31/07/2022 20:00 hours EAT
 * This is a retrofit example that only shows the the functionality of retrofit
 * the app uses only simple coding
 */


public class Post {

    private int userId;

    private Integer id;

    private String title;

    @SerializedName("body")
    private String text;

    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
