package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	
	@FindBy(xpath="//div[@class='page-title']//h1")
	private WebElement cellphoneText;
	
	//drop-down for select the price Low To High & display size
	@FindBy(xpath="//select[@id='products-orderby']")
	private WebElement sortbybtn;
	
	@FindBy(xpath="//select[@id='products-pagesize']")
	private WebElement displaybtn;
	
	@FindBy(xpath="(//button[contains(@class,'button-2 pro')])[2]")
	private WebElement addToCartbtn;
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public AddToCart(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
		
	}
	
	
	public void selectCellPhoneOption() 
	{
		String text = cellphoneText.getText();
		System.out.println(text);
	}

	public void selectPrice() throws InterruptedException 
	{
		Thread.sleep(2000);
		Select s2 = new Select(sortbybtn); 
		s2.selectByVisibleText("Price: Low to High");
	}
	
	public void selectToDisplaySize() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select s2 = new Select(displaybtn); 
		s2.selectByVisibleText("9");
	}
	
	public void selectAddToCartOption() throws InterruptedException 
	{
		Thread.sleep(5000);
		addToCartbtn.click();
	}
} 

