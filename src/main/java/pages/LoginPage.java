package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage_nuvz;

public class LoginPage extends BasePage_nuvz{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='userCompany']")
	private WebElement CompanyCode;
	
	@FindBy(xpath="//input[@id='j_username']")
	private WebElement UserName;
	
	@FindBy(xpath="//input[@id='j_password']")
	private WebElement Password;
	
	@FindBy(xpath="//button[@id='proceed']")
	private WebElement Login;
	
	@FindBy(xpath="//div[@id='diCompanylogo']//img")
	private WebElement CompanyLogo;
	
	public void login(String Companycode,String Username,String pwd){
//		CompanyCode.sendKeys(Companycode);
//		UserName.sendKeys(Username);
//		Password.sendKeys(pwd);
//		Login.click();
//		CompanyLogo.click();
//		CompanyCode.sendKeys(Companycode);
//		UserName.sendKeys(Username);
//		Password.sendKeys(pwd);
		
		
		entertext(CompanyCode, Companycode, "enter company code"+Companycode);
		entertext(UserName, Username, "enter company code"+Username);
		entertext(Password, pwd, "enter company code"+pwd);
		click(Login, "click on login button");
	
	}	
}
