package com.tr_reny.recyclerviewwithmultipleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private List<RecommendMovie> recommendMovieList;

    public MyAdapter(Context mContext, List<RecommendMovie> recommendMovieList) {
        this.mContext = mContext;
        this.recommendMovieList = recommendMovieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_movie,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(recommendMovieList.get(position).getName());


        //Adding Glide Library to display the images

        Glide.with(mContext)
                .load(recommendMovieList.get(position).getImageurl())
                .into(holder.imageUrl);


    }

    @Override
    public int getItemCount() {
        return recommendMovieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageUrl;
        TextView name;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.image_view_movie);
            name = itemView.findViewById(R.id.tv_title);
        }
    }
}
