package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class AppTest {
    WebDriver browser;

    @BeforeTest
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "d:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.rozetka.com.ua/");

    }

    @AfterTest
    public void postCondition() {
        browser.close();

    }


    @Test
    public void searchGoods() {
        WebElement searchField = browser.findElement(By.xpath("//*[@name=\"search\"]"));
        searchField.sendKeys("Навушники Xiaomi AirDots/Earbuds Basic TWS (TWSEJ04LS)");

        WebElement searchButton = browser.findElement(By.xpath("//*[@role=\"search\"]/form/button"));
        searchButton.click();

        browser.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement buyElementButton = browser.findElement(By.xpath("//*[@class=\"product__buy\"]/*/button"));
        buyElementButton.click();

        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement closeButtonClick = browser.findElement(By.xpath("//*[@classmodalcontent=\"cart-modal\"]/*/div/*/button"));
        closeButtonClick.click();


    }

    @Test
    public void checkPrice() {

        WebElement searchField = browser.findElement(By.xpath("//*[@name='search']"));
        searchField.sendKeys("Мобільний телефон");

        WebElement searchButton = browser.findElement(By.xpath("//*[@role='search']/form/button"));
        searchButton.click();

        WebElement isPriceInGrivna = browser.findElement(By.xpath("//*[@class='goods-tile__price-currency']"));
        Assert.assertTrue(isPriceInGrivna.getText().contains("₴"));

    }
}
