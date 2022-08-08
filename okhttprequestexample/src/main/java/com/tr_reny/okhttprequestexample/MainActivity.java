package com.tr_reny.okhttprequestexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created on 8th AUG 2022 time: 21:00 hrs
 * This is a simple OkHttpRequest which request JSON object and displayed it TextView
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextViewResults = findViewById(R.id.textVewResults);

        OkHttpClient client = new OkHttpClient();

        String url = "https://reqres.in/api/users?page=2";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                     String myResponse = response.body().string();

                     MainActivity.this.runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             mTextViewResults.setText(myResponse);
                         }
                     });
                }

            }
        });

    }
}