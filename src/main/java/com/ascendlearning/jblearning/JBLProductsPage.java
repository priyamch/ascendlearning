package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLProductsPage extends BasePage {

	protected JBLProductsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	
	public JBLCoursePage clickProductNameLink(String productId) throws Exception{
		
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.productpage.namelink").replace("productId", productId), 
				PropertiesRepository.getString("jblearning.coursepage.launch"));
		
		return new JBLCoursePage(driver);
	}
}
