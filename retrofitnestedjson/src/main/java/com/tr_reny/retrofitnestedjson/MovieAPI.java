package com.tr_reny.retrofitnestedjson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {
    @GET("")
    Call<List<Movie>> getMovieList();
}
