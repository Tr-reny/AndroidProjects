package com.tr_reny.retrofitrvsearchview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private ArrayList<Post> postArrayList;
    private ArrayList<Post> postArrayListFull;

    public MyAdapter(Context mContext, ArrayList<Post> postArrayList) {
        this.mContext = mContext;
        this.postArrayListFull = postArrayList;
        this.postArrayList = new ArrayList<>(postArrayListFull);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(postArrayList.get(position).getTitle());
//        holder.id.setText(postList.get(position).getId());
//        holder.userId.setText(postList.get(position).getUserId());
        holder.body.setText(postArrayList.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return titleFilter;
    }

// Filter the Containers
    private final Filter titleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Post> filteredTitle = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredTitle.addAll(postArrayListFull);
            }
            else {
                String filterPatten = constraint.toString().toLowerCase().trim();

                for (Post post : postArrayListFull){

                    if (post.getTitle().toLowerCase(Locale.ROOT).contains(filterPatten))
                        filteredTitle.add(post);

                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredTitle;
            results.count = filteredTitle.size();

            return results;


        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            postArrayList.clear();
            postArrayList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,body,id,userId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvtitle);
            body = itemView.findViewById(R.id.tvbody);
//            userId = itemView.findViewById(R.id.tvuserId);
//            id = itemView.findViewById(R.id.tvId);

        }
    }
}