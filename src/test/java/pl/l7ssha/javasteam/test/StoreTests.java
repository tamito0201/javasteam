package pl.l7ssha.javasteam.test;

// pl.l7ssha.javasteam.test
//
// Date created: 01 Apr 2018
// Author: Szymon 'l7ssha' Uglis

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.l7ssha.javasteam.SteamAPI;
import pl.l7ssha.javasteam.StoreFrontService;
import pl.l7ssha.javasteam.storefront.*;
import pl.l7ssha.javasteam.storefront.gamelist.GameList;
import pl.l7ssha.javasteam.storefront.gamelist.GameListQuery;
import pl.l7ssha.javasteam.storefront.gameuptodate.IGameVersion;
import pl.l7ssha.javasteam.storefront.news.News;
import pl.l7ssha.javasteam.storefront.steamgame.CurrentPlayers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTests {
    static StoreFrontService storeFrontService;

    @BeforeAll
    static void getToken() throws IOException {
        String token = System.getenv("STEAM_TOKEN");
        storeFrontService = new SteamAPI(token).getService(StoreFrontService.class);
    }

    @Test
    void getRichGameInfo() {
        RichSteamGame csgo = storeFrontService.getFullInfoOfApp("730");

        assertNotNull(csgo);
        assertNotNull(csgo.getGenres().get(0).getDescription());
        assertNotNull(csgo.getDetailedDescription());
        assertTrue(csgo.getMetacritic().getScore() > 0);
        assertNotNull(csgo.getLinuxRequirements().getMinimum());
    }

    @Test
    void getBaseGameInfo() {
        LiteSteamGame csgo = storeFrontService.getBaseInfoOfApp("730");

        assertNotNull(csgo);
        assertNotNull(csgo.getType());
        assertNotNull(csgo.getType());
        assertNotNull(csgo.getReleaseDate().getDate());
        assertNotNull(csgo.getPublishers().get(0));
    }

    @Test
    void getCurrentPlayers() {
        LiteSteamGame dota2 = storeFrontService.getBaseInfoOfApp("570");

        CurrentPlayers currentPlayersDota2 = dota2.getCurrentPlayers();

        assertNotNull(currentPlayersDota2);
        assertTrue(currentPlayersDota2.getCount() > 200000);
    }

    @Test
    void getStoreFeatured() {
        StoreFeatured featured = storeFrontService.getStoreFeatured();

        assertNotNull(featured.getFeaturedLinux());
        assertNotNull(featured.getLargeCapsules());

        assertNotNull(featured.getFeaturedMac().get(0).getHeaderImage());
        assertNotNull(featured.getFeaturedWin().get(2).getCurrency());
    }

    //Disable for now
    /*
    @Test
    void getStoreFeaturedCategories() {
        StoreFeaturedCategories featuredCategories = storeFrontService.getStoreFeaturedCategories();

        assertNotNull(featuredCategories.getFirst().getName());
        assertNotNull(featuredCategories.getFirst().getSpotlightItems().get(0).getName());
    }
    */
    
    @Test
    void packageTest() {
        StorePackage randomPackage = storeFrontService.getStorePackageInfo("253662");

        assertNotNull(randomPackage.getReleaseDate().getDate());
        //System.out.println(randomPackage.getReleaseDate().getDate());

        //assertNotNull(randomPackage.getControllerSupport());
        // System.out.println(randomPackage.getControllerSupport());
        assertNotNull(randomPackage.getPrice().getCurrency());
        assertNotNull(randomPackage.getApps());
    }

    @Test
    void gameEqualsTest() {
        RichSteamGame richGame = storeFrontService.getFullInfoOfApp("730");
        LiteSteamGame liteGame= storeFrontService.getBaseInfoOfApp("730");

        assertEquals(richGame, liteGame);
    }

    @Test
    void searchStoreTest() {
        GameList list = storeFrontService.searchStore(new GameListQuery().setAppid(730).setMaxResults(5));

        assertNotNull(list.getApps());
        assertTrue(list.isHaveMoreResults());

        assertNotNull(list.getApps().get(2).getLastModified());

        assertEquals(5, list.getApps().size());
    }

    @Test
    void searchStoreTestAsync() throws ExecutionException, InterruptedException {
        GameList list = storeFrontService.searchStoreAsync(new GameListQuery().setMaxResults(15)).get();

        assertNotNull(list.getApps());
        assertTrue(list.isHaveMoreResults());
    }

    @Test
    void newsTest() {
        NamedSteamGame tf2 = storeFrontService.getBaseInfoOfApp("440");
        News tf2News = tf2.getNews(5);

        assertNotNull(tf2News);
        assertNotNull(tf2News.getNews().get(1).getDate());
        assertEquals(5, tf2News.getNews().size());
    }

    @Test
    void checkGameVersionTest() {
        IGameVersion dotaVer = storeFrontService.checkGameVersion("570", "7.14");

        assertTrue(dotaVer.isUpToDate());
        assertNull(dotaVer.getMessage());
    }
}

