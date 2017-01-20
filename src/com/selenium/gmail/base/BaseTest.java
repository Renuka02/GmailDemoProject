package com.selenium.gmail.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.gmail.utilities.dataUtil;

public class BaseTest {
	
	public static WebDriver driver;
	 public static Properties prop;
	 //initialize properties
	public static void init(){
		    prop = new Properties();
				try {
					FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
						prop.load(fs);
					} catch (IOException e) {
					
						e.printStackTrace();
					}
	}
	
	 //Browser properties
	public void openBrowser() throws Exception{
		
		driver = new FirefoxDriver();
		//driver.get(prop.getProperty("gmail_url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		
	}
	
	//navigate to the site	
	public void navigate(String url_xpath){
		 driver.get(prop.getProperty(url_xpath));
	}
	
	public static void logout(){
		//driver.findElement(By.xpath("//*[@class='gb_8a gbii']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='gb_8a gbii']")));
		element.click();
		//driver.get("https://mail.google.com/mail/?logout&hl=en");
		driver.findElement(By.xpath("//*[@id='gb_71']")).click();
	}
	//click properties
	public void click(String xpathEleKey){
	driver.findElement(By.xpath(prop.getProperty(xpathEleKey))).click();
	}
	
     //type properties
	public void type(String xpathElekey ,String data){
		driver.findElement(By.xpath((prop.getProperty(xpathElekey)))).sendKeys(data);;
	}
/****************************************app function *********************************/
	
	
	public boolean doLogin(String username,String password){
   	 type("logintextbox",username);
   	 click("btn_next");
   	//WebDriverWait wait = new WebDriverWait(driver, 10);
	//WebElement element = wait.until(
	//ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("passwordtextbox"))));
   	 type("passwordtextbox",password);
   	 click("btn_login");
   	   return false;
    }
	public void waitforelement(String locator , int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			System.out.println("element found");
			
		}catch(Exception e){
			System.out.println("element not found");
		}
				
	}
	
	

}
