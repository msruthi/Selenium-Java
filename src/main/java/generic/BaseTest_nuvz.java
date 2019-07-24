package generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//@Listeners(FWListener_nuvz.class)
@Listeners(ExtentReporterNG.class)
public class BaseTest_nuvz implements IAutoConst_nuvz{
	public WebDriver driver;
	public String strURL;
	public String lngETO;
	public Logger log=Logger.getLogger(this.getClass());
	public ITestResult result;
	
	@BeforeSuite
	public void initFrameWork(){
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
		System.setProperty(IE_KEY, IE_PATH);
		
	}
//	------------------------------------------------------------------------------------------
//	*************************catching the value passed in the xml parameter*******************
	@Parameters({"browser"})
	@BeforeMethod
	public void openPortal(@Optional("firefox") String browser){
		
		
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
			log.info("open chrome browser");
		}
		else{
			driver=new FirefoxDriver();
			log.info("open firefox browser");
		}
		
		strURL=AutoUtility.getPropertyValue(CONFIGFILE_PATH,"URL");
		driver.get(strURL);
		
		String strITO=AutoUtility.getPropertyValue(CONFIGFILE_PATH, "ITO");
		Long lngITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(lngITO, TimeUnit.SECONDS);
		
	}
//	-------------------------------------------------------------------------------------------
	@AfterMethod
	public void closeBrowser(ITestResult result){
	
		log.info("closing the browser");
		System.out.println(result.getStatus());
		if(result.getStatus() == ITestResult.SUCCESS){
			String photopath=SCREENSHOT_PATH+AutoUtility.now()+".png";
			AutoUtility.takeScreenshot(driver,photopath);
			log.info("the Screenshot is taken:"+photopath);	
			
		}
		
//        driver.quit();

//		driver.quit();
//		driver.close();
		
	}
	
	@AfterClass
	public void aftertestclass(){
		System.out.print("after class test");
	}
}