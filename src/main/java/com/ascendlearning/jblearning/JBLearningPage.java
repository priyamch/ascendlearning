package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLearningPage extends BasePage{

	protected JBLearningPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public JBLearningPage closeWidget(){
		ButtonHandler buttonHandler = new ButtonHandler(driver);
		buttonHandler.clickButton(PropertiesRepository.getString("jblearning.mainpage.widget.close"), PropertiesRepository.getString("jblearning.mainpage.username"));
		
		return this;
	}
	public JBLearningPage enterUserName(String userName) throws Exception{
		
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.mainpage.username"),userName);
		
		return this;
	}
	
	
	public JBLearningPage enterPassword(String password) throws Exception{
		
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.mainpage.password"),password);
		
		return this;
	}
	
	public void clickLoginButton() throws Exception{
		
		LinkHandler linkHandler =new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.mainpage.login.btn"),PropertiesRepository.getString("jblearning.productpage.showhide"));
	}
	
	public JBLProductsPage doValidLogin(String userName) throws Exception{
		enterUserName(userName);
		enterPassword(getPassword(userName));
		clickLoginButton();
		
		return new JBLProductsPage(driver);
	}

	private String getPassword(String userName) {
		// TODO Auto-generated method stub
		return "changeme";
	}

	public JBLearningPage loadMainPage() {
		driver.get(PropertiesRepository.getString("jblearning.mainpage.url"));
		setDriverWait(PropertiesRepository.getString("jblearning.mainpage.url.waitfor"));
		
		return this;
		
	}

}
