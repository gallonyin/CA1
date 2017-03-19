package org.caworks.ca1;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gallon on 2017/3/18
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    CA1App getApplication();

    Context getContext();

}
