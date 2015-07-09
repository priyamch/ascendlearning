package com.ascendlearning.companionsites;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class EMSZoneMainPage extends BasePage{



	public EMSZoneMainPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public EMSZoneMainPage launchEmszone(String url){
		driver.get(url);
		return this;
	}

	public void clickFreeSubject(String subjectRef) throws Exception{
	
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("emszone.free.subject").replace("subjectRef", subjectRef));
		
	}
	
	
	public void clickSpecialPrivilageItem(String privilageType) throws Exception{
		
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("emszone.special.type").replace("privilageType", privilageType));
		
	}
	
	
	public boolean isFreeSubjectDisplayed(String subjectRef) throws Exception{
		
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("emszone.free.subject").replace("subjectRef", subjectRef)).isDisplayed();
		
	}
	
	public String getMainContextText() throws Exception{
		
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getText(PropertiesRepository.getString("emszone.special.maincontent"));
		
	}
	
	public void clickLoginLink() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("emszone.login.link"));
	}
	
	public void enterUserName(String userName) throws Exception{
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("emszone.loginframe.user"), userName);
	}
	
	public void enterPassword(String password) throws Exception{
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("emszone.loginframe.pass"), password);
	}
	
	public void clickSubmit() throws Exception{
		ButtonHandler btnHandler = new ButtonHandler(driver);
		btnHandler.clickButton(PropertiesRepository.getString("emszone.loginframe.submit"));
	}
	
	public void clickCloseFrame() throws Exception{
		ButtonHandler btnHandler = new ButtonHandler(driver);
		btnHandler.clickButton(PropertiesRepository.getString("emszone.loginframe.close"));
	}
	
	public void doEMSLogin(String userName, String password) throws Exception{
		clickLoginLink();
		driver.switchTo().frame(PropertiesRepository.getString("ems.login.frame"));
		enterUserName(userName);
		enterPassword(password);
		clickSubmit();
		driver.switchTo().defaultContent();		
	}
	
	public boolean isMp3OptionAvailable(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("ems.special.mp3")).isDisplayed();
		
	}
	
	public boolean isMovOptionAvailable(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("ems.special.mov")).isDisplayed();
		
	}
}
