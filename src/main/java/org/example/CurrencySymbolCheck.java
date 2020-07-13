package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CurrencySymbolCheck {

    private WebDriver driver;
    private final By checkCurrency = By.xpath("//*[@class='main-goods__currency']");

    public CurrencySymbolCheck(WebDriver driver) {
        this.driver = driver;
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
