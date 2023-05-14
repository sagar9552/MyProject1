package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JeweleryRent {
	
	@FindBy(xpath ="(//button[@class='button-2 product-box-add-to-cart-button'])[1]")
	private WebElement rent ;

	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public JeweleryRent(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}
	
	public void selectRentOption() throws InterruptedException 
	{
		Thread.sleep(3000);
		rent.click();
	}
	
}
