package com.cortes_saavedra.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    //Localizadores
    private By locatorSearchBar = AppiumBy.id("com.android.settings:id/search_action_bar");
    private By locatorKeyboard = AppiumBy.id("com.google.android.settings.intelligence:id/open_search_view_edit_text");
    private String inputSearchText = "battery";
    private By firstResult = AppiumBy.androidUIAutomator("new UiSelector().text(\"Battery\").instance(0)");

    //Constructor-es

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    //Métodos
    public void clickOnSearchBar() {
        click(locatorSearchBar);
    }
    //método para seleccionar teclado y escribir
    public void selectKeyboard() {
        click(locatorKeyboard);
        type(locatorKeyboard, inputSearchText);
    }

    public String getTitleBattery() {
        return getText(firstResult);
    }
}
