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
 * This is a simple app that shows how the Nested JSON is accessed*/

public class MainActivity extends AppCompatActivity {
    // JSONSERVE LINK https://api.jsonserve.com/heyQhT
    private JsonServeAPI jsonServeAPI;
    private TextView textViewresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewresults =findViewById(R.id.txt_results);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonserve.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

     jsonServeAPI = retrofit.create(JsonServeAPI.class);
     getMoveList();

    }
    private void getMoveList(){
        Call<List<Movie>> call = jsonServeAPI.getMovieList();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (!response.isSuccessful()){
                    textViewresults.setText("Code: " + response.code());
//                    Toast.makeText(MainActivity.this, "Code: " + response.code() , Toast.LENGTH_LONG).show();
                    return;
                }

                List<Movie> movies = response.body();
                for (Movie movie : movies){
                 String content = "";
                    content += "Total" + movie.getTotal() + "\n";
                    content += "Name: " + movie.getMovies().getClass().getName() + "\n";
              /*
                    content += "RealName: " + marvel.getRealname() + "\n";
                    content += "Team: " + marvel.getTeam() + "\n";
                    content += "Bio: " + marvel.getBio() + "\n";
                    content += "ImageUrl: " + marvel.getImageurl() + "\n\n";*/

                   textViewresults.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                textViewresults.setText(t.getMessage());
//                Toast.makeText(MainActivity.this,"Error: " + t.getMessage() , Toast.LENGTH_SHORT ).show();
                t.printStackTrace();
            }
        });
    }
}