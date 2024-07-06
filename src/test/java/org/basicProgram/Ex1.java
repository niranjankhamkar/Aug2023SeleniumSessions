package org.basicProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ex1 {

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
//			WebDriver driver1 = new EdgeDriver();
//			driver1.quit();
			
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/select-menu");
			String curUrl = driver.getCurrentUrl();
			System.out.println("Currant Url : "+curUrl);
			//String getPageSource = driver.getPageSource();
			//System.out.println("Page Source : "+getPageSource);
			String title = driver.getTitle();
			System.out.println("Title : "+title);
			driver.navigate().forward();
			//driver.close();
			driver.manage().window().minimize();
			
			driver.quit();
			
			
			
		
		}

}
