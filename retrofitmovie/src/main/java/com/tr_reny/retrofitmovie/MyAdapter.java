package com.tr_reny.retrofitmovie;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context mContext;
    private List<Marvel>marvelList;

    public MyAdapter(Context mContext, List<Marvel> marvelList) {
        this.mContext = mContext;
        this.marvelList = marvelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.marvel_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(marvelList.get(position).getName());
        holder.realName.setText(marvelList.get(position).getRealname());

        //Adding Glide Library to display the images

        Glide.with(mContext)
                .load(marvelList.get(position).getImageurl())
                .into(holder.imageViewUrl);

    }

    @Override
    public int getItemCount() {
        return marvelList.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView realName;
        ImageView imageViewUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewName);
            realName= itemView.findViewById(R.id.textViewRealName);
            imageViewUrl = itemView.findViewById(R.id.imageViewUrl);

        }
    }
}
