import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Mohamed's test to open the original capsules products page
public class MhdTest {
    WebDriver driver;
    String WebDriverType = "webdriver.chrome.driver";
    String WebDriverPath = "C://Users//fzjadour//selenium jars and drivers//drivers//chrome driver//chromedriver.exe";
    String nespressoUrlFr = "https://www.nespresso.com/fr/fr/";
    String nespressoUrlEn = "https://www.nespresso.com/fr/en";

    @BeforeTest
    public void launchBrowser() {
        System.setProperty(WebDriverType, WebDriverPath);
        driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get(nespressoUrlFr);
        }catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("launchBrowser Error");
        }
    }

    @Test
    public void clickAndHold(){
        //Accept cookies(click)
        driver.findElement(By.xpath("//*[@id='_evidon-banner-acceptbutton']")).click();
        //ClickAndHold
        WebElement OrderCoffee = driver.findElement(By.xpath("(//span[contains(@class,'Sprite HeaderNavigationBarItem__icon')])[1]"));
        new Actions(driver).clickAndHold(OrderCoffee).perform();
        //Click To Order
        driver.findElement(By.xpath("(//a[contains(@lightbox,'[object Object]')])[2]")).click();
    }

    @AfterTest
    public void terminateBrowse() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
