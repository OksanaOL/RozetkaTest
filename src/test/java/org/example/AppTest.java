package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class AppTest {
    WebDriver browser;
    private String baseURI = System.getenv("baseURI");

    @BeforeTest
    public void startWebPage() {
        if (baseURI == null) {
            baseURI = "https://google.com.ua";
        }
        browser = PreConditions.initWebDriver();
        PreConditions preConditions = new PreConditions(browser);
        preConditions.openPage(baseURI)
                .scrollPage();
    }

    @Test
    public void searchGoods() {
        CurrencySymbolCheck currencySymbolCheck = new CurrencySymbolCheck(this.browser);
        currencySymbolCheck.typeToSearchField("Навушники Xiaomi AirDots/Earbuds Basic TWS (TWSEJ04LS)")
                .clickSearchButton()
                .clickBuyButton()
                .openPopup()
                .increaseAmount()
                .closePopup();
    }

    @Test
    public void checkPrice() {
        CurrencySymbolCheck currencySymbolCheck = new CurrencySymbolCheck(this.browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(currencySymbolCheck.isPriceCorrect(expectedcurrencySymbol));
    }
}




