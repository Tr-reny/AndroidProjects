package com.tr_reny.retrofitnestedjson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonServeAPI {

    @GET("v3/65866b72-2c90-4697-808c-cf1b52bf8794")
    Call<List<IBM>> getIBM();

    @GET("v3/65866b72-2c90-4697-808c-cf1b52bf8794")
    Call<ArrayList<IBM>> getIBMArray();
}
