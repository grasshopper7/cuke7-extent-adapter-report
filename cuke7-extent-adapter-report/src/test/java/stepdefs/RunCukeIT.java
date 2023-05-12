package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/stepdefs/", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"
/* "rerun:target/rerun1.txt" */ }/* , tags = "@skip or @exception or @both or @duplicate" */)
public class RunCukeIT {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() {
	 * System.out.println("PARALLL"); return super.scenarios(); }
	 */
}
