package com.tr_reny.rapidapiexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RapidApi {
//    'X-RapidAPI-Host': 'crypto-news-live3.p.rapidapi.com'
    //   'X-RapidAPI-Key': '7b17418753msh4f16608e0aa78d7p1a6fe6jsnfc06e90efe18',
    // URL 'https://crypto-news-live3.p.rapidapi.com/news',

    @GET("news")
    Call<List<News>> getNews(@Header("X-RapidAPI-Host") String api,
                             @Header("X-RapidAPI-Key") String apiKey);
//                              @Query("query") String query_str);
}
