package com.cortes_saavedra.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.ScheduledExecutorService;

public class WifiPage extends BasePage{
    //Localizadores
    private By buttonNetworkInternet = AppiumBy.androidUIAutomator("new UiSelector().text(\"Network & internet\")");
    private By buttonInternet = AppiumBy.androidUIAutomator("new UiSelector().text(\"Internet\")");
    private By buttonSwitchInternet = AppiumBy.id("com.android.settings:id/switchWidget");

    //Constructor
    public WifiPage(AndroidDriver driver) {
        super(driver);
    }

    //Métodos
    public void clickToNetworkInternet(){
        click(buttonNetworkInternet);
    }

    public void enterToInternet(){
        click(buttonInternet);
    }

    public void switchInternet(){
        click(buttonSwitchInternet);
    }

    public String getSwitchInternet(){
        return getAttribute(buttonSwitchInternet, "checked");
    }

}
