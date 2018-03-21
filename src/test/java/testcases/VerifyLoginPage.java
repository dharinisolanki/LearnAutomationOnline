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
import pages.LoginPage;

public class VerifyLoginPage 

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
		
    	
    	//when you call homepage.class,it will return you the object of (same)homepage class.
    	HomePage home = PageFactory.initElements(driver, HomePage.class);
    	String titleApp = home.getApplicationTitle();
    	Assert.assertTrue(titleApp.contains("Avactis"));
    	home.clickOnSignInLink();
    	
    	Thread.sleep(3000);
    	
    	
    	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    	login.loginAApplication(DataProviderfactory.getExcel().getData("Login", 0, 0), DataProviderfactory.getExcel().getData("Login", 0, 1));
    	login.verifysignout();
    	
	}
    
    @AfterMethod
    public void tearDown()
    {

    	BrowserFactory.closeBrowser(driver);	
    }
}
