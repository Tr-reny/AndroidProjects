package com.tr_reny.cryptocompare;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tr_reny.cryptocompare.Model.Data;
import com.tr_reny.cryptocompare.Model.JsonServeAPI;
import com.tr_reny.cryptocompare.Model.News;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    /**
     * Created on 15th Aug 2022 by Reny K.
     * This is a practise app to test to see if i can Display Api data from
     * https://min-api.cryptocompare.com/
     * as Well as Crypto Market Graphs
     */

    private ArrayList<Data> dataList;
    private TextView tv_results;
    private JsonServeAPI jsonServeAPI;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dataList = new ArrayList<>();

//        tv_results = findViewById(R.id.tv_results);

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonServeAPI = retrofit.create(JsonServeAPI.class);


    //    getNews();
        getNewsOnRecyclerView();

    }

    private void getNews() {
        Call<News> call = jsonServeAPI.getNews();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {

                    Log.d(TAG, "body to string: " + response.body().getMessage());

                    News news = response.body();


                    ArrayList<Data> datas = new ArrayList<Data>(Arrays.asList(response.body().getData()));

                    Log.d(TAG + " getNews ", " onResponse: Type: " + news.getType() + "  message: " + news.getMessage());

                    for (Data data : datas) {
                        Log.d(TAG, data.toString());

                        String content = "";
                        content += "title: " + data.getTitle() + "\n";
                        content += "Body: " + data.getBody() + "\n";
                        content += "Source: " + data.getSourceInfo().getName() + "\n\n";


                        tv_results.append(content);

                    }

                } else {
                    Log.d(TAG + " getNews", " onResponse " + "Error Code " + response.code());
                }
            }


            @Override
            public void onFailure(Call<News> call, Throwable t) {
                tv_results.setText("Error: " + t.getMessage());
                Log.d(TAG + " getNews ", " onFailure " + " Didn't work " + t.getMessage() + " " + t.getCause() + " \n" + Arrays.toString(t.getStackTrace()));


            }
        });

    }

    private void getNewsOnRecyclerView(){
        Call<News> call = jsonServeAPI.getNews();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {

                    Log.d(TAG, "body to string: " + response.body().getMessage());

                    News news = response.body();

                    ArrayList<Data> datas = new ArrayList<Data>(Arrays.asList(response.body().getData()));

                    Log.d(TAG + " getNews ", " onResponse: Type: " + news.getType() + "  message: " + news.getMessage());



                    for (Data datal : datas) {
                        Log.d(TAG, datal.toString());
/*
                        String content = "";
                        content += "title: " + data.getTitle() + "\n";
                        content += "Body: " + data.getBody() + "\n";
                        content += "Source: " + data.getSourceInfo().getName() + "\n\n";


                        tv_results.append(content);

                        */
                      dataList.add(datal);

                    }
                    PutDataIntoRecylerView(dataList);

                } else {
                    Log.d(TAG + " getNews", " onResponse " + "Error Code " + response.code());
                }
            }


            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d(TAG + " getNews ", " onFailure " + " Didn't work " + t.getMessage() + " " + t.getCause() + " \n" + Arrays.toString(t.getStackTrace()));


            }
        });

    }

    private void PutDataIntoRecylerView(ArrayList<Data> dataList) {

        MyAdapter myAdapter = new MyAdapter(this,dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
}

