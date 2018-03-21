package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderfactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReportWithScreenShot 

{
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void SetUP() throws Exception
	{
		//"True" paramater in the ExtentReport class will overRide the existing report(Recommonded to do that)
		reports = new ExtentReports("C:\\code\\DhariniReview\\Java\\com.learnautomation.hybrid\\Reports\\LoginPageReport.html", true);
		
		logger = reports.startTest("loginVerification");
		logger = new ExtentTest("Verification of loginPage", "This TC will verify signout from drop down");
		
		driver = BrowserFactory.getBrowser("firefox");
		
    	driver.get(DataProviderfactory.getConfig().getApplicationURL());
    	
    	logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	
	
    @Test
	public void testHomePage() throws Exception{
		
    	
    	//when you call homepage.class,it will return you the object of (same)homepage class.
    	HomePage home = PageFactory.initElements(driver, HomePage.class);
    	String titleApp = home.getApplicationTitle();
    	Assert.assertTrue(titleApp.contains("Avactis"));
    	
    	logger.log(LogStatus.PASS, "Application Title is obtained");
    	
    	home.clickOnSignInLink();
    	
    	logger.log(LogStatus.INFO, "click on signout Link");
    	
    	Thread.sleep(3000);
    	
    	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    	
    	login.loginAApplication(DataProviderfactory.getExcel().getData("Login", 0, 0), DataProviderfactory.getExcel().getData("Login", 0, 1));
    	
    	logger.log(LogStatus.INFO, "Login to Application");
    	
    	login.verifysignout();
    	
    	logger.log(LogStatus.PASS, "Sign out is succesful");
    	
	}
    
    @AfterMethod
    public void tearDown()
    {

    	BrowserFactory.closeBrowser(driver);
    	reports.endTest(logger);
    	reports.flush();
    	
    }
}
