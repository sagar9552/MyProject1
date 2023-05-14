package PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
	//Expected Date
	//02-May-2023
	
	String expectedDay = "6" ;
	String expectedMonth = "NOVEMBER" ;
	String expectedYear = "2023" ;
	
	@FindBy(id = "rental_start_date_40")
	private WebElement start_date_Calendar;
	
	@FindBy(id = "rental_end_date_40")
	private WebElement End_date_Calendar;
	
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	private WebElement calendarMonth;
	
	@FindBy(xpath="//span[@class='ui-datepicker-year']")
	private WebElement calendarYear;
	
	@FindBy(xpath="//a[@data-handler='next']")
	private WebElement nextBtn;
	
	@FindBy(id="product_enteredQuantity_40")
	private WebElement quantity;
	
	@FindBy(xpath="add-to-cart-button-40")
	private WebElement rent_Add_To_Card;
	
	@FindBy (xpath ="//table//tbody//tr//td")
	private List< WebElement> daysList ;
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	private Actions actions;
	
	public DatePicker(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}

	public void selectStartDate() throws InterruptedException 
	{	
		start_date_Calendar.click();
		
		while(true) 
		{
			String calendarM = calendarMonth.getText();
			String calendarY = calendarYear.getText();
			
			if(calendarM.equals(expectedMonth)&& calendarY.equals(expectedYear)) 
			{		
				for (WebElement e : daysList) 
				{
					String calenderDay = e.getText();
					
					if (calenderDay.equals(expectedDay)) 
					{
						e.click();
						
						break ;
					}
					
				 }
				
			break;
			 }
			else 
			{
				nextBtn.click();
			}
		}		

	}
	
	public void selectProductQuantity() throws InterruptedException 
	{
		Thread.sleep(2000);
		quantity.clear();
		quantity.sendKeys("3");
	}
	
	public void selectRentOption() throws InterruptedException 
	{
		Thread.sleep(2000);
		rent_Add_To_Card.click();
	}
	
	public void selectEndDate() 
	{
		
	}
	
}

