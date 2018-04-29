package pl.l7ssha.javasteam.storefront;

// pl.l7ssha.javasteam.storefront
//
// Date created: 01 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import com.google.gson.annotations.SerializedName;
import pl.l7ssha.javasteam.storefront.steamgame.ControllerSupport;
import pl.l7ssha.javasteam.storefront.steamgame.Requirements;
import pl.l7ssha.javasteam.storefront.steamgame.SupportInfo;
import pl.l7ssha.javasteam.storefront.steamgame.achievements.Achievements;
import pl.l7ssha.javasteam.storefront.store.*;
import pl.l7ssha.javasteam.storefront.store.storevideo.StoreVideo;

import java.util.List;

public class RichSteamGame extends LiteSteamGame {
    @SerializedName("required_age")
    private int RequiredAge;

    @SerializedName("is_free")
    private boolean isFree;

    @SerializedName("controller_support")
    private ControllerSupport controllerSupport;

    @SerializedName("detailed_description")
    private String detailedDescription;

    @SerializedName("about_the_game")
    private String aboutTheGame;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("supported_languages")
    private String supportedLanguages;

    @SerializedName("header_image")
    private String headerImage;

    private String website;

    @SerializedName("pc_requirements")
    private Requirements pcRequirements;

    @SerializedName("mac_requirements")
    private Requirements macRequirements;

    @SerializedName("linux_requirements")
    private Requirements linuxRequirements;

    private List<Integer> packages;

    @SerializedName("package_groups")
    private List<PackageGroup> packageGroups;

    private Metacritic metacritic;
    private List<StoreCategory> categories;
    private List<StoreGenre> genres;

    private List<StoreScreenshot> screenshots;
    private List<StoreVideo> movies;
    private Recommendations recommendations;
    private Achievements achievements;

    @SerializedName("support_info")
    private SupportInfo supportInfo;

    private String background;

    public RichSteamGame() { }

    public int getRequiredAge() {
        return RequiredAge;
    }

    public boolean isFree() {
        return isFree;
    }

    public ControllerSupport getControllerSupport() {
        return controllerSupport;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public String getAboutTheGame() {
        return aboutTheGame;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getSupportedLanguages() {
        return supportedLanguages;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public String getWebsite() {
        return website;
    }

    public Requirements getPcRequirements() {
        return pcRequirements;
    }

    public Requirements getMacRequirements() {
        return macRequirements;
    }

    public Requirements getLinuxRequirements() {
        return linuxRequirements;
    }

    public List<Integer> getPackages() {
        return packages;
    }

    public List<PackageGroup> getPackageGroups() {
        return packageGroups;
    }

    public Metacritic getMetacritic() {
        return metacritic;
    }

    public List<StoreCategory> getCategories() {
        return categories;
    }

    public List<StoreGenre> getGenres() {
        return genres;
    }

    public List<StoreScreenshot> getScreenshots() {
        return screenshots;
    }

    public List<StoreVideo> getMovies() {
        return movies;
    }

    public Recommendations getRecommendations() {
        return recommendations;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public SupportInfo getSupportInfo() {
        return supportInfo;
    }

    public String getBackground() {
        return background;
    }
}