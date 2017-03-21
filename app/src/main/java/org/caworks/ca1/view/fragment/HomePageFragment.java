package org.caworks.ca1.view.fragment;

import android.content.Context;

import org.caworks.ca1.contract.HomePageContract;
import org.caworks.ca1.model.db.entities.minimalist.Weather;
import org.caworks.library.fragment.BaseFragment;

/**
 * Created by Gallon on 2017/3/19.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View {

    private HomePageContract.Presenter presenter;
    private Weather weather;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void init() {

    }

    @Override
    public void displayWeatherInformation(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void setPresent(HomePageContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
