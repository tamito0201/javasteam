package pl.l7ssha.javasteam.steamstats.userachievements;

// pl.l7ssha.javasteam.steamstats.userachievements
//
// Date created: 07 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import java.util.Date;

public class PlayerAchievement {
    private String apiName;
    private boolean achieved;
    private Date unlockTime;
    private String name;
    private String description;

    public PlayerAchievement(String apiName, boolean achieved, Date unlockTime, String name, String desciption) {
        this.apiName = apiName;
        this.achieved = achieved;
        this.unlockTime = unlockTime;
        this.name = name;
        this.description = desciption;
    }

    /**
     * Internal name of achievement
     * @return String with name
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * True if achievement completed.
     * @return Boolean
     */
    public boolean isAchieved() {
        return achieved;
    }

    /**
     * Date when achievement was unlocked
     * @return Date object
     */
    public Date getUnlockTime() {
        return unlockTime;
    }

    /**
     * Public name of achievement
     * @return String with name
     */
    public String getName() {
        return name;
    }

    /**
     * Description of achievement (Secondary text in which is written how to obtain achievement)
     * @return Description String
     */
    public String getDescription() {
        return description;
    }
}
