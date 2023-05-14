package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageDetails {

	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy (id = "Password")
	private WebElement pwd;
	

	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement loginbtn;

	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;

	public LoginPageDetails(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}

	public void sendEmail() 
	{
		email.sendKeys("sagarbattise94@gmail.com");
	}

	public void sendPasswrd() {
		pwd.sendKeys("sb@1994#$");
	}
	
	public void selectLoginbtn() {
		actions.moveToElement(loginbtn).click().build().perform();
	}
}
