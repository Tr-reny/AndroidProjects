package com.tr_reny.retrofitmovie;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResults = findViewById(R.id.textMarvelsResults);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.simplifiedcoding.net/demos/marvel/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SimplifiedCodingAPI simplifiedCodingAPI = retrofit.create(SimplifiedCodingAPI.class);

        Call<List<Marvel>> call = simplifiedCodingAPI.getMarvels();

        call.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {
                if (!response.isSuccessful()){
                    textViewResults.setText("Code: " + response.code());
                    return;
                }

                List<Marvel> marvels = response.body();
                for (Marvel marvel : marvels){
                    String content = "";
                    content += "Name: " + marvel.getName() + "\n";
                    content += "RealName: " + marvel.getRealname() + "\n";
                    content += "Team: " + marvel.getTeam() + "\n";
             /*       content += "Bio: " + marvel.getBio() + "\n";
                    content += "ImageUrl: " + marvel.getImageurl() + "\n\n";*/

                    textViewResults.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {
              textViewResults.setText(t.getMessage());

            }
        });

    }
}