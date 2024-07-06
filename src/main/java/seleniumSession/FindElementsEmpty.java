package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEmpty {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		List<WebElement> eles = driver.findElements(By.xpath("//input[@class='niranjan']"));
//		System.out.println(eles.size());//0
	
		By logo = By.cssSelector(".img-responsive");
		if(checkElementPresent(logo)) {
			System.out.println("logo is present");
		}else {
			System.out.println("Fail");
		}
		
		
		
	}
	public static boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size()==1 ? true : false; 
	}

}
