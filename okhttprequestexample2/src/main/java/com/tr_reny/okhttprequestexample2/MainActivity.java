package com.tr_reny.okhttprequestexample2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResults;
    final String TAG = "OkHttp ex.2";


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

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                     e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                Log.d(TAG,"onResponse: Thread Id" + Thread.currentThread());

                if (response.isSuccessful()){
                   final String myResponse = response.body().string();

//                    final JSONArray myResponse=new JSONArray(response.body());

                    try {
                        JSONArray jsonArray = new JSONArray(myResponse);
                      for (int i=0; i<myResponse.length(); i++){
                          JSONObject marvel = jsonArray.getJSONObject(i);
                          String firstname = marvel.getString("name");
                          String lastname = marvel.getString("realname");
                      }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            textViewResults.setText(myResponse);
                        }
                    });
                }


            }
        });

    }




}