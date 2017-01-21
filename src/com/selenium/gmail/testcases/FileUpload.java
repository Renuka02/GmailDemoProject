package com.selenium.gmail.testcases;
//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.gmail.base.BaseTest;
import com.selenium.gmail.utilities.dataUtil;

// Please change the file extension to .java
// I have to change the extension to .text because udemy does not support uploading .java files
public class FileUpload extends BaseTest {
	//private String baseUrl;

	@BeforeClass
	public void beforeClass() throws Exception {
	init();
	dataUtil.setExcelFile(prop.getProperty("path"),"Fileupload");
	}
	   @DataProvider(name = "Fileupload")
	 	public Object[][] dataProvider() {
	 		Object[][] testData = dataUtil.getTestData("Invalid_Login");
	 		return testData;
	  }
	
	   @Test(dataProvider="Fileupload")
	public void fileUpload(String sendto, String sub,String Pathname) throws Exception {
		openBrowser();
		navigate("gmail_url");
		doLogin();
		click("btn_compose");
		type("sendTo", sendto);
		type("subject",sub);
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();
		StringSelection stringSelection= new StringSelection(Pathname);
		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		// Cmd + Tab
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		// Goto Window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		// Hit Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		takeScreenShot();
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
