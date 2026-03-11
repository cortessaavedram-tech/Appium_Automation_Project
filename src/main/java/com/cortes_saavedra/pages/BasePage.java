package com.cortes_saavedra.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    //Constructor para la espera explícita

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        //Definimos una espera de 10 sec para todo el framework
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Método genérico para hacer click
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    //Método genérico para obtener texto
    public String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    //Método para obtener atributos del DOM
    public String getAttribute(By locator, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getDomAttribute(attribute);
    }

    //Método para escribir
    public void type(By locator, String text) {
        waitForElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    //Método para hacer scroll
    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"" + text + "\"));"
        ));
    }


}
