package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PreConditions {
    private WebDriver driver;

    public PreConditions(WebDriver driver) {
        this.driver = driver;
    }

    public PreConditions openPage(String url) {
        driver.get(url);
        return this;
    }

    public PreConditions scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }
}
