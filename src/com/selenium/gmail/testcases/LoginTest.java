package com.selenium.gmail.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.gmail.base.BaseTest;
import com.selenium.gmail.utilities.dataUtil;

public class LoginTest extends BaseTest {
	
     @BeforeClass	
     public void initialize() throws Exception{
    	 init();
    	 dataUtil.setExcelFile(prop.getProperty("path"),"LoginTests");
    	 
     }
     @DataProvider(name = "loginTests")
 	public Object[][] dataProvider() {
 		Object[][] testData = dataUtil.getTestData("Invalid_Login");
 		return testData;
 	}

	@Test(dataProvider="loginTests")

		public void doLoginTest(String username,String password) throws Exception{
			openBrowser();
			navigate("gmail_url");
			doLogin(username,password);
			//logout();
			
	}
		@AfterClass
	public void exit() throws Exception{
			driver.quit();
		}


}
