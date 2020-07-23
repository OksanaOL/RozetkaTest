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
    PreConditions preconditions;
    CartPopup cartPopup;
    ProductSearch productSearch;

    @Given("Open Rozetka home page")
    public void open_rozetka_home_page() {
        preconditions = new PreConditions();
        driver = preconditions.getDriver();
        cartPopup = new CartPopup(driver);
        productSearch = new ProductSearch(driver);
        preconditions.openPage("https://www.rozetka.com.ua/");
    }

    @When("Enter product title in search field")
    public void enter_product_title_in_search_field() {
//        driver.findElement(By.xpath("//*[@name=\"search\"]")).sendKeys("Навушники Xiaomi AirDots/Earbuds Basic");
    productSearch.typeToSearchField("Навушники Xiaomi AirDots/Earbuds Basic");
    }

    @When("press Search button")
    public void press_search_button() {
//        driver.findElement(By.xpath("//*[@role=\"search\"]/form/button"));
        productSearch.clickSearchButton();
    }

    @Then("all prices in search result are in grivna")
    public void check_all_prices_in_hrivna() {
        String expectedcurrencySymbol = "₴";
        Assert.assertTrue(productSearch.isPriceCorrect(expectedcurrencySymbol));
    }

}
