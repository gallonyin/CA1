package org.caworks.ca1.model.preference;

/**
 * Created by gallon on 17-3-19.
 */

public interface ConfigurationListener {

    void onConfigurationChanged(CA1Settings pref, Object newValue);

}
