package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features=".//Features",
		         glue="stepDefinitions",
		         dryRun=true,
		         monochrome = true,
		         plugin = {"pretty","html:target/htmlreport.html"},
		         tags = "@surya"
		        )
public class TestRunner extends AbstractTestNGCucumberTests {

}
