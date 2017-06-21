package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	
	public static  WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getchromepathUrl());
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("wedriver.ie.driver",config.getiePathUrl());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}
	
}
