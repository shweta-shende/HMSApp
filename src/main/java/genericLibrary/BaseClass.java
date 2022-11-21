package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	 public DatabaseUtility dLib=new DatabaseUtility();
		public FileUtility fLib=new FileUtility();
		public ExcelUtility eLib=new ExcelUtility();
		public JavaUtility jLib=new JavaUtility();
		public WebDriverUtility wLib=new WebDriverUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
		
		@BeforeSuite(groups= {"smoke","regression"})
		
		public void connectToDb()throws Throwable
		{
			dLib.connectionToDB();
			System.out.println("connect to database");	
		}
	//@Parameters("BROWSER")
		@BeforeClass(groups= {"smoke","regression"})

		public void lauchingBrowser()throws Throwable
		{
			String BROWSER=fLib.readDataFromPropertyFile("browser");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();    
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			sdriver=driver;
			
	       wLib.maximiseWindow(driver);
		
			
		}
			
			
			   @AfterClass(groups= {"smoke","regression"})
				public void closeBrowser()
				{
					driver.quit();
				}

			   @AfterSuite(groups= {"smoke","regression"})
				public void CloseDb()throws Throwable
				{
					dLib.connectionToDB();
					System.out.println("disconnect to database");	
				}
		
	}






