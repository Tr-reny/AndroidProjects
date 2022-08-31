package com.tr_reny.recyclerviewwithmultipleview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MockApi {


    //https://60d194a45b017400178f3e51.mockapi.io/movies
    //https://60d194a45b017400178f3e51.mockapi.io/directors

    @GET("marvel")
    Call<List<RecommendMovie>> getRecommendMovie();
}
