package com.ascendlearning.jblearning;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.ascendlearning.excelsoft.SarasAssessmentPage;
import com.ascendlearning.navigate.NavigateCourseHomePage;

public class JBLSanityTest extends BaseTest{

	private String userName="qainstructor26@jblearning.com";
	private String productId="6709616d-647f-45f3-92f8-24d9c7f1ca78";


	String customer="jblplatformqa";
	private String nav1CourseCode="24bc7880-4e05-4bdd-92a1-6ceaf8fea799";
	private String nav2CourseCode="720d68e7-d769-4086-ad1b-84125f075e61";
	private String testPrepCourseCode="94fb84ff-b7e3-4d9d-8e30-fb0f806f7b7a";
	private String companionCourseCode="6e956d78-fc09-4cb2-8776-cbbe6a956647";
	private String courseId="1E4953";
	private String assessment="ch1practice";


	@Test
	public void test_VerifyJBLearningMainPage() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver)
		.loadMainPage("jblearning.prod.url")
		.closeWidget();
		
		Assert.assertTrue(jblPage.isTechSupportLinkVisible(),"Technical SUpport LInk not visible");
		Assert.assertTrue(jblPage.isAboutUsLinkVisible(),"About Us LInk not visible");
		Assert.assertTrue(jblPage.isMyAccountLinkVisible(),"My Account LInk not visible");
		Assert.assertTrue(jblPage.isRedeemCodeLinkVisible(),"Redeem Code LInk not visible");
		Assert.assertTrue(jblPage.isShoppingCartLinkVisible(),"Shoppoing Cart LInk not visible");
	}
	@Test
	public void test_ProductCheckOutFlow() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver);

		JBLCheckoutOptionsPage jblCheckOutPage = jblPage.loadMainPage("jblearning.prod.url")
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


	@Test
	public void test_VerifyNav1Access() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage("jblearning.prod.url")
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

	@Test
	public void test_VerifyNav2Access() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage("jblearning.prod.url")
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav2CourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isLessonsPathwayTabDisplayed(), "Lessons PATHWAY tab not displayed");
		Assert.assertTrue(navCourseHomePage.isLearningPathwayTabDisplayed(), "Learning PATHWAY tab not displayed");
		//Assert.assertTrue(navCourseHomePage.isTeachingPathwayTabDisplayed(), "Teaching PATHWAY tab not displayed");

	}


	@Test
	public void test_VerifyTestPrepOpenEnroll() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage("jblearning.prod.url")
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(testPrepCourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isCreateTestLinkDisplayed(), "Create test not displayed");
		Assert.assertTrue(navCourseHomePage.isReviewTestLinkDisplayed(), "Review test not displayed");
		Assert.assertTrue(navCourseHomePage.isCompleteAssessmentLinkDisplayed(), "Complete assessment not displayed");
		Assert.assertTrue(navCourseHomePage.isReviewAssessmentLinkDisplayed(), "Review assessment not displayed");

	}


	@Test
	public void test_VerifyEBookOpenEnroll() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage("jblearning.prod.url")
				.closeWidget()
				.doValidLogin(PropertiesRepository.getString(customer+".info.email"), "password")
				.clickProductNameLink(nav2CourseCode)
				.clickLaunchOpenEnrolCourseButton();

		Assert.assertTrue(navCourseHomePage.isLessonsPathwayTabDisplayed(), "Lessons PATHWAY tab not displayed");
		Assert.assertTrue(navCourseHomePage.isLearningPathwayTabDisplayed(), "Learning PATHWAY tab not displayed");
		//Assert.assertTrue(navCourseHomePage.isTeachingPathwayTabDisplayed(), "Teaching PATHWAY tab not displayed");

		navCourseHomePage.expandSection("1").clickEBook();

	}


	@Test
	public void test_VerifyAssessment() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);

		SarasAssessmentPage sarasPage = jblPage.loadMainPage("jblearning.staging.url")
				.closeWidget()
				.doValidLogin(userName)
				.clickProductNameLink(productId)
				.clickLaunchCourseButton()
				.expandSection("1")
				.launchChapter1PracticeActivity()
				.clickStartAssessmentLink()
				.answerAllQuestions(courseId, assessment)
				.submitAssessment()
				.confirmSubmitAssessment();

		Assert.assertEquals(sarasPage.getSubmitCOnfirmationMessage(), "Congratulations");

	}
}
