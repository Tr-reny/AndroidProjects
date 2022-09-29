package com.tr_reny.cryptocompare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("guid")
    @Expose
    public String guid;
    @SerializedName("published_on")
    @Expose
    public Integer publishedOn;
    @SerializedName("imageurl")
    @Expose
    public String imageurl;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("tags")
    @Expose
    public String tags;
    @SerializedName("categories")
    @Expose
    public String categories;
    @SerializedName("upvotes")
    @Expose
    public String upvotes;
    @SerializedName("downvotes")
    @Expose
    public String downvotes;
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("source_info")
    @Expose
    public SourceInfo sourceInfo;

}