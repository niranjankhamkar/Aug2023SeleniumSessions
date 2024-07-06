package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String emailId_Id = "input-email";
		String password_Id = "input-password";
		String loginBtn_xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";
		String register_linkText = "Register";
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", emailId_Id, "test@gmail.com");
		eleUtil.doSendKeys("id",password_Id,"test123");
		eleUtil.doClick("xpath", loginBtn_xpath);
		//eleUtil.doClick("linkText", register_linkText);
		
		String registerValue = eleUtil.doElementGetText("linkText",register_linkText);
		System.out.println(registerValue);
	}

}
