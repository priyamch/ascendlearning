package com.ascendlearning.navigate;

import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.ascendlearning.excelsoft.SarasAssessmentPage;

public class NavigateCourseHomePage extends BasePage{

	public NavigateCourseHomePage(WebDriver webDriver) {
		super(webDriver);
		WindowHandler winHandler = new WindowHandler(driver);
		winHandler.switchToLatestWindow(PropertiesRepository.getString("jblearning.navigate.headerlogo"));
	}

	public boolean isLessonsPathwayTabDisplayed(){
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.lessonspathway")).isDisplayed();
	}
	
	public boolean isLearningPathwayTabDisplayed(){
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.learningpathway")).isDisplayed();
	}
	
	public boolean isTeachingPathwayTabDisplayed(){
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.teachingpathway")).isDisplayed();
	}
	
	public NavigateCourseHomePage clickNav1Course() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate1.courselink"), PropertiesRepository.getString("jblearning.navigate1.courseimage"));
		
		return this;
	}
	
	
	public boolean isPeopleBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.peopleblock")).isDisplayed();
	}
	
	public boolean isActivitiesBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.activitiesblock")).isDisplayed();
	}
	
	public boolean isAdministrationBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.administrationblock")).isDisplayed();
	}
	
	public boolean isSearchForumsBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.searchforumblock")).isDisplayed();
	}
	
	public boolean isMessagesBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.messagesblock")).isDisplayed();
	}
	
	public boolean isUpcomingEventsBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.eventsblock")).isDisplayed();
	}
	
	public boolean isCalendarBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.navigate1.calendarblock")).isDisplayed();
	}
	
	public boolean isCreateTestLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.testprep.createpractice")).isDisplayed();
	}
	
	public boolean isReviewTestLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.testprep.reviewpractice")).isDisplayed();
	}
	
	public boolean isCompleteAssessmentLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.testprep.completeassessment")).isDisplayed();
	}
	
	
	public boolean isReviewAssessmentLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextelement(PropertiesRepository.getString("jblearning.testprep.reviewassessment")).isDisplayed();
	}
	
	public NavigateCourseHomePage expandSection(String sectionPos) throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", sectionPos));
		
		return this;
	}
	
	public void clickEBook() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.ebook"));
		
	}

	public SarasAssessmentPage launchChapter1PracticeActivity() throws Exception {
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.ch1practice"));
		
		return new SarasAssessmentPage(driver);
	}
}
