package PageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitHelper;

public class LoginPage {

	WebDriver driver;
	WaitHelper helper;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		helper=new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//input[@name='Email']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public void setUsername(String username)
	{
		helper.waitForElement(txtEmail, 10);
		txtEmail.clear();
		txtEmail.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		submitBtn.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}

	public String getPageTitle()
	{
		return (driver.getTitle());
	}
	
	

	 
}
