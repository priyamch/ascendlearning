package com.ascendlearning.common;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.ascendlearning.automation.ui.test.BaseTest;


public class JBLBaseTest extends BaseTest{

	public JBLBaseTest() {
		// TODO Auto-generated constructor stub
	}

	@AfterMethod(alwaysRun=true)
	public void catchExceptions(ITestResult result){
	    Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	    String methodName = result.getName();
	    if(!result.isSuccess()){
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(scrFile, new File(System.getProperty("suiteName")+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png"));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
	}
}
