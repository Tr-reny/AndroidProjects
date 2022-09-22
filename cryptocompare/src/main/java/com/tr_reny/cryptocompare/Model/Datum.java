package com.tr_reny.cryptocompare.Model;


import com.google.gson.annotations.SerializedName;

public class Datum {

    public String id;
    public String guid;
    public Integer publishedOn;
    public String imageurl;
    public String title;
    public String url;
    @SerializedName("source")
    public String msource;
    public String body;
    public String tags;
    public String categories;
    public String upvotes;
    public String downvotes;
    public String lang;
    public SourceInfo sourceInfo;

    //constructor


    public Datum(String id, String guid, Integer publishedOn, String imageurl, String title, String url, String msource, String body, String tags, String categories, String upvotes, String downvotes, String lang, SourceInfo sourceInfo) {
        this.id = id;
        this.guid = guid;
        this.publishedOn = publishedOn;
        this.imageurl = imageurl;
        this.title = title;
        this.url = url;
        this.msource = msource;
        this.body = body;
        this.tags = tags;
        this.categories = categories;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.lang = lang;
        this.sourceInfo = sourceInfo;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public Integer getPublishedOn() {
        return publishedOn;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getMsource() {
        return msource;
    }

    public String getBody() {
        return body;
    }

    public String getTags() {
        return tags;
    }

    public String getCategories() {
        return categories;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public String getDownvotes() {
        return downvotes;
    }

    public String getLang() {
        return lang;
    }

    public SourceInfo getSourceInfo() {
        return sourceInfo;
    }
}