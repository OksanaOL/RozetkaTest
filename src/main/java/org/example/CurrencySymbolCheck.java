package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CurrencySymbolCheck {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");
    private final By searchField = By.xpath("//*[@name=\"search\"]");
    private final By searchButton = By.xpath("//*[@role=\"search\"]/form/button");
    private final By buyProductButton = By.xpath("//*[@class=\"product__buy\"]/*/button");
    //private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");
    private final By closePopupButton = By.xpath("//*[@class ='modal__header']/button");
    private final By productSeller = By.className("product-seller__body");
    private final By openCart = By.cssSelector("a[href$=\"profile/cart\"]");
    private final By plusButton = By.xpath("//*[@class='cart-product__footer']//div/button[2]");
    private final int TIME_OUT_IN_SECONDS = 30;

    public CurrencySymbolCheck(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30L);
    }

    public CurrencySymbolCheck typeToSearchField(String text) {
        this.driver.findElement(this.searchField).sendKeys(text);
        return this;
    }

    public CurrencySymbolCheck clickSearchButton() {
        this.driver.findElement(this.searchButton).click();
        // this is example how to click elements with JS (if regular click can't do that)
        WebElement searchBtn =  this.driver.findElement(this.searchButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", searchBtn);
        return this;
    }

    public CurrencySymbolCheck clickBuyButton() {
        this.waitForProductDetailPageToLoad();
        this.driver.findElement(this.buyProductButton).click();
        return this;
    }

    public CurrencySymbolCheck openPopup() {
        this.driver.findElement(this.openCart).click();
        return this;
    }

    public CurrencySymbolCheck increaseAmount() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        for(int i = 0; i < 2; ++i) {
            this.driver.findElement(this.plusButton).click();
        }
        return this;
    }

    public CurrencySymbolCheck closePopup() {
        this.driver.findElement(this.closePopupButton).click();
        return this;
    }

    public CurrencySymbolCheck hoverMouseToShowMinicart() {
        // this is an example of how to use Actions class for operations with mouse
        Actions action = new Actions(this.driver);
        WebElement we = driver.findElement(openCart);
        action.moveToElement(we).build().perform();
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
