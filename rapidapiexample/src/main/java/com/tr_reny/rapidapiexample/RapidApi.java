package com.tr_reny.rapidapiexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RapidApi {

    @GET("")
    Call<List<News>> getNews( @Header("X-RapidAPI-Host") String api,
                              @Header("X-RapidAPI-Key") String apiKey,
                              @Query("query") String query_str);
}
