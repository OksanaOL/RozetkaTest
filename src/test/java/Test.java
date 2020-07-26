import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CartPopup;
import org.example.PreConditions;
import org.example.ProductSearch;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Test {
    WebDriver driver;
    PreConditions preConditions;
    ProductSearch productSearch;
    CartPopup cartPopup;

    @Given("Open Rozetka home page")
    public void open_rozetka_home_page() {
        driver = PreConditions.initWebDriver();
        preConditions = new PreConditions(driver);
        productSearch = new ProductSearch(driver);
        cartPopup = new CartPopup(driver);
        preConditions.openPage("https://www.rozetka.com.ua/");
    }

    @When("Enter product {string} in search field")
    public void enterProductInSearchField(String title) {
        productSearch.typeToSearchField(title);
    }

    @Then("Press Search button")
    public void press_search_button() {
        productSearch.clickSearchButton();
    }

    @Given("Rozetka site is opened")
    public void rozetka_site_is_opened() {
        driver = PreConditions.initWebDriver();
        preConditions = new PreConditions(driver);
        productSearch = new ProductSearch(driver);
        cartPopup = new CartPopup(driver);
        preConditions.openPage("https://www.rozetka.com.ua/");
    }

    @When("Scroll till end off page to load all products")
    public void scroll_till_end_of_page_to_load_all_products() {
        preConditions.scrollPage();
    }

    @Then("Prices are shown in Grivna")
    public void prices_are_shown_in_grivna() {
        ProductSearch productSearch = new ProductSearch(this.driver);
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(productSearch.isPriceCorrect(expectedcurrencySymbol));
    }

    @Given("Requested product is shown and buy button is pressed")
    public void requestedProductIsShownAndBuyButtonIsPressed() {
        driver = PreConditions.initWebDriver();
        preConditions = new PreConditions(driver);
        productSearch = new ProductSearch(driver);
        cartPopup = new CartPopup(driver);
        preConditions.openPage("https://www.rozetka.com.ua/");
        productSearch.typeToSearchField("Навушники Xiaomi AirDots/Earbuds Basic ")
                .clickSearchButton()
                .clickBuyButton();
    }

    @When("Product Cart is opened - item is present")
    public void productCartIsOpenedItemIsPresent() {
        cartPopup.openPopup();
    }

    @And("Plus button is pressed - total price is changed")
    public void plusButtonIsPressedTotalPriceIsChanged() throws InterruptedException {
        Thread.sleep(3000);
        int inititalPrice = cartPopup.totalPrice();
        cartPopup.increaseAmount();
        Thread.sleep(3000);
        int finalPrice = cartPopup.totalPrice();
        Assert.assertEquals(inititalPrice * cartPopup.PRODUCT_QUANTITY, finalPrice);
        cartPopup.closePopup();
    }

    @Then("Product Cart is closed")
    public void productCartIsClosed() {
        cartPopup.closePopup();
    }
}