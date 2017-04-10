package org.caworks.ca1.activity.component;

import org.caworks.ca1.ApplicationComponent;
import org.caworks.ca1.activity.MainActivity;
import org.caworks.ca1.activity.module.HomePageModule;
import org.caworks.ca1.util.ActivityScoped;

import dagger.Component;

/**
 * Created by Gallon on 2017/4/10.
 */

@ActivityScoped
@Component(modules = HomePageModule.class, dependencies = ApplicationComponent.class)
public interface HomePageComponent {

    void inject(MainActivity mainActivity);
}
