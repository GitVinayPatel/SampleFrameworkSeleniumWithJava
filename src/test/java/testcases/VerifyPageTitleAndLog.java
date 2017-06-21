package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.AdminLoginPage;
import utility.Helper;

public class VerifyPageTitleAndLog {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeMethod
	public void setup() 
	{   
		report = new ExtentReports(".//Reports//LoginPageReport.html",true);
		
		logger = report.startTest("Verify test login");
		driver = BrowserFactory.getBrowser("firefox");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO,"App is up and running");
		
	}
	
	
	@Test 
	public void test() throws InterruptedException
	{
		
		
		AdminLoginPage loginAs = PageFactory.initElements(driver,AdminLoginPage.class);
		
		loginAs.ClickOnHamburger();
		Thread.sleep(3000);
		loginAs.ClickLoginAsAdmin();
		Thread.sleep(3000);
		loginAs.ClickYesButton();
		
		//login submit
				String Username = DataProviderFactory.getExcel().getdata("Login",1,0);
				//String Pass = DataProviderFactory.getExcel().getdata("Login",1,1);
				
				loginAs.sendUserName(Username);
				loginAs.sendPassword("password1");
				logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver,"Test")));
				loginAs.ClickLoginButton();
				logger.log(LogStatus.INFO,"logged in sucessfully ");
				

				String title = driver.getTitle();
				System.out.println(title);
				Assert.assertTrue(title.contains("test"));
				logger.log(LogStatus.PASS,"Title is verified ");
				
				
		}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Helper.captureScreenshot(driver,result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
	
	
	
	
}
