package com.tr_reny.cryptocompare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceInfo {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("img")
    @Expose
    public String img;



}