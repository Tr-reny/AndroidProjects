package com.tr_reny.cryptocompare.Model;

import java.util.List;

public class News {

    public Integer type;
    public String message;
    public List<Object> promoted = null;
    public List<Datum> data = null;
    public RateLimit rateLimit;
    public Boolean hasWarning;

}