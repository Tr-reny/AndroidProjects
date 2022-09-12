package com.tr_reny.rapidapiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private List<News> newsList;

    public MyAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.source.setText(newsList.get(position).getMsource());
        holder.title.setText(newsList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView source;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            source = itemView.findViewById(R.id.text_view_source);
            title = itemView.findViewById(R.id.text_view_title);

        }
    }
}
