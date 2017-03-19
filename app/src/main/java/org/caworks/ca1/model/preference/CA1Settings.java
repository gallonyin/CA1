package org.caworks.ca1.model.preference;

/**
 * Created by gallon on 17-3-19.
 */
public enum CA1Settings {

    /* default config */
    SETTINGS_FIRST_USE("first_use", true),

    SETTINGS_CURRENT_CITY_ID("current_city_id", "");

    private final String mId;
    private final Object mDefaultValue;

    CA1Settings(String id, Object defaultValue) {
        this.mId = id;
        this.mDefaultValue = defaultValue;
    }

    public String getmId() {
        return this.mId;
    }

    public Object getmDefaultValue() {
        return this.mDefaultValue;
    }

    public static CA1Settings fromId(String id) {
        CA1Settings[] values = values();
        for (CA1Settings value : values) {
            if (value.mId.equals(id)) {
                return value;
            }
        }
        return null;
    }
}
