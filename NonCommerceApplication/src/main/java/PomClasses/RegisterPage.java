package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage 
{
	@FindBy (xpath = "//a[text()='Register']")
	private WebElement registerbtn ;
	
	public RegisterPage(WebDriver driver) 
	{	
	PageFactory.initElements(driver, this);
	
	}
	
	public void clickOnRegisterButton() {
		
		registerbtn.click();
	}
	
	
	
}