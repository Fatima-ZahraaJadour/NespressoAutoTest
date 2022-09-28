import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;
    @BeforeTest
    public void testCase() {
        System.setProperty("webdriver.chrome.driver", "C://Users//fzjadour//selenium jars and drivers//drivers//chrome driver//chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://selenium.dev/");
         driver.manage().window().maximize();

    }
    @Test
    public void test() {
        var title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Selenium");

    }@AfterTest
    public void driverQuit() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
