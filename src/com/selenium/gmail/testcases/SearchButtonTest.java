package com.selenium.gmail.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.gmail.base.BaseTest;
import com.selenium.gmail.utilities.dataUtil;

public class SearchButtonTest extends BaseTest {
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws Exception {
	init();
	dataUtil.setExcelFile(prop.getProperty("path"),"Searchname");
	}
	   @DataProvider(name = "Searchname")
	 	public Object[][] dataProvider() {
	 		Object[][] testData = dataUtil.getTestData("Invalid_Login");
	 		return testData;
	   }
	
	@Test(dataProvider="Searchname")
	public void searchButtonTest(String Searchname,String a) throws Exception {
		openBrowser();
		navigate("gmail_url");
		doLogin();
		//driver.findElement(By.xpath("")).click();
		type("searchname",Searchname);
		click("btn_search");
		takeScreenShot();
		
		}
	
}
