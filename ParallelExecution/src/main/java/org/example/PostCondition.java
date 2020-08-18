package org.example;

import org.openqa.selenium.WebDriver;

public class PostCondition {
    private WebDriver driver;

    public PostCondition (WebDriver driver){
        this.driver=driver;
    }
    public void closeBrowser(){
        driver.close();
    }
}
