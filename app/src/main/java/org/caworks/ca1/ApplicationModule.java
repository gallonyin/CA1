package org.caworks.ca1;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gallon on 2017/3/19.
 */

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    CA1App provideApplication() {
        return (CA1App) context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }
}
