package org.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsList {

    List<String> existing_quantities = List.of("0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "150", "200", "250", "300");

    WebDriver driver;

    @FindBy(xpath = "//*[@id='ta-mini-basket__open']")
    WebElement showCartButton;
    @FindBy(xpath = "//*[id='ta-quantity-selector__custom-ok']")
    WebElement addToCartOkButton;
    @FindBy(xpath = "//*[id='ta-quantity-selector__custom-field']")
    WebElement addToCartInput;
    /*
    @FindBy(xpath = "//form[contains(@class,'list-item-form')]/descendant :: button[contains(@class, 'tocart')][1]" )
    WebElement addToBagButton_INDONESIA;
    @FindBy(xpath = "//form[contains(@class,'list-item-form')]/descendant :: span[@data-qtyitem='10']")
    WebElement quantityItem;*/


    public ProductsList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void addProductToCart(String name, String quantity){
        WebElement addToBagButton = driver.findElement(By.xpath("//*[@data-ta-product-name='"+ name +"']/descendant :: button[contains(@class, 'AddToBagButton')]"));
        //WebElement quantityItem = driver.findElement(By.xpath("//*[@data-product-item-id="+ id +"]/descendant :: span[@data-qtyitem="+quantity+"]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton)).click();

        //WebElement addToCartOkButton = driver.findElement(By.xpath("//*[@data-product-item-id="+ id +"]/descendant :: *[id='ta-quantity-selector__custom-ok']"));
        //WebElement addToCartInput = driver.findElement(By.xpath("//*[@data-product-item-id="+ id +"]/descendant :: *[id='ta-quantity-selector__custom-field']"));
        //addToBagButton.click();
        if(existing_quantities.contains(quantity)){
            WebElement quantityItem2 = driver.findElement(By.xpath("//*[contains(@id,'ta-quantity-selector__predefined-"+ existing_quantities.indexOf(quantity) +"')]"));
            quantityItem2.click();
        }
        else {
            addToCartInput.sendKeys(quantity);
            if(Integer.parseInt(quantity) % 10 != 0){
                addToCartOkButton.click();
            }
            addToCartOkButton.click();
        }
    }
    public void showShoppingBag(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(showCartButton)).click();
        showCartButton.click();
    }

}
