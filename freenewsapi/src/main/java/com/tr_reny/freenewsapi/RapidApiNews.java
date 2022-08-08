package com.tr_reny.freenewsapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RapidApiNews {

   @GET("v1/search?q=Elon%20Musk&lang=en")
    Call<List<Articles>> getArticles();
}
