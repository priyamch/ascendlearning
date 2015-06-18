package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLCoursePage extends BasePage{

	protected JBLCoursePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLaunchCourseButton(){
		ButtonHandler buttonHandler = new ButtonHandler(driver);
		buttonHandler.clickButton(PropertiesRepository.getString("jblearning.coursepage.launch"));
	}

}
