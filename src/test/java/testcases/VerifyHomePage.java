package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderfactory;
import pages.HomePage;

public class VerifyHomePage 

{
	WebDriver driver;
	
	@BeforeMethod
	public void SetUP() throws Exception
	{
		driver = BrowserFactory.getBrowser("firefox");
    	driver.get(DataProviderfactory.getConfig().getApplicationURL());
	}
	
	
	
    @Test
	public void testHomePage() throws Exception{
		
    	
    	//when yu call homepage.class, it will return you the object of (same)homepage class.
    	HomePage home = PageFactory.initElements(driver, HomePage.class);
    	
    	String titleApp = home.getApplicationTitle();
    	
    	Assert.assertTrue(titleApp.contains("Avactis"));
    	
    	
	}
    
    @AfterMethod
    public void tearDown()
    {

    	BrowserFactory.closeBrowser(driver);	
    }
}
