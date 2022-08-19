package com.tr_reny.retrofitpostdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 18th AUG 2022 by Reny Kipkoech.
 * This is an app which Take inpute from user, convert it to JSON and POST it on JSON server
 */
public class MainActivity extends AppCompatActivity {
    private EditText edtxtName, edtxtJob;
    private Button btncreatePost;
    private ProgressBar progressBar;
    private TextView tvresponse,tvNameError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtJob = findViewById(R.id.idEdtJob);
        edtxtName = findViewById(R.id.idEdtName);
        progressBar = findViewById(R.id.idLoadingPB);
        btncreatePost = findViewById(R.id.idBtnPost);
        tvresponse = findViewById(R.id.idTVResponse);
        tvNameError = findViewById(R.id.tvNameError);

        btncreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     //validate if the fields is empty or not
                if (edtxtName.getText().toString().isEmpty() && edtxtJob.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Both the Values", Toast.LENGTH_SHORT).show();
                    return;
                }*/

              /*  //validate if Name and Job fields is empty or not
                if (edtxtName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Name", Toast.LENGTH_SHORT).show();
                } else if (edtxtJob.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Job Role", Toast.LENGTH_SHORT).show();
                    return;
                }*/

                //Validate if each field is empty or not and display it on TextView
                if (edtxtName.getText().toString().isEmpty()) {
                    tvNameError.setError("Please Enter Name");
                } else if (edtxtJob.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Job Role", Toast.LENGTH_SHORT).show();
                    return;
                }


                //Calling a method to post the data and passing our name and Job.
                postData(edtxtName.getText().toString(), edtxtJob.getText().toString());
            }

        });


    }

    private void postData(String name, String job) {
        //Display our progress Bar
        progressBar.setVisibility(View.VISIBLE);

        //Creation of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                .build();
// create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // passing data from our text fields to our modal class.
        DataModal dataModal = new DataModal(name, job);

        // // calling a method to create a post and passing our modal class.
        Call<DataModal> call = retrofitAPI.createPost(dataModal);


        //on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                if (!response.isSuccessful()) {
                    tvresponse.setText("CODE: " + response.code());
                    return;
                }
                //this method is called when we get response from the server
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                //Hide our progressbar
                progressBar.setVisibility(View.GONE);

                //on below we are setting empty text to our both Edit Text
                edtxtJob.setText("");
                edtxtName.setText("");

                //we are getting response from our body and passing it to our model class.
                DataModal responseFromAPI = response.body();

                //getting data from Model Class and adding it to our String
                String responseString = "Response Code: " + response.code() + "\nName: " + responseFromAPI.getName() + "\n" + "Job: " + responseFromAPI.getJob();

                //Setting our string to our TextView
                tvresponse.setText(responseString);

            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                tvresponse.setText(t.getMessage());

            }
        });


    }

}