package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.AdminLoginPage;
import pages.CreateEmpManuallyPage;

public class CreateEmployee {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
	    driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	    AdminLoginPage LoginAs = PageFactory.initElements(driver,AdminLoginPage.class);
		
	    //click on loginAsAdmin 
		/*driver.findElement(By.xpath("//button[@class='navbar-toggle']")).click();
		driver.findElement(By.xpath("//a[text()='Login as Admin / Manager']")).click();
		driver.findElement(By.xpath("//a[@href='/adminloginas']")).click();*/
	    
	    LoginAs.ClickOnHamburger();
	    LoginAs.ClickLoginAsAdmin();
	    LoginAs.ClickYesButton();
		
		//login submit
		String Username = DataProviderFactory.getExcel().getdata("Login",1,0);
		String Pass = DataProviderFactory.getExcel().getdata("Login",1,1);
		
		LoginAs.sendUserName(Username);
		LoginAs.sendPassword(Pass);
		LoginAs.ClickLoginButton();
		/*driver.findElement(By.xpath("//input[@id='edit-name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='edit-pass']")).sendKeys(Pass);
		driver.findElement(By.xpath("//a[@id='adminloginas-manual-login-button']")).click();*/
		
		//select company
		//driver.findElement(By.xpath("//select[@id='edit-company-select']/option[3]")).click();
		//driver.findElement(By.xpath("//button[@id='edit-done']")).click();
		
		//create employee
		
		driver.findElement(By.xpath("//button[@value='Create employee manually']")).click();
	}
	

	
	@Test
	public void test()
	
	{
		
		CreateEmpManuallyPage createEmp = PageFactory.initElements(driver,CreateEmpManuallyPage.class );
		
		/*String Fname = DataProviderFactory.getExcel().getdata("TestData",1,0);
		createEmp.sendFirstName(Fname);
		
		String lname = DataProviderFactory.getExcel().getdata("TestData",1,1);
		createEmp.sendLastName(lname);
		
		String Gname = DataProviderFactory.getExcel().getdata("TestData",1,2);
		createEmp.selectGender(Gname);
		
		String DOB = DataProviderFactory.getExcel().getdata("TestData",1,3);
		createEmp.selectdob(DOB);
		
		String Address = DataProviderFactory.getExcel().getdata("TestData",1,4);
		createEmp.sendStreetAdress(Address);
		
		String PostalCode = DataProviderFactory.getExcel().getdata("TestData",1,5);
		createEmp.sendPostCode(PostalCode);
		
		String cityName = DataProviderFactory.getExcel().getdata("TestData",1,6);
		createEmp.sendCityName(cityName);
		
		String RszNum = DataProviderFactory.getExcel().getdata("TestData",1,7);
		createEmp.sendRsz(RszNum);
		
		String PhNum = DataProviderFactory.getExcel().getdata("TestData",1,8);
		createEmp.sendPhoneNum(PhNum);
		
		String Mailid = DataProviderFactory.getExcel().getdata("TestData",1,9);
		createEmp.sendemailId(Mailid);
		
		createEmp.clickOnnext();
		
		createEmp.selectNoneFun();
		
		createEmp.clickOnnext();
		
		createEmp.selectEmpType();
		
		createEmp.clickOnnext();
		
		createEmp.clickOnConfirm();
		
		createEmp.clickOnOk();*/
		
		int rowcount = DataProviderFactory.getExcel().rowcount("TestData");
        System.out.println(rowcount);
		for (int i = 1; i < rowcount; i++) {
			
			String Fname = DataProviderFactory.getExcel().getdata("TestData",i,0);
			String lname = DataProviderFactory.getExcel().getdata("TestData",i,1);
			String Gname = DataProviderFactory.getExcel().getdata("TestData",i,2);
			String DOB = DataProviderFactory.getExcel().getdata("TestData",i,3);
			String Address = DataProviderFactory.getExcel().getdata("TestData",i,4);
			String PostalCode = DataProviderFactory.getExcel().getdata("TestData",i,5);
			String cityName = DataProviderFactory.getExcel().getdata("TestData",i,6);
			String RszNum = DataProviderFactory.getExcel().getdata("TestData",i,7);
			String PhNum = DataProviderFactory.getExcel().getdata("TestData",i,8);
			String Mailid = DataProviderFactory.getExcel().getdata("TestData",i,9);
			String emptype = DataProviderFactory.getExcel().getdata("TestData",i,12);
			
			createEmp.sendFirstName(Fname);
			createEmp.sendLastName(lname);
			createEmp.selectGender(Gname);
			createEmp.selectdob(DOB);
			createEmp.sendStreetAdress(Address);
			createEmp.sendPostCode(PostalCode);
			createEmp.sendCityName(cityName);
			createEmp.sendRsz(RszNum);
			createEmp.sendPhoneNum(PhNum);
			createEmp.sendemailId(Mailid);
			createEmp.clickOnnext();
			
			createEmp.selectNoneFun();
			
			createEmp.clickOnnext();
			
			createEmp.selectEmpType(emptype);
			
			createEmp.clickOnnext();
			
			createEmp.clickOnConfirm();
			
			createEmp.clickOnOk();
			
			driver.findElement(By.xpath("//button[@value='Create employee manually']")).click();
			
			
			
			
			
			
		}
		
}
	
	@AfterMethod
	public void tearDown()
	
	{
		BrowserFactory.closeBrowser(driver);
	}
	
	
}
