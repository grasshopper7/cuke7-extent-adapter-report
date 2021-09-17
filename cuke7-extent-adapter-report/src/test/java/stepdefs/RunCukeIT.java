package stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary",
/* "rerun:target/rerun1.txt" */ } /* , tags = "@misc" */ )
public class RunCukeIT  extends AbstractTestNGCucumberTests  {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
