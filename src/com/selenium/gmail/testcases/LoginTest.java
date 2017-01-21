package com.selenium.gmail.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.gmail.base.BaseTest;
import com.selenium.gmail.utilities.dataUtil;

public class LoginTest extends BaseTest {
	
     @BeforeClass	
     public void initialize() throws Exception{
    	 init();
    	 test=rep.startTest("loginTest");
    	 test.log(LogStatus.INFO, "starting the login test");
    	 dataUtil.setExcelFile(prop.getProperty("path"),"LoginTests");
    	 
     }
     @DataProvider(name = "LoginTests")
 	public Object[][] dataProvider() {
 		Object[][] testData = dataUtil.getTestData("Invalid_Login");
 		return testData;
 	}

	@Test(dataProvider="LoginTests")

		public void doLoginTest() throws Exception{
			openBrowser();
			navigate("gmail_url");
			doLogin();
			takeScreenShot();
			
	}
		@AfterClass
	public void exit() throws Exception{
			driver.quit();
		}


}
