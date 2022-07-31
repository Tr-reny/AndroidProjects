 package com.tr_reny.realtimerecyleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
/**
 * Created by Reny Kipkoech on 29/07/2022 01:00 hours EAT
 * This App Uses Firebase realtime DataBase and Displays it Using RecyclerView
 * */

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code to Open UserLayout
        Button test = findViewById(R.id.btnTest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,userlist.class);
                startActivity(intent);
            }
        });
    }
}