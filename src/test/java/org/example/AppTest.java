package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
                .closePopup()
                .hoverMouseToShowMinicart();
    }

    @Test
    public void checkPrice() {
        CurrencySymbolCheck currencySymbolCheck = new CurrencySymbolCheck(this.browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(currencySymbolCheck.isPriceCorrect(expectedcurrencySymbol));
    }
}




