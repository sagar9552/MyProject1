package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pride_And_Prejudice {
	
	@FindBy(xpath = "//h1[text()='Pride and Prejudice']")
	private WebElement pride;
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public Pride_And_Prejudice(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}
	
	public  String to_verify_getPride_And_PrejudiceMessage() 
	{
		String text = pride.getText();

		return text ;

	}
}
