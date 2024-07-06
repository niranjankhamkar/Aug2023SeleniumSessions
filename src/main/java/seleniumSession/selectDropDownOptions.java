package seleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectDropDownOptions {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
		
		By country = By.id("Form_getForm_Country");
//		WebElement country_ele = driver.findElement(country);
		
//		Select select = new Select(country_ele);
//		List<WebElement> countryList = select.getOptions();
//		System.out.println(countryList.size());
//	
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
//		System.out.println(getDropDownOptionCount(country));
//		selectDropDownOption(country, "India");
//		System.out.println(getDropDownOptions(country));
		if(getDropDownOptions(country).contains("India")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getDropDownOptionCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
		
	}
	
	public static List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> optinsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for(WebElement e : optinsList) {
			String text = e.getText();
			optionsTextList.add(text);			
		}
		return optionsTextList;
	}
	
	public static void selectDropDownOption(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optinsList = select.getOptions();
		System.out.println(optinsList.size());
	
		for(WebElement e : optinsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

}
