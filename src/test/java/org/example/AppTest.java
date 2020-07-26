package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver browser;
    private String baseURI = System.getenv("baseURI");

    @BeforeTest
    public void startWebPage() {
        if (baseURI == null) {
            baseURI = "https://rozetka.com.ua";
        }
        browser = PreConditions.initWebDriver();
        PreConditions preConditions = new PreConditions(browser);
        preConditions.openPage(baseURI)
                .scrollPage();
    }
    @AfterTest
    public void closeWebPage(){
        PostCondition postCondition= new PostCondition(browser);
        postCondition.closeBrowser();
    }

    @Test
    public void searchProduct() throws InterruptedException {
        ProductSearch productSearch = new ProductSearch(this.browser);
        CartPopup cartPopup = new CartPopup(this.browser);
        productSearch.typeToSearchField("Навушники Xiaomi AirDots/Earbuds Basic")
                .clickSearchButton()
                .clickBuyButton();
        cartPopup.openPopup();
        Thread.sleep(3000);
        int inititalPrice = cartPopup.totalPrice();
        cartPopup.increaseAmount();
        Thread.sleep(3000);
        int finalPrice = cartPopup.totalPrice();
        Assert.assertEquals(inititalPrice * cartPopup.PRODUCT_QUANTITY, finalPrice);
        cartPopup.closePopup();
    }

    @Test
    public void checkPrice() {
        ProductSearch productSearch = new ProductSearch(this.browser);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(productSearch.isPriceCorrect(expectedcurrencySymbol));
    }
}




