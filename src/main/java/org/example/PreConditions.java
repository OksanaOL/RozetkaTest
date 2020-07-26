package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PreConditions {
    private WebDriver driver;


    public PreConditions(WebDriver driver) {
        this.driver = driver;
    }

    public PreConditions() {
        this.driver = initWebDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public PreConditions openPage(String url) {
        driver.get(url);
        return this;
    }

    public static WebDriver initWebDriver() {
        WebDriverManager.chromedriver().version("83.0.4103.39").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


    public PreConditions scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }
}
