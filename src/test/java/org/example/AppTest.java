package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AppTest {
    WebDriver browser;

    @BeforeTest
    public void preCondition() {

        System.setProperty("webdriver.chrome.driver", "d:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("https://www.rozetka.com.ua/");
        // browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterTest
    public void postCondition() {
        browser.close();

    }


    @Test
    public void searchGoods() {
        SearchProducts searchProducts = new SearchProducts(browser);
        searchProducts.fillInSearchField("Навушники Xiaomi AirDots/Earbuds Basic TWS (TWSEJ04LS)")
                .pressSearchButton()
                .pressBuyButton()
                .closeWindow();


    }

    @Test
    public void checkPrice() {
        SearchProducts searchProducts = new SearchProducts(browser);
        String actualCurrencyValue = searchProducts.CurrencyValue();
        String expectedCurrencyValue = "₴";
        Assert.assertTrue(actualCurrencyValue.contains(expectedCurrencyValue));

    }
}
