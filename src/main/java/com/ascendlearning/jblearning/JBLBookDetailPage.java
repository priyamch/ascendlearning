package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLBookDetailPage extends BasePage {

	protected JBLBookDetailPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public JBLShoppingCartPage clickAddToCart() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.book.addtocart"),PropertiesRepository.getString("jblearning.shoppingcart.checkout"));
		
		return new JBLShoppingCartPage(driver);
	}

}
