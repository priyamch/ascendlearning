package com.ascendlearning.navigate.moodle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.common.JBLBaseTest;
import com.ascendlearning.excelsoft.TestAndAssessmentPage;
import com.ascendlearning.jblearning.JBLearningPage;
import com.ascendlearning.navigate.AddAnActivityOrResource;
import com.ascendlearning.navigate.InstructorReportPage;
import com.ascendlearning.navigate.NavigateCourseHomePage;

public class JBLFrontPageContentTests extends JBLBaseTest{

	private String userName="qainstructor26@jblearning.com";
	private String productId="6709616d-647f-45f3-92f8-24d9c7f1ca78";
	private String launchUrl;
	
	private String nav2CourseCode="767255ac-48ab-4eee-a0ee-6cf084535861";
	@BeforeSuite(alwaysRun=true)
	public void suiteSetUp(){
		//launchUrl=PropertiesRepository.getString("jblearning."+System.getProperty("env")+".url");
		launchUrl=PropertiesRepository.getString("jblearning.staging.url");
	}
	
	@Test(groups = {"ponetest"},description="Test Case :{FPCT-1} ,Application should display all chapters under 'Lesson Pathways' .")
	public void test_VerifyAllchaptersAreDispalyingUnderLessionsPathWayTab() throws Exception{

		JBLearningPage jblPage=new JBLearningPage(driver);
		
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton();
		boolean lessionpathway=navCourseHomePage.isLessonsPathwayTabDisplayed();
		Assert.assertTrue(lessionpathway, "LessonPathwayIsDisplaying");
		
		Assert.assertTrue(navCourseHomePage.isAllchaptersAreDispalyedUnderLessonsPathwayTab(), "ALLChaptersAreDispalyingUnderLessionsPathWayTab");
	}
	
	@Test(groups = {"ponetest"},description="Test Case :{FPCT-7},Application should display all eBooks under 'eBook' link.")
	public void test_VerifyApplicationDisplaysEBooksAndEBookActivityLinkUnderEBooklink() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton();
		
		Assert.assertTrue(navCourseHomePage.isLearningPathwayTabDisplayed(), "LearningPathwayTabDisplayed");
		navCourseHomePage.selectLearningPathwayTab().clickEBook();
		Assert.assertTrue(navCourseHomePage.isEbookLinkDispaying(), "EbookLinkDispaying");
	}
	
	@Test(groups = {"ponetest"},description="Test Case :{FPCT-14},Instrctor should be able to launch Manage items ,Manage assessments and Manual grading/Essay grading from Test bank placard.")
	public void test_verifyManageItemsManageAssessmentsandManualGradingLinksareAvailable() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton();
		
		Assert.assertTrue(navCourseHomePage.isTeachingPathwayTabDisplayed(), "TeachingPathwayTabDisplayed");
		navCourseHomePage.selectTeachingPathwayTab().clickTestBank();
		//Assert.assertTrue(navCourseHomePage.isMangeItemsDispalyingUnderTestBank(), "MangeItemsDispalyingUnderTestBank");
		Assert.assertTrue(navCourseHomePage.isManageAssessmentDispalyingUnderTestBank(), "ManageAssessmentDispalyingUnderTestBank");
		Assert.assertTrue(navCourseHomePage.isManualGradingDispalyingUnderTestBank(), "ManualGradingDispalyingUnderTestBank");
		
		Assert.assertTrue(navCourseHomePage.lunchManageAssesmentPage().verifyTestAssesmentsPageLoadedOrNot());
		TestAndAssessmentPage tandAssPage=new TestAndAssessmentPage(driver);
		tandAssPage.switchFromTestAndAssessmentPageToNavPage();
		Assert.assertTrue(navCourseHomePage.lunchManualGradingPage().verifyTestAssesmentsPageLoadedOrNot());
		tandAssPage.switchFromTestAndAssessmentPageToNavPage();
		Assert.assertTrue(navCourseHomePage.isMangeItemsDispalyingUnderTestBank(), "MangeItemsDispalyingUnderTestBank");
		//Assert.assertTrue(navCourseHomePage.lunchMAnageItemsPage().verifyTestAndAssessmentPageIsLoadedForManageItems());
	}
	
	/*@Test(description="Test Case :{FPCT-19},Application should display  the following activities under 'Study Center:ebook, Midterm ,Final ")
	public void test_VerifyApplicationshoulddisplayfollowingactivitiesunderStudyCenterebookMidtermFinal() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
			
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton().clickOnTurnOnEditing();
		
		
	}*/
	
	@Test(groups = {"ponetest"},description="Test Case :{FPCT-25},brought to the reports and grades page in the same tab")
	public void test_BroughtToTheReportsandGradesPageInThesameTab() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton().reportsandGrads();
		
		Assert.assertTrue(navCourseHomePage.verifyPageWithHelpOfLogo(),"Still @ Navigate2 Page");
		
	}
	
	@Test(groups = {"ponetest"},description="Test Case :{FPCT-33},user logs out and is taken to my accounts page in same tab")
	public void test_logoutWorks() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		JBLearningPage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode).clickLogout();
		
		Assert.assertTrue(jblPage.isMyAccountLinkVisible(),"MyAccountLinkVisible");
		
	}
	
	@Test(description="Test Case :{FPCT-19},The activties should be launched in new tabs when clicked on activities which are displayed under the Instructor's ToolBox")
	public void test_verifyAddAnActivityItems() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		NavigateCourseHomePage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton().clickOnTurnOnEditing().instructorsToolbox();
		
		AddAnActivityOrResource addanActivity=new AddAnActivityOrResource(driver);
		Assert.assertTrue(addanActivity.isMidtermExamIsAvailableInAddActivityPOpUp(),"Midterm Exam Available In Add an Activity Pop Up");
		Assert.assertTrue(addanActivity.isFinalExamIsAvailableInAddActivityPOpUp(),"Ebook chapterAvailable In Add an Activity Pop Up");
		Assert.assertTrue(addanActivity.isEbookchapterIsAvailableInAddActivityPOpUp(),"Ebook chapterAvailable In Add an Activity Pop Up");
	}
	
	@Test(description="Test Case :{FPCT-8},eBook Activity Report is eBook Reports tab under Reports and Grades performs similar functionality")
	public void test_verifyReportsPageUnderEbookReport() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		InstructorReportPage navCourseHomePage = jblPage.loadMainPage(launchUrl)
				.closeWidget()
				.doValidLogin(userName, "changeme").clickProductNameLink(nav2CourseCode)
				.clickLaunchCourseButton().reportsandGrads().clickOnebookReportUnderReportsAndGradesTab();
		Assert.assertEquals(navCourseHomePage.gettitleofThewindow(), "Instructor Reports","Instructor report Page Opening in new window");
	}
}
