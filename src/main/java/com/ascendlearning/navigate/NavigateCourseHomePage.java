package com.ascendlearning.navigate;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.MenuHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.ascendlearning.excelsoft.SarasAssessmentPage;
import com.ascendlearning.excelsoft.TestAndAssessmentPage;

public class NavigateCourseHomePage extends BasePage{
	BaseHandler baseHandler;
	public NavigateCourseHomePage(WebDriver webDriver) {
		super(webDriver);
		baseHandler=new BaseHandler(driver);
		WindowHandler winHandler = new WindowHandler(driver);
		winHandler.switchToLatestWindow();
	}

	public boolean isLessonsPathwayTabDisplayed() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.lessonspathway")).isDisplayed();
	}
	
	public boolean isLearningPathwayTabDisplayed() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.learningpathway")).isDisplayed();
	}
	
	
	
	public boolean isTeachingPathwayTabDisplayed() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.teachingpathway")).isDisplayed();
	}
	
	public NavigateCourseHomePage clickNav1Course() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate1.courselink"), PropertiesRepository.getString("jblearning.navigate1.courseimage"));
		
		return this;
	}
	
////Ravi 
	public boolean verifyPageWithHelpOfLogo() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		return menuHandler.getMenuItem(PropertiesRepository.getString("jblearning.navigate.headerlogo")).isDisplayed();
		//return menuHandler.getMenuItem(".header-logo>a>img").isDisplayed();jblearning.navigate.headerlogo
	}
	
	
	 public boolean isAllchaptersAreDispalyedUnderLessonsPathwayTab(){
		BaseHandler baseHandler=new BaseHandler(driver);
		boolean pvalue=false;
		
		List<WebElement> allchapters=baseHandler.findElements(PropertiesRepository.getString("jblearning.navigate2Home.AllChaptersDisplayBlock"));
		for (WebElement webElement : allchapters) {
			if(baseHandler.isDisplayed(webElement)){
				pvalue=true;
			}else
				pvalue=false;
		}
		return pvalue;
		
	 }
	
	 public NavigateCourseHomePage selectLearningPathwayTab() throws Exception{
		MenuHandler menuHandler = new MenuHandler(driver);
		menuHandler.selectMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.learningpathway"));
		return this;
	 }
	 public NavigateCourseHomePage selectTeachingPathwayTab() throws Exception{
		 MenuHandler menuHandler = new MenuHandler(driver);
		 menuHandler.selectMenuItem(PropertiesRepository.getString("jblearning.navigate.menu.teachingpathway"));
		 return this;
	 }
	 
	 
	 public void clickTestBank() throws Exception{
		 LinkHandler linkHandler = new LinkHandler(driver);
		 linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.TestBank"));
	 }
	
	 public boolean isEbookLinkDispaying() throws Exception{
		BaseHandler baseHandler=new BaseHandler(driver);
		
		return baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.ebooklink")));	
	 }
	 
	 public boolean isMangeItemsDispalyingUnderTestBank() throws Exception{
		 TextHandler textHandler = new TextHandler(driver);
		 BaseHandler baseHandler = new BaseHandler(driver);
		 Thread.sleep(3000);
		 return baseHandler.findElement(PropertiesRepository.getString("jblearning.navigate.manageItem")).getText().equals("Manage Items");
//				  return false;
	///return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate.manageItem")).isDisplayed();
	 }
	 public boolean isManageAssessmentDispalyingUnderTestBank() throws Exception{
		 TextHandler textHandler = new TextHandler(driver);
		 return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate.manageAssessment")).isDisplayed();
	 }
	 public boolean isManualGradingDispalyingUnderTestBank() throws Exception{
		 TextHandler textHandler = new TextHandler(driver);
		 return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate.manualGrading")).isDisplayed();
	 }
	 
	 public TestAndAssessmentPage lunchManageAssesmentPage() throws Exception{
		 LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manageAssessment"));
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manageAssessmentLunch"));
			return new TestAndAssessmentPage(driver); 
	 }
	 public TestAndAssessmentPage lunchManualGradingPage() throws Exception{
		 LinkHandler linkHandler = new LinkHandler(driver);
			//linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manageAssessment"));
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manualGradingLunch"));
			return new TestAndAssessmentPage(driver); 
	 }
	 public TestAndAssessmentPage lunchMAnageItemsPage() throws Exception{
		 LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manageItem"));
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.manageItemLunch"));//,"#ctl00_imgLogo"
			Thread.sleep(5000);
			return new TestAndAssessmentPage(driver); 
	 }
	  public NavigateCourseHomePage clickOnTurnOnEditing() throws Exception{
		  	LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.turnOnEditingButtton"));
		return this;
		  
	  }
	  
	  public NavigateCourseHomePage reportsandGrads() throws Exception{
		  	LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.reportsandGrads"));
		return this;
		  
	  }
	  
	  public NavigateCourseHomePage clickAddAnActivityOptionOfFirstPlacard() throws Exception{
		//  ul[class='topics ui-sortable']>li:nth-child(2)>div:nth-child(3)>div[class='visibleifjs addresourcemodchooser'] a span
		  LinkHandler linkHandler = new LinkHandler(driver);
		  MenuHandler menuHandler=new MenuHandler(driver);
		  menuHandler.hoverOverMenuItem(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", "2"));
			linkHandler.selectLink("ul[class='topics ui-sortable']>li:nth-child(3)>div:nth-child(3)>div[class='visibleifjs addresourcemodchooser'] a span");
		return this;
	  }
	  public NavigateCourseHomePage instructorsToolbox() throws Exception{
			//  ul[class='topics ui-sortable']>li:nth-child(2)>div:nth-child(3)>div[class='visibleifjs addresourcemodchooser'] a span
			  LinkHandler linkHandler = new LinkHandler(driver);
			  MenuHandler menuHandler=new MenuHandler(driver);
			  menuHandler.hoverOverMenuItem(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", "0"));
				linkHandler.selectLink("ul[class='topics ui-sortable']>li:nth-child(1)>div:nth-child(3)>div[class='visibleifjs addresourcemodchooser'] a span");
			return this;
		  }
	   public InstructorReportPage clickOnebookReportUnderReportsAndGradesTab() throws Exception{
		   LinkHandler linkHandler = new LinkHandler(driver);
			  MenuHandler menuHandler=new MenuHandler(driver);
			  menuHandler.hoverOverMenuItem(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", "2"));
				linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", "2"));
			return new InstructorReportPage(driver);
	   }
	  
	 public NavigateCourseHomePage enterTextIntoMidtermExamnamefield() throws Exception{
		 TextHandler textHandler = new TextHandler(driver);
			textHandler.writeText(PropertiesRepository.getString("jblearning.navigate.enterTextIntoMidtermExamnamefield"),"HMTest_"+RandomStringUtils.randomAlphabetic(7));
			return this;
	 }
	  public NavigateCourseHomePage selectShowDescriptionCheckBox() throws Exception{
		  LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.selectShowDescriptionCheckBox"));
		  return this;
	  }
	  
	  public NavigateCourseHomePage selectAssessmentRequiredfield(String assessment) throws Exception{
		  DropDownHandler dropDownhandler=new DropDownHandler(driver);
		  dropDownhandler.selectByVisibleText(dropDownhandler.getDropDown(PropertiesRepository.getString("jblearning.navigate.selectAssessmentRequiredfield")), assessment);
		  return this;
	  }
	  

	  public NavigateCourseHomePage clickOnAddrestriction() throws Exception{
		  LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.clickOnAddrestriction"));
		  return this;
	  }
	  
	  public NavigateCourseHomePage clickOnDateButton() throws Exception{
		  LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.clickOnDateButton"));
		  return this;
	  }
	  
	  public NavigateCourseHomePage fillFromDate(){
		  
		  
		  return this;
	  }
	  
	  public NavigateCourseHomePage fillUntillDate(String date,String month) throws Exception{
		  DropDownHandler dropDownhandler=new DropDownHandler(driver);
		  dropDownhandler.selectByVisibleText(dropDownhandler.getDropDown(".availability-inner>.availability-children>.availability-item:nth-child(3)>span.availability_date.availability-plugincontrols>span:nth-child(1)>label:nth-child(1)>select"), "until");
		  dropDownhandler.selectByValue(dropDownhandler.getDropDown(".availability-inner>.availability-children>.availability-item:nth-child(3)>span.availability_date.availability-plugincontrols>span:nth-child(2)>label:nth-child(1)>select"), date);
		  
		 // dropDownhandler.selectByVisibleText(dropDownhandler.getDropDown(".availability-inner>.availability-children>.availability-item:nth-child(3)>span.availability_date.availability-plugincontrols>span:nth-child(2)>label:nth-child(2)>select"), Month);
		  Thread.sleep(5000);
		  return this;
	  }
	  
	  public NavigateCourseHomePage ClickOnSaveandReturnToCourse() throws Exception{
		  LinkHandler linkHandler = new LinkHandler(driver);
			linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.clickOnSaveandReturnToCourse"));
			return this;
	  }
	/////
	
	public boolean isPeopleBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.peopleblock")).isDisplayed();
	}
	
	public boolean isActivitiesBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.activitiesblock")).isDisplayed();
	}
	
	public boolean isAdministrationBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.administrationblock")).isDisplayed();
	}
	
	public boolean isSearchForumsBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.searchforumblock")).isDisplayed();
	}
	
	public boolean isMessagesBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.messagesblock")).isDisplayed();
	}
	
	public boolean isUpcomingEventsBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.eventsblock")).isDisplayed();
	}
	
	public boolean isCalendarBlockDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.navigate1.calendarblock")).isDisplayed();
	}
	
	public boolean isCreateTestLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.testprep.createpractice")).isDisplayed();
	}
	
	public boolean isReviewTestLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.testprep.reviewpractice")).isDisplayed();
	}
	
	public boolean isCompleteAssessmentLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.testprep.completeassessment")).isDisplayed();
	}
	
	
	public boolean isReviewAssessmentLinkDisplayed(){
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getTextElement(PropertiesRepository.getString("jblearning.testprep.reviewassessment")).isDisplayed();
	}
	
	public NavigateCourseHomePage expandSection(String sectionPos) throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.chaptersection").replace("sectionPos", sectionPos));
		
		return this;
	}
	
	public void clickEBook() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		//linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.ebook"));
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.ebook2"));
			
	}

	public SarasAssessmentPage launchChapter1PracticeActivity(String practiceActivityId) throws Exception {
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.ch1practice").replace("practiceActivityId", practiceActivityId));
		
		return new SarasAssessmentPage(driver);
	}
}
