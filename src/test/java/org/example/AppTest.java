package org.example;

import org.example.pages.CartPopup;
import org.example.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver browser;

    @BeforeMethod
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "d:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.rozetka.com.ua/");
    }

    @AfterMethod
    public void postCondition() {
        browser.close();
    }

    @Test
    public void searchGoods() {
        HomePage homePage = new HomePage(browser);
        CartPopup cartPopup = new CartPopup(browser);
        homePage.typeToSearchField("Навушники Xiaomi AirDots/Earbuds Basic TWS (TWSEJ04LS)")
                .clickSearchButton()
                .clickBuyButton();
        cartPopup.closePopup();
    }

    @Test
    public void checkPrice() {
        HomePage homePage = new HomePage(browser);
        homePage.typeToSearchField("Мобільний телефон")
                .clickSearchButton();
        String actualCurrencySymbol = homePage.getCurrencySymbol();
        String expectedCurrencySymbol = "₴";
        Assert.assertTrue(actualCurrencySymbol.contains(expectedCurrencySymbol));
    }
}
