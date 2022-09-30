import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//le runner is a java class that will run our scenario

@CucumberOptions(features = "Features/", glue = "stepDefinition",tags = "@Ready", plugin = {"pretty", "html:target/htmlreports.html","json:target/htmlreports.json"})
public class CucumberTest extends AbstractTestNGCucumberTests {
}
//to run : mvn test -Dtest=CucumberTest "-Dcucumber.options=--tags @Ready" "-Dmaven.test.failure.ignore=true
