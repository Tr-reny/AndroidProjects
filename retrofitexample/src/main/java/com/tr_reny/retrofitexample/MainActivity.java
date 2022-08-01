package com.tr_reny.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Reny Kipkoech on 31/07/2022 20:15 hours EAT
 * This is a retrofit example that only shows the the functionality of retrofit
 */

public class MainActivity extends AppCompatActivity {
    private TextView textViewResults;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResults = findViewById(R.id.txtPost);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
      //getPosts();
        getComment();
    }

    private void getPosts(){
        Call<List<Post>> call = jsonPlaceHolderApi.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResults.setText("Code :" + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResults.append(content);


                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResults.setText(t.getMessage());

            }
        });
    }

    private void getComment(){
        Call<List<Comment>> call = jsonPlaceHolderApi.getComments();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){
                    textViewResults.setText("Code: " + response.code());
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResults.setText(t.getMessage());

            }
        });

    }
}