package com.tr_reny.retrofitnestedjson;

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
    private ArrayList<IBM> ibmArrayList;

    public MyAdapter(Context mContext, ArrayList<IBM> ibmArrayList) {
        this.mContext = mContext;
        this.ibmArrayList = ibmArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(ibmArrayList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return ibmArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           title= itemView.findViewById(R.id.textViewTitle);

        }
    }
}
