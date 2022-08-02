package com.tr_reny.retrofitmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResults=findViewById(R.id.textMarvelsResults);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieInterfaceAPI movieInterfaceAPI = retrofit.create(MovieInterfaceAPI.class);
        Call<List<Marvel>> call = MovieInterfaceAPI.getMarvels();


    }
}