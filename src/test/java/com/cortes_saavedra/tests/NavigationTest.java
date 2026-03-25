package com.cortes_saavedra.tests;

import com.cortes_saavedra.base.BaseTest;
import com.cortes_saavedra.pages.NetworkPage;
import com.cortes_saavedra.pages.SearchPage;
import com.cortes_saavedra.pages.SettingsPage;
import com.cortes_saavedra.pages.WifiPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class NavigationTest extends BaseTest {

    @Test
    public void testSettings() {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEnNetwork();
        //Assertion
        String textoReal = settingsPage.obtenerTitulo();
        Assert.assertEquals(textoReal, "Network & internet", "Error, no se entró en menú Network & internet");

        NetworkPage networkPage = new NetworkPage(driver);
        networkPage.enterToInternet();
        //Assertion
        String textoInternet = networkPage.obtenerTituloInternet();
        Assert.assertEquals(textoInternet, "Internet", "Error, no se entró en menú Internet.");

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
    public void testSwitchWifi() {
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
        settingsPage.click(AppiumBy.androidUIAutomator("new UiSelector().text(\"About emulated device\")"));
    }

    @Test
    public void testHandleWebContext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.getContextHandles().size() > 1);

        Set<String> contextos = driver.getContextHandles();
        for (String contexto : contextos) {
            System.out.println("Contexto encontrado: " + contexto);

            //Si queremos cambiar automáticamente al WebView cuando aparezca
            if (contexto.contains("CHROMIUM")) {
                driver.context(contexto);
                System.out.println("Cambiado con éxito al contexto: " + contexto);
            }
        }
    }

    @Test
    public void testInteraccionWebReal() throws InterruptedException {
        //Abrir URL directamente
        driver.get("https://www.ifp.es");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.context("NATIVE_APP");

        //Interactuamos con cookies en modo nativo
        try {
            WebElement botonAceptar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@text=\"ACEPTAR\"]")));
            botonAceptar.click();
           System.out.println("Cookies aceptadas correctamente.");
        } catch (Exception e) {
           System.out.println("No se detectó banner de cookies, seguimos...");
        }

        //Espera explícita
        wait.until(d -> driver.getContextHandles().contains("CHROMIUM"));

        //PointerInput
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        //Coordenadas (centro de la pantalla hacia arriba)
        int startX = 500; //mitad de la pantalla aprox
        int startY = 1500; //punto bajo
        int endY = 500; //punto alto

        //Construimos el movimiento
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        //Ejecutamos la acción
        driver.perform(Arrays.asList(scroll));
        System.out.println("Scrolling nativo realizado con éxito.");

        boolean encontrado = false;
        for (int i = 0; i <6 ; i++) {
            try {
                driver.context("CHROMIUM");
                WebElement botonIfpOnline = new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Online")));
                botonIfpOnline.click();
                encontrado = true;
                System.out.println("Botón encontrado y clicado");
                break;

            } catch (Exception e) {
                System.out.println("Buscando...intento de scroll");
                driver.context("NATIVE_APP");
                driver.perform(Arrays.asList(scroll));
                Thread.sleep(800);
            }

        }




    }
}









