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
    /**
     * Created on 15th Aug 2022 by Reny K.
     * This is a practise app to test to see if i can Display Api data from
     * https://min-api.cryptocompare.com/
     * as Well as Crypto Market Graphs
     */

    private Cryptocompare cryptocompare;
    private List<News> newsList;
    private RecyclerView recyclerView;


    private TextView tv_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_results = findViewById(R.id.tv_results);
        newsList = new ArrayList<>();
//        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cryptocompare = retrofit.create(Cryptocompare.class);
        getNewsT();

        //  getNews();
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

        */
/*        String user_name= response.getUsername();
                user_array= new ArrayList<>(response.getUserArray());
                Toast.makeText(PrintTicket.this,response.toString(),Toast.LENGTH_SHORT).show();
            *//*




            List<News> newsList1 = response.body();

                for (News news : newsList1) {
              */
/*     String content = "";
                    content += "title: " + news.getTitle() + "\n";
                    content += "Source: " + news.getMsource() + "\n\n";

                    tv_results.append(content);*//*


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

    private void getNewsT() {
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

                content += "title: " + news.getMessage() + "\n";
            /*    content += "Source: " + response.body().getMessage() + "\n\n";*/

                tv_results.append(content);

        }

        @Override
        public void onFailure (Call < News > call, Throwable t){
            tv_results.setText("Error: " + t.getMessage());

        }
    });
}



 /*   private void PutDataIntoRecylerView(List<News> newsList) {

        MyAdapter myAdapter = new MyAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }*/
}