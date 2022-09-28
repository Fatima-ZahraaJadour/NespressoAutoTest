package org.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//td[contains(@class,'MiniBasketItem__title')]/child :: span" )
    WebElement itemName;
    @FindBy(xpath = "//*[@id='ta-mini-basket__checkout']")
    WebElement proceedToCheckoutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var item = wait.until(ExpectedConditions.elementToBeClickable(itemName));

        return item.getText();
    }
    public String getProductQuantity(String name){

        WebElement itemQuantity = driver.findElement(By.xpath("//td[contains(@headers,'"+name+"')]/descendant :: *[contains(@class,'quantity')]"));
        return itemQuantity.getText();
    }
    public void proceedToCheckout(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }

}
