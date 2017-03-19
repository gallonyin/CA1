package org.caworks.ca1.model.preference;

import org.caworks.ca1.CA1App;
import org.caworks.library.util.GLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gallon on 17-3-19.
 */

public class PreferenceHelper {

    private static final String SETTING_FILENAME = CA1App.class.getPackage().getName();

    private static final List<ConfigurationListener> CONFIGURATION_LISTENERS = Collections.synchronizedList(new ArrayList<ConfigurationListener>());

    private PreferenceHelper() {
        super();
    }

    public static void loadDefaults() {
        //SharedPreference defaultValue
        try {
            Map<CA1Settings, Object> defaultPrefers = new HashMap<>();
            CA1Settings[] values = CA1Settings.values();
            for (CA1Settings value : values) {
                defaultPrefers.put(value, value.getmDefaultValue());
            }
//            savePreferences(defaultPrefers, true);
        } catch (Exception e) {
            GLog.e("Save default settings fails");
        }
    }
}
