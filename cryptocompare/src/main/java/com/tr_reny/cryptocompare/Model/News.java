package com.tr_reny.cryptocompare.Model;

import java.util.List;

public class News {

    public Integer type;
    public String message;
    public List<Object> promoted = null;
    public List<Datum> data = null;
    public RateLimit rateLimit;
    public Boolean hasWarning;

    //constructors

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