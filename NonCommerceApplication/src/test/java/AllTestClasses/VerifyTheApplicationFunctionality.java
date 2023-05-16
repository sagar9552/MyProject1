package AllTestClasses;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PomClasses.AddToCart;
import PomClasses.DatePicker;
import PomClasses.ElectronicsProductPage;
import PomClasses.JeweleryRent;
import PomClasses.LogOutFromApplication;
import PomClasses.LoginButton;
import PomClasses.LoginPageDetails;
import PomClasses.Pride_And_Prejudice;
import PomClasses.RegisterPage;
import PomClasses.RegistrationDetailsPage;
import PomClasses.ViewAndRemoveAddToCart;

public class VerifyTheApplicationFunctionality
{
	WebDriver driver ;
	LoginPageDetails logPgDetails;
	RegisterPage regpg;
	RegistrationDetailsPage regDetailsPg;
	LoginButton logBtn ;
	LogOutFromApplication logOutpg;
	ElectronicsProductPage	elecProductPg;
	AddToCart addToCartbtn;
	JeweleryRent jewelryRnt ;
	DatePicker datePckr ;
	Pride_And_Prejudice prideAndPre;
	JavascriptExecutor js;
	int testID ;
	static ExtentTest test;
	static ExtentHtmlReporter reporter ;
	
	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("----BeforeClass--- Lauch The Browser-----");
		
		//NEW "C:\chrome.EXE\1\chromedriver_win32 (4)\chromedriver.exe"
		//OLD D:\\E-commerce PROJECT\\chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome.EXE\\1\\chromedriver_win32 (4)\\chromedriver.exe");		
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--remote-allow-origins=*");
//		//option.addArguments("--disable notifications");
//		WebDriver	driver = new ChromeDriver(option);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.get("https://demo.nopcommerce.com/");
//		driver.manage().window().maximize();		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		System.out.println("--- BeforeMethod--- Pre-Conditon Steps Login To The Application ---");

		//RegisterPage regpg = new RegisterPage(driver);
		//regpg.clickOnRegisterButton();
		logBtn = new LoginButton(driver);
		Thread.sleep(2000);
		logBtn.verifyLoginBtn();
		String title = driver.getTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Login");
		System.out.println( title);
		System.out.println("The Login Button Title is Verified");
		Thread.sleep(2000);
		logPgDetails = new LoginPageDetails(driver);
		logPgDetails.sendEmail();
		logPgDetails.sendPasswrd();
		logPgDetails.selectLoginbtn();
	}

	@Test(priority = 3 ,enabled = false)
	public void myFirstTest() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("--- Verify ALL  TestCases----");
		String title = driver.getTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Register");
		System.out.println( title);
	}
	
	@Test(priority = 2 , enabled = false)
	public void VerifyTheRegistrationDetails() throws InterruptedException 
	{
		Thread.sleep(3000);
		regDetailsPg = new RegistrationDetailsPage(driver);
		regDetailsPg.selectMaleButton();
		regDetailsPg.clickOnFirstName();
		regDetailsPg.clickOnLastName();
		regDetailsPg.day();
		regDetailsPg.month();
		regDetailsPg.year();
		regDetailsPg.sendEmailAndCompanyName();

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)"); 
		regDetailsPg.selectCheckBox();
		regDetailsPg.setPasswrd();
	}

	@Test(priority = 1 ,enabled = false)
	public void VerifyLoginButton() throws InterruptedException 
	{
		Thread.sleep(2000);
		logBtn = new LoginButton(driver);
		logBtn.verifyLoginBtn();
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Login");
		System.out.println( title);
		System.out.println("The Login Button Title is Verified");
	}
	
	@Test(priority = 4 , enabled = false)
	public void VerifyApplicationHomePage()
	{
		System.out.println("---@Test(4)---  ");
		String title = driver.getTitle();
		Assert.assertEquals(title, "nopCommerce demo store");
		System.out.println( title);
		System.out.println("---Application Home Page Title is Verified----");
	}
	
	@Test(priority = 5)
	public void VerifyAddToCart() throws InterruptedException 
	{
		ElectronicsProductPage	elecProductPg = new ElectronicsProductPage(driver);
		elecProductPg.verifyElectronicsProductbtn();

		addToCartbtn = new AddToCart(driver);
		addToCartbtn.selectCellPhoneOption();

		addToCartbtn.selectPrice();
		addToCartbtn.selectToDisplaySize();

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)"); 

		addToCartbtn.selectAddToCartOption(); 
	}
	
	@Test(priority = 6)
	public void VerifyProductRemoveInAddToCart() throws InterruptedException
	{
		ViewAndRemoveAddToCart removeTocart = new ViewAndRemoveAddToCart(driver);
		removeTocart.goToShopCart();
		removeTocart.removeProduct();
		
		String textName =removeTocart.getEmptyMessage();
		
		Assert.assertEquals(textName, "Your Shopping Cart is empty!");
		System.out.println(textName);
		
	}
	
	@Test(priority = 7)
	public void verifyDatePickerInJewelryModule() throws InterruptedException
	{
		Thread.sleep(3000);
		elecProductPg = new ElectronicsProductPage(driver);
		elecProductPg.selectJewelry();
		
		jewelryRnt = new JeweleryRent(driver);

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		
		jewelryRnt.selectRentOption();
		datePckr = new DatePicker(driver);
		datePckr.selectStartDate();
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		datePckr.selectProductQuantity();
		//datePckr.selectRentOption();	
		}
	
	@Test(priority = 8)
	public void verifySearchBoxWorking() throws InterruptedException 
	{
		elecProductPg = new ElectronicsProductPage(driver);
		elecProductPg.verifySearchBox();
		Thread.sleep(3000);
		prideAndPre = new Pride_And_Prejudice(driver);
		String name =prideAndPre.to_verify_getPride_And_PrejudiceMessage();
		
		if(name.equals("Pride and Prejudice")) 
		{
			System.out.println("verify searchBox - passed");
			Assert.assertTrue(true);
			System.out.println("-----"+ name +"-----");
		}
		else 
		{
			System.out.println("verify seachBox - failed");
			Assert.assertFalse(false);
		}

	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("---AfterMethod----- LogOut To The Application (TearDown)---");
		 logOutpg = new LogOutFromApplication(driver);
		 logOutpg.tearDown();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("-----AfterClass----- (clearObject) -----");
		regpg = null;
		regDetailsPg = null;
		logBtn = null ;
		logPgDetails = null;
		elecProductPg = null;
		addToCartbtn = null ;
		jewelryRnt = null ;
		datePckr = null ;
		prideAndPre = null ;
		logOutpg = null ;
		
	}
	
	@AfterTest
	public void closeBrowser() 
	{
		System.out.println("-------AfterTest----Close & Quit the Browser--------");
		driver.quit();
		driver = null ;
		System.gc(); //	garbage collector using for  clear the memory
		
		
	}
	
}
