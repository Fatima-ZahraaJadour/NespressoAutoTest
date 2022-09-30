package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//l'implementation des steps definition
public class LoginStepsDefinitions {

    WebDriver driver;
    @Before //ce before s'execute avant chq scenario not before steps
    public void prepareDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Users//fzjadour//selenium jars and drivers//drivers//chrome driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on homepage")
    public void user_is_on_homepage() throws Throwable {
        driver.get("https://ma.buynespresso.com/ma_fr/");
    }

    @And("user navigates to {string} Page")
    public void user_navigates_to_login_page(String pageName) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("_evidon-accept-button")))).click();

        if("login".equalsIgnoreCase(pageName)){
            driver.findElement(By.id("header-login-link")).click();
        }
    }

    @When("user fill username {string} and password {string}")
    public void user_fill_username_and_password(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("email"))))
        .sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() throws Throwable {

    }
    @After
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }

    @And("user navigates to Login Page")
    public void userNavigatesToLoginPage() {
    }
}
