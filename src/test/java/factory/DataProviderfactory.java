package factory;

import java.io.IOException;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

// Reason of creating this particular class is that everytime you donmt need to create an object of your class "ConfigDataProvider"
//and "ExcelDataProvider". see a class "BrowserFactory" and observe how this class is useful to call only methods of this class
// instead creating an object each time

public class DataProviderfactory 
{
	
	public static ConfigDataProvider getConfig() throws Exception
	{
	
	ConfigDataProvider config = new ConfigDataProvider();
	return config;
	
	}
	
	public static ExcelDataProvider getExcel() throws IOException
	{
	
	ExcelDataProvider excel = new ExcelDataProvider();
	return excel;
	
	}

}
