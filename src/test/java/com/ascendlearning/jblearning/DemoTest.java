package com.ascendlearning.jblearning;

import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.test.BaseTest;

public class DemoTest extends BaseTest{

	private String userName="qainstructor26@jblearning.com";
	private String productId="6709616d-647f-45f3-92f8-24d9c7f1ca78";
	
	@Test
	public void testcase() throws Exception{
		JBLearningPage jblPage=new JBLearningPage(driver);
		
		jblPage.loadMainPage()
		.closeWidget()
		.doValidLogin(userName)
		.clickProductNameLink(productId)
		.clickLaunchCourseButton();
	}
}
