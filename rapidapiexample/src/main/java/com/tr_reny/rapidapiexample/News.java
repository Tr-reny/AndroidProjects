package com.tr_reny.rapidapiexample;

import com.google.gson.annotations.SerializedName;

public class News {
    public String title;
    public String url;
    @SerializedName("source")
    public String msource;

    //getters

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getMsource() {
        return msource;
    }
}

