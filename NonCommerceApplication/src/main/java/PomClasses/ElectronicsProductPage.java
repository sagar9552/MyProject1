package PomClasses;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsProductPage {
	
	@FindBy(xpath="(//a[text()='Electronics '])[1]")
	private WebElement eletronicbtn;
	
	@FindBy(xpath="(//a[text()='Cell phones '])[1]")
	private WebElement cellphonebtn;
	
	//For jewelery module Automation
	@FindBy(xpath = "(//a[text()='Jewelry '])[1]")
	private WebElement jewelery;
	
	
	//search list verify Method
	@FindBy (id = "small-searchterms")
	private WebElement searchBox ;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']//li")
	private List <WebElement>booksList ;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement searchBtn;
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public ElectronicsProductPage(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}

	public void verifyElectronicsProductbtn() 
	{
		actions.moveToElement(eletronicbtn).build().perform();
		actions.moveToElement(cellphonebtn).click().build().perform();
	}
	
	public void selectJewelry()
	{
		jewelery.click();
	}
	
	public void verifySearchBox()  
	{
		searchBox.sendKeys("books");
		
		for (WebElement e : booksList)
		{
			System.out.println(e.getText());
				
			if(e.getText().trim().equals("Pride and Prejudice"))
			{
				e.click();	
				
				break;
			}
		}

	}
	
}
