package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateEmpManuallyPage 

{
    //private static final String String = null;
	WebDriver driver;
	public CreateEmpManuallyPage(WebDriver ldriver)
	{
           this.driver=ldriver;
    }
	
	@FindBy(xpath="//input[@id='edit-firstname']") WebElement firstName;
	@FindBy(xpath="//input[@id='edit-lastname']") WebElement lastName;
	@FindBy(xpath="//select[@id='edit-gender']/option[2]") WebElement genderMale;
	@FindBy(xpath="//select[@id='edit-gender']/option[3]") WebElement genderFemale;
	@FindBy(xpath="//input[@id='edit-dob']") WebElement dob;
	@FindBy(xpath="//input[@id='edit-streetaddress']") WebElement streetAdress;
	@FindBy(xpath="//input[@id='edit-postalcode']") WebElement posatlCode;
	@FindBy(xpath="//input[@id='edit-city']") WebElement cityName;
	@FindBy(xpath="//input[@id='edit-rsz-number']") WebElement rszNum;
	@FindBy(xpath="//input[@id='edit-phone']") WebElement phoneNum;
	@FindBy(xpath="//input[@id='edit-email']") WebElement emailID;
	@FindBy(xpath="//input[@id='edit-bank-acc-number']") WebElement bankAccNum;
	@FindBy(xpath="//button[@id='edit-submit']") WebElement nextLink;
	@FindBy(xpath="//label[text()='Select None']/span") WebElement Selectnone;
	@FindBy(xpath="//label[text()='Select all']/span") WebElement Selectall;
	@FindBy(xpath="//label[text()='Normal employee']/span") WebElement typeNor;
	@FindBy(xpath="//label[text()='Student']/span") WebElement typeSTU ;
	@FindBy(xpath="//label[text()='Flex employee']/span") WebElement typeFLX;
	@FindBy(xpath="//label[text()='Occasional employee']/span") WebElement typeEXT;
	@FindBy(xpath="//button[@id='edit-ok-button']") WebElement buttonOK;
	@FindBy(xpath="//button[@id='edit-confirm']") WebElement buttonConfirm;
	
	
	public void sendFirstName(String name)
	{
		firstName.sendKeys(name);
	}
	
	public void sendLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void selectGender(String gname)
	{
		if (gname.equalsIgnoreCase("male"))
		{
			genderMale.click();
			//genderMale.replace('x','2').click();
		}
		else if(gname.equalsIgnoreCase("female"))
		{
			genderFemale.click();
		}
	}
	
	public void selectdob(String DoB)
	{
		dob.sendKeys(DoB,Keys.ENTER);
	}
	
	public void sendStreetAdress(String add)
	{
		streetAdress.sendKeys(add);
	}
	
	public void sendPostCode(String Pcode)
	{
		posatlCode.sendKeys(Pcode);
	}
	
	public void sendCityName(String Cname)
	{
		cityName.sendKeys(Cname);
	}
	
	public void sendRsz(String rsz)
	{
		rszNum.sendKeys(rsz);
	}
	
	public void sendPhoneNum(String Pnum)
	{
		phoneNum.sendKeys(Pnum);
	}
	
	
	public void sendemailId(String mailId)
	{
		emailID.sendKeys(mailId);
	}
	
	public void clickOnnext()
	{
		nextLink.click();
	}
	
	
	public void selectNoneFun()
	{
		Selectnone.click();
	}
	
	public void selectEmpType(String emptype )
	{
		//String emptype = DataProviderFactory.getExcel().getdata("TestData",1,12);
		System.out.println(emptype);
		
		String strArray[] = emptype.split(" ");
		for(int i=0; i < strArray.length; i++){
	         if(strArray[i].equalsIgnoreCase("STU"))
	         {
	        	 typeSTU.click();
	         }
	         else if(strArray[i].equalsIgnoreCase("FLX"))
	         {
	        	 typeFLX.click();
	         }
	         else if(strArray[i].equalsIgnoreCase("EXT"))
	         {
	        	 typeEXT.click();
	         }
	         else if(strArray[i].equalsIgnoreCase("Nor"))
	         {
	        	 typeNor.click();
	         }
	}
}
	public void clickOnOk()
	{
		buttonOK.click();
	}
	
	public void clickOnConfirm()
	{
		buttonConfirm.click();
	}
	
}
