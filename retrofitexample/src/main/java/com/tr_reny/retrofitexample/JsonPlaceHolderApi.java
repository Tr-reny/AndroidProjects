package com.tr_reny.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //this Service Request the relative link
    @GET("posts") //annotate method
    Call<List<Post>> getPost();

    @GET("posts/1/comments")
    Call<List<Comments>> getComments();
}
