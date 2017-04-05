package org.caworks.ca1.view.fragment;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.caworks.ca1.R;
import org.caworks.ca1.contract.HomePageContract;
import org.caworks.ca1.model.db.entities.minimalist.LifeIndex;
import org.caworks.ca1.model.db.entities.minimalist.Weather;
import org.caworks.ca1.model.db.entities.minimalist.WeatherForecast;
import org.caworks.ca1.view.adapter.ForecastAdapter;
import org.caworks.ca1.widget.IndicatorView;
import org.caworks.library.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Gallon on 2017/3/19.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View {

    //基本天气信息
    @BindView(R.id.cv_weather_information)
    CardView weatherInformationCardView;
    @BindView(R.id.temp_text_view)
    TextView tempTextView;
    @BindView(R.id.weather_text_view)
    TextView weatherNameTextView;
    @BindView(R.id.publish_time_text_view)
    TextView realTimeTextView;

    //AQI
    @BindView(R.id.cv_aqi)
    CardView aqiCardView;
    @BindView(R.id.tv_aqi)
    TextView aqiTextView;
    @BindView(R.id.tv_quality)
    TextView qualityTextView;
    @BindView(R.id.indicator_view_aqi)
    IndicatorView aqiIndicatorView;
    @BindView(R.id.tv_advice)
    TextView adviceTextView;
    @BindView(R.id.tv_city_rank)
    TextView cityRankTextView;

    //预报
    @BindView(R.id.forecast_recycler_view)
    RecyclerView forecastRecyclerView;

    //生活指数
    @BindView(R.id.index_card_view)
    CardView indexCardView;
    @BindView(R.id.life_index_recycler_view)
    RecyclerView lifeIndexRecyclerView;

    private OnFragmentInteractionListener onFragmentInteractionListener;

    private Unbinder unbinder;

    private Weather weather;

    private List<WeatherForecast> weatherForecasts;
    private List<LifeIndex> lifeIndices;

    private ForecastAdapter forecastAdapter;
//    private LifeIndexAdapter lifeIndexAdapter;

    private HomePageContract.Presenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {

            // TODO: 2017/3/23 0023  
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void init() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void displayWeatherInformation(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void setPresent(HomePageContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public interface OnFragmentInteractionListener {
        void updatePageTitle(String title);
    }
}
