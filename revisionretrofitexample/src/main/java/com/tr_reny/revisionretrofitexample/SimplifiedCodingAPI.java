package com.tr_reny.revisionretrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SimplifiedCodingAPI {
    @GET("marvel")
    Call<List<Marvel>> getMarvels();
}
