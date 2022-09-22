package com.tr_reny.cryptocompare.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("type")
    public Integer type;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public Datum mData;

    public RateLimit rateLimit;
    public Boolean hasWarning;

    //constructors

        public News(Integer type, String message, Datum mData, RateLimit rateLimit, Boolean hasWarning) {
        this.type = type;
        this.message = message;
        this.mData = mData;
        this.rateLimit = rateLimit;
        this.hasWarning = hasWarning;
    }

    public News(Integer type) {
        this.type = type;
    }


    //getters


    public Integer getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Datum getData() {
        return Data;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public Boolean getHasWarning() {
        return hasWarning;
    }
}