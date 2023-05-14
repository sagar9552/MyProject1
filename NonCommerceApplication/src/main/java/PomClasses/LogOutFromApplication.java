package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutFromApplication {	
	@FindBy (xpath = "//a[text()='Log out']")
	private WebElement logOutbtn ;
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public LogOutFromApplication(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);	
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}

	public void tearDown()
	{
		actions.moveToElement(logOutbtn).click().build().perform();

	}
}
