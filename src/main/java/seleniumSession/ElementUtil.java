package seleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {	//constructor of class
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String locatorValue) {
		By by = null;
		switch(locatorType.toLowerCase().trim()){
			case "id" :
				by = By.id(locatorValue);
				break ;
			case "name":
				by = By.id(locatorValue);
				break;
			case "class":
				by = By.name(locatorValue);
				break;
			case "xpath" :
				by = By.xpath(locatorValue);
				break;
			case "css" :
				by = By.cssSelector(locatorValue);
				break;
			case "linktext":
				by = By.linkText(locatorValue);
				break;
			case "partiallinktext":
				by = By.partialLinkText(locatorValue);
				break;
			case "tag":
				by = By.tagName(locatorValue);
			
			default:
				System.out.println("Wrong locator type is Passed..."+locatorType);
				throw new AutomationException("Wrong locator type");
				//break;	--> unreachable code
		}
		return by;
	}
	//locatorType="id",locatorValue="input-email", value = "tom@gmail.com"
	public void doSendKeys(String locatorType, String locatorValue,String value) {
		getElement(locatorType,locatorValue).sendKeys(value);
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	
	}
	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType,locatorValue).click();	
	}
	
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doElementGetText(String locatorType, String locatorValue) {
		return getElement(locatorType,locatorValue).getText();
	}
	
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);	
	}
	
	public  WebElement getElement(String locatorType, String locatorValue ) {
		return driver.findElement(getBy(locatorType,locatorValue));
		
	}
	
	public  boolean checkSingleElementPresent(By locator) {
		return driver.findElements(locator).size()==1 ? true : false; 
	}
	
	public  boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size()>=1 ? true : false; 
	}
	
	
	
	
	//WAF : capture the text of all the page links and return List<String>
		public   List<String> getElementsTextList(By locator) {
			List<WebElement> eleList = getElements(locator);
			List<String> eleTextList = new ArrayList<String>();//pc=0{}
			
			for(WebElement e : eleList) {
				String text = e.getText();
				
				if(text.length()!=0) {
					eleTextList.add(text);
				}
			}
			return eleTextList;
		}
		
		//WAF : capture specific attribute from the list
		public  List<String> getElementAttributeList(By locator, String attrName) {
			List<WebElement> eleList = getElements(locator);
			List<String> eleAttrList = new ArrayList<String>();
			
			for(WebElement e : eleList) {
				String attrValue = e.getAttribute(attrName);
				eleAttrList .add(attrValue);
				
			}
			return eleAttrList;
		}
		
		public  int getElementsCount(By locator) {
			return getElements(locator).size();
		}
		public  List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}
		
		public  void googleSearch(By searchField,By suggestions, String searchKey, String suggName) throws InterruptedException {
			
			doSendKeys(searchField, searchKey);
			Thread.sleep(3000);
			
			List<WebElement> suggList = getElements(suggestions);
			System.out.println(suggList.size());
			
			for(WebElement e : suggList) {
				String text = e.getText();
				System.out.println(text);
					if(text.contains(suggName)) {
						e.click();
						break;
					}	
			}
		}
		
		//*********** Select Drop Down Util ***********
		
		public Select createSelect(By locator) {
			Select select = new Select(getElement(locator));
			return select;
		}
		public  void doSelectDropDownByIndex(By locator, int value) {
			createSelect(locator).selectByIndex(value);
		}
		public void doSelectDropDownByVisibleText(By locator, String visibleText) {
			createSelect(locator).selectByVisibleText(visibleText);
		}
		public void doSelectDropDownByValue(By locator, String value) {
			createSelect(locator).selectByValue(value);
		}
	
		public  int getDropDownOptionCount(By locator) {
			return createSelect(locator).getOptions().size();
		}
		
		public  List<String> getDropDownOptions(By locator) {
			
			List<WebElement> optinsList = createSelect(locator).getOptions();
			List<String> optionsTextList = new ArrayList<String>();

			for(WebElement e : optinsList) {
				String text = e.getText();
				optionsTextList.add(text);			
			}
			return optionsTextList;
		}
		
		public  void selectDropDownOption(By locator, String dropDownValue) {
			List<WebElement> optinsList = createSelect(locator).getOptions();
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
		
		public void selectDropDownValue(By locator, String value) {
			List<WebElement> optionList = getElements(locator);
			for(WebElement e : optionList) {
				String text = e.getText();
				if(text.equals(value)) {
					e.click();
					break;
				}
			}
		}
		
		public  boolean selectDropDownMultiple(By locator) {
			return createSelect(locator).isMultiple() ? true : false;
		}
		
	/**
	 * This method is used to select the values from the drop down. it can select;
	 * 1.Single selection
	 * 2.Multiple selection
	 * 3.All selection: please pass "all" as a value to select all values
	 * @param locator
	 * @param values
	 */
		public void selectDropDownMultipleValues(By locator, By optionLocator, String... values)
				throws InterruptedException {
			if (selectDropDownMultiple(locator)) {

				if (values[0].equalsIgnoreCase("all")) {
					List<WebElement> optionList = getElements(optionLocator);
					for (WebElement e : optionList) {
						Thread.sleep(1000);
						e.click();
					}
				} else {
					for (String value : values) {
						createSelect(locator).selectByVisibleText(value);
					}
				}

			}

		}
	
}
