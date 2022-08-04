package com.tr_reny.advanceapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoPickerActivity extends AppCompatActivity {

    private int page = 1;

    FrameLayout searchLayout;
    AppBarLayout appBarLayout;
    EditText searchBar;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    PhotosAdapter adapter;
    PhotosAdapter.OnPhotoClickedListener photoClickListener;

    UnsplashInterface dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_img_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appBarLayout = findViewById(R.id.app_bar_layout);
        searchLayout = findViewById(R.id.searchLayout);
        searchBar = findViewById(R.id.searchBar);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        dataService = UnsplashClient.getUnsplashClient().create(UnsplashInterface.class);

        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ( (actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN ))){
                    search(searchBar.getText().toString());
                    return true;
                }
                else{
                    return false;
                }
            }
        });

        photoClickListener = new PhotosAdapter.OnPhotoClickedListener() {
            @Override
            public void photoClicked(Photo photo, ImageView imageView) {
                Intent intent = new Intent();
                intent.putExtra("image", photo);
                setResult(RESULT_OK, intent);
                finish();
            }
        };

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PhotosAdapter(new ArrayList<Photo>(), this, photoClickListener);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadPhotos();
            }
        });

        loadPhotos();

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    private void loadPhotos() {
        progressBar.setVisibility(View.VISIBLE);

        dataService.getPhotos(page,null,"latest")
                .enqueue(new Callback<List<Photo>>() {
                    @Override
                    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                        List<Photo> photos = response.body();
                        Log.d("Photos", "Photos Fetched " + photos.size());
                        //add to adapter
                        page++;
                        adapter.addPhotos(photos);
                        recyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<List<Photo>> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);

                    }
                });

    }

    public void search(String query){
        if(query != null && !query.equals("")) {
            progressBar.setVisibility(View.VISIBLE);

            dataService.searchPhotos(query,null,null,null)
                    .enqueue(new Callback<SearchResults>() {
                        @Override
                        public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                            SearchResults results = response.body();
                            Log.d("Photos", "Total Results Found " + results.getTotal());
                            List<Photo> photos = results.getResults();
                            adapter = new PhotosAdapter(photos, PhotoPickerActivity.this, photoClickListener);
                            recyclerView.setAdapter(adapter);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<SearchResults> call, Throwable t) {
                            Log.d("Unsplash", t.getLocalizedMessage());
                            progressBar.setVisibility(View.GONE);

                        }
                    });

        }
        else {
            loadPhotos();
        }
    }

    private void showSearchBar() {
        appBarLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
        searchBar.requestFocus();
    }

    public void hideSearchBar(View view) {
        searchLayout.setVisibility(View.GONE);
        appBarLayout.setVisibility(View.VISIBLE);
        searchBar.clearFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_unsplash_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_search) {
            Log.d("picker", "Search bar open");
            showSearchBar();
            return true;
        }
        if(item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(searchLayout.getVisibility() == View.VISIBLE){
            Log.d("picker", "Search bar visible");
            hideSearchBar(null);
            return;
        }
        super.onBackPressed();
    }
}