package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
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
	
	public JBLearningPage hoverOverSubjectDropDown() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		menuHandler.hoverOverMenuItem(PropertiesRepository.getString("jblearning.mainpage.menu.subject.dropdown"));
		
		return this;
	}
	
	public JBLearningPage hoverOverSubjectCategory(String selector) throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		menuHandler.hoverOverMenuItem(selector);
		
		return this;
	}
	
	public JBLCatalogPage selectTopic(String topic) throws Exception{
		String categoryPos=PropertiesRepository.getString(topic+".category");
		String subCategoryPos=PropertiesRepository.getString(topic+".subcategory");
		String subTopicPos=PropertiesRepository.getString(topic+".topic");
		
		hoverOverSubjectDropDown();
		hoverOverSubjectCategory(PropertiesRepository.getString("jblearning.mainpage.menu.subject.category").replace("subjectCategoryPos", categoryPos));
		hoverOverSubjectCategory(PropertiesRepository.getString("jblearning.mainpage.menu.subject.subcategory").replace("subjectCategoryPos", categoryPos).replace("subjectSubCategoryPos", subCategoryPos));
		
		MenuHandler menuHandler = new MenuHandler(driver);
		menuHandler.selectMenuItem(PropertiesRepository.getString("jblearning.mainpage.menu.subject.topic").replace("subjectCategoryPos", categoryPos).replace("subjectSubCategoryPos", subCategoryPos).replace("topicPos", subTopicPos),
				PropertiesRepository.getString("jblearning.mainpage.menu.topic.waitfor"));
		
		return new JBLCatalogPage(driver);
	}

}
