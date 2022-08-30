package com.tr_reny.retrofitnestedjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 27th AUG 2022 by Reny K.
 * This is a simple app that shows how the Nested JSON is accessed
 */

public class MainActivity extends AppCompatActivity {
    // JSONSERVE LINK https://api.jsonserve.com/gPKgmN
    private JsonServeAPI jsonServeAPI;
    private TextView textViewresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewresults = findViewById(R.id.txt_results);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonServeAPI = retrofit.create(JsonServeAPI.class);
        getIBM();
    }

    private void getIBM() {
        Call<List<IBM>> call = jsonServeAPI.getIBM();
        call.enqueue(new Callback<List<IBM>>() {
            @Override
            public void onResponse(Call<List<IBM>> call, Response<List<IBM>> response) {
                if (!response.isSuccessful()){
                    textViewresults.setText("Code: " + response.code());
                    return;
                }

                List<IBM> ibms = response.body();
               for (IBM ibm : ibms){
                   String content = "";

                   content += "Isbn: " + ibm.getIsbn() + "\n";

                  /* content += "User ID: " + post.getUserId() + "\n";
                   content += "Title: " + post.getTitle() + "\n";
                   content += "Text: " + post.getText() + "\n\n";*/

                   textViewresults.append(content);
               }

               }

            @Override
            public void onFailure(Call<List<IBM>> call, Throwable t) {
                textViewresults.setText(t.getMessage());

            }
        });
    }
}
