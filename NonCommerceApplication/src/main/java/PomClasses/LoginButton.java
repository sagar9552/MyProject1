package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginButton {
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement loginbtn;

	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;

	public LoginButton(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		actions = new Actions(driver);
	}

	public void verifyLoginBtn() throws InterruptedException 
	{
		Thread.sleep(3000);
		actions.moveToElement(loginbtn).click().build().perform();
		
	}
}
