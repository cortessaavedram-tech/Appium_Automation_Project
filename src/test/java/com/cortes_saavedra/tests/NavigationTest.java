package com.cortes_saavedra.tests;

import com.cortes_saavedra.base.BaseTest;
import com.cortes_saavedra.pages.NetworkPage;
import com.cortes_saavedra.pages.SearchPage;
import com.cortes_saavedra.pages.SettingsPage;
import com.cortes_saavedra.pages.WifiPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NavigationTest extends BaseTest {

    @Test
    public void testSettings(){
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEnNetwork();
        //Assertion
        String textoReal = settingsPage.obtenerTitulo();
        Assert.assertEquals(textoReal, "Network & internet", "Error, no se entró en menú Network & internet");

        NetworkPage networkPage = new NetworkPage(driver);
        networkPage.enterToInternet();
        //Assertion
        String textoInternet = networkPage.obtenerTituloInternet();
        Assert.assertEquals(textoInternet, "Internet", "Error, no se entró en menú Internet." );

        System.out.println("Driver cerrado");
    }

    @Test
    public void testSearchFunctionality() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickOnSearchBar();
        searchPage.selectKeyboard();
        //Assertion
        String resultTitle = searchPage.getTitleBattery();
        Assert.assertEquals(resultTitle, "Battery");
    }

    @Test
    public void testSwitchWifi(){
        WifiPage wifiPage = new WifiPage(driver);
        wifiPage.clickToNetworkInternet();
        wifiPage.enterToInternet();
        wifiPage.switchInternet();
        //Assertion
        String resultStateSwitch = wifiPage.getSwitchInternet();
        Assert.assertEquals(resultStateSwitch, "false");
    }

    @Test
    public void testScrollToAboutEmulatedDevice() {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.scrollToText("About emulated device");
    }

}

