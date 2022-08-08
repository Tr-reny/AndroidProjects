package com.tr_reny.freenewsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewResults = findViewById(R.id.TextViewResults);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://free-news.p.rapidapi.com/v1/search?q=Elon%20Musk&lang=en")
                .get()
                .addHeader("X-RapidAPI-Key", "7b17418753msh4f16608e0aa78d7p1a6fe6jsnfc06e90efe18")
                .addHeader("X-RapidAPI-Host", "free-news.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}