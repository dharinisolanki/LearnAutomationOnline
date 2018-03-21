package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
public class Helper {
	
	public static String captureScreenShot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		// *****System.currentTimeMillis() it is imp to add time stamp othetwise it will over ride the previous screen shot
		String destination = "C:\\code\\DhariniReview\\Java\\com.learnautomation.hybrid\\ScreenShots" + screenshotName + System.currentTimeMillis()+".png"; 
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot " + e.getMessage());
		}
		return destination;
		
	}

}


