package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import PageObjects.LoginPage;
import Utils.WaitHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepDefinitions extends BaseClass {
	
	Logger logger;
	@Before
	public void setup() throws IOException
	{
		FileInputStream fis=new FileInputStream("./commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser=pro.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Given("User launches the browser")
	public void user_launches_the_browser() {
		logger.info("******************** Launching the browser ***********************");
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		logger.info("********** Launching the application **************");
	    driver.get(url);
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
	    loginpage=new LoginPage(driver);
	    logger.info("************* Entering username ***************");
	    loginpage.setUsername(username);
	    logger.info("************ entering password *****************");
	    loginpage.setPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		logger.info("************** Clicking on Login button ****************");
	    loginpage.clickOnLogin();
	}
	
	@When("user click on logout")
	public void user_click_on_logout() {
		logger.info("*************** Clicking on Logout button **************");
		loginpage.clickOnLogout();

	}

	@Then("close browser")
	public void close_browser() {
		logger.info("************* Closing the browse **************");
	    driver.quit();
	}
	
	@And("wait for few seconds")
	public void wait_for_few_seconds() throws InterruptedException {
	    Thread.sleep(3000);
	}



	
}
