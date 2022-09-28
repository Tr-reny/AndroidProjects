package com.tr_reny.cryptocompare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.tr_reny.cryptocompare.Adapter.MyAdapter;
import com.tr_reny.cryptocompare.Interface.Cryptocompare;
import com.tr_reny.cryptocompare.Model.Datum;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cryptocompare = retrofit.create(Cryptocompare.class);
//       getNewsT();

        //  getNews();

        getData();
    }

    private void getData() {

        Call<Datum> call = cryptocompare.getNewsServe();
        call.enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<Datum> datum1  = (List<Datum>) response.body();
                for (Datum datum : datum1){


                    newsList.add(datum);
                }

                PutDataIntoRecylerView(newsList);

            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });








    /*enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.toString(), Toast.LENGTH_LONG).show();
                    return;
                }
                List<Datum> datalist = response.body().getData();
                for (int i=0; i<datalist.size(); i++){

                }
                News news = response.body();

                newsList.add(datalist);

                PutDataIntoRecylerView(newsList);


            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();

            }
        });*/
    }

/*

    private void getNews() {
        Call<List<News>> call = cryptocompare.getNewsServe();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.toString(), Toast.LENGTH_LONG).show();
                    return;
                }


            List<News> newsList1 = response.body();

                for (News news : newsList1) {

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

*/


 /*   private void getNewsT() {
        Call<News> call = cryptocompare.getNewsServe();
        call.enqueue(new Callback<News>() {

            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (!response.isSuccessful()) {
                    tv_results.setText("Code: " + response.code());
                    return;
                }

                News news = response.body();
                String content = "";

                content += "Code: " + response.code() + "\n";
                content += "Type: " + news.getType() + "\n";

                content += "Message: " + news.getMessage() + "\n";
                content += "Has warning: " + news.getHasWarning() + "\n\n";
                *//*    content += "Source: " + response.body().getMessage() + "\n\n";*//*

                tv_results.append(content);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                tv_results.setText("Error: " + t.getMessage());

            }
        });
    }

*/

    private void PutDataIntoRecylerView(List<Datum> newsList) {

        MyAdapter myAdapter = new MyAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }


}