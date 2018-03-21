package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage 
{
   WebDriver driver;
   
   public LoginPage(WebDriver ldriver)
   {
	   this.driver = ldriver;
   }
   
   @FindBy(xpath=".//*[@name='login[username]']") WebElement userName;
   @FindBy(xpath=".//*[@name='login[password]']") WebElement password;
   @FindBy(xpath="//form[@id='login-form']//div[4]//button") WebElement loginButton;
   @FindBy(xpath="//div[@class='header content']/div[1]/ul/li[2]//span[text()='Dharini Parmar']") WebElement clickingOndropDown;
   @FindBy(xpath="//div[@class='header content']//div[1]//ul/li[2]//li[3]//a") WebElement SignOut;
   @FindBy(xpath="//main[@id='maincontent']/div[1]/h1/span") WebElement CustomerLoginTitle;
   
   public void loginAApplication(String user, String Pass)
   {
	   userName.sendKeys(user);
	   password.sendKeys(Pass);
	   loginButton.click();
	   
	   
   }
   
   public void verifysignout()
   {
   
	 clickingOndropDown.click();
	 SignOut.click();
	 String CustLoginTitle = CustomerLoginTitle.getText();
	 Assert.assertEquals(CustLoginTitle,"You are signed out.");
	   
   }

}
