package com.ascendlearning.jblearning;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.ascendlearning.common.JBLBaseTest;
import com.ascendlearning.companionsites.EMSZoneMainPage;
import com.ascendlearning.excelsoft.SarasAssessmentPage;
import com.ascendlearning.jblearning.JBLCheckoutOptionsPage;
import com.ascendlearning.jblearning.JBLearningPage;
import com.ascendlearning.navigate.NavigateCourseHomePage;


public class JBLSanityTest extends JBLBaseTest{

	private String userName="qainstructor26@jblearning.com";
	private String productId="6709616d-647f-45f3-92f8-24d9c7f1ca78";


	String customer="jblplatformqa";
	private String nav1CourseCode="24bc7880-4e05-4bdd-92a1-6ceaf8fea799";
	private String nav2CourseCode="720d68e7-d769-4086-ad1b-84125f075e61";
	private String testPrepCourseCode="94fb84ff-b7e3-4d9d-8e30-fb0f806f7b7a";
	private String companionCourseCode="6e956d78-fc09-4cb2-8776-cbbe6a956647";
	private String practiceActivityId="19818";
	private String courseId="1E4953";
	private String assessment="ch1practice";
	private String launchUrl;
	private String loginReqdMsg="You must login in order to view this page.";
	private String cdxLight="CDX Light Vehicle";


	@BeforeSuite
	public void suiteSetUp(){
		launchUrl=PropertiesRepository.getString("jblearning."+System.getProperty("env")+".url");
	}
	@Test(description="TC001")
	public void test_VerifyJBLearningMainPage() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver)
		.loadMainPage(launchUrl)
		.closeWidget();

		Assert.assertTrue(jblPage.isTechSupportLinkVisible(),"Technical SUpport LInk not visible");
		Assert.assertTrue(jblPage.isAboutUsLinkVisible(),"About Us LInk not visible");
		Assert.assertTrue(jblPage.isMyAccountLinkVisible(),"My Account LInk not visible");
		Assert.assertTrue(jblPage.isRedeemCodeLinkVisible(),"Redeem Code LInk not visible");
		Assert.assertTrue(jblPage.isShoppingCartLinkVisible(),"Shoppoing Cart LInk not visible");
	}
	@Test(description="TC002")
	public void test_ProductCheckOutFlow() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver);

		JBLCheckoutOptionsPage jblCheckOutPage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.hoverOverSubjectDropDown()
				.selectTopic("Corrections")
				.clickProductName("9781284020212")
				.clickAddToCart()
				.clickCheckOutButton()
				.signInAsReturningUser(PropertiesRepository.getString(customer+".info.email"), "password")
				.enterCustomerInfoAndContinue(customer)
				.clickCompleteCheckOut();

		String orderConfirmMessage= jblCheckOutPage.getCustNameFromOrderConfirmation();
		Assert.assertTrue(orderConfirmMessage.contains(PropertiesRepository.getString(customer+".info.firstname")), "First name does not match on order confirmation page ");
		Assert.assertTrue(orderConfirmMessage.contains(PropertiesRepository.getString(customer+".info.lastname")), "Last name does not match on order confirmation page ");

	}


	@Test(description="TC003")
	public void test_VerifyNav1Access() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav1CourseCode)
				.clickLaunchCourseButton()
				.clickNav1Course();

		Assert.assertTrue(navCourseHomePage.isPeopleBlockDisplayed(), "People block is not displayed");
		Assert.assertTrue(navCourseHomePage.isActivitiesBlockDisplayed(), "Activities block is not displayed");
		Assert.assertTrue(navCourseHomePage.isAdministrationBlockDisplayed(), "Administration block is not displayed");
		Assert.assertTrue(navCourseHomePage.isSearchForumsBlockDisplayed(), "Search forums block is not displayed");
		Assert.assertTrue(navCourseHomePage.isMessagesBlockDisplayed(), "Messages block is not displayed");
		Assert.assertTrue(navCourseHomePage.isUpcomingEventsBlockDisplayed(), "Upcoming events block is not displayed");
		Assert.assertTrue(navCourseHomePage.isCalendarBlockDisplayed(), "Calendar block is not displayed");
	}

	@Test(description="TC004")
	public void test_VerifyNav2Access() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav2CourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isLessonsPathwayTabDisplayed(), "Lessons PATHWAY tab not displayed");
		Assert.assertTrue(navCourseHomePage.isLearningPathwayTabDisplayed(), "Learning PATHWAY tab not displayed");
		//Assert.assertTrue(navCourseHomePage.isTeachingPathwayTabDisplayed(), "Teaching PATHWAY tab not displayed");

	}


	@Test(description="TC005")
	public void test_VerifyEBookOpenEnroll() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav2CourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isLessonsPathwayTabDisplayed(), "Lessons PATHWAY tab not displayed");
		Assert.assertTrue(navCourseHomePage.isLearningPathwayTabDisplayed(), "Learning PATHWAY tab not displayed");
		//Assert.assertTrue(navCourseHomePage.isTeachingPathwayTabDisplayed(), "Teaching PATHWAY tab not displayed");

		navCourseHomePage.expandSection("1").clickEBook();

	}	

	@Test(description="TC006")
	public void test_VerifyPracticeActivity() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		SarasAssessmentPage sarasPage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav2CourseCode)
				.clickLaunchOpenEnrolCourseButton()
				.expandSection("1")
				.launchChapter1PracticeActivity(practiceActivityId)
				.clickStartAssessmentLink()
				.answerAllQuestions(courseId, assessment)
				.submitAssessment()
				.confirmSubmitAssessment();

		Assert.assertEquals(sarasPage.getSubmitCOnfirmationMessage(), "Congratulations!");

	}


	@Test(description="TC007")
	public void test_VerifyTestPrepOpenEnroll() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(testPrepCourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isCreateTestLinkDisplayed(), "Create test not displayed");
		Assert.assertTrue(navCourseHomePage.isReviewTestLinkDisplayed(), "Review test not displayed");
		Assert.assertTrue(navCourseHomePage.isCompleteAssessmentLinkDisplayed(), "Complete assessment not displayed");
		Assert.assertTrue(navCourseHomePage.isReviewAssessmentLinkDisplayed(), "Review assessment not displayed");

	}
	
	//@Test(description="TC008")
	public void test_VerifyJBLHostedCourse(){
		//TODO  need a JBL hosted course set up for the user
	}

	@Test(description="TC009")
	public void test_VerifyEmszone() throws Exception{
	
		EMSZoneMainPage emsPage = new EMSZoneMainPage(driver);
		emsPage.launchEmszone(PropertiesRepository.getString("emt.emszone.url"));
		
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("anatomy"), "Anatomy not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("crosswords"), "Crosswords not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("flashcards"), "Flashcards not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("glossary"), "Glossary not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("assessmentReview"), "Assessment and Emergency Care not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("ready_for_review"), "Ready for review not displayed");
		Assert.assertTrue(emsPage.isFreeSubjectDisplayed("state_ems_offices"), "State Ems Offices not displayed");
		
		emsPage.clickSpecialPrivilageItem("audio");
		Assert.assertEquals(emsPage.getMainContextText(), loginReqdMsg,"Login required message not displayed");
		emsPage.doEMSLogin(PropertiesRepository.getString(customer+".info.email"), "password");
		
		emsPage.clickCloseFrame();
		emsPage.clickSpecialPrivilageItem("audio");
		
		Assert.assertTrue(emsPage.isMp3OptionAvailable(),"MP3 option not available");
		Assert.assertTrue(emsPage.isMovOptionAvailable(),"Mov option not available");
		
	}

}
