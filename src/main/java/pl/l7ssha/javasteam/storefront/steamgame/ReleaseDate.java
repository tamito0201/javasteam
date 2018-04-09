package pl.l7ssha.javasteam.storefront.steamgame;

// pl.l7ssha.javasteam.storefront.models.steamgame
//
// Date created: 01 Apr 2018
// Author: Szymon 'l7ssha' Uglis
// Free for open source use, all changes send back to author

import com.google.gson.annotations.SerializedName;

public class ReleaseDate {
    @SerializedName("coming_soon")
    private boolean comingSoon;

    @SerializedName("date")
    private String date;
    //private Date date;

    public ReleaseDate() { }

    public boolean isComingSoon() {
        return comingSoon;
    }

    public String getDate() {
        return date;
    }
}