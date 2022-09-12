package com.tr_reny.pagingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    //We will parse data from this link https://jsonplaceholder.typicode.com/photos
    //We will separate page by "albumId"

    @GET("photos")
    Call<List<Photos>> getPhotos();

}
