package org.caworks.ca1.presenter.component;

import org.caworks.ca1.ApplicationModule;
import org.caworks.ca1.presenter.HomePagePresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gallon on 2017/4/10.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface PresenterComponent {

    void injcet(HomePagePresenter presenter);

//    void inject(SelectCit)
}
