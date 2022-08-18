package com.tr_reny.retrofitpostdate;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("users")
    Call<DataModal> createPost(@Body DataModal dataModal);
}
