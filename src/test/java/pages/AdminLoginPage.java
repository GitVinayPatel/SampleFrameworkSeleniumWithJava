package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage 
{
	WebDriver driver;
	
	public AdminLoginPage (WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(xpath="//button[@class='navbar-toggle']") WebElement hamburger;
	@FindBy(xpath="//a[text()='Login as Admin / Manager']") WebElement LoginAsAdmin;
	@FindBy(xpath="//div[@id='drupal-modal--body']/form[@class='conform-login-popup']/div[2]/div[2]/div[1]/a[@href='/adminloginas']") WebElement YesButton;

	@FindBy(xpath="//input[@id='edit-name']") WebElement EditName;
	@FindBy(xpath="//input[@id='edit-pass']") WebElement Editpass;
	@FindBy(xpath="//a[@id='adminloginas-manual-login-button']") WebElement LoginButton;
	@FindBy(xpath="//button[@value='Create employee manually']") WebElement CreateEmpManually;
	
	public void ClickOnHamburger()
	{
		hamburger.click();
	}
	
	public void ClickLoginAsAdmin()
	{
		LoginAsAdmin.click();
	}
	
	public void ClickYesButton()
	{
		YesButton.click();
	}
    
	public void sendUserName(String name)
	{
		EditName.sendKeys(name);
	}
	
	public void sendPassword(String pass)
	{
		Editpass.sendKeys(pass);
	}
	
	public void ClickLoginButton()
	{
		LoginButton.click();
	}
	
	public void ClickCreateEmp()
	{
		CreateEmpManually.click();
	}
}
