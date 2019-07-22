package scripts;

import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest_nuvz;
import pages.LoginPage;

public class TestLogin extends BaseTest_nuvz{
	
	@Test
	void  testLogin(){
		String row = AutoUtility.getRowNum(EXCELFILE_PATH,"TestLoginPage1");
		System.out.println("Row picked from getRowNum"+row);
		String cmpcode= AutoUtility.readFromExcel(EXCELFILE_PATH, "NudeliverIt", row, "1");
		String uname= AutoUtility.readFromExcel(EXCELFILE_PATH, "NudeliverIt", row, "2");
		String pwd= AutoUtility.readFromExcel(EXCELFILE_PATH, "NudeliverIt", row, "3");

		LoginPage loginpage=new LoginPage(driver);
     	loginpage.login(cmpcode,uname,pwd);
		
	}

}
