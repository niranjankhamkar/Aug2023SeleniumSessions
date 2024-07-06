package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amzon.com/");
		
		
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println("total image : "+imgList.size());
		
		for(WebElement e : imgList) {
			
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");
			
			System.out.println(srcValue+"===="+altValue);
		}
		
		
	}

}
