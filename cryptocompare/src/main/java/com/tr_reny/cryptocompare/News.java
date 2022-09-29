package com.tr_reny.cryptocompare;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    //Getters and Setters

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
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