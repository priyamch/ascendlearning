package com.ascendlearning.companionsites;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class CDXAuto extends BasePage{

	protected CDXAuto(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	public void selectCourse(String course) throws Exception{
		DropDownHandler drpdwnHandler = new DropDownHandler(driver);
		drpdwnHandler.selectByVisibleText(drpdwnHandler.getDropDown(PropertiesRepository.getString("cdxauto.main.selectcourse")), course);
		
	}

}
