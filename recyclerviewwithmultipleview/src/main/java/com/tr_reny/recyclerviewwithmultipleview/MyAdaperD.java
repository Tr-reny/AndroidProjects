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

public class MyAdaperD extends RecyclerView.Adapter<MyAdaperD.MyViewHolder> {

    private Context mContext;
    private List<Directors> directorsList;

    public MyAdaperD(Context mContext, List<Directors> directorsList) {
        this.mContext = mContext;
        this.directorsList = directorsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_director, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(directorsList.get(position).getName());
        //Glide
        Glide.with(mContext)
                .load(directorsList.get(position).getAvatar())
                .into(holder.avator);

    }

    @Override
    public int getItemCount() {
        return directorsList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView avator;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_view_name);
            avator =itemView.findViewById(R.id.image_view_director);
        }
    }
}
