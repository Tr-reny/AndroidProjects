package com.tr_reny.retrofitrvsearchview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Post> postArrayList;

    public MyAdapter(Context mContext, ArrayList<Post> postArrayList) {
        this.mContext = mContext;
        this.postArrayList = postArrayList;
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

    /*@NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(postList.get(position).getTitle());
//        holder.id.setText(postList.get(position).getId());
//        holder.userId.setText(postList.get(position).getUserId());
        holder.body.setText(postList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

       
      *//*  public Filter getFilter(){

          return new Filter() {
              @Override
              protected FilterResults performFiltering(CharSequence constraint) {
                  String searchString = constraint.toString();

                  if (searchString.isEmpty()){
                      postList = filteredUserList;
                  }
                  else {

                      List<Post> tempFilteredList = new ArrayList<>();
                      for (Post post: postList){
                          // search for user Title
                          if (post.getTitle().toLowerCase(Locale.ROOT).contains(searchString)){
                              tempFilteredList.add(post);
                          }

                      }
                      postList = tempFilteredList;
                  }
                  FilterResults filterResults = new FilterResults();
                  filterResults.values = filteredUserList;
                  return filterResults;
              }

              @Override
              protected void publishResults(CharSequence constraint, FilterResults results) {

              }
          }
        }
*//*




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
*/