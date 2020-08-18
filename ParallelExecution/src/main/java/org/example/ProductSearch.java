package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductSearch {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");
    private final By searchField = By.xpath("//*[@name=\"search\"]");
    private final By searchButton = By.xpath("//*[@role=\"search\"]/form/button");
    private final By buyProductButton = By.xpath("//*[@class=\"product__buy\"]/*/button");
    private final By productSeller = By.className("product-seller__body");
    private final int TIME_OUT_IN_SECONDS = 30;

    public ProductSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30L);
    }

    public ProductSearch typeToSearchField(String text) {
        this.driver.findElement(this.searchField).sendKeys(text);
        return this;
    }

    public ProductSearch clickSearchButton() {
        this.driver.findElement(this.searchButton).click();
        return this;
    }

    public ProductSearch clickBuyButton() {
        this.waitForProductDetailPageToLoad();
        this.driver.findElement(this.buyProductButton).click();
        return this;
    }


    public void waitForProductDetailPageToLoad() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.productSeller));
    }

    public boolean isPriceCorrect(String currencySign) {
        List<WebElement> currencySignElements = driver.findElements(checkCurrency);
        for (WebElement currencySignElement : currencySignElements) {
            if (!currencySignElement.getText().contains(currencySign)) {
                return false;
            }
        }
        return true;
    }
}