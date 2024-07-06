package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//xPath : address of the element in HTML DOM(document object Module)
		//1.Absolute xPath: /html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/a/img
		//2.Relative xPath: using element attributes with xPath functions
		
		//htmltag[@attrName='attrValue']-->eg. //input[@name='search']  eg. //input[@name='search']
		//eg. //input[@id='input-email'] --- xpath vs id -- id is fastest. preference should give id first 
		
		//htmltag[@attr1='value' and attr2='value']
		//eg. //input[@id='input-email' and @type = 'text'] ---> and
		
		////input[@type='text' or @name='email' or  @name='telephone']--->or
		// //input[@type or @name or  @name]
		
		//  //input[@id]-->6-->findElements method
		//	//a-->81   //input-->14
		
//		driver.findElement(By.xpath("//input[@type='text' and @name='search']")).sendKeys("Niranjan");
//		driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']")).click();
	
		int linksCount = driver.findElements(By.xpath("//a")).size();  //eg //img  //input
		System.out.println(linksCount);
	
		//input[@id and @type]
		//a[@class='list-group-item']
		
		//driver.findElements(By.className("list-group-item"));
		List<WebElement> linksList = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		System.out.println(linksList.size());
		
		for(WebElement e : linksList) {
			String text=e.getText();
			System.out.println(text);
		}
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		//htmltag[text()='value']
		//h2[text()='Returning Customer']
		//h2[text()='new Customer']
		//a[text()='Recurring payment']
		//a[text()='Forgotten Password'] --2 --FEs -- size() -- 2==2 -- true PASS
	
		//text() with attribute:
		//htmltag[text()='value' and @attr='value'] //Formula
		//text() with attribute:
				//htmltag[text()='value' and @attr='value']
				//a[text()='My Account' and @class='list-group-item']
				//a[@class='list-group-item' and text()='My Account']
				//a[@class='list-group-item' and text()='Forgotten Password']
				
				//htmltag[text()='value' and @attr1='value' and @attr2='value']
				
				//contains() in xpath:
				//contains() with attribute:
				//htmltag[contains(@attr, 'value')]
				//input[contains(@placeholder, 'E-Mail')]
				//input[contains(@placeholder, 'Address')]
				//input[contains(@id, 'email')]
				//input[contains(@id, 'email') and @type='text' and contains(@placeholder, 'E-Mail')]
				
				//input[contains(@id, 'email')]
				//input[@id='input-email']
				
				//when to use contains()?
				//1. long text:
				//contains() with text():
				//htmltag[contains(text(),'value')]
				//h2[contains(text(),'Returning')]
				//p[contains(text(),'By creating an account')]
				
				//contains() with text() and attribute:
				//htmltag[contains(text(),'value') and contains(@attr,'value')]
				//a[contains(text(),'Password') and contains(@class,'list-group-item')]
				
				//2. dynamic attributes:
				//dynamic id:
				//<input id = firstname_123>
				//<input id = firstname_125>
				//<input id = firstname_126>
				//<input id = firstname_120>
				//driver.findElement(By.id("firstname_123")).sendKeys("test");//---invalid
				
				//input[contains(@id,'firstname_')]
				
				//starts-with() in xpath:
				//htmltag[starts-with(text(),'value')]
				//p[starts-with(text(),'By creating an account')]
				
				//htmltag[starts-with(@attr,'value')]
				//input[starts-with(@id,'firstname')]
				
				//ends-with() in xpath: deprecated -- not valid now
				
				
				//id - unique -- By.id(naveen);
				//xpath with id --> //input[@id='naveen']
				
				//space with text:
				//label[normalize-space()='Yes']
		
		// index
		
		String text= driver.findElement(By.xpath("//input[@name='password']/../label[text()='Password']")).getText();
		System.out.println(text);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
