package Utils;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForElement(WebElement ele, int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
