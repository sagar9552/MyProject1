package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationDetailsPage {
	
	@FindBy (id = "gender-male")
	private WebElement malebtn ;
	
	@FindBy (id = "FirstName")
	private WebElement  fname;
	
	@FindBy (xpath = "//input[@name='LastName']")
	private WebElement lname ;
	
	@FindBy (xpath = "//select[@name='DateOfBirthDay']")
	private WebElement day ;
	
	@FindBy (xpath = "//select[@name='DateOfBirthMonth']")
	private WebElement month  ;
	
	@FindBy (xpath = "//select[@name='DateOfBirthYear']")
	private WebElement  year;
	
	@FindBy (id = "Email")
	private WebElement email ;
	
	@FindBy (id = "Company")
	private WebElement companyName ;
	
	@FindBy (id = "Newsletter")
	private WebElement checkbox ;
	
	@FindBy (xpath = "(//input[@type='password'or@data-val='true'])[5]")
	private WebElement passwd ;
	
	@FindBy (xpath = "(//input[@type='password'or@data-val='true'])[6]")
	private WebElement confirmPwd ;
	
	private WebDriverWait wait ;
	private WebDriver driver ;
	
	public RegistrationDetailsPage(WebDriver driver) 
	{	
	PageFactory.initElements(driver, this);
	this.driver = driver ;
	wait = new WebDriverWait(driver,10);
	}
	
	public void selectMaleButton()
	{
		malebtn.click();
	}
	
	public void clickOnFirstName()
	{
		fname.sendKeys("sagar");		
	}
	
	public void clickOnLastName()
	{
		lname.sendKeys("battise");		
	}


	public void day() 
	{
		Select s = new Select(day);
		s.selectByIndex(1);
	}
	public void month()
	{	
		Select s2 = new Select(month); 
		s2.selectByVisibleText("June");
	}
	public void year()
	{
		Select s3 = new Select(year);
		s3.selectByVisibleText("1994");
	}
	
	public void sendEmailAndCompanyName() 
	{
		email.sendKeys("sagarbattise94@gmail.com");
		companyName.sendKeys("hyperlinkTechnology");
	}
	
	public void selectCheckBox() 
	{
		boolean result = checkbox.isSelected();
		System.out.println(result);
		
		if(result==true)
		{
		System.out.println(" check Box is already selected");
		}
		else 
		{
		System.out.println("check box not selected");	
		checkbox.click();
		}
		
		System.out.println("====now click the Newsletter Button========");
		result = checkbox.isSelected();
		System.out.println(result);
	}
	
	public void setPasswrd() {
		passwd.sendKeys("sb@1994#$");
		confirmPwd.sendKeys("sb@1994#$");
	}
}
