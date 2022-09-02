package com.tr_reny.recyclerviewwithmultipleview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MockApi {

//movie https://api.jsonserve.com/uPBkda
//directors https://api.jsonserve.com/opvAb8


    @GET("uPBkda")
    Call<List<RecommendMovie>> getRecommendMovie();

    @GET("opvAb8")
    Call<List<Directors>> getDirectorsList();

}
