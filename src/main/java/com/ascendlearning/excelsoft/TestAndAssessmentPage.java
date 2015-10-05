package com.ascendlearning.excelsoft;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.ascendlearning.navigate.NavigateCourseHomePage;

public class TestAndAssessmentPage extends BasePage{
	BaseHandler baseHandler;
	public TestAndAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler=new BaseHandler(driver);
		WindowHandler winHandler = new WindowHandler(driver);
		winHandler.switchToLatestWindow();
	}
	
	public boolean verifyTestAssesmentsPageLoadedOrNot() throws DriverException{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.assessmentPage")).isDisplayed();
	}
	
	public boolean verifyTestAndAssessmentPageIsLoadedForManageItems() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.manageItemTestAssessmentPage")).isDisplayed();
	}
	public NavigateCourseHomePage switchFromTestAndAssessmentPageToNavPage(){
		
		WindowHandler windowHandler=new WindowHandler(driver);
		driver.close();
		//windowHandler.switchToMainWindow(PropertiesRepository.getString("jblearning.navigate1.courseimage"));
		return new NavigateCourseHomePage(driver);
	}
}
