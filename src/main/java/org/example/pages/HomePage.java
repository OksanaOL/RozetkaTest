package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final By searchField = By.xpath("//*[@name=\"search\"]");
    private final By searchButton = By.xpath("//*[@role=\"search\"]/form/button");
    private final By currencySymbol = By.xpath("/*[@class='goods-tile__price-currency']");
    private final By buyProductButton = By.xpath("///*[@class=\"product__buy\"]/*/button");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage typeToSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public HomePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public HomePage clickBuyButton() {
        driver.findElement(buyProductButton).click();
        return this;
    }

    public String getCurrencySymbol() {
        return driver.findElement(currencySymbol).getText();
    }

}
