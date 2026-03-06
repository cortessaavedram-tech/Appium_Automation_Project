package com.cortes_saavedra.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void configuration() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.android.settings");
        options.setAppActivity(".Settings");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            System.out.println("Sesión de Appium finalizada correctamente.");
        }
    }
}
