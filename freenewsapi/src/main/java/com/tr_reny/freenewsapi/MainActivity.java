package com.tr_reny.freenewsapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArticlesAPi articlesAPi;
    private TextView textViewResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResults = findViewById(R.id.TextViewResults);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request newRequest = originalRequest.newBuilder()
                                .get()
//                                .addHeader("X-RapidAPI-Key", "7b17418753msh4f16608e0aa78d7p1a6fe6jsnfc06e90efe18")
//                                .addHeader("X-RapidAPI-Host", "free-news.p.rapidapi.com")
                                .build();

                        return chain.proceed(newRequest);
                    }
                })
                .addInterceptor(loggingInterceptor)
                .build();

        String url = "https://free-news.p.rapidapi.com/";

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        articlesAPi = retrofit.create(ArticlesAPi.class);
        getArticles();




/*


        OkHttpClient client = new OkHttpClient();

        String url = "https://free-news.p.rapidapi.com/v1/search?q=Elon%20Musk&lang=en";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", "7b17418753msh4f16608e0aa78d7p1a6fe6jsnfc06e90efe18")
                .addHeader("X-RapidAPI-Host", "free-news.p.rapidapi.com")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if (response.isSuccessful()) {
                    String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            textViewResults.setText(myResponse);

                            JSONObject json = null;
                            try {
                                json = new JSONObject(myResponse);
                                textViewResults.setText(json.getJSONObject("status").getString("status"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


//                            txtString.setText(json.getJSONObject("data").getString("first_name")+ " "+json.getJSONObject("data").getString("last_name"));
                        }
                    });

                }

            }
        });
*/


    }

    private void getArticles() {
        Call<List<Articles>> call = articlesAPi.getArticles();

        call.enqueue(new Callback<List<Articles>>() {
            @Override
            public void onResponse(Call<List<Articles>> call, retrofit2.Response<List<Articles>> response) {

                if (!response.isSuccessful()) {
                    textViewResults.setText("Code: " + response.code());
                    return;
                }

                List<Articles> articles = response.body();
                for (Articles article : articles) {
                    String content = "";
                    content += "Title: " + article.getTitle() + "\n";
                    content += "Summary: " + article.getSummary() + "\n";

                    textViewResults.append(content);
                }


            }

            @Override
            public void onFailure(Call<List<Articles>> call, Throwable t) {
              textViewResults.setText(t.getMessage());


            }
        });
    }
}