package com.tr_reny.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Reny Kipkoech on 31/07/2022 20:00 hours EAT
 * This is a retrofit example that only shows the the functionality of retrofit
 * the app uses only simple coding
 */


public class Post {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

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
