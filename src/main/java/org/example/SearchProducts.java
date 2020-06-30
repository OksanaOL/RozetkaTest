package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProducts {

    private final By searchField = By.xpath("//*[@name='search']");
    private final By findButton = By.xpath("//*[@role='search']/form/button");
    private final By buyElementButton = By.xpath("//*[@class='product__buy']/*/button");
    private final By closeButtonClick = By.xpath("//*[@classmodalcontent='cart-modal']/*/div/*/button");
    private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");
    private final By productSeller = By.className("product-seller__body");

    private WebDriver driver;
    private WebDriverWait wait;

    private final int TIME_OUT_IN_SECONDS = 30;

    public SearchProducts(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    public SearchProducts fillInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public SearchProducts pressSearchButton() {
        driver.findElement(findButton).click();
        return this;
    }

    public SearchProducts pressBuyButton() {
        waitForProductDetailPageToLoad();
        driver.findElement(buyElementButton).click();
        return this;
    }

    public SearchProducts closeWindow() {
        driver.findElement(closeButtonClick).click();
        return this;
    }

    public void waitForProductDetailPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSeller));
    }

    public String CurrencyValue() {
        String currencySign = driver.findElement(checkCurrency).getText();
        return currencySign;
    }
}
