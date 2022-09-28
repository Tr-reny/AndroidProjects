package com.tr_reny.cryptocompare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.tr_reny.cryptocompare.Adapter.MyAdapter;
import com.tr_reny.cryptocompare.Interface.Cryptocompare;
import com.tr_reny.cryptocompare.Model.Datum;
import com.tr_reny.cryptocompare.Model.News;

import java.util.ArrayList;
import java.util.List;

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

    private Cryptocompare cryptocompare;
    private ArrayList newsList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tv_results = findViewById(R.id.tv_results);
        newsList = new ArrayList();
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Datum> news_array;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cryptocompare = retrofit.create(Cryptocompare.class);

    }
}