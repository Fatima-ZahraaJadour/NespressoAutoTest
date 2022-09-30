import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//le runner qui est une classe java qui va etre executé

@CucumberOptions(features = "Features/", glue = "stepDefinition",tags = "@Ready", plugin = {"pretty", "html:target/htmlreports.html","json:target/htmlreports.json"})
public class CucumberTest extends AbstractTestNGCucumberTests {
}
//to run : mvn test -Dtest=CucumberRunner "-Dcucumber.options=--tags @Ready" "-Dmaven.test.failure.ignore=true
