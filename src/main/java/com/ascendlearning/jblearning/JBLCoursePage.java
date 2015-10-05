package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.ascendlearning.navigate.NavigateCourseHomePage;

public class JBLCoursePage extends BasePage{

	protected JBLCoursePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public NavigateCourseHomePage clickLaunchCourseButton(){
		ButtonHandler buttonHandler = new ButtonHandler(driver);
		buttonHandler.clickButton(PropertiesRepository.getString("jblearning.coursepage.launch"));
		
		return new NavigateCourseHomePage(driver);
	}
	
	
	public NavigateCourseHomePage clickLaunchOpenEnrolCourseButton(){
		ButtonHandler buttonHandler = new ButtonHandler(driver);
		buttonHandler.clickButton(PropertiesRepository.getString("jblearning.coursepage.launch.openenrollment"));
		
		return new NavigateCourseHomePage(driver);
	}
	
	public JBLearningPage clickLogout() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.ProductCourse.Logout")).click();
	//	menuHandler.getMenuItem("a:contains('Log Out')").click();
		return new JBLearningPage(driver);
	}

}
