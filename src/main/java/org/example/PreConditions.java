package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class PreConditions {
    private WebDriver driver;

    private static final String CHROMEDRIVER_EXECUTABLE_PATH = "/src/test/resources/chromedriver";
    private static final String CHROMEDRIVER_PATH_SETTING = "webdriver.chrome.driver";

    public PreConditions(WebDriver driver) {
        this.driver = driver;
    }

    public PreConditions openPage(String url) {
        driver.get(url);
        return this;
    }

    public static WebDriver initDriver() {
        String absolutePath = System.getProperty("user.dir") + CHROMEDRIVER_EXECUTABLE_PATH;
        System.setProperty(CHROMEDRIVER_PATH_SETTING, absolutePath);
        return new ChromeDriver();
    }

    public PreConditions scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }
}
