package org.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, 'order/capsules/vertuo') and contains(@class,HeaderNavigationBarItem)][1] ")
    WebElement coffeeElement;
    @FindBy(xpath = "//button[@id='_evidon-accept-button']")
    WebElement acceptCookiesButton;
    @FindBy(xpath = "//a[contains(@href, 'order/capsules/original?name=nav&id=coffee-menu&creative=Buy-Original-Capsules&position=1-2')]")
    WebElement originalCoffeeCatalogButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void acceptCookies(){
        acceptCookiesButton.click();

    }
    public void navigateToCatalog(){
        Actions action = new Actions(driver);
        action.moveToElement(coffeeElement).perform();
        originalCoffeeCatalogButton.click();
    }
}
