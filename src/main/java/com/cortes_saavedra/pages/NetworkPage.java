package com.cortes_saavedra.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NetworkPage extends BasePage{

    //Localizadores
    private By buttonInternet = AppiumBy.androidUIAutomator("new UiSelector().text(\"Internet\")");
    private By tittleInternet = AppiumBy.accessibilityId("Internet");

    //Constructor que pasa el driver a BasePage
    public NetworkPage(AndroidDriver driver) {
        super(driver);
    }

    //Métodos
    public void enterToInternet(){
        click(buttonInternet);
    }

    public String obtenerTituloInternet() {
        return getAttribute(tittleInternet, "contentDescription");
    }
}
