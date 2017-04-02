package org.caworks.ca1.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.caworks.ca1.R;
import org.caworks.ca1.model.db.entities.minimalist.WeatherForecast;
import org.caworks.library.adapter.BaseRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Gallon on 2017/3/30.
 */

public class ForecastAdapter extends BaseRecyclerViewAdapter {

    private List<WeatherForecast> weatherforecasts;

    public ForecastAdapter(List<WeatherForecast> weatherForecasts) {
        this.weatherforecasts = weatherForecasts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.week_text_view)
        TextView weekTextView;
        @BindView(R.id.weather_icon_image_view)
        ImageView weatherIconImageView;
        @BindView(R.id.temp_max_text_view)
        TextView tempMaxTextView;
        @BindView(R.id.temp_min_text_view)
        TextView tempMinTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
