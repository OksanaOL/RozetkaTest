package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPopup {
    private WebDriver driver;

    private final By openCart = By.xpath("//*[@class='js-rz-cart']/div[1]/a");
    private final By plusButton = By.xpath("//*[@class='cart-product__footer']//div/button[2]");
    private final By closePopupButton = By.xpath("//*[@class ='modal__header']/button");
    private final By productPrice = By.xpath("//*[@class='cart-product__price']");
    public final int PRODUCT_QUANTITY = 3;

    public CartPopup(WebDriver driver) {
        this.driver = driver;
    }

    public CartPopup openPopup() {
        this.driver.findElement(this.openCart).click();
        return this;
    }

    public CartPopup increaseAmount() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        for (int i = 0; i < PRODUCT_QUANTITY - 1; ++i) {
            this.driver.findElement(this.plusButton).click();
        }


        return this;
    }

    public int totalPrice() {
        String text = this.driver.findElement(this.productPrice).getText();
        String result = "";
        String[] text1 = text.split(" ");
        for (String element : text1
        ) {
            Integer intElement = TryParseInt(element);
            if (intElement != null) {
                result +=element;
            }
        }

        int price = Integer.parseInt(result);

        return price;
    }

    public static Integer TryParseInt(String someText) {
        try {
            return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public CartPopup closePopup() {
        this.driver.findElement(this.closePopupButton).click();
        return this;
    }
}
