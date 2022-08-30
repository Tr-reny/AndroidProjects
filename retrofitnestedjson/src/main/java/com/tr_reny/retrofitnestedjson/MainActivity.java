package com.tr_reny.retrofitnestedjson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.ArrayList;
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
    // JSONSERVE LINK https://run.mocky.io/v3/65866b72-2c90-4697-808c-cf1b52bf8794
    private JsonServeAPI jsonServeAPI;
    private TextView textViewresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewresults = findViewById(R.id.txt_results);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonServeAPI = retrofit.create(JsonServeAPI.class);
        //getIBM();
        getIBMArrayList();
    }

    private void getIBM() {
        Call<List<IBM>> call = jsonServeAPI.getIBM();
        call.enqueue(new Callback<List<IBM>>() {
            @Override
            public void onResponse(Call<List<IBM>> call, Response<List<IBM>> response) {

                if (response.isSuccessful()){
                    textViewresults.setText("Code: " + response.code());
                    return;
                }


              List<IBM> ibms = response.body();
               for (IBM ibm : ibms) {
                   String content = "";

                   content += "Isbn: " + ibm.getIsbn() + "\n";
                   content += "Author name: " + ibm.getAuthor().getFirstname() + "\n";

                   textViewresults.setText("response" + response);
                   textViewresults.append(content);

               }
            }

            @Override
            public void onFailure(Call<List<IBM>> call, Throwable t) {
                textViewresults.setText(t.getMessage());

            }
        });
    }


    private void getIBMArrayList(){
        Call<ArrayList<IBM>> call = jsonServeAPI.getIBMArray();
        call.enqueue(new Callback<ArrayList<IBM>>() {
            @Override
            public void onResponse(Call<ArrayList<IBM>> call, Response<ArrayList<IBM>> response) {
                if (!response.isSuccessful()){
                    textViewresults.setText("code: " + response.code());
                    return;
                }
                textViewresults.setText("code: " + response);

            }

            @Override
            public void onFailure(Call<ArrayList<IBM>> call, Throwable t) {
                textViewresults.setText(t.getMessage());

            }
        });
    }
}
