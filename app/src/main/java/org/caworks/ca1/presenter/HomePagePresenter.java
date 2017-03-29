package org.caworks.ca1.presenter;

import android.content.Context;

import org.caworks.ca1.contract.HomePageContract;
import org.caworks.ca1.model.db.dao.WeatherDao;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/3/24 0024.
 */

public class HomePagePresenter implements HomePageContract.Presenter {

    private final Context context;
    private final HomePageContract.View weatherView;

    private final CompositeSubscription subscription;

    @Inject
    WeatherDao weatherDao;

    public HomePagePresenter(Context context, HomePageContract.View weatherView) {

        this.context = context;
        this.weatherView = weatherView;
        this.subscription = new CompositeSubscription();
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadWeather(String cityId) {

    }
}
