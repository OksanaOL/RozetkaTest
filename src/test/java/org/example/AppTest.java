package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver browser;
    private final String rozetkaUrl = "https://www.rozetka.com.ua/";

    @BeforeTest
    public void startWebPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\AQA_2020\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        PreConditions preConditions = new PreConditions(browser);
        preConditions.openPage(rozetkaUrl)
                .scrollPage();
    }

    @Test
    public void checkPrice() {
        CurrencySymbolCheck currencySymbolCheck = new CurrencySymbolCheck(browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(currencySymbolCheck.isPriceCorrect(expectedcurrencySymbol));

    }
}
