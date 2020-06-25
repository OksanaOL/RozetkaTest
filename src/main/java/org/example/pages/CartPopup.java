package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPopup {
    private final By closePopupButton= By.xpath("//*[@classmodalcontent=\"cart-modal\"]/*/div/*/button");

    private WebDriver driver;

    public CartPopup(WebDriver driver){
        this.driver = driver;
    }

    public CartPopup closePopup(){
        driver.findElement(closePopupButton).click();
        return this;
    }
}
