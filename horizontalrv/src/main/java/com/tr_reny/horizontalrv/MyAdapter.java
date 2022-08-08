package com.tr_reny.horizontalrv;

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

public class MyAdapter<S, V, B> extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private Context mContext;
    private List<Marvel> marvelList;

    public MyAdapter(Context mContext, List<Marvel> marvelList, RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.mContext = mContext;
        this.marvelList = marvelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(marvelList.get(position).getName());

//        holder.realName.setText(marvelList.get(position).getRealname());

        //Adding Glide Library to display the images

        Glide.with(mContext)
                .load(marvelList.get(position).getImageurl())
                .into(holder.imageViewUrl);
    /*    //attaching on Click Listener
        holder.imageViewUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, marvelList.get(position), Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return marvelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView realName;
        ImageView imageViewUrl;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            name = itemView.findViewById(R.id.tvTitle);
//            realName= itemView.findViewById(R.id.textViewRealName);
            imageViewUrl = itemView.findViewById(R.id.imageView);

            //item on ClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }

                }
            });

        }
    }
}
