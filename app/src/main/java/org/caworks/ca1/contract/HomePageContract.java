package org.caworks.ca1.contract;

import org.caworks.ca1.model.db.entities.minimalist.Weather;
import org.caworks.library.presenter.BasePresenter;
import org.caworks.library.view.BaseView;

/**
 * Created by Gallon on 2017/3/21.
 */

public interface HomePageContract {

    interface View extends BaseView<Presenter> {

        void displayWeatherInformation(Weather weather);
    }

    interface Presenter extends BasePresenter {

        void loadWeather(String cityId);
    }

}
