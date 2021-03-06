package pl.l7ssha.javasteam.storefront;

// pl.l7ssha.javasteam.storefront
//
// Date created: 22 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import com.google.gson.annotations.SerializedName;
import pl.l7ssha.javasteam.storefront.news.News;
import pl.l7ssha.javasteam.storefront.steamgame.CurrentPlayers;

import java.util.concurrent.CompletableFuture;

import static pl.l7ssha.javasteam.utils.Links.currentPlayersUrl;
import static pl.l7ssha.javasteam.utils.Links.newsForApp;
import static pl.l7ssha.javasteam.utils.ResponserUtils.getGenericResponse;

public class SteamGame {
	@SerializedName("steam_appid")
	protected long appId;

	protected SteamGame() {
	}
	public SteamGame(long appId) {
		this.appId = appId;
	}

	public long getAppId() {
		return appId;
	}

	public News getNews(int count) {
		return getGenericResponse(String.format(newsForApp, appId, count), News.class);
	}

	public CompletableFuture<News> getNewsAsync(String id, int count) {
		return CompletableFuture.supplyAsync(() -> getNews(count));
	}

	public CurrentPlayers getCurrentPlayers() {
		return getGenericResponse(String.format(currentPlayersUrl, appId), CurrentPlayers.class);
	}

	public CompletableFuture<CurrentPlayers> getCurrentPlayersAsync() {
		return CompletableFuture.supplyAsync(this::getCurrentPlayers);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof SteamGame)
			return this.getAppId() == ((SteamGame) o).getAppId();

		return false;
	}

	@Override
	public String toString() {
		return String.format("%s", this.appId);
	}
}
