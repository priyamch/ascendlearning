package com.ascendlearning.navigate;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class AddAnActivityOrResource extends BasePage{
	BaseHandler baseHandler;

	public AddAnActivityOrResource(WebDriver webDriver) {
		super(webDriver);	
		baseHandler=new BaseHandler(driver);
	}
	                                
	public AddAnActivityOrResource chooseAnyActivity(){   
		baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.chooseAnyActivity")).click(); 
		return this;
	}
	public AddAnActivityOrResource chooseQuizActivity(){   
		baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.quiz")).click(); 
		return this;
	}
	
	public boolean isMidtermExamIsAvailableInAddActivityPOpUp() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.chooseAnyActivity")).isDisplayed();
	}
	public boolean isFinalExamIsAvailableInAddActivityPOpUp() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.FinalExamActivity")).isDisplayed();
	}
	public boolean isEbookchapterIsAvailableInAddActivityPOpUp() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.ebookchapterActivity")).isDisplayed();
	}
	public NavigateCourseHomePage ClickOnAddButton(){
		baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.clickOnAddButton")).click();
		return new NavigateCourseHomePage(driver);
	}
	
	public NavigateCourseHomePage clickOnCancelButton(){
		baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.clickOnCancelButton")).click();
		return new NavigateCourseHomePage(driver);
	}
}
