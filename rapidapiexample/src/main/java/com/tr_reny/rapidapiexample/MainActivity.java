package com.tr_reny.rapidapiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**Created by Reny K. On 2nd Sep 2022
 * This is a Simple app which GET NewsAPI from RapidAPI and Displays it RecyclerView
 * */

public class MainActivity extends AppCompatActivity {

    private RapidApi rapidApi;
    private List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crypto-news-live3.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rapidApi = retrofit.create(RapidApi.class);

        getNews();

    }
}