package com.tr_reny.retrofitmovie;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Marvel> marvelList;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylerView);

        marvelList = new ArrayList<>();

        //textViewResults = findViewById(R.id.textMarvelsResults);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SimplifiedCodingAPI simplifiedCodingAPI = retrofit.create(SimplifiedCodingAPI.class);

        Call<List<Marvel>> call = simplifiedCodingAPI.getMarvels();

        call.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {
                if (!response.isSuccessful()){
//                    recyclerView.setText("Code: " + response.code());
                    return;
                }

                List<Marvel> marvels = response.body();
                for (Marvel marvel : marvels){
                  /*  String content = "";
                    content += "Name: " + marvel.getName() + "\n";
                    content += "RealName: " + marvel.getRealname() + "\n";
                    content += "Team: " + marvel.getTeam() + "\n";
                    content += "Bio: " + marvel.getBio() + "\n";
                    content += "ImageUrl: " + marvel.getImageurl() + "\n\n";

                    textViewResults.append(content);*/

                    marvelList.add(marvel);
                }
                PutDataIntoRecylerView(marvelList);

            }

            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {
//              recyclerView.setText(t.getMessage());

            }
        });

    }

    private void PutDataIntoRecylerView(List<Marvel> marvelList) {

        MyAdapter myAdapter = new MyAdapter(this,marvelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }
}