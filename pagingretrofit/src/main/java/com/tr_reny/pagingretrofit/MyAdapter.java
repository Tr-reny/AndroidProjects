package com.tr_reny.pagingretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Photos> photosArrayList;

    public MyAdapter(Context mContext, ArrayList<Photos> photosArrayList) {
        this.mContext = mContext;
        this.photosArrayList = photosArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_image,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //glide

        Glide.with(mContext)
                .load(photosArrayList.get(position).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.url);


    }

    @Override
    public int getItemCount() {
        return photosArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            url = itemView.findViewById(R.id.image_view);

        }

    }
}
