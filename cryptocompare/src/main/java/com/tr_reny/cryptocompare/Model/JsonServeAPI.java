package com.tr_reny.cryptocompare.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonServeAPI {

//    https://api.jsonserve.com/HCiQ5c
    @GET("HCiQ5c")
    Call<News> getnews();
}
