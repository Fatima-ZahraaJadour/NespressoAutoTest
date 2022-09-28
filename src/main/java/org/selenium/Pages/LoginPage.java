package org.selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//it can be tested just with geturl without using this class
public class LoginPage {
    WebDriver driver;
    //*[@id='block-8823988671989']/descendant :: h1[contains(@class,"h1_wrap_content")]
    @FindBy(xpath = "//h1[contains(@class,'h1_wrap_content')]" )
    WebElement loginTitle;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getLoginTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var item = wait.until(ExpectedConditions.visibilityOf(loginTitle));
        return item.getText();
    }
}
