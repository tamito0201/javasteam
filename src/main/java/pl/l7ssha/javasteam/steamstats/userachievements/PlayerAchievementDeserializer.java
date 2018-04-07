package pl.l7ssha.javasteam.steamstats.userachievements;

import com.google.gson.*;
import pl.l7ssha.javasteam.utils.Utils;

import java.lang.reflect.Type;
import java.util.Date;

// pl.l7ssha.javasteam.steamstats.userachievements
//
// Date created: 07 Apr 2018
// Author: Szymon 'l7ssha' Uglis
// Free for open source use, all changes send back to author
public class PlayerAchievementDeserializer implements JsonDeserializer<PlayerAchievement> {

    @Override
    public PlayerAchievement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject base = json.getAsJsonObject();

        String apiName = base.get("apiname").getAsString();
        boolean achieved = base.get("achieved").getAsInt() == 1;
        Date unlockTime = Utils.timestampToDate(base.get("unlocktime").getAsLong());
        String name = base.get("name").getAsString();
        String description = base.get("description").getAsString();

        return new PlayerAchievement(apiName, achieved, unlockTime, name, description);
    }
}
