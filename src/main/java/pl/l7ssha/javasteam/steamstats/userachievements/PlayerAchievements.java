package pl.l7ssha.javasteam.steamstats.userachievements;

// pl.l7ssha.javasteam.steamstats.userachievements
//
// Date created: 07 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import pl.l7ssha.javasteam.steamuser.ISteamUser;
import pl.l7ssha.javasteam.steamuser.SteamUser;
import pl.l7ssha.javasteam.steamuser.Userable;

import java.util.Iterator;
import java.util.List;

public class PlayerAchievements implements Userable, Iterable<PlayerAchievement> {
    private long steamID;
    private String gameName;

    private List<PlayerAchievement> achievements;

    public PlayerAchievements() { }

    public long getSteamID() {
        return steamID;
    }

    public String getGameName() {
        return gameName;
    }

    public List<PlayerAchievement> getAchievements() {
        return achievements;
    }

    @Override
    public ISteamUser getSteamUser() {
        return new SteamUser(steamID);
    }

    @Override
    public Iterator<PlayerAchievement> iterator() {
        return achievements.iterator();
    }
}