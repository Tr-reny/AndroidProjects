package com.tr_reny.cryptocompare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    public List<Datum> data = null;
    @SerializedName("RateLimit")
    @Expose
    public RateLimit rateLimit;
    @SerializedName("HasWarning")
    @Expose
    public Boolean hasWarning;

    //Constructors

    public News(Integer type, String message, List<Object> promoted, List<Datum> data, RateLimit rateLimit, Boolean hasWarning) {
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

    public String getMessage() {
        return message;
    }

    public List<Object> getPromoted() {
        return promoted;
    }

    public List<Datum> getData() {
        return data;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public Boolean getHasWarning() {
        return hasWarning;
    }
}