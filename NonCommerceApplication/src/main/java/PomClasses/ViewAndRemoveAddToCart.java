package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewAndRemoveAddToCart {
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	private WebElement shopCart;
	

	@FindBy(xpath="//button[text()='Go to cart']")
	private WebElement goToCart;
	
	@FindBy(xpath="(//div//tr//td)[7]")
	private WebElement remove;
	
	@FindBy(xpath="//div[@class='order-summary-content']")
	private WebElement emptyMessage;
	
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	public ViewAndRemoveAddToCart(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}

	public void goToShopCart() throws InterruptedException 
	{
		Thread.sleep(2000);
		actions.moveToElement(shopCart).build().perform();
		Thread.sleep(2000);
		actions.moveToElement(goToCart).click().build().perform();
	}
	
	public void removeProduct() throws InterruptedException
	{
		Thread.sleep(4000);
		remove.click();
	}
	
	public String getEmptyMessage() 
	{
		String text = emptyMessage.getText();

		return text ;

	}
}
