package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage_nuvz implements IAutoConst_nuvz {
	public WebDriver driver;
	public Long lngETO;
	public Logger log;
	public WebDriverWait wait;

	public BasePage_nuvz(WebDriver driver){
		this.driver=driver;
		String strETO=AutoUtility.getPropertyValue(CONFIGFILE_PATH, "ETO");
		Long lngETO=Long.parseLong(strETO);
		wait=new WebDriverWait(driver, lngETO);
		log= Logger.getLogger(this.getClass());
		PageFactory.initElements(driver, this);	
	}

	public void Exists(WebElement w,String message)
	{
		try{	
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) w));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) w));
		log.info(message);
		}
		catch(Exception e){
		log.error(message+e);
		e.printStackTrace();
		Assert.fail();
		}
	}
	public void entertext(WebElement w,String text,String message){
		try{
		w.sendKeys(text);
		log.info(message);
	}
		catch(Exception e){
			log.error(message+e);
			e.printStackTrace();
	Assert.fail();		
		}
	}
	
	public  void click(WebElement w,String message){
		try{
			w.click();
			log.info(message);
		}
		catch(Exception e){
			log.error(message+e);
			e.printStackTrace();
			Assert.fail();
		}
	}
}
