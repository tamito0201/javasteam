package pl.l7ssha.javasteam.utils.deserializers;

// pl.l7ssha.javasteam.storefront.models.store
//
// Date created: 01 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import com.google.gson.*;
import pl.l7ssha.javasteam.storefront.RichSteamGame;

import java.lang.reflect.Type;

import static pl.l7ssha.javasteam.utils.Utils.deserializeObjectWithCancer;

public class SteamGameDeserializer implements JsonDeserializer<RichSteamGame> {

    @Override
    public RichSteamGame deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement firstData = deserializeObjectWithCancer(json);

        return new Gson().fromJson(firstData, RichSteamGame.class);
    }
}
