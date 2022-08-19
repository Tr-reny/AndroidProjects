package com.tr_reny.retrofitrvsearchview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Post> post;

    public MyAdapter(Context context, ArrayList<Post> post) {
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,body,id,userId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvtitle);
            body = itemView.findViewById(R.id.tvbody);
            userId = itemView.findViewById(R.id.tvuserId);
            id = itemView.findViewById(R.id.tvId);


        }
    }

}
