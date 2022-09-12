package com.tr_reny.rapidapiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Reny K. On 2nd Sep 2022
 * This is a Simple app which GET NewsAPI from RapidAPI and Displays it RecyclerView
 */

public class MainActivity extends AppCompatActivity {

    private RapidApi rapidApi;
    private List<News> newsList;
    private RecyclerView recyclerView;


    private TextView tv_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tv_results = findViewById(R.id.text_view_results);
        newsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crypto-news-live3.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rapidApi = retrofit.create(RapidApi.class);

        getNews();
    }

    private void getNews() {
        Call<List<News>> call = rapidApi.getNews("crypto-news-live3.p.rapidapi.com", "7b17418753msh4f16608e0aa78d7p1a6fe6jsnfc06e90efe18");
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<News> newsList1 = response.body();
                for (News news : newsList1) {
              /*     String content = "";
                    content += "title: " + news.getTitle() + "\n";
                    content += "Source: " + news.getMsource() + "\n\n";

                    tv_results.append(content);*/

                    newsList.add(news);
                }

                PutDataIntoRecylerView(newsList);

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();

            }
        });


    }


    private void PutDataIntoRecylerView(List<News> newsList) {

        MyAdapter myAdapter = new MyAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }
}