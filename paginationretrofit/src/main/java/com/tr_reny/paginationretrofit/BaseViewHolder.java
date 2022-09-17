package com.tr_reny.paginationretrofit;

/**
 * BaseViewHolder is a helper class, It responsible for manage multiple view holders in an easier way.
 * It was written a separate article on Best Practices of RecyclerView in Android
 * link --> https://androidwave.com/android-recyclerview-example-best-practices/
 * */

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    protected abstract void clear();
    public void onBind(int position) {
        mCurrentPosition = position;
        clear();
    }
    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}