package com.tr_reny.pagingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project Created on 4th Sep 2022 by Reny Kipkoech
 * --------------------------------------------Project Purpose------------------------------------------------------
 * Suppose you have 5000 images data from a backend API and you do not want load whole 5000 images data at once
 * that time you can use the paging library. This only load small amounts of data from your large data set.
 * It will consume less bandwidth. Also, fewer resources resulting in a smooth app and nice user experience.
 * */

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    private ProgressBar progressBar;
    private NestedScrollView nestedScrollView;
    private RecyclerView recyclerView;
    private List<Photos> photosList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variable
        progressBar = findViewById(R.id.progressBar);
        nestedScrollView = findViewById(R.id.scroll_view);
        recyclerView = findViewById(R.id.recyclerView);
        photosList = new ArrayList<>();


        //retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}