package org.caworks.ca1.view.fragment;

import android.content.Context;

import org.caworks.ca1.R;
import org.caworks.ca1.contract.HomePageContract;
import org.caworks.ca1.model.db.entities.minimalist.Weather;
import org.caworks.library.fragment.BaseFragment;

import butterknife.Unbinder;

/**
 * Created by Gallon on 2017/3/19.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View {

    private HomePageContract.Presenter presenter;
    private Weather weather;

    private Unbinder unbinder;

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
