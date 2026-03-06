package com.cortes_saavedra.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsPage  extends BasePage{

    //Localizadores
    private By botonNetwork = AppiumBy.androidUIAutomator("new UiSelector().text(\"Network & internet\")");
    private By tituloNetwork = AppiumBy.accessibilityId("Network & internet");

    //Constructor para recibir el driver del test
    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    //Métodos
    public void clickEnNetwork(){
        click(botonNetwork);
    }

    public String obtenerTitulo(){
        return getAttribute(tituloNetwork, "contentDescription");
    }

}
