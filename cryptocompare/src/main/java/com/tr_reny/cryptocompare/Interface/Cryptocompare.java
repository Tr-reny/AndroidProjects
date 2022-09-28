package com.tr_reny.cryptocompare.Interface;

import com.tr_reny.cryptocompare.Model.Datum;
import com.tr_reny.cryptocompare.Model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Cryptocompare {

/*
    @GET("news/?lang=EN")
    Call<List<News>> getNews(
            @Header("Apikey") String apiKey);
*/

    //test
    @GET("ZI9BtX")

    Call<News<Datum>> getNewsServe();

}
