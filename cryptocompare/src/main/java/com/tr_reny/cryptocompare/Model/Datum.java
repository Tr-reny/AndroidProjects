package com.tr_reny.cryptocompare.Model;

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


//constructor
    public Datum(String id, String guid, Integer publishedOn, String imageurl, String title, String url, String source, String body, String tags, String categories, String upvotes, String downvotes, String lang, SourceInfo sourceInfo) {
        this.id = id;
        this.guid = guid;
        this.publishedOn = publishedOn;
        this.imageurl = imageurl;
        this.title = title;
        this.url = url;
        this.source = source;
        this.body = body;
        this.tags = tags;
        this.categories = categories;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.lang = lang;
        this.sourceInfo = sourceInfo;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Integer publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(String downvotes) {
        this.downvotes = downvotes;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public SourceInfo getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(SourceInfo sourceInfo) {
        this.sourceInfo = sourceInfo;
    }
}