package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	
	static WebDriver driver;	//null

	public static void main(String[] args) {
		
		//first crearte the webelement first
		//create the webelement + perform an action(click,sendKeys, getText,isDisplay)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//DOM  - Document Object Module
		//1st way
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("admin123");
		
		//2nd
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail");
//		password.sendKeys("admin123");
		
		//3rd : By locator
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(eId);
//		WebElement password = driver.findElement(pwd);
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("admin123");
		
		//4th : By locator + generic method
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		getElement(eId).sendKeys("test@gmail.com");
//		getElement(pwd).sendKeys("admin123");
	
		//5th : By locator + generic method for element and action
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		doSendKeys(eId,"test@gmail.com");
//		doSendKeys(pwd,"test123");
		
		//6th : By locator + generic method for element and action in other element Util class
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		
//		eleUtil.doSendKeys(eId, "test@gmail.com");
//		eleUtil.doSendKeys(pwd, "test123");
		
		//7th : BrowserUtil + ElementUtil
		
		//8th :By locators -- > String
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
		
		String email_id = "input-email";
		String pwd_id = "input-password";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id",email_id, "abc@gmail.com");
		eleUtil.doSendKeys("id",pwd_id, "abc123");
		
		
		//9th : POM + Framework
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);	
	}
	
}
