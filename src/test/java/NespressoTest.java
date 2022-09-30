import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

//My test to open the original capsules products page
public class NespressoTest {

        WebDriver driver;
        @BeforeTest
        public void before() {
            System.setProperty("webdriver.chrome.driver", "C://Users//fzjadour//selenium jars and drivers//drivers//chrome driver//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            // why and why here
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //driver.findElement(By.xpath("//a[contains(@href,'capsules') and contains(@class,'AccessibleLink HeaderNavigationBarDropdown__medium-link')]"))
                  //  .click();

        }
        @Test
        public void test() {
            try {
                driver.get("https://www.nespresso.com/fr/fr/");
            }
            catch (TimeoutException e){

            }
            //accept the cookies
            driver.findElement(By.xpath("//button[@id='_evidon-banner-acceptbutton']")).click();
            //go to capsules
            Actions action = new Actions(driver);
            WebElement coffeeElement = driver.findElement(By.xpath("//a[contains(@href,'/order/capsules/vertuo')]"));
            action.moveToElement(coffeeElement).perform();
            driver.findElement(By.xpath("//a[contains(@href,'capsules') and contains(@class,'HeaderNavigationBarDropdown')]"))
              .click();



        }
        @AfterTest
        public void driverQuit() throws InterruptedException {
            Thread.sleep(10000);
            driver.quit();
        }

}
