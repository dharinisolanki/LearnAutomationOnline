package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver= ldriver;
	}
	
	@FindBy(xpath ="//div[@class='header content']//li[2]//a") WebElement signInlink;
	@FindBy(xpath ="//div[@class='header content']//li[3]//a") WebElement CreatAccount;
	@FindBy(xpath="//div[@class='header content']//li[1]//span") WebElement welcome;

	public void clickOnSignInLink()
	{
		signInlink.click();
	}
	
	public void clickOnCreateAccount()
	{
		CreatAccount.click();
	}
	
	
	public void clickOnWelcomeLink()
	{
		welcome.click();
	}
	
	public String getApplicationTitle()
	{
		 
		return driver.getTitle(); 
	}
}
