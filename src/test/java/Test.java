import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    WebDriver driver;

    @Given("Open Rozetka home page")
    public void open_rozetka_home_page() {
        System.setProperty("webdriver.chrome.driver", "d:\\AQA_2020\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.rozetka.com.ua/");
    }

    @When("Enter product title in search field")
    public void enter_product_title_in_search_field() {
        driver.findElement(By.xpath("//*[@name=\"search\"]")).sendKeys("Навушники Xiaomi AirDots/Earbuds Basic");

    }

    @Then("press Search button")
    public void press_search_button() {
        driver.findElement(By.xpath("//*[@role=\"search\"]/form/button"));
    }

}
