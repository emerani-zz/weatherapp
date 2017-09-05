package com.ezraerani.weatherappc4q;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezraerani.weatherappc4q.responsemodels.Period;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ezraerani on 9/5/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PeriodViewHolder> {

    private List<Period>  periods;
    MainActivity mainActivity;

    public RecyclerViewAdapter(List<Period> periods, MainActivity mainActivity) {
        this.periods = periods;
        this.mainActivity = mainActivity;
    }

    @Override
    public PeriodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.period_viewholder, parent, false);
        return new PeriodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeriodViewHolder holder, int position) {
        Period period = periods.get(position);

        holder.date.setText(period.getDateTimeISO().substring(0, 10));
        String minTemp = mainActivity.getString(R.string.low);
        String maxTemp = mainActivity.getString(R.string.high);

        if (mainActivity.isFahrenheit()) {
            String units = mainActivity.getString(R.string.degrees_F);
            minTemp += period.getMinTempF() + units;
            maxTemp += period.getMaxTempF() + units;

        } else {
            String units = mainActivity.getString(R.string.degrees_C);
            minTemp += period.getMinTempC() + units;
            maxTemp += period.getMaxTempC() + units;
        }

        holder.minTemp.setText(minTemp);
        holder.maxTemp.setText(maxTemp);
        holder.icon.setImageBitmap(getImage(period.getIcon()));
    }

    public Bitmap getImage(String name) {

        AssetManager manager = mainActivity.getAssets();
        try {
            InputStream stream = manager.open("icons/" + name);
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return periods.size();
    }

    public class PeriodViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        ImageView icon;
        TextView maxTemp;
        TextView minTemp;

        public PeriodViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            icon = (ImageView) itemView.findViewById(R.id.iconView);
            maxTemp = (TextView) itemView.findViewById(R.id.maxTemp);
            minTemp = (TextView) itemView.findViewById(R.id.minTemp);
        }
    }
}
