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

}
}
