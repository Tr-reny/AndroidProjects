package com.tr_reny.okhttprequestexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResults = findViewById(R.id.textviewResults);

        OkHttpClient client = new OkHttpClient();
        String url = "https://www.simplifiedcoding.net/demos/marvel";

        Request request = new Request.Builder()
                .url(url)
                .build();



    }
}