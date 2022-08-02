package com.tr_reny.retrofitmovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInterfaceAPI {
    @GET("marvel")
    Call<List<Marvel>> getMarvels();
}
