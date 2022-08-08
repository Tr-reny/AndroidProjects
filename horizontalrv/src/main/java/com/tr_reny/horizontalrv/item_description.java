package com.tr_reny.horizontalrv;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class item_description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        String name = getIntent().getStringExtra("name");
        String realname = getIntent().getStringExtra("realname");
        String bio = getIntent().getStringExtra("bio");


        String image = getIntent().getStringExtra("imageurl");

//        int imageurl= getIntent().getIntExtra("imageurl",0);

        TextView textViewName = findViewById(R.id.textViewName);
        ImageView imageViewb = findViewById(R.id.imageViewdes);


        textViewName.setText(name);
//        textViewName.setText(realname);
        textViewName.setText(bio);


//        imageViewb.setImageURI(image);


        new DownloadImageTask(imageViewb).execute(getIntent().getStringExtra("imageurl"));


    }


}