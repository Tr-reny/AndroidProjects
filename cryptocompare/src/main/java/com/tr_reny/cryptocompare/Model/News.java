package com.tr_reny.cryptocompare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class News {


    @SerializedName("Type")
    @Expose
    public Integer type;
    @SerializedName("Message")
    @Expose
    public String message;
    @SerializedName("Promoted")
    @Expose
    public List<Object> promoted = null;
    @SerializedName("Data")
    @Expose
    public ArrayList<Datum> data = null;
    @SerializedName("RateLimit")
    @Expose
    public RateLimit rateLimit;
    @SerializedName("HasWarning")
    @Expose
    public Boolean hasWarning;

    //Constructors

    public News(Integer type, String message, List<Object> promoted, ArrayList<Datum> data, RateLimit rateLimit, Boolean hasWarning) {
        this.type = type;
        this.message = message;
        this.promoted = promoted;
        this.data = data;
        this.rateLimit = rateLimit;
        this.hasWarning = hasWarning;
    }


    //getters

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getPromoted() {
        return promoted;
    }

    public void setPromoted(List<Object> promoted) {
        this.promoted = promoted;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
    }

    public Boolean getHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(Boolean hasWarning) {
        this.hasWarning = hasWarning;
    }
}