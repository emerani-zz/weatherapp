package com.ezraerani.weatherappc4q;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ezraerani on 9/5/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PeriodViewHolder> {

    public RecyclerViewAdapter() {
    }

    @Override
    public PeriodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PeriodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PeriodViewHolder extends RecyclerView.ViewHolder {

        public PeriodViewHolder(View itemView) {
            super(itemView);
        }
    }
}
