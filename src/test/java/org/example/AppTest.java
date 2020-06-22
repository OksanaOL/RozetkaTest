package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class AppTest {
    @Test
    public void RozetkaTest() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "d:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver browser = new ChromeDriver(capabilities);
        browser.get("https://www.rozetka.com.ua/");

        WebElement searchField = browser.findElement(By.xpath("//*[@name=\"search\"]"));
        searchField.sendKeys("Навушники Xiaomi AirDots/Earbuds Basic TWS (TWSEJ04LS)");

        WebElement searchButton = browser.findElement(By.xpath("//*[@role=\"search\"]/form/button"));
        searchButton.click();

        browser.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement buyElementButton = browser.findElement(By.xpath("//*[@class=\"product__buy\"]/*/button"));
        buyElementButton.click();

        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement closeButtonClick = browser.findElement(By.xpath("//*[@classmodalcontent=\"cart-modal\"]/*/div/*/button"));
        closeButtonClick.click();

    }
}