package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasic {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//1.open the browser : chorme
		//2.enter url
		//3.get the title
		//4.verify the title
		//5.close the browser
		
		//automation step
		//ChormeDriver driver = new ChormeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		
		String browser = "FireFox";
		
		//cross browser logic
		switch(browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":	
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "safari":	
			driver = new SafariDriver();
			break;
		default :
			System.out.println("Please pass right browser....");
			break;
			
		}
		
		
		driver.get("https://www.google.com/");
		
		String actTitle = driver.getTitle();
		System.out.println("title is : "+actTitle);
		
		//verification point/checkpoint/act vs exp result : testing
		if(actTitle.equals("Google")) {
			System.out.println("title is correct--->PASS");
		}else {
			System.out.println("title is not correct--->FAIL");
		}
		
		String appUrl = driver.getCurrentUrl();
		System.out.println("appurl : "+appUrl);
		if(appUrl.contains("google")) {
			System.out.println("url is correct--->PASS");
		}else {
			System.out.println("url is not correct--->FAIL");
		}
		
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		if(pageSource.contains("googele ")) {
			System.out.println("pageSource is correct--->PASS");
		}else {
			System.out.println("pageSource is not correct--->FAIL");
			
		}
		
		driver.quit();	
	
	}

}
