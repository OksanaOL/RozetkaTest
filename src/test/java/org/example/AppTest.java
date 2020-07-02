package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class AppTest {
    WebDriver browser;

    @BeforeTest
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "d:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("https://www.rozetka.com.ua/");
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Test
    public void checkPrice() {
        CurrencySymbol_Check currencySymbol_check = new CurrencySymbol_Check(browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(currencySymbol_check.isPriceCorrect(expectedcurrencySymbol));

    }
}
