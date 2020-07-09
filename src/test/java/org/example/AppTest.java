package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.PreConditions.initDriver;

public class AppTest {
    WebDriver browser;
    private String baseURI = System.getenv("baseURI");

    @BeforeTest
    public void startWebPage() {
        if(baseURI == null) {
            baseURI = "https://www.rozetka.com.ua/";
        }
        browser = initDriver();
        PreConditions preConditions = new PreConditions(browser);
        preConditions.openPage(baseURI)
                .scrollPage();
    }

    @Test
    public void checkPrice() {
        CurrencySymbolCheck currencySymbolCheck = new CurrencySymbolCheck(browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(currencySymbolCheck.isPriceCorrect(expectedcurrencySymbol));
    }
}
