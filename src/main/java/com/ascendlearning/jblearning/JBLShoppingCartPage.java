package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLShoppingCartPage extends BasePage {

	public JBLShoppingCartPage(WebDriver webDriver) {
		super(webDriver);

	}
	
	public JBLCheckoutOptionsPage clickCheckOutButton(){
		ButtonHandler buttonHandler= new ButtonHandler(driver);
		buttonHandler.clickButton(PropertiesRepository.getString("jblearning.shoppingcart.checkout"), PropertiesRepository.getString("jblearning.checkout.signin.heading"));
		
		return new JBLCheckoutOptionsPage(driver);
	}

}
