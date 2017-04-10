package org.caworks.ca1.activity.module;

import org.caworks.ca1.contract.HomePageContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gallon on 2017/4/10.
 */

@Module
public class HomePageModule {

    private HomePageContract.View view;

    public HomePageModule(HomePageContract.View view) {
        this.view = view;
    }

    @Provides
    HomePageContract.View provideHomePageContractView() {
        return view;
    }
}
