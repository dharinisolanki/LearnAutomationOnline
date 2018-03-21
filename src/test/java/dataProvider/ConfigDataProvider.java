package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {
	Properties pro;


	
	public ConfigDataProvider() throws Exception
	{
		File src = new File("C://code//DhariniReview//Java//com.learnautomation.hybrid//Configuration//config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			 pro.load(fis);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	public String getIEPath()
	{
		String IEpath = pro.getProperty("IEpath");
		return IEpath;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFFpath()
	{
		String FFpath = pro.getProperty("Firefoxpath");
		return FFpath;
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("url");
		return url;
	}
}
