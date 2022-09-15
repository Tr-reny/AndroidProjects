package com.tr_reny.cryptocompare.Interface;

import com.tr_reny.cryptocompare.Model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Cryptocompare {

    @GET("data/v2/news/?lang=EN")
    Call<List<News>> getNews(
//            @Header("API Host") String apiHost,
            @Header("API KEY in URL") String apiKey);

}
