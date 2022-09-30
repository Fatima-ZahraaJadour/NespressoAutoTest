import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.Pages.CartPage;
import org.selenium.Pages.HomePage;
import org.selenium.Pages.LoginPage;
import org.selenium.Pages.ProductsList;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageObjectPatternTest {

    String driverPath = "C://Users//fzjadour//selenium jars and drivers//drivers//chrome driver//chromedriver.exe";
    WebDriver driver;
    HomePage homePage;
    ProductsList productsList;
    CartPage cartPage;
    LoginPage loginPage;
    String itemName = "Tropical Coconut Over Ice";
    String itemHeader = "nespresso-coconut-ice-coffee-pods";
    String itemQuantity = "10";
    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://www-staging.nespresso.com/uk/en");
        }
        catch (TimeoutException e){

        }
    }
    @Test(priority = 1)
    public void navigateToTheCatalog() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.navigateToCatalog();

    }
    @Test(priority = 2)
    public void addProductToCart() {
        productsList = new ProductsList(driver);
        productsList.addProductToCart(itemName,itemQuantity);

    }
    @Test(priority = 3)
    public void checkProductsInCart() {
        cartPage = new CartPage(driver);
        productsList.showFullShoppingBag();
        String productName = cartPage.getProductName();
        Assert.assertEquals(productName,itemName);
        String qty = cartPage.getProductQuantity(itemHeader);
        Assert.assertEquals(qty,itemQuantity);
    }
    @Test(priority = 4)
    public void checkoutAndNavigateToLoginPage() {
        cartPage.proceedToCheckout();
        loginPage = new LoginPage(driver);
        String title = loginPage.getLoginTitle();
        System.out.println(title);
        boolean titleContainsLogin = title.toLowerCase().contains("login");
        Assert.assertTrue(titleContainsLogin);
    }
    @AfterTest
    public void driverQuit() throws InterruptedException {

        driver.quit();
    }
}
