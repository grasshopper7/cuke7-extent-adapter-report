package stepdefs;

//import static org.testng.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.SkipException;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {

	private Scenario scenario;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("BEFORE ALL HOOK");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("AFTER ALL HOOK");
	}

	@Before(value = "not @failure")
	public void before(Scenario scenario) {
		this.scenario = scenario;
		scenario.log("BEFORE HI");
		scenario.log("BEFORE HELLO");
	}

	@After(value = "not @failure")
	public void after(Scenario scenario) {
		this.scenario = scenario;
		scenario.log("AFTER HI");
		scenario.log("AFTER HELLO");
	}

	@Before(value = "@failure")
	public void beforeFailure(Scenario scenario) { //
		this.scenario = scenario;
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}

	@After(value = "@failure")
	public void afterFailure() { //
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}

	@BeforeStep(value = "@failure")
	public void beforeStepFailure() { //
	}

	@AfterStep(value = "@failure")
	public void afterStepFailure() { //
	}

	@Given("Hook failure step")
	public void hook_failure_step() throws InterruptedException {
		// System.out.println("Failure step");
		Thread.sleep(500);
		scenario.log("FAILURE STEP HI");
		scenario.log("FAILURE STEP HELLO");
	}

	@Given("Skip hook failure step")
	public void skip_hook_failure_step() throws InterruptedException {
		Thread.sleep(250);
	}

	@Given("Hello background")
	public void background() throws InterruptedException {
		this.scenario.log("background");
		Thread.sleep(250);
	}

	@Given("Write a {string} step with precondition in {string}")
	@When("Complete action in {string} step in {string}")
	@Then("Validate the outcome in {string} step in {string}")
	public void step(String step, String scenario) throws InterruptedException {
		// System.out.format("%s step from %s.\n", step.toUpperCase(),
		// scenario.toUpperCase());
		this.scenario.log("log HATE THIS");
		Thread.sleep(1000);
	}

	@Then("Raise exception")
	public void raiseExcep() throws InterruptedException {
		Thread.sleep(2500);
		Random r = new Random();
		boolean flag = r.nextBoolean();
		assertEquals(flag, true);
	}

	@Then("Raise exception Skip")
	public void raiseExcepSkip() throws InterruptedException {
		// throw new SkipException("Sample skip");
	}

	@Then("Do not raise exception")
	public void doNotRaiseExcep() throws InterruptedException {
		Thread.sleep(1500);
		assertEquals(true, true);
	}

	@Given("Customer orders the dishes")
	public void dataTable(List<List<String>> table) throws InterruptedException {
		Thread.sleep(2000);
		// System.out.println(table);
	}

	@Given("the doc string is")
	public void docStr(String docStr) throws InterruptedException {
		Thread.sleep(2000);
		// System.out.println(docStr);
	}

	private WebDriver driver;
	private String site;

	@And("Go to {word}")
	public void visitweb(String site) throws Exception {
		driver.get(site);

		// System.out.println(driver.getTitle());

		WebDriverWait waitDrv = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitDrv.until(ExpectedConditions.or(ExpectedConditions.titleContains("GitHub"),
				ExpectedConditions.titleContains("Stack Overflow")));

		this.site = site;
		scenario.log("scenario website name - " + site);
	}

	@BeforeStep(value = "@website or @large", order = 1)
	public void beforeSite(Scenario scenario) throws Exception {
		this.scenario = scenario;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(500);

		scenario.log("HELLO THERE!!! ");
	}

	@BeforeStep(value = "@website", order = 2)
	public void beforeSite2() {
		scenario.log("GOOD BYE!!! ");
	}

	@AfterStep(value = "@website or @large", order = 2)
	public void afterSite() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

		scenario.log("HELLO THERE!!! " + this.site);

		scenario.attach(screenshot, "image/png", this.site);
		driver.quit();
	}

	@AfterStep(value = "@website", order = 1)
	public void afterSite2() {
		scenario.log("GOOD BYE!!! " + this.site);
	}

	@Given("Pending step definition")
	public void pendingStep() throws PendingException {
		throw new PendingException();
	}

	@Given("Skipped step definition")
	public void skippedStep() {
		// throw new SkipException("SKip it");
	}

	@Given("Go to capture 2 images in one step")
	public void twoImages() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(500);

		driver.get("https://github.com/");
		Thread.sleep(500);
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "github");

		driver.get("https://stackoverflow.com/");
		Thread.sleep(500);
		ts = (TakesScreenshot) driver;
		screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "stackoverflow");

		driver.quit();
	}
}