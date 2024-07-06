package seleniumSession;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/**
 * @author Niranjan
 * BrowserUtil is having multiple generic methods to handle the various browser actions
 */
public class BrowserUtil {
	
	WebDriver driver;	//declare one global WebDriver
	/**
	 * this method is used to launch the browser on the basis of given browser name
	 * @param browserName
	 * @return this returns the driver instance
	 */
	public WebDriver LaunchBrowser(String browserName) {	//start launch the browser on the basis of what, 
													//give me browser name then i launch the browser
			
		System.out.println("browser name : "+browserName);
		
		switch(browserName.toLowerCase().trim()) {
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
			throw new AutomationException("INVALID BROWSER"+browserName);
			//break;
		}
		
		return driver;
			
	}
	/**
	 * this methode use to launch url
	 * @param url
	 */
		public void LaunchURL(String url) {
			if (url == null) {
				System.out.println("URL is Null");
				throw new AutomationException("NULL URL");
			}
			if(url.indexOf("http")==0) {
				driver.get(url);
			}else {
				throw new AutomationException("HTTP is missing");
			}
		}
		
		public void LaunchURL(URL url) {
			if (url == null) {
				System.out.println("URL is Null");
				throw new AutomationException("NULL URL");
			}
			driver.navigate().to(url);
		}
	
		public String getPageTitle() {	//-->12 oct 7:24
			String title = driver.getTitle();
			System.out.println("Page title is :"+title);
			return title;
		}
		
		public String getPageURL() {	
			String url = driver.getCurrentUrl();
			return url;
		}
		
		public boolean getPageSource(String value) {
			String pageSource = driver.getPageSource();
			if(pageSource.contains(value)) {
				return true;
			}
		return false;
		}
		
		public void closeBrowser() {
			driver.close();
			System.out.println("browser is closed");
		}
		
		public void quitBrowser() {
			driver.quit();
			System.out.println("browser is closed");
		}
		
		
}

















