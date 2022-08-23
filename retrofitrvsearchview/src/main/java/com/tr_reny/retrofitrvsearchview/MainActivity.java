package com.tr_reny.retrofitrvsearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Reny Kipkoech on 19th AUG 2022
 * This is an App which shows the functionality of Retrofit with RecycleView and SearchView together
 * */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Post> arrayListPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        arrayListPost = new ArrayList<>();
        /* postList = new ArrayList<>();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        Call<List<Post>> call = jsonPlaceHolderAPI.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                  /*  String content = "";

                    content += "ID: " + post.getId() + "\n";
                    content += "UserID: " + post.getUserId() + "\n";
                    content += "Body: " + post.getBody() + "\n";
                    content += "Title: " + post.getTitle() + "\n";*/

                    arrayListPost.add(post);

                }
                PutDataIntoRecylerView(arrayListPost);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    private void PutDataIntoRecylerView(ArrayList<Post> arrayListPost) {

        MyAdapter myAdapter = new MyAdapter(this,arrayListPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
            //execute
        /*call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                   *//* textViewResults.setText("CODE: " + response.code());*//*
                    return;
                }

                List<Post> posts = response.body();
                for (Post post : posts){
                   *//* String content = "";

                    content += "ID: " + post.getId() + "\n";
                    content += "UserID: " + post.getUserId() + "\n";
                    content += "Body: " + post.getBody() + "\n";
                    content += "Title: " + post.getTitle() + "\n";*//*
                   postList.add(post);

                }
                PutDataIntoRecylerView(postList);


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });*/

    }
   /* private void PutDataIntoRecylerView(List<Post> postList) {

        MyAdapter myAdapter = new MyAdapter(this,postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
*/
    //
   /* public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);

        MenuItem searchItem = menu.findItem(R.id.menu_search);

        SearchView searchView = null;
        if (searchItem != null){
            searchView = (SearchView) searchItem.getActionView();
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MyAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }*/
