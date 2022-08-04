package com.tr_reny.retrofitmovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SimplifiedCodingAPI {

    @GET("marvel")
    Call<List<Marvel>> getMarvel();


}
