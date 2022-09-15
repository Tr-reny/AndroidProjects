package com.tr_reny.cryptocompare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tr_reny.cryptocompare.Model.News;
import com.tr_reny.cryptocompare.R;

import java.util.ArrayList;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<News> newsArrayList;

    public MyAdapter(Context mContext, ArrayList<News> newsArrayList) {
        this.mContext = mContext;
        newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_news,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(newsArrayList.get(position).getTitle());
//        holder.id.setText(postList.get(position).getId());
//        holder.userId.setText(postList.get(position).getUserId());
        holder.body.setText(postArrayList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
