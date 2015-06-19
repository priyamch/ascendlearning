package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLCatalogPage extends BasePage {

	protected JBLCatalogPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	
	public JBLBookDetailPage clickProductName(String isbn) throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.catalog.products.name").replace("isbn", isbn),PropertiesRepository.getString("jblearning.book.title"));
		
		return new JBLBookDetailPage(driver);
	}
	
	public JBLBookDetailPage clickProductImage(String isbn) throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.catalog.products.image").replace("isbn", isbn),PropertiesRepository.getString("jblearning.book.title"));
		
		return new JBLBookDetailPage(driver);
	}
}
