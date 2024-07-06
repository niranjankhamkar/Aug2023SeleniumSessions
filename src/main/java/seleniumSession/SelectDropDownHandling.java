package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
		
		By country = By.id("Form_getForm_Country");
		WebElement country_ele = driver.findElement(country);
//		
//		Select select = new Select(country_ele);
//		select.selectByIndex(96);
//		Thread.sleep(1000);
//		select.selectByVisibleText("Afghanistan");
//		Thread.sleep(1000);
//		select.selectByValue("Angola");
		doSelectDropDownByIndex(country, 96);
		Thread.sleep(1000);
		doSelectDropDownByVisibleText(country, "Angola");
		Thread.sleep(1000);
		doSelectDropDownByValue(country, "Afghanistan");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectDropDownByIndex(By locator, int value) {
		Select select = new Select(getElement(locator));
	  		select.selectByIndex(value);
	}
	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
	  		select.selectByVisibleText(visibleText);
	}
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
	  		select.selectByValue(value);
	}
}