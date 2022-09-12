package com.tr_reny.pagingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project Created on 4th Sep 2022 by Reny Kipkoech
 * --------------------------------------------Project Purpose------------------------------------------------------
 * Suppose you have 5000 images data from a backend API and you do not want load whole 5000 images data at once
 * that time you can use the paging library. This only load small amounts of data from your large data set.
 * It will consume less bandwidth. Also, fewer resources resulting in a smooth app and nice user experience.
 */

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ArrayList<Photos> photosList;
    private PostRecyclerAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variable
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        photosList = new ArrayList<>();

        getData();



    }


    private void getData() {
        //retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Photos>> call = jsonPlaceHolderApi.getPhotos();


        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //When response is successfull and not empty
                    //Hide progressbar

                    progressBar.setVisibility(View.GONE);

                    List<Photos> photos = response.body();
                    for (Photos photos1 : photos) {

                        photosList.add(photos1);
                    }
                    PutDataIntoRecylerView(photosList);

                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }


    private void PutDataIntoRecylerView(List<Photos> photosArrayList) {

        myAdapter = new PostRecyclerAdapter(this, photosArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }
}