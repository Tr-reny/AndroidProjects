package com.tr_reny.cryptocompare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /** Created on 15th Aug 2022 by Reny K.
     * This is a practise app to test to see if i can Display Api data from
     * https://min-api.cryptocompare.com/
     * as Well as Crypto Market Graphs
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}