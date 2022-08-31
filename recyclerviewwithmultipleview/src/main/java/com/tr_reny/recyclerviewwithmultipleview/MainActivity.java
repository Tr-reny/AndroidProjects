package com.tr_reny.recyclerviewwithmultipleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Reny K. on 31st Aug 2022
 * This is an app that implements multiple RecyclerView in One Layout
 * */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMovie , recyclerViewDirectors;
    private MockApi mockApi;
    private List<RecommendMovie> recommendMovieList;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMovie = findViewById(R.id.recylerViewMovie);
        recommendMovieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mockApi = retrofit.create(MockApi.class);
        getRecommendMovie();

    }
    private void getRecommendMovie() {
        Call<List<RecommendMovie>> call = mockApi.getRecommendMovie();
        call.enqueue(new Callback<List<RecommendMovie>>() {
            @Override
            public void onResponse(Call<List<RecommendMovie>> call, Response<List<RecommendMovie>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Code: " + response.code() , Toast.LENGTH_LONG).show();
                    return;
                }
                List<RecommendMovie> MovieList = response.body();
                for (RecommendMovie recommendMovie : MovieList){

                    recommendMovieList.add(recommendMovie);

                }
                PutDataIntoRecylerView(recommendMovieList);

            }

            @Override
            public void onFailure(Call<List<RecommendMovie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage() , Toast.LENGTH_LONG).show();
                t.printStackTrace();

            }
        });
    }

    private void PutDataIntoRecylerView(List<RecommendMovie> recommendMovieList) {

        myAdapter = new MyAdapter(this, recommendMovieList);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMovie.setAdapter(myAdapter);


    }

}