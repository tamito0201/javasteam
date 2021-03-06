package pl.l7ssha.javasteam.schema;

// pl.l7ssha.javasteam.schema
//
// Date created: 06 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import com.google.gson.annotations.SerializedName;

public class SchemaStat {
    private String name;

    @SerializedName("defaultValue")
    private int defaultValue;

    private String displayName;

    public SchemaStat() { }

    /**
     * Internal stat name
     * @return String with name
     */
    public String getName() {
        return name;
    }

    /**
     * Default stat value. 0 in most cases.
     * @return Integer with value
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    /**
     * Stat name displayed to public
     * @return String with name
     */
    public String getDisplayName() {
        return displayName;
    }
}
