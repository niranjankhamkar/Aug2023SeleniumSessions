package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//WebElement + perform action(get attribute)
		
		By emailId = By.id("input-email");
		By registerLink = By.linkText("Register");
		
//		String  placeHoderValue = driver.findElement(emailId).getAttribute("placeholder");
//		System.out.println(placeHoderValue);
//		
//		String hrefValue = driver.findElement(registerLink).getAttribute("href");
//		System.out.println(hrefValue);
//		
//		String  className = driver.findElement(registerLink).getAttribute("class");
//		System.out.println(className);

//		driver.findElement(emailId).sendKeys("tom@gmail.com");
//		String text = driver.findElement(emailId).getAttribute("value");
//		System.out.println(text);
	
		String placeholdr = doGetElementAttribute(emailId, "placeholder");
		System.out.println(placeholdr);
		
		String hrefValue = doGetElementAttribute(registerLink, "href");
		System.out.println(hrefValue);
		
		String value = doGetElementAttribute(registerLink, "value");
		System.out.println(value);
		
		By pwd = By.id("input-password");
		driver.findElement(pwd).sendKeys("naveen@123");
		String pv = doGetElementAttribute(pwd, "value");
		System.out.println(pv);
		
		
	}
	
	public static String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
}
