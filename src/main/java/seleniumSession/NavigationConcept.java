package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		//driver.navigate().to("https://naveenautomationlabs.com/opencart/");
		driver.navigate().to(new String("https://naveenautomationlabs.com/opencart/"));
		
		driver.navigate().refresh();		
	}

}
