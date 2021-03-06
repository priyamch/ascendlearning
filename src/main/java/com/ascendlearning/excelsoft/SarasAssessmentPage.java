package com.ascendlearning.excelsoft;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.RadioButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class SarasAssessmentPage extends BasePage{

	Logger log = Logger.getLogger(SarasAssessmentPage.class);
	private List<String> itemIdList;
	public SarasAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		WindowHandler winHandler = new WindowHandler(driver);
		winHandler.switchToLatestWindow(PropertiesRepository.getString("jblearning.navigate.assessment.startbtn"));
		setItemList();
	}

	public SarasAssessmentPage clickStartAssessmentLink() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.assessment.startbtn"), PropertiesRepository.getString("jblearning.navigate.assessment.coursetitle"));
		
		return this;
	}
	
	
	public void clickNext(String itemId) throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.assessment.next").replace("itemId", itemId));
	}
	
	
	/**
	 * This method will enter the text into the answer field
	 * @param itemId
	 * @param answer
	 * @return
	 * @throws Exception
	 */
	public SarasAssessmentPage enterAnswerText(String itemId, String answer) throws Exception{
		log.info("Entering answer text for: "+itemId+" -> "+answer);
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.navigate.assessment.anstext").replace("itemId", itemId), answer);
		return this;
	}

	private String getAnswerText(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * This method will select option true for a true/false type question.
	 * @param itemId
	 * @param answer
	 * @return
	 * @throws Exception 
	 */
	public SarasAssessmentPage selectTrue(String itemId) throws Exception{
		
		RadioButtonHandler radioHandler = new RadioButtonHandler(driver);
		radioHandler.selectRadioButton(PropertiesRepository.getString("jblearning.navigate.assessment.anstrue").replace("itemId", itemId));
		
		return this;
		
	}
	
	
	/**
	 * This method will select option false for a true/false type question.
	 * @param itemId
	 * @param answer
	 * @return
	 * @throws Exception 
	 */
	public SarasAssessmentPage selectFalse(String itemId) throws Exception{
		
		RadioButtonHandler radioHandler = new RadioButtonHandler(driver);
		radioHandler.selectRadioButton(PropertiesRepository.getString("jblearning.navigate.assessment.ansfalse").replace("itemId", itemId));
		
		return this;
		
	}
	
	/**
	 * This method will select option from multiple choice.
	 * option is the position of the answer option to select.
	 * @param itemId
	 * @param answer
	 * @return
	 * @throws Exception 
	 */
	public SarasAssessmentPage selectOption(String itemId,String option) throws Exception{
		
		RadioButtonHandler radioHandler = new RadioButtonHandler(driver);
		radioHandler.selectRadioButton(PropertiesRepository.getString("jblearning.navigate.assessment.ansradio").replace("itemId", itemId).replace("ansPosition", option));
		
		return this;
		
	}
	
	public SarasAssessmentPage submitAssessment() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.assessment.submitbtn"), PropertiesRepository.getString("jblearning.navigate.assessment.submitconfirm.yes"));

		return this;
	}
	
	public SarasAssessmentPage confirmSubmitAssessment() throws Exception{
		LinkHandler linkHandler = new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.navigate.assessment.submitconfirm.yes"), PropertiesRepository.getString("jblearning.navigate.assessment.submit.congrats"));

		return this;
	}
	
	public String getSubmitCOnfirmationMessage() throws Exception{
		
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getText(PropertiesRepository.getString("jblearning.navigate.assessment.submit.congrats"));
	}
	
	
	/**
	 * This method will answer all questions in the given assessment. 
	 * The details of the assessment needs to be set in assessmentinfo.properties
	 * 
	 * @param courseId
	 * @param assessment
	 * @throws Exception
	 */
	public SarasAssessmentPage answerAllQuestions() throws Exception{
		
		
		int q=1;
		String questionType=null;
		String answer=null;
		for(String itemId: itemIdList){
			log.info("Answering for Question number: "+q);
//			itemId=PropertiesRepository.getString(propKeyPrefix+".question"+q+".itemId");
			questionType=PropertiesRepository.getString(itemId+".qtype");
			answer=PropertiesRepository.getString(itemId+".answer");
			
			switch (questionType) {
			case "TorF":
				answerTrueOrFalseType(itemId, answer);
				break;
			case "fillBlank":
				enterAnswerText(itemId, answer);
				break;
			case "multiChoice":
				selectOption(itemId, answer);
				break;
			case "matchOptionsTODO":
				//TODO
				break;
			case"fillMultiBlanks":
				//TODO
				break;
				
			default:
				throw new Exception("Unrecognized questiontype in assessmentinfo file"+questionType);
			}
			
			if(q<itemIdList.size()){
				clickNext(itemId);
			}
			q++;
		}
		return this;
	}

	/**
	 * @param itemId
	 * @param answer
	 * @throws Exception
	 */
	private void answerTrueOrFalseType(String itemId, String answer)
			throws Exception {
		switch (answer) {
		case "T":
			selectTrue(itemId);
			break;
		case "F":
			selectFalse(itemId);

		default:
			break;
		}
	}
	
	public void setItemList(){
		itemIdList = new ArrayList<String>();
		log.info("Setting item list");
		List<WebElement> items = driver.findElements(By.cssSelector(PropertiesRepository.getString("jblearning.navigate.assessments.item")));
		log.info("Item count: "+items.size());
		for(WebElement ele : items){
			log.info("Adding to list: "+ele.getAttribute("id"));
			itemIdList.add(ele.getAttribute("id"));
		}
	}
}
