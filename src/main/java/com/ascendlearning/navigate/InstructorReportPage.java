package com.ascendlearning.navigate;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class InstructorReportPage extends BasePage{
	BaseHandler baseHandler;
	public InstructorReportPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler=new BaseHandler(driver);
		WindowHandler winHandler = new WindowHandler(driver);
		winHandler.switchToLatestWindow();
	}

	public String gettitleofThewindow(){
		System.out.println("Title of This window is :::  "+driver.getTitle());
		return driver.getTitle();
	}

}
