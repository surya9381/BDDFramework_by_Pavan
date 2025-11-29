package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitHelper;

public class HomePage {

	WebDriver driver;
	WaitHelper helper;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		helper=new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userdd;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public void clickOnUserDropdown()
	{
		helper.waitForElement(userdd, 10);
		userdd.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
}
