package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProducts {

    private final By searchField = By.xpath("//*[@name='search']");
    private final By findButton = By.xpath("//*[@role='search']/form/button");
    private final By buyElementButton = By.xpath("//*[@class='product__buy']/*/button");
    private final By closeButtonClick = By.xpath("//*[@classmodalcontent='cart-modal']/*/div/*/button");
    private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");

    private WebDriver driver;

    public SearchProducts(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(buyElementButton).click();
        return this;
    }

    public SearchProducts closeWindow() {
        driver.findElement(closeButtonClick).click();
        return this;

    }
    public String CurrencyValue (){
        String currencySign = driver.findElement(checkCurrency).getText();
        return currencySign;
    }
}
