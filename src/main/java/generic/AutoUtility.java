package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class AutoUtility {

	
	
	public static  String readFromExcel(String path,String sheet, String row, String col){
//		String readFromExcel(String path,String sheet, String Testcasename, String columnname)
		String v="";
		
		System.out.println(path+";"+sheet+";"+row+";"+col);
	      try{
//		FileInputStream fileInputStream = new FileInputStream(new File(path));
		FileInputStream fis = new FileInputStream(new File(path));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);

	      Row r=sh.getRow(Integer.parseInt(row));
	      Cell c=r.getCell(Integer.parseInt(col));
	       v=c.getStringCellValue();
	      System.out.println(v);
	    
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	    	  Assert.fail();
	      }
		
		
		
	      return v;
		
	}
	
	public static String getRowNum (String path,String testcasename) {
		System.out.println(testcasename);
		FileInputStream fis;
		String row = "";
		try {
			 fis = new FileInputStream(new File(path));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheetAt(0);
			int LastRow = sh.getLastRowNum();
		    for(int i =1;i<LastRow;i++){
				 Row r=sh.getRow(i);
			      Cell c=r.getCell(0);
			      String v=c.getStringCellValue();
			      System.out.println(v);
			     if(v.equals(testcasename)){
			    	  row = Integer.toString(i);
			    	  break;
			      }
//			     else{
//			    	 System.out.println("Test case name doesn't exists in excel sheet");
////			    	 continue
////			    	 break;
//			     }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  Assert.fail();
		}
		return row;
		
	}
	
	
	
	
	
	
	
	public static void sleep(int seconds){
			try{
				Thread.sleep(seconds*1000);
			}
			catch(InterruptedException e){
				
			}
		}
//---------------------------------------------------------------
	
	
	public static String getPropertyValue(String path,String key){
		String value="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value=p.getProperty(key);
		}
		catch(Exception e){
			
		}
		return value;
	}
	
//	to get screenshot of the page
	public static void takeScreenshot(WebDriver driver,String path){
		try{
			TakesScreenshot t=(TakesScreenshot) driver;
			File image=t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File(path));
		}
		catch(Exception e){
			
		}
	}
//	---------------------------------------------------------------------------------------------
//	this method will return the system time in dd_MM_yy_hh_mm_ss format return type is String
	public static String now(){
		SimpleDateFormat s=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");

		
		String presentTime=s.format(new Date());
		return presentTime;
		
		
	}
//	----------------------------------------------------------------------------------------------
		
	
	
	
}
