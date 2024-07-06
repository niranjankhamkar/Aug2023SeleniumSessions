package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();	//sid123  session id
		driver.get("https://www.google.com/"); //sid 123
		
		String actTitle = driver.getTitle();	//sid 123
		
		System.out.println("title is : "+actTitle);
		
		driver.quit();	//ssi null
		//after using quit you not use selenium driver session id is null after that
		//your driver is quit your server running in backround 
		//you should not write a code after this line
		
		
		driver = new ChromeDriver();	//new sid 456
		System.out.println(driver.getTitle());	//sid 456 session id
		
		
		
	}

}
