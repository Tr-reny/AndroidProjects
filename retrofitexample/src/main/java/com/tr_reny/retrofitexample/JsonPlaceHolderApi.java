package com.tr_reny.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //this Service Request the relative link
    @GET("posts")
    Call<List<Post>> getPost();
}
