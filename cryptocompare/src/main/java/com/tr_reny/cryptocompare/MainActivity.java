package com.tr_reny.cryptocompare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tr_reny.cryptocompare.Adapter.MyAdapter;
import com.tr_reny.cryptocompare.Interface.Cryptocompare;
import com.tr_reny.cryptocompare.Model.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /** Created on 15th Aug 2022 by Reny K.
     * This is a practise app to test to see if i can Display Api data from
     * https://min-api.cryptocompare.com/
     * as Well as Crypto Market Graphs
     * */

    private Cryptocompare cryptocompare;
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
                .baseUrl("https://min-api.cryptocompare.com/data/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cryptocompare = retrofit.create(Cryptocompare.class);

        getNews();
    }

    private void getNews() {
        Call<List<News>> call = cryptocompare.getNews("6b438844ac5cc35f50b52a7d4ee12a897d8b9537ea6141bcb888c1f4b5f8ff46");
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